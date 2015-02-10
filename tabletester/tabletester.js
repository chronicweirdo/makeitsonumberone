/**
 * Created by scacoveanu on 2/10/2015.
 */
var SUFFIX = window.location.pathname.substr(window.location.pathname.lastIndexOf('/')+1);
var NAME_LAST = "last_" + SUFFIX;
var NAME_LEVELS = "levels_" + SUFFIX;

function copyTables() {
    $("table").each(function() {
        var tableClone = $(this).clone();
        $(this).addClass("hidden");
        $(this).css("display", "none");
        tableClone.insertAfter($(this));
    });
}

function insertInput() {
    var level = getDisplayLevel();
    console.log("testing level: " + getDisplayLevel());
    var levels = readCookie(NAME_LEVELS);
    if (levels == null) {
        levels = [];
    }
    console.log("levels:");
    console.log(levels);
    $("table:not(.hidden) td").each( function(index) {
        var currentLevel = levels[index];
        if (currentLevel == null || currentLevel <= level) {
            $(this).html('<input type="text" value="" />');
        }
    });
}

function addCheckButton() {
    $("input[name=practice]").remove();
    $('<input name="check" type="button" value="check" onclick="check()" />').prependTo($("body"));
}

function addPracticeButton() {
    $('<input name="practice" type="button" value="practice" onclick="setupPractice()" />').prependTo($("body"));
}


function check() {
    var score = 0;
    var correctValues = $("table.hidden td");
    var levels = readCookie(NAME_LEVELS);
    console.log("levels:");
    console.log(levels);
    if (levels == null) {
        levels = [];
    }
    $("table:not(.hidden) td").each(function(index, element) {
        var input = $("input", this);
        if (input.length == 1) {
            var correctValue = $(correctValues[index]).html();
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
    createCookie(NAME_LEVELS, levels);
    var finalScore = (score / correctValues.length) * 100;
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
    var last = readCookie(NAME_LAST);
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
    createCookie(NAME_LAST, getTime());
}

function setupPractice() {
    copyTables();
    addCheckButton();
    insertInput();
}

$(document).ready(function() {

    $.cookie.json = true;
    $.cookie.path = window.location.pathname;
    addPracticeButton();
});