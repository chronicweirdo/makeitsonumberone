<html>
<title>mwahaha: ${title}</title>
<link rel="stylesheet" href="/base.css" />
<link rel="stylesheet" href="/post.css" />
<body>
<div class="page">
    <div class="head">
        <p>
            <a href="/">
                <img class="logo" src="/mw.png" alt="mwahaha" />
            </a>
            <span class="title">${title}</span>
        </p>
        <p>
            <#list tags as tag>
                <span class="tag">${tag}</span>
            </#list>
        </p>
    </div>

    <#list sections as section>
        <div class="section">${section}</div>
    </#list>
</div>
</body>
</html>