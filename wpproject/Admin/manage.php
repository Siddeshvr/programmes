<?php
include("../connection.php");
?>
<!DOCTYPE <!DOCTYPE html>
<html>
<head>
    <title>TMS</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="icon" type="img/icon" href="../img/icon.png">
</head>
<body>
    <div id="full">
        <div id="rp" style="background-image:url('../img/banner2.jpg'); height=1200px;">
            <div id="header">
                <div id="logo">
                    <h1><font color="white">TMS</font></h1>
                </div>
                <div id="nav">
                    <ul id="a1">
                        <li><a href="Admin_home.php">Home</a></li>
                        <li><a href="manage.php">Manage</a></li>
                        <li><a href="Admin_booking.php">Booking</a></li>
                        <li><a href="md.php">Management</a></li>
                        <li><a href="">Help</a></li>
                    </ul>
                </div>
            </div>  
            <div id="banner">
                <center><div id="form">
                    <form action="manage.php" method="post">
                        <table style="color: yellow;">
                            <tr>
                                <td>Vehicle No</td>
                                <td><input type="text" name="num" placeholder="Enter Vehicle No" title="Enter Vehicle No"></td>
                            </tr>
                            <tr>
                                <td>Vehicle Type</td>
                                <td><input type="text" name="type" placeholder="Enter Vehicle Type" title="Enter Vehicle Type"></td>
                            </tr>
                            <tr>
                                <td>Vehicle Price</td>
                                <td><input type="text" name="price" placeholder="Enter Vehicle Price" title="Enter Vehicle Price"></td>
                            </tr>
                            <td>
                                <td><input style="width:120px; height:30px; border-radius:20px; opacity:0.7" type="submit" name="submit" value="submit"></td>
                            </td>
                        </table>
                    </form>
                    <?php
                        if(isset($_POST['submit']))
                        {
                            $num = $_POST['num'];
                            $type = $_POST['type'];
                            $price = $_POST['price'];
                            if(mysqli_query($a,"insert into manage(vehicleno,vehicletype,vehicleprice) values('$num','$type','$price')"))
                            {
                                alert("data inserted");
                            }
                            else
                            {
                                alert("data not inserted");
                            }
                        }
                    ?>
                </div></center>
            </div>  
        </div>
    </div>
        
    </div>
</body>
</html>
