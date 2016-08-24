var p = "";
var focus = "";
function fucnB(digit) {


    addDig(digit);
}
function addDig(dig) {
    if (p.length < 16) {
        p += dig;
        refreshForm();
    } else if (p > 17) {
        p = p.substring(0, 16);
        refreshForm();
    }
}

function refreshForm() {
    clearAll();
    if (p.length <= 4) {
        $('#txt1').val(p);

    }
    else if (p.length <= 8) {
        $('#txt1').val(p.substring(0, 4));
        $('#txt2').val(p.substring(4));
    }
    else if (p.length <= 12) {
        $('#txt1').val(p.substring(0, 4));
        $('#txt2').val(p.substring(4, 8));
        $('#txt3').val(p.substring(8));


    }
    else if (p.length <= 16) {
        $('#txt1').val(p.substring(0, 4));
        $('#txt2').val(p.substring(4, 8));
        $('#txt3').val(p.substring(8, 12));
        $('#txt4').val(p.substring(12));
    }
    if (p.length == 12 || p.length == 16) {
        $('#btnMenu').attr('value', 'ПРОДОВЖИТИ');

    } else {
        $('#btnMenu').attr('value', 'МЕНЮ');
    }
}

function clearAll() {
    $('#txt1').val("");
    $('#txt2').val("");
    $('#txt3').val("");
    $('#txt4').val("");


}
function reqForm() {
    if (p.length == 12 || p.length == 16)
        window.location = 'process-payment?code=' + p;
    else window.location.href = "select-operation";
}
function delLastChar() {

    if (p.length > 0) {
        p = p.substring(0, p.length - 1);

    }
    refreshForm();
}
function fucnA(digit) {

    addDigA(digit);
}

function funcC(difgit) {

    if (focus.length > 0)
        $('#' + focus).val(difgit);

}
function screenKeyBoard() {

    $('#visible').css({'display': 'block'});

}
function onFoc(id) {
    focus = id;
}
function addDigA(dig) {
    p += dig;
    refreshFormA();
}
function refreshFormA() {
    clearAllA();

    $('#ident').val(p);
}
function clearAllA() {

    $('#ident').val("");
}
function clearA() {
    p = "";
    clearAllA();
}
function delLastCharA() {
    if (p.length > 0) {
        p = p.substring(0, p.length - 1);
    }
    refreshFormA();

}
function reqLoginForm() {

    window.location.href = 'password-menu?code=' + p;
}
function reqPasswordForm() {

    window.location.href = 'cash-menu?code=' + p;
}
// modal form
var globalInterval;
var timeout;
var count;
var interval;
var modalClose = false;
//modal form with timer
function onLoad(open) {
    timeout = open;
    setTimeout(showModal, open);
}

function showModal() {

    $('#overlay').fadeIn(400,
        function () {
            $('#modal_form')
                .css('display', 'block')
                .animate({opacity: 1, top: '50%'}, 200);
        });

    count = document.getElementById('timer_inp').innerHTML;

    timer();
}

function showModalPlural() {
    $('#overlay').fadeIn(400,
        function () {
            $('#modal_form')
                .css('display', 'block')
                .animate({opacity: 1, top: '50%'}, 200);
        });

    modalClose=false;
    timer();
}
function timer() {
    var obj = document.getElementById('timer_inp');
    obj.innerHTML--;
    if (obj.innerHTML == 0) {
        myModalClose();
        window.location.href = 'start';
    } else if (modalClose) {

        obj.innerHTML = count;

    }
    else {
        setTimeout(timer, 1000);
    }


}
function restartModal() {


    setTimeout(showModalPlural, timeout);

}
function cleatIntervals() {
    if (interval != null)
        cleatInterval(interval);
    if (clearInterval != null)
        cleatInterval(globalInterval);

}
function myModalClose() {

    $('#modal_form')
        .animate({opacity: 0, top: '45%'}, 200,
            function () {
                $(this).css('display', 'none');
                $('#overlay').fadeOut(400);
            }
        );

    //document.getElementById('timer_inp').innerHTML = -1;
    //restartModal();
}
function specialModalClose() {
    modalClose = true;
    myModalClose();
    restartModal();

}

// error modal
function onLoadError(open) {
    timeout = open;
    setTimeout(showModalError, open);
}

function showModalError() {

    $('#overlay').fadeIn(400,
        function () {
            $('#modal_form')
                .css('display', 'block')
                .animate({opacity: 1, top: '50%'}, 200);
        });

    count = document.getElementById('timer_inp').innerHTML;

    timerError();
}

function showModalPluralError() {
    $('#overlay').fadeIn(400,
        function () {
            $('#modal_form')
                .css('display', 'block')
                .animate({opacity: 1, top: '50%'}, 200);
        });

    modalClose=false;
    timerError();
}
function timerError() {
    var obj = document.getElementById('timer_inp');
    obj.innerHTML--;
    if (obj.innerHTML == 0) {
        myModalCloseError();
        window.location.href = 'operation-time-check-exception';
    } else if (modalClose) {

        obj.innerHTML = count;

    }
    else {
        setTimeout(timerError, 1000);
    }


}
function restartModalError() {


    setTimeout(showModalPluralError, timeout);

}
function cleatIntervals() {
    if (interval != null)
        cleatInterval(interval);
    if (clearInterval != null)
        cleatInterval(globalInterval);

}
function myModalCloseError() {

    $('#modal_form')
        .animate({opacity: 0, top: '45%'}, 200,
            function () {
                $(this).css('display', 'none');
                $('#overlay').fadeOut(400);
            }
        );

    //document.getElementById('timer_inp').innerHTML = -1;
    //restartModal();
}
function specialModalCloseError() {
    modalClose = true;
    myModalCloseError();
    restartModalError();

}

