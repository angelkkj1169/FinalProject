<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="icon" href="./img/core-img/favicon.ico">
<link rel="stylesheet" href="/css/style2.css">
<style>

table{font-size:20px;
text-align: center;}

#pageNumber{text-align: center;}

</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/module/adminHead.jsp"></jsp:include>
<div class="container">


		<table class="table">
			<thead>
				<tr class="row">
					<th class="col">이미지</th>
					<th class="col">제목</th>
					<th class="col">가격</th>
					<th class="col">유통기한</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="i" items="${ShopBoardList}">
					<tr class="row" style="height: 12rem">
						<th class="col">
							<!-- ${i.shop_imagepath1}<a href="#" onclick="window.open('','','width=600px, height=450px')"></a> -->
							<img src="${i.shop_imagepath1}" alt="">

						</th>
						<td class="col">${i.shop_contents}</td>
						<td class="col"><b>${i.shop_price}</b>원</td>
						<td class="col">${i.shop_expiration}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



<div id="pageNumber">
		<c:forEach var="i" items="${pageList}">
				<c:choose>

					<c:when test="${i eq '<이전'}">
						<a href="ShopBoardManagementProc?page=${page-1}">${i}</a>
					</c:when>

					<c:when test="${i eq '다음>'}">
						<a href="ShopBoardManagementProc?page=${page+1}">${i}</a>
					</c:when>

					<c:otherwise>
						<a href="ShopBoardManagementProc?page=${i}">${i}</a>
					</c:otherwise>

				</c:choose>
			</c:forEach>
        </div>

</div>
<jsp:include page="/WEB-INF/views/module/footer.jsp"></jsp:include>
</body>
</html>