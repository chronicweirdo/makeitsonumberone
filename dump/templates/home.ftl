<html>
<body>
<div>${greeting}</div>
<ul>
    <#list pages as page>
        <li><a href="${page.url}"><span>${page.date}</span><span>${page.title}</span></a></li>
    </#list>
</ul>
</body>
</html>