<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Список кафедр</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Список кафедр</h1>

<ul>
    <#list departments as department>
        <li><a href="/departments/${department.id}">${department.name}</a></li>
    </#list>
</ul>

<h3>Додати нову кафедру</h3>
<form action="/departments" method="post">
    <label for="name">Назва:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="title">Опис:</label>
    <textarea id="title" name="title" required></textarea>
    <br>
    <label for="phone">Телефон:</label>
    <input type="text" id="phone" name="phone" required>
    <br>
    <label for="classroom">Кабінет:</label>
    <input type="text" id="classroom" name="classroom" required>
    <br>
    <button type="submit">Додати</button>
</form>
</body>
</html>
