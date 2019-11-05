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
        <div id="home" style="background-image:url('../img/banner4.jpg');background-size:100% 730px width=100%;height=730px;">
            <div id="header">
                <div id="logo">
                    <h1><font color="white">TMS</font></h1>
                </div>
                <div id="nav">
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Booking</a></li>
                        <li><a href="#">Our Places</a></li>
                        <li><a href="#">Help</a></li>
                    </ul>
                </div>
            </div>  
            <div id="banner"><br><br><br>
                <center>
                    <div>
                        <form action="" method="post">
                            <table>
                                <tr>
                                    <td width="50%" height="50px">Username</td>
                                    <td width="50%" height="50px"><input type="text" name="username" placeholder="Enter Username" title="Enter Username"></td>
                                </tr>
                                <tr>
                                    <td width="50%" height="50px">Password</td>
                                    <td width="50%" height="50px"><input type="password" name="password" placeholder="Enter Password" title="Enter Password"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="submit" name="submit" value="Login" style="width:150px;height:50px;border-radius:30px;opacity:0.8"></td>
                                </tr>
                            </table>
                        </form>
                        <?php
                            if(isset($_POST['submit']))
                            {
                                $username = $_POST['username'];
                                $password = $_POST['password'];
                                $q1 = "select * from admin";
                                $run = mysqli_query($a,$q1);
                                $row = mysqli_fetch_array($run);
                                $u = $row['username'];
                                $p = $row['password'];
                                if($username==$u && $password==$p)
                                {
                                    header("Location:Admin_home.php");
                                }
                                else
                                {
                                    header("Location:Admin_index.php?Wrong User");
                                }
                            }
                        ?>
                    </div>
                </center>
            </div>    
        </div>
    </div>
</body>
</html>
