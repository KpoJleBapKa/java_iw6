<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Додати новину</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Додати новину</h1>

<form action="/news" method="post">
    <label for="title">Заголовок:</label>
    <input type="text" id="title" name="title" required>
    <br>
    <label for="content">Контент:</label>
    <textarea id="content" name="content" required></textarea>
    <br>
    <button type="submit">Додати</button>
</form>
</body>
</html>
