<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
</head>

<body>

	<h2>THÔNG TIN CÁ NHÂN</h2>

	<form action="${pageContext.request.contextPath}/profile" method="post"
		enctype="multipart/form-data">

		<div>
			<label>Họ và tên:</label> <input type="text" name="fullname"
				value="${user.fullname}" required>
		</div>

		<br>

		<div>
			<label>Số điện thoại:</label> <input type="text" name="phone"
				value="${user.phone}" required>
		</div>

		<br>

		<div>
			<label>Ảnh đại diện:</label> <br>
			<br>

			<c:if test="${not empty user.images}">

				<img src="${pageContext.request.contextPath}/uploads/${user.images}"
					width="150" height="150" alt="Ảnh đại diện">

			</c:if>

			<br>
			<br> <input type="file" name="images" accept="image/*">
		</div>

		<br>

		<button type="submit">Cập nhật</button>

	</form>

</body>
</html>