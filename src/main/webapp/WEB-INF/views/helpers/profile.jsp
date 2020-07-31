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

<body class="profile-page">

<div class="page-header header-filter" data-parallax="true"
     style="background-image:url('http://wallpapere.org/wp-content/uploads/2012/02/black-and-white-city-night.png');"></div>
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
            <div class="row">
                <div class="col-md-6 ml-auto mr-auto">
                    <div class="profile-tabs">
                        <a href="/user/adduniversity" style="color: #4d90fe; font-size: 160%">
                            <div style="width: 150px; height: 50px; float: left;">
                                Add university
                            </div>
                        </a>
                        <a href="/user/addfaculty" style="color: #4d90fe;font-size: 160%">
                            <div style="width: 150px; height: 50px; float: left;">
                                Add faculty
                            </div>
                        </a>
                        </ul>
                        <a href="/user/addsubject" style="color: #4d90fe; font-size: 160%">
                            <div style="width: 150px; height: 50px; float: left;">
                                Add subject
                            </div>
                        </a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="align-content: center; padding-top: 150px;">
        <p style="font-family: Shruti; font-size: 200%; ">
            Your Universities
        </p>
        <div>
            <%@include file="../loggedInUserUniversityPage.jsp"%>
        </div>
    </div>

</div>
<script>
    <%@include file="styles/profile2.js" %>
</script>
</body>