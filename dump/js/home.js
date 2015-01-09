function fixWidth(element, unit, padding, margin) {
    var width = $(element).width();
    var dW = Math.ceil((width + padding) / unit);
    var nw = unit * dW - margin;
    console.log(width + " " + dW + " " + nw);
    $(element).width(nw);
}

function fixWidths() {
    var padding = 20;
    var unit = 50;
    var margin = 1;
    $(".link > *").each(function (index, element) {
        fixWidth(element, unit, padding, margin);
    });
}

$(document).ready(function() {
    fixWidths();

    //console.log($(".logo.m img").first());
    /*resizeLogo();*/
});