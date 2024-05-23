<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Інформація про кафедру</title>
</head>
<body>
<nav>
    <a href="/departments">Кафедри</a> |
    <a href="/subjects">Предмети</a> |
    <a href="/news">Новини</a>
</nav>

<h1>Інформація про кафедру</h1>

<h2>${department.name}</h2>
<p>${department.title}</p>
<p>Телефон: ${department.phone}</p>
<p>Кабінет: ${department.classroom}</p>

<h3>Список предметів</h3>
<ul>
    <#list department.subjects as subject>
        <li>${subject.name} - ${subject.description}</li>
    </#list>
</ul>

<h3>Новини кафедри</h3>
<ul>
    <#list department.news as newsItem>
        <li>${newsItem.title} - ${newsItem.content}</li>
    </#list>
</ul>

<a href="/departments">Назад до списку кафедр</a>
</body>
</html>
