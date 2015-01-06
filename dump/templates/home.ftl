<html>
<body>
<div>${greeting}</div>
<ul>
    <#list pages as page>
        <li>
            <a href="${page.url}"><span>${page.date}</span><span>${page.title}</span></a>
            <#list page.tags as tag>
                <span class="tag">${tag}</span>
            </#list>
        </li>
    </#list>
</ul>
</body>
</html>