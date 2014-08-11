function getAllLeftSiblings(startContainer) {
    var collect = true;
    var siblings = [];
    var parent = $(startContainer).parent();
    var contents = parent.contents()
    contents.each(function(index, node) {
        if (collect) {
            if ($(node).is(startContainer)) {
                collect = false;
            } else {
                siblings.push(node);
            }
        }
    });
    return siblings;
}