<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Додати предмети до кафедри</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Додати предмети до кафедри</h1>

<h2>${department.name}</h2>

<form action="/departments/${department.id}/subjects" method="post">
    <label for="subjects">Виберіть предмети:</label>
    <select id="subjects" name="subjectIds" multiple>
        <#list subjects as subject>
            <option value="${subject.id}">${subject.name}</option>
        </#list>
    </select>
    <br>
    <button type="submit">Додати предмети</button>
</form>

<a href="/departments/${department.id}">Назад до інформації про кафедру</a>
</body>
</html>
