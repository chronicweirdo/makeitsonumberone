function loadNext(filterType, tags) {
    $.ajax({
        url: "filterNext",
        data: {
            'id': window.location.pathname,
            'filterType': "or",
            'tag': getFilter()
        },
        dataType: "json",
        context: $(".next"),
        success: function(result) {
            console.log(result);
        }
    }).done(function() {
        $(this).title()
    });
}
function getFilter() {

}

$(document).ready(function() {
    fixTagWidths(50);

    /*$(window).resize(resizeLogo);
    resizeLogo();*/
});