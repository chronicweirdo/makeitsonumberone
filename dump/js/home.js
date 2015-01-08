function fixWidths() {
    var headWidth = $(".head").width();
    console.log(headWidth);
    var logoWidth = 0;
    console.log($(".head .logo").length);
    $(".head .logo").each(function (index, element) {
        console.log(element);
        var elementWidth = parseInt($(element).width(), 10);
        console.log(elementWidth);
        logoWidth += elementWidth;
    });
    console.log(logoWidth);
    logoWidth = 330;
    var remainingWidth = headWidth - logoWidth;
    console.log(remainingWidth);
    if (remainingWidth > 0) {
        var separatorCount = $(".head .separator").length;
        var separatorWidth = remainingWidth / separatorCount;
        console.log(separatorWidth);
        $(".head .separator").width(separatorWidth);
    }
}

$(document).ready(function() {
    fixWidths();

    //console.log($(".logo.m img").first());
    console.log($('.logo').first().width());
    $(window).resize(fixWidths);
    /*resizeLogo();*/
});