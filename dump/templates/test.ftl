<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>

<p>${me.name} by ${me.developer}</p>

<ul>
    <#list systems as system>
        <li>${system_index + 1}. ${system.name} from ${system.developer}</li>
    </#list>
</ul>

</body>
</html>