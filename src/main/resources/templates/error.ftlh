<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Помилка</title>
</head>
<body>
<nav>
    <a href="/">Головна</a> |
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Помилка</h1>
<p>${errorMessage!''}</p>

</body>
</html>
