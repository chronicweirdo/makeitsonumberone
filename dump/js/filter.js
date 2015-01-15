/*
On each page we have a filter. The filter contains tags.
Treat this as a component.

Actions:
    get filter values
    add to filter
    remove from filter
    get next - ajax call
    get previous - ajax call
    get pages - ajax call (paginated)
 */
if (typeof Filter === "undefined") {
    var Filter = {
        properties: {
            filterSelector: ".filter"
        },
        createItem: function(value) {
            return '<a class="tag" onclick="Filter.toggle(this);">' + value + '</a>'
        },
        getValue: function(item) {
            return $(item).text().trim();
        },
        getValues: function () {
            var filter = [];
            $(properties.filterSelector + " *").each(function (index, item) {
                filter.push(getValue(item));
            })
            return filter;
        },
        contains: function(value) {
            return getValues().indexOf(value) != -1;
        },
        toggle: function(element) {
            var value = getValue(element);

            var filter = getFilterValues();
            if (contains(value)) {
                $(properties.filterSelector + " *:contains(" + value + ")").remove();
            } else {
                $(properties.filterSelector).append(createItem(value));
            }
        },
        getNext: function() {

        },
        getPrevious: function() {

        },
        getPages: function(start, count) {
            var tags = getFilterValues();
            console.log(tags);
            var data = {
                'tag': tags
            };
            console.log(data);
            $.ajax({
                traditional: true,
                url: "filter",
                data: data,
                dataType : "json",
                success: function (data) {
                    console.log(data);
                }
            });
        }
    }
}

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