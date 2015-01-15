<html>
<head>
    <title>mwahaha</title>
    <link rel="stylesheet" href="/base.css" />
    <link rel="stylesheet" href="/home.css" />

    <script type="text/javascript" src="/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="/home.js"></script>
</head>
<body>
<div class="page">
    <p class="head">
        <span class="logo"><img src="/mwahaha.png" /></span>
    </p>
    <#list pages as page>
    <p class="link">
        <span class="date">${page.year}.${page.month}.${page.day}&nbsp;${page.hour}:${page.minute}</span>
        <a class="title" href="${page.url}">${page.title}</a>
        <#list page.tags as tag>
            <a class="tag" onclick="toggleFilter(this);">${tag}</a>
        </#list>
    </p>
    </#list>
</div>
</body>
</html>