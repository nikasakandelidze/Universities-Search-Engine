<%--
  Created by IntelliJ IDEA.
  User: khati
  Date: 7/29/2020
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Subject</title>
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
<%@include file="helpers/navbar.jsp"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<div class="col-md-4 col-md-offset-4" id="register">
    <section id="inner-wrapper" class="register">
        <article>
            <p>
            <h1 style="text-align: center; font-family: Chandas">
                Subject Registration
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="subRegisterForm" action="/user/addsubject" method="post" onsubmit="return validateRequiredFields()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="number" id="SubId"class="form-control" placeholder="Subject Code" name="subjectId">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="number" id="SubFacId"class="form-control" placeholder="Faculty Id" name="facultyId">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="SubName"class="form-control" placeholder="Subject Name" name="subjectName">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="SubCredits" class="form-control" placeholder="Subject Credits" name="credits">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="SubDescriptions" class="form-control" placeholder="Subject Description" name="descriptions">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="number" id="SubSemester" class="form-control" placeholder="Semester" name="semester">
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
        var subjectId = document.getElementById("SubId").value;
        var facultyId = document.getElementById("SubFacId").value;
        var name = document.getElementById("SubName").value;
        var credits = document.getElementById("SubCredits").value;
        var descriptions = document.getElementById("SubDescriptions").value;
        var semester = document.getElementById("SubSemester").value;
        var inputsNotEmpty = true
        if( subjectId == "" ){
            inputsNotEmpty = false
            document.getElementById("SubId").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubId").style.backgroundColor=""
        }
        if( facultyId == "" ){
            inputsNotEmpty = false
            document.getElementById("SubFacId").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubFacId").style.backgroundColor=""
        }
        if( name == "" ){
            inputsNotEmpty = false
            document.getElementById("SubName").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubName").style.backgroundColor=""
        }
        if( credits == "" ){
            inputsNotEmpty = false
            document.getElementById("SubCredits").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubCredits").style.backgroundColor=""
        }
        if( descriptions == "" ){
            inputsNotEmpty = false
            document.getElementById("SubDescriptions").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubDescriptions").style.backgroundColor=""
        }
        if( semester == "" ){
            inputsNotEmpty = false
            document.getElementById("SubSemester").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("SubSemester").style.backgroundColor=""
        }

        return inputsNotEmpty
    }
</script>


