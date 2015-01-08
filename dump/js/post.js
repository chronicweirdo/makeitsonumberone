function fixWidth(element, unit, padding, margin) {
    var width = $(element).width();
    var dW = Math.ceil((width + padding) / unit);
    var nw = unit * dW - margin;
    console.log(width + " " + dW + " " + nw);
    $(element).width(nw);
}

function fixTagWidths() {
    var padding = 20;
    var unit = 50;
    var margin = 1;
    $(".head .tag").each(function (index, element) {
        fixWidth(element, unit, padding, margin);
    })
    $(".head .title").each(function (index, element) {
        fixWidth(element, unit, padding, margin);
    })
}

$(document).ready(function() {
    fixTagWidths(50);

    /*$(window).resize(resizeLogo);
    resizeLogo();*/
});