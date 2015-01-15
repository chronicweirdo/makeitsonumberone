function fixWidth(element, unit, padding, margin) {
    var width = $(element).width();
    var dW = Math.ceil((width + padding) / unit);
    var nw = unit * dW - margin;
    console.log(width + " " + dW + " " + nw);
    $(element).width(nw);
}

function fixWidths(jqueryFilter) {
    var padding = 20;
    var unit = 50;
    var margin = 1;
    $(jqueryFilter).each(function (index, element) {
        fixWidth(element, unit, padding, margin);
    });
}

function toggleFilter(element) {
    var tag = $(element).text().trim();
    console.log("toggling filter for: " + tag);

    var filter = getFilterValues();
    if (filter.indexOf(tag)  != -1) {
        $(".filter *:contains(" + tag + ")").remove();
    } else {
        $(".filter").append(getTagElement(tag));
        fixWidths(".filter > *");
    }
    console.log("filter: " + getFilterValues());
    load();
}

function getTagElement(tag) {
    return '<a class="tag" onclick="toggleFilter(this);">' + tag + '</a>'
}

$(document).ready(function() {
    fixWidths(".link > *");

    //console.log($(".logo.m img").first());
    /*resizeLogo();*/
});