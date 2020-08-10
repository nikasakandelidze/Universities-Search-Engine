function validateInput() {
    var username = document.forms["loginForm"]["username"].value;
    var password = document.forms["loginForm"]["password"].value;
    var errorMessage = "EmptyField"
    var inputsNotEmpty = true
    if (username == "") {
        inputsNotEmpty = false
        document.forms["loginForm"]["username"].style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.forms["loginForm"]["username"].style.backgroundColor = ""
    }
    if (password == "") {
        inputsNotEmpty = false
        document.forms["loginForm"]["password"].style.backgroundColor = "rgba(255,69,0, 0.2)"
    } else {
        document.forms["loginForm"]["username"].style.backgroundColor = ""
    }
    return inputsNotEmpty
}

function validateUpdate() {
    return sessionStorage.getItem("fromLogin") === "Y";
}