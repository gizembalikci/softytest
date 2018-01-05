var password = document.signup.password;
var con_password = document.signup.conpassword;

function signUpFormValidation() {
    // Get the form values
    if(password.value !== con_password.value) {
        con_password.setCustomValidity("Passwords don't match");
        return false;
    }
    else{
        con_password.setCustomValidity('');
        return true;
    }
}

password.onchange = signUpFormValidation;
con_password.onkeyup = signUpFormValidation;