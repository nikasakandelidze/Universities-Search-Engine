<%--
  Created by IntelliJ IDEA.
  User: khati
  Date: 7/29/2020
  Time: 3:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.projectk.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/27/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Faculty</title>
    <style>
        body {
            background: #333;
        }

        #register {
            -webkit-perspective: 1000px;
            -moz-perspective: 1000px;
            perspective: 1000px;
            margin-top: 50px;
            margin-left: 30%;
        }

        .register .form-group {
            margin-bottom: 17px;
        }

        .register .form-control,
        .register .btn {
            border-radius: 0;
        }

        .register .btn {
            text-transform: uppercase;
            letter-spacing: 3px;
        }

        .input-group-addon {
            border-radius: 0;
            color: #fff;
            background: #f3aa0c;
            border: #f3aa0c;
        }

        .forgot a {
            color: #333;
        }

        .forgot a:hover {
            color: #5cb85c;
        }
    </style>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<div class="col-md-4 col-md-offset-4" id="register">
    <section id="inner-wrapper" class="register">
        <article>
            <p>
            <h1 style="text-align: center; font-family: Chandas">
                Faculty Registration
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="facRegisterForm" action="/addfaculty" method="post" onsubmit="return validateRequiredFields()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="number" id="facCode"class="form-control" placeholder="Faculty Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" id="facCategory"class="form-control" placeholder="Faculty Category" name="category">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="hidden" name="uniId" value="${sessionScope.user.university_id}" >
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="FacName" class="form-control" placeholder="Faculty Name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="FacDeanInfo" class="form-control" placeholder="Dean Info" name="dean">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="number" id="FacPrice" class="form-control" placeholder="Price" name="price">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="FacDescription" class="form-control" placeholder="Faculty Description" name="description">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="FacWebPage" class="form-control" placeholder="Faculty Web Page" name="webPage">
                    </div>
                </div>
                <button type="submit" class="btn btn-success btn-block">Submit</button>
            </form>
        </article>
    </section>
</div>
</body>
</html>
<script>
    function validateRequiredFields(){
        var code = document.getElementById("facCode").value;
        var category = document.getElementById("facCategory").value;
        var name = document.getElementById("FacName").value;
        var dean = document.getElementById("FacDeanInfo").value;
        var price = document.getElementById("FacPrice").value;
        var description = document.getElementById("uniDescription").value;
        var webPage = document.getElementById("FacWebPage").value;
        var inputsNotEmpty = true
        if( code == "" ){
            inputsNotEmpty = false
            document.getElementById("facCode").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("facCode").style.backgroundColor=""
        }
        if( category == "" ){
            inputsNotEmpty = false
            document.getElementById("facCategory").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("facCategory").style.backgroundColor=""
        }
        if( name == "" ){
            inputsNotEmpty = false
            document.getElementById("FacName").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("FacName").style.backgroundColor=""
        }
        if( dean == "" ){
            inputsNotEmpty = false
            document.getElementById("FacDeanInfo").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("FacDeanInfo").style.backgroundColor=""
        }
        if( price == "" ){
            inputsNotEmpty = false
            document.getElementById("FacPrice").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("FacPrice").style.backgroundColor=""
        }
        if( description == "" ){
            inputsNotEmpty = false
            document.getElementById("FacDescription").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("FacDescription").style.backgroundColor=""
        }
        if( webPage == "" ){
            inputsNotEmpty = false
            document.getElementById("FacWebPage").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("FacWebPage").style.backgroundColor=""
        }

        return inputsNotEmpty
    }
</script>

