let form;
let xButtons;

window.onload = function() {
    form = document.forms['parameters'];
    xButtons = Array.from(document.getElementsByClassName('x-button'));
    for (button of xButtons) {
        button.onclick = function(event) {
            updateX(event.target.value);
        };
    };
};

function validateForm(form) {
    const REGEXP = /^[+-]?\d+(\.\d+)?$/;
    const yString = form.y.value;
    const y = parseFloat(yString);
    if (!REGEXP.test(yString) || isNaN(y) || y <= -5 || y >= 3) {
        alert(
            'Неверно указан параметр ‘y’.\n'+
            'Пожалуйста, введите число в интервале (-5 ... 3).'
        );
        return false;
    }
    return true;
}

function updateX(newValue) {
    form.x.value = newValue;
    for (btn of xButtons) {
        if (btn.value === newValue) {
            btn.classList.add('active');
        } else {
            btn.classList.remove('active');
        }
    }
}