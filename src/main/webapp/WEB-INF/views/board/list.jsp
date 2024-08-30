<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list.jsp</title>
</head>
<body>
<table border="1">
    <tr>
        <th>게시글번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>작성일</th>
    </tr>
    <c:forEach var="vo" items="${list}">
        <tr>
            <td>${vo.num}</td>
            <td>${vo.writer}</td>
            <td><a href="/board/detail?num=${vo.num}"> ${vo.title}</a></td>
            `
            <td>${vo.regdate}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <c:forEach var="i" begin="${pu.startPageNum}" end="${pu.endPageNum}">
        <c:choose>
            <c:when test="${pu.pageNum==i}">
                <a href="/board/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style="color:red"></span>[${i}]</a>
            </c:when>
            <c:otherwise>
                <a href="/board/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style="color:gray"></span>[${i}]</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<div>
    <form action="/board/list" method="post">
        <select name="field">
            <option value="title"<c:if test="${field =='title'}">selected</c:if>>제목</option>
            <option value="writer"<c:if test="${field =='writer'}">selected</c:if>>작성자</option>
            <option value="content"<c:if test="${field =='content'}">selected</c:if>>내용</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
</div>
</body>
</html>
