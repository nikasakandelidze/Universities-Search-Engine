function validate() {
    return validatePassword() && validateRequiredFields();
}

function validateRequiredFields() {
    var username = document.getElementById("txtUsername").value;
    var password = document.getElementById("txtPassword").value;
    var confPassword = document.getElementById("txtConfirmPassword").value;
    var code = document.getElementById("txtCode").value;
    var inputsNotEmpty = true
    if (username == "") {
        inputsNotEmpty = false
        document.getElementById("txtUsername").style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.getElementById("txtUsername").style.backgroundColor = ""
    }
    if (password == "") {
        inputsNotEmpty = false
        document.getElementById("txtPassword").style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.getElementById("txtPassword").style.backgroundColor = ""
    }
    if (confPassword == "") {
        inputsNotEmpty = false
        document.getElementById("txtConfirmPassword").style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.getElementById("txtConfirmPassword").style.backgroundColor = ""
    }
    if (code == "") {
        inputsNotEmpty = false
        document.getElementById("txtCode").style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.getElementById("txtCode").style.backgroundColor = ""
    }
    return inputsNotEmpty
}

function validatePassword() {
    var password = document.getElementById("txtPassword").value;
    var confirmPassword = document.getElementById("txtConfirmPassword").value;
    if (password != confirmPassword) {
        window.alert("Passwords do not match.");
        return false;
    }
    return true;
}