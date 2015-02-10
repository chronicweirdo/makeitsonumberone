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

    window.NAME_LAST = "last_" + SUFFIX;
    window.NAME_LEVELS = "levels_" + SUFFIX;
    $.cookie.json = true;
    $.cookie.path = window.location.pathname;
}

function check() {
    var score = 0;
    var levels = readCookie(window.NAME_LEVELS);
    if (levels == null) {
        levels = [];
    }
    $("table:not(.hidden) td").each(function(index, element) {
        var input = $("input", this);
        if (input.length == 1) {
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
    var finalScore = (score / window.data.length) * 100;
    $("input[name=check]").remove();
    $('<input name="reload" type="button" value="reload" onclick="location.reload()" />').prependTo($("body"));
    $('<span>score:' + finalScore + '%</span>').prependTo($("body"));

}

function createCookie(name, value) {
    $.cookie(name, value, { expires: 365 });
}

function getTime() {
    return new Date().getTime();
}

/*
 This function will check the saved last testing time and comapare it to the current
 time to figure out up to which level we are testing.
 */
function getDisplayLevel() {
    var last = readCookie(window.NAME_LAST);
    if (last == null) {
        last = getTime();
    }
    var current = getTime();
    var timeInterval = current - last;
    var hourInterval = timeInterval / (60 * 60 * 1000);
    var level = Math.floor(Math.sqrt(hourInterval));
    return level;
}

function readCookie(name) {
    var value = $.cookie(name);
    if (value == undefined) {
        return null;
    }
    return value;
}


function updateHistory(index, correct) {
    var name = document.location + index;
    var level = readCookie(name);
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
    createCookie(name, level);
}

function updateLastTested() {
    createCookie(window.NAME_LAST, getTime());
}

function addCheckButton() {
    $("input[name=practice]").remove();
    var checkButtonDefinition = '<input name="check" ' +
        'type="button" value="check" onclick="check()" />';
    $(checkButtonDefinition).prependTo($("body"));
}

function insertInput() {
    var level = getDisplayLevel();
    var levels = readCookie(window.NAME_LEVELS);
    if (levels == null) {
        levels = [];
    }
    window.data = [];
    $("table td").each( function(index) {
        var currentLevel = levels[index];
        if (currentLevel == null || currentLevel <= level) {
            data[index] = $(this).html();
            $(this).html('<input type="text" value="" />');
        }
    });
    console.log("hidden data");
    console.log(window.data);
}

function practice() {
    addCheckButton();
    insertInput();
}



function addPracticeButton() {
    var practiceButtonDefinition = '<input name="practice"'
        + 'type="button" value="practice"'
        + 'onclick="practice()" />'
    $(practiceButtonDefinition).prependTo($("body"));
}

$(document).ready(function() {
    setup();
    addPracticeButton();
});