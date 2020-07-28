function validateRequiredFields(){
    var code = document.getElementById("uniCode").value;
    var name = document.getElementById("uniName").value;
    var city = document.getElementById("uniCity").value;
    var address = document.getElementById("uniAddress").value;
    var web = document.getElementById("uniWeb").value;
    var description = document.getElementById("uniDescription").value;
    var inputsNotEmpty = true
    if( code == "" ){
        inputsNotEmpty = false
        document.getElementById("uniCode").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniCode").style.backgroundColor=""
    }
    if( name == "" ){
        inputsNotEmpty = false
        document.getElementById("uniName").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniName").style.backgroundColor=""
    }
    if( city == "" ){
        inputsNotEmpty = false
        document.getElementById("uniCity").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniCity").style.backgroundColor=""
    }
    if( address == "" ){
        inputsNotEmpty = false
        document.getElementById("uniAddress").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniAddress").style.backgroundColor=""
    }
    if( web == "" ){
        inputsNotEmpty = false
        document.getElementById("uniWeb").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniWeb").style.backgroundColor=""
    }
    if( description == "" ){
        inputsNotEmpty = false
        document.getElementById("uniDescription").style.backgroundColor="rgba(255,69,0, 0.2)"
    }else{
        document.getElementById("uniDescription").style.backgroundColor=""
    }

    return inputsNotEmpty
}