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
<%--FROM TO SELECT--%>
<form action="selectServlet.do" method="post">
    <input type="submit" value="Показать книги">
</form>

<%--FORM TO ADD BOOK--%>
<button><a href="addForm.html" >Добавить новую книгу </a> </button>


<%--FORM TO DELETE THE BOOK--%>
<form  action="deleteBook.do" method="post" >
    <input type="number"  name="id" placeholder="введите номер книги которую хотите удалить">
    <input type="submit" value="Удалить">
</form>

<%--FORM TO SELECT BOOK BY ID--%>
<form  action="getById.do" method="post" >
    <input type="number"  name="id" placeholder="введите номер книги">
    <input type="submit" value="Найти">
</form>


<div class="table_books">
    <table >

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
