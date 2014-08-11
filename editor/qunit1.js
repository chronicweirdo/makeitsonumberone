QUnit.test("hello test", function(assert) {
    assert.ok(1 == "1", "Passed!");
});
function dummyList() {
    var list = ["one element"];
    return list;
}
QUnit.test("dummy list", function(assert) {
    assert.equal(dummyList().length, 1, "Dummy list length verification");
})

// testing and mocking
QUnit.test("getAllLeftSiblings", function(assert) {
    var startContainer = "start container";
    var parent = {};
    var sibling = "sibling";

    var parentParameters, contentsParameters;

    jQuery.parent = function(parameters) {
        parentParameters = parameters;
        return parent;
    }
    console.log("parent parameters: " + parentParameters);

    parent.contents = function(parameters) {
        contentsParameters = parameters;
        return [sibling];
    }
    console.log("contentsParameters: " + contentsParameters);

    var siblings = getAllLeftSiblings(startContainer);

    assert.ok(siblings.length > 0, "test result length");
})