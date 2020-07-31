<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
    <link rel="stylesheet"
          href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
          integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <style>
        <%@include file="styles/profile2.css" %>
    </style>
</head>
<style>
    div.a{
        border: 2px white;
        padding: 20px;
        width: 500px;
        resize: vertical;
    }
    div.header {
        background-color: cadetblue;
        padding: 20px;
        color:white;
        text-align: center;
    }
</style>
<body class="profile-page">
<div class="page-header header-filter" data-parallax="true"></div>
<div class="main main-raised">
    <div class="profile-content">
        <div class="container">
            <div class="row">
                <div class="col-md-6 ml-auto mr-auto">
                    <div class="profile" >
                        <div class="name" style="border-style: outset; background-color: #f3aa0c">
                            <h2 style="font-size: 430%; font-family: -moz-fixed;">${sessionScope.user.username}</h2>
                        </div>
                    </div>
                </div>
            </div>
            <form  id="myForm" action="/user/logout" method="get" onsubmit="true" method="get">
                <button type="submit" style="border-style: outset; width: 100px; background-color: #f3aa0c; color: black" class="btn btn-success btn-block">
                    Logout
                </button>
            </form>
            <form  id="myForm2" action="/user/adduniversity" method="get" onsubmit="true" method="get">
                <button type="submit" style="border-style: outset; width: 150px; background-color: #f3aa0c; color: black" class="btn btn-success btn-block">
                    Add University
                </button>
            </form>
        </div>
    </div>
    <div style="align-content: center; padding-top: 150px;">
        <div class="header">
        <p style="font-family: Shruti; font-size: 200%; ">Your Universities</p>
        </div>
        <div>
            <div class="a">
            <%@include file="../loggedInUserUniversityPage.jsp"%>
            </div>
        </div>
    </div>

</div>
<script>
    <%@include file="styles/profile2.js" %>
</script>
</body>