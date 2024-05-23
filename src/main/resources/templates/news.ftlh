<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Новини</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a> |
</nav>

<h1>Новини</h1>

<ul>
    <#list newsList as news>
        <li>
            <h2>${news.title!''}</h2>
            <p>${news.content!''}</p>
            <small>${news.createdAt!''}</small>
        </li>
    </#list>
</ul>

<h3>Додати новину</h3>
<form action="/news" method="post">
    <label for="title">Заголовок:</label>
    <input type="text" id="title" name="title" required>
    <br>
    <label for="content">Контент:</label>
    <textarea id="content" name="content" required></textarea>
    <br>
    <label for="department">Кафедра:</label>
    <select id="department" name="departmentId">
        <#list departments as department>
            <option value="${department.id}">${department.name}</option>
        </#list>
    </select>
    <br>
    <button type="submit">Додати</button>
</form>

</body>
</html>
