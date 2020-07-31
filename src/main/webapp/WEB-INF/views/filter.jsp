<html>
<head>
    <style>
        /* width */
        ::-webkit-scrollbar {
            width: 10px;
        }

        /* Track */
        ::-webkit-scrollbar-track {
            box-shadow: inset 0 0 5px grey; A
        border-radius: 10px;
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
            background: green;
            border-radius: 10px;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
            background: green;
        }
        .dark-mode {
            background-color: black;
            color: white;
        }
        div.k{
            text-align: center;
        }
        div.a {
            position: absolute;
            width: 350px;
            height: 90px;
            border: 1px solid black;
        }
        div.f {
            position: absolute;
            width: 350px;
            height: 150px;
            border: 1px solid black;
        }
        div.d {
            position: absolute;
            width: 350px;
            height: 50px;
            border: 1px solid black;
        }

        div.c {

            position: absolute;
            right: 150px;
            width: 200px;
            height: 120px;
            border: 3px  green;
        }
        .button {
            background-color: #4CAF50 ;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            width: 287px;
            height: 50px;
            cursor: pointer;
        }
        .header {
            background-color:#4CAF50 ;
            padding: 20px;
            color:white;
            text-align: center;
        }
        .footer {
            margin-bottom: 15px;
            padding: 4px 12px;
            background-color: yellow;
            border-left: 6px solid #f44336;
        }

    </style>

    <div class="header">
        <h1>Select Your Filter Options</h1>
    </div>
    <p>

    </p>
    <label for="university">Choose a Filter Option:</label>

    <select id="university">
        <option value="university">Filter with University</option >
        <option value="faculty">Filter with Faculty</option>
        <option value="subject">Filter with Subject</option>
    </select>


    <button   onclick="myFunction()">Toggle dark mode</button>


    <script>
        function myFunction() {
            var element = document.body;
            element.classList.toggle("dark-mode");
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <form method="post"
          enctype="application/x-www-form-urlencoded"
          action="https://pizza.example.com/order.cgi">
        <h1>University Search tools</h1>
        <div class="a">
            <p><label>University Name: <input name="universityName"></label></p>
            <p><label>University Address (city): <input name="universityCity">
                <h1>Faculty Search tools</h1>
                <div class="f">
            <p><label>University Faculty Category: <input name="facultyCategory" ></label>
            <p><label>Faculty Name: <input name="FacultyName">

                <div class="container">
                    <div class="styled-select">
                        <select id="minprice" name="minprice">
                            <option value="0" selected="selected">No minimum price</option>

                            <option value="2250"> 2250</option>
                            <option value="3500"> 3500</option>
                            <option value="4500"> 4500</option>
                            <option value="5500"> 5500</option>
                            <option value="6500"> 6500</option>
                            <option value="7500"> 7500</option>
                            <option value="8500"> 8500</option>
                            <option value="9500"> 9500</option>
                            <option value="10500"> 10500</option>
                            <option value="11500"> 11500</option>
                        </select>
                    </div>
                    <div class="styled-select">
                        <select id="maxprice" name="maxprice">
                            <option value="2000000" selected="selected">No maximum price</option>
                            <option value="2250"> 2250</option>
                            <option value="3500"> 3500</option>
                            <option value="4500"> 4500</option>
                            <option value="5500"> 5500</option>
                            <option value="6500"> 6500</option>
                            <option value="7500"> 7500</option>
                            <option value="8500"> 8500</option>
                            <option value="9500"> 9500</option>
                            <option value="10500"> 10500</option>
                            <option value="11500"> 11500</option>
                        </select>
                    </div>
                </div>

                <h1>Subject Search tools</h1>
                <div class="d">
            <p>
                <label>Subject Name : <input name="subjectName">
                </label>
                <div class="footer">
            <p><strong>Notice!</strong> "select filter option" is must </p>
        </div>
        <div class="button">
            <input type="button" class="button" value="Input Button"></div>
        </p>
        </div>


    </form>

</head>

</html>
