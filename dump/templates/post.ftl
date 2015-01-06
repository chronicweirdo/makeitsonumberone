<html>
<title>mwahaha: ${title}</title>
<link rel="stylesheet" href="/base.css" />
<link rel="stylesheet" href="/post.css" />
<body>
<div id="head">
    <a href="/">
        <img class="logo" src="/mw.png" alt="mwahaha" />
    </a>
    <#list tags as tag>
        <span class="tag">${tag}</span>
    </#list>
</div>
<h1 class="title">${title}</h1>
<#list sections as section>
    <div class="section">${section}</div>
</#list>
</body>
</html>