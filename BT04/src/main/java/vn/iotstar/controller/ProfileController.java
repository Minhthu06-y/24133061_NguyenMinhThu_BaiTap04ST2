package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/profile" })

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)

public class ProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService =
            new UserServiceImpl();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        User user = userService.findById(1);

        request.setAttribute("user", user);

        request.getRequestDispatcher("/common/info.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");

        User user = userService.findById(1);

        if (user != null) {

            user.setFullname(fullname);

            user.setPhone(phone);

            Part filePart = request.getPart("images");

            if (filePart != null && filePart.getSize() > 0) {

                String originalFileName =
                        filePart.getSubmittedFileName();

                String extension = "";

                int index =
                        originalFileName.lastIndexOf(".");

                if (index > 0) {

                    extension =
                            originalFileName.substring(index);
                }

                String fileName =
                        UUID.randomUUID().toString()
                                + extension;

                String uploadPath =
                        getServletContext()
                                .getRealPath("/uploads");

                File uploadFolder =
                        new File(uploadPath);

                if (!uploadFolder.exists()) {

                    uploadFolder.mkdirs();
                }

                filePart.write(
                        uploadPath
                                + File.separator
                                + fileName
                );

                user.setImages(fileName);
            }

            userService.update(user);
        }

        response.sendRedirect(
                request.getContextPath() + "/profile"
        );
    }
}