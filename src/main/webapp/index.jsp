<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Library</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 align="center">My Library</h1>

</br>
</br>
<%--FORMS--%>
<%--Ref TO SELECT--%>
<button>
    <a href="books.do?action=selectAllFields">Показать книги</a>
</button>
<%--FORM TO ADD BOOK--%>

<button><a href="addForm.html">Добавить новую книгу </a></button>


<%--FORM TO DELETE THE BOOK--%>
<form action="books.do" method="post">
    <input type="number" name="id" placeholder="введите номер книги которую хотите удалить">
    <input type="submit" value="Удалить">
    <input name="action" value="deleteById" hidden="hidden">
</form>

<%--FORM TO SELECT BOOK BY ID--%>
<form action="books.do" method="get">
    <input type="number" name="id" placeholder="введите номер книги">
    <input type="submit" value="Найти">
    <input name="action" value="findById" hidden="hidden">
</form>

        <br/>
        <c:out value="${exception}"/>


<div class="table_books">
    <table>

        <thead class="title_table">
        <tr>
            <th>id</th>
            <th>book_name</th>
            <th>author_name</th>
            <th>description</th>
            <th>year</th>
        </tr>
        </thead>

        <c:forEach items="${books}" var="book">
            <tr>
                <td align="center">${book.idbooks}</td>
                <td align="center">${book.bookName}</td>
                <td align="center">${book.authorName}</td>
                <td align="center">${book.description}</td>
                <td align="center">${book.year}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
