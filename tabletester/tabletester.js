/**
 * Created by scacoveanu on 2/10/2015.
 */
// setup constants
function setup() {
    // prepare the suffix
    var pathname = window.location.pathname;
    var from = pathname.lastIndexOf("/") + 1;
    var to = pathname.lastIndexOf(".");
    pathname = pathname.substring(from, to);
    pathname = pathname.replace("\\s", "_");
    window.SUFFIX = pathname;

    // creating cookie names for this page
    window.NAME_LAST = "last_" + SUFFIX;
    window.NAME_LEVELS = "levels_" + SUFFIX;

    // setting up jquery.cookie plugin
    $.cookie.json = true;
    $.cookie.path = window.location.pathname;
}

function readCookie(name) {
    var value = $.cookie(name);
    if (value == undefined) {
        return null;
    }
    return value;
}

function createCookie(name, value) {
    $.cookie(name, value, { expires: 365 });
}

function getTime() {
    return new Date().getTime();
}

// replace the practice button with a check button
function addCheckButton() {
    $("input[name=practice]").remove();
    var checkButtonDefinition = '<input name="check" ' +
        'type="button" value="check" onclick="check()" />';
    $(checkButtonDefinition).insertBefore($('table').first());
}

// this function decides how much time must pass before a concept is tested, based on that concept's level
function getTimeForLevel(level) {
    if (level == 0) return 0;
    var hour = 60 * 60 * 1000;
    return hour * Math.pow(2, level);
}

// this function decides whether we are testing a concept at the current time or not
function shouldTest(level, lastTested) {
    if (level == null || lastTested == null) {
        return true;
    }
    var elapsedTime = getTime() - lastTested;
    var timeForLevel = getTimeForLevel(level);
    return (elapsedTime >= timeForLevel);
}

/*
    save table data to a global variable for later reference
    replace table data with input fields
*/
function convert() {
    var last = readCookie(window.NAME_LAST);
    if (last == null) {
        last = [];
    }
    var levels = readCookie(window.NAME_LEVELS);
    if (levels == null) {
        levels = [];
    }
    console.log("last: " + last);
    console.log("levels: " + levels);
    window.data = [];
    $("table td").each( function(index) {
        var currentLevel = levels[index];
        var lastTested = last[index];
        if (shouldTest(currentLevel, lastTested)) {
            data[index] = $(this).html();
            $(this).html('<input type="text" value="" style="width: 100%;"/>');
        }
    });
}

// start the practice session
function practice() {
    addCheckButton();
    convert();
}

// add a button that will start the practice session
function addPracticeButton() {
    var practiceButtonDefinition = '<input name="practice"'
        + 'type="button" value="practice"'
        + 'onclick="practice()" />'
    $(practiceButtonDefinition).insertBefore($('table').first());
}

// check answers by comparing input fields
// if an answer is correct, make the input field background green
// if an answer is wrong, make the input field background red
// add the correct answer near fields where the user made a mistake
// compute the score - correctness percentage
// add score and reload buttons to page
function check() {
    var score = 0;
    var levels = readCookie(window.NAME_LEVELS);
    if (levels == null) {
        levels = [];
    }
    var last = readCookie(window.NAME_LAST);
    if (last == null) {
        last = [];
    }
    $("table td").each(function(index) {
        var input = $("input", this);
        if (input.length == 1) {
            last[index] = getTime();

            var correctValue = window.data[index];
            var value = $(input).val();
            var correct = (correctValue === value);
            if (correct) {
                $(input).css("background-color", "green");
                score = score + 1;
            } else {
                $(input).css("background-color", "red");
                $('<span>' + correctValue + '</span>').appendTo($(this));
            }

            var level = levels[index];
            if (level == null) {
                level = 0;
            }
            if (correct) {
                level = level + 1;
            } else {
                if (level > 0) {
                    level = level - 1;
                }
            }
            levels[index] = level;
        }
    });
    createCookie(window.NAME_LEVELS, levels);
    createCookie(window.NAME_LAST, last);
    var finalScore = (score / window.data.length) * 100;
    addScore(finalScore);
    addReloadButton();
}

// add the score to page
function addScore(score) {
    var scoreDefinition = '<span>score:' + score + '%</span>';
    $(scoreDefinition).insertBefore($('table').first());
}


// remove check button and add reload button
function addReloadButton() {
    $("input[name=check]").remove();
    var reloadButtonDefinition = '<input name="reload"' +
        'type="button" value="reload" onclick="location.reload()" />';
    $(reloadButtonDefinition).insertBefore($('table').first());
}

$(document).ready(function() {
    setup();
    addPracticeButton();
});