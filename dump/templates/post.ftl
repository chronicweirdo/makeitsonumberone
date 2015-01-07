<html>
<title>mwahaha: ${title}</title>
<link rel="stylesheet" href="/base.css" />
<link rel="stylesheet" href="/post.css" />

<script type="text/javascript" src="/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/post.js"></script>

<body>
<div class="page">
    <div class="head">
        <p class="filter">
            <#--<span class="filterin">-->
            <#--the filterin element allows us to add a background color to the tags but changes the vertical-align
            of the navigation element-->
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
            <#--</span>-->
        </p>
        <p class="navigation">
            <span>
                <a href="/">
                    <img class="logo" src="/mw.png" alt="mwahaha" />
                </a>
            </span>
            <span><a>&gt;</a></span>
            <span><a>?</a></span>
            <span><a>&lt;</a></span>
        </p>
    </div>
    <div class="title">
        <span class="title">${title}</span>
    </div>
    <#list sections as section>
        <div class="section">${section}</div>
    </#list>
</div>
</body>
</html>