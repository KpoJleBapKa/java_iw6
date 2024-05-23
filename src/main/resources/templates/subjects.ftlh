<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Список предметів</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Список предметів</h1>

<ul>
    <#list subjects as subject>
        <li>${subject.name} - ${subject.description}
        <#if subject.department??>
            (Кафедра: ${subject.department.name})
        </#if>
        </li>
    </#list>
</ul>

<h3>Додати новий предмет</h3>
<form action="/subjects" method="post">
    <label for="name">Назва:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="description">Опис:</label>
    <textarea id="description" name="description" required></textarea>
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
