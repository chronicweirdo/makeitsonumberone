function fixTagWidths() {
    var padding = 20;
    var unit = 50;
    var margin = 1;
    $(".tag").each(function (index, element) {
        var width = $(element).width();
        var dW = Math.ceil((width + padding) / unit);
        var nw = unit * dW - margin;
        console.log(width + " " + dW + " " + nw);
        $(element).width(nw);
    })
}

$(document).ready(function() {
    fixTagWidths(50);

    /*$(window).resize(resizeLogo);
    resizeLogo();*/
});