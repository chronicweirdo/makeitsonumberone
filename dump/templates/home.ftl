<html>
<head>
    <title>mwahaha</title>
    <link rel="stylesheet" href="/base.css" />
    <link rel="stylesheet" href="/home.css" />

    <script type="text/javascript" src="/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="page">
    <p class="head">
        <span class="m"><img src="/m.png" alt="m" /></span>
        <span class="w"><img src="/w.png" alt="w" /></span>
        <span class="a"><img src="/a.png" alt="a" /></span>
        <span class="h"><img src="/h.png" alt="h" /></span>
        <span class="a"><img src="/a.png" alt="a" /></span>
        <span class="h"><img src="/h.png" alt="h" /></span>
        <span class="aend"><img src="/aend.png" alt="a" /></span>
    </p>
    <p>
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
    </p>
</div>
</body>
</html>