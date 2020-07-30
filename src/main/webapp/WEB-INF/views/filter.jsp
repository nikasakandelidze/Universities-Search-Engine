<html>
<head>
    <style>
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
    </style>


    <label for="university">Choose a Filter Option:</label>

    <select id="university">
        <option value="university">Filter with University</option >
        <option value="faculty">Filter with Faculty</option>
        <option value="subject">Filter with Subject</option>
    </select>

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
            </p>
        </div>
    </form>
</head>
</html>
