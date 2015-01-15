<html>
<head>
    <title>mwahaha: ${title}</title>
    <link rel="stylesheet" href="/base.css" />
    <link rel="stylesheet" href="/post.css" />

    <script type="text/javascript" src="/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/post.js"></script>
</head>

<body>
<div class="page">
    <div class="head">
        <p>
            <span class="link">
                <a href="/">
                    <img class="logo" src="/mw.png" alt="mwahaha" />
                </a>
            </span>
            <#if previous??>
                <span class="link">
                    <a class="previous" href="${previous.url}">
                        <img src="/left.png" alt="&lt;" />
                    </a>
                </span>
            </#if>
            <#if next??>
            <span class="link">
                <a class="next" href="${next.url}">
                    <img src="/right.png" alt="&gt;" />
                </a>
            </span>
            </#if>

            <#list tags as tag>
                <span class="tag">${tag}</span>
            </#list>
                <span class="tag">sfafasgasfa</span>
                <span class="tag">weqerwqda</span>
                <span class="tag">jhjf</span>
                <span class="tag">dsada</span>
                <span class="tag">dghjgjxastr</span>
                <span class="tag">sasadfeewqrghhj</span>
                <span class="tag">httrt34r</span>
            <span class="title">${title}</span>
        </p>
    </div>
    <#list sections as section>
        <div class="section">${section}</div>
    </#list>
</div>
</body>
</html>