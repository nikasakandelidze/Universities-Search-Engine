<%--
  Created by IntelliJ IDEA.
  User: basa
  Date: 7/31/2020
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="helpers/navbar.jsp" %>
<p>
<h1 style="text-align: center; color:cadetblue;">
    University Subject dummy
</h1>
</p>
<div class="facultySubject">
    <c:forEach items="${allUniversities}" var="facultySub">
    <div class="list-group" style="height: 170px">
        <a href="/facSubPage/${university.id}" class="list-group-item list-group-item-action"
           style="border-radius: 10px">
            <div class="uni-name">
                <h4>${university.universityName}</h4>
            </div>
            <div class="uni-desc">
                <p id="demo">${university.descriptions}...</p>
            </div>
        </a>
    </div>
    </c:forEach>
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
                <form style="text-align: center" name="facRegisterForm" action="/user/addfaculty" method="post"
                      onsubmit="return validateRequiredFields()">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                            <input type="number" id="facCode" class="form-control" placeholder="Faculty Code"
                                   name="code">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                            <input type="text" id="facCategory" class="form-control" placeholder="Faculty Category"
                                   name="category">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                            <input type="hidden" name="uniId" value="${sessionScope.user.university_id}">
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
                            <input type="text" id="FacDeanInfo" class="form-control" placeholder="Dean Info"
                                   name="dean">
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
                            <input type="text" id="FacDescription" class="form-control"
                                   placeholder="Faculty Description" name="description">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                            <input type="text" id="FacWebPage" class="form-control" placeholder="Faculty Web Page"
                                   name="webPage">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success btn-block">Submit</button>
                </form>
            </article>
        </section>
    </div>
    <section id="inner-wrapper" class="register">
        <article>
            <p>
            <h1 style="text-align: center; color:cadetblue;">
                Registration Page
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="registerForm" action="/register" method="post"
                  onsubmit="return validate()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="text" id="txtUsername" class="form-control" placeholder="Username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" id="txtCode" class="form-control" placeholder="University Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtPassword" class="form-control" placeholder="Password"
                               name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtConfirmPassword" class="form-control"
                               placeholder="Confirm Password" name="confPassword">
                    </div>
                </div>
                <input type="submit"></input>
            </form>
        </article>
    </section>
</body>
</html>
