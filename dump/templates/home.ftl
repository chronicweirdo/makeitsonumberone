<html>
<head>
    <title>mwahaha</title>
    <link rel="stylesheet" href="/base.css" />
    <link rel="stylesheet" href="/home.css" />

    <script type="text/javascript" src="/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/home.js"></script>
</head>
<body>
<div class="page">
    <p class="head">
        <span class="logo"><img src="/mwahaha.png" /></span>
    </p>
    <#list pages as page>
    <p class="link">
        <span class="date">${page.date}</span>
        <a class="title" href="${page.url}">${page.title}</a>
        <#list page.tags as tag>
            <span class="tag">${tag}</span>
        </#list>
    </p>
    </#list>
</div>
</body>
</html>