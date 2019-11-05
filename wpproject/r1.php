<?php
include("connection.php");
$r = $_GET['vehicle'];
$ci = $_GET['ci'];
$co = $_GET['co'];
?>
<!DOCTYPE <!DOCTYPE html>
<html>
<head>
    <title>TMS</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="img/icon" href="img/icon.png">
</head>
<body>
    <div id="full">
        <div id="rp" style="background-image:url('img/banner2.jpg'); height=1200px;">
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
            <div id="banner">
                <div id="form">
                    <form action="r1.php" method="post">
                        <table style="color: yellow;">
                            <?php
                                $q1 = "select * from vehicle where status='UnBooked'";
                                $run = mysqli_query($a,$q1);
                                $row = mysqli_fetch_array($run);
                                $vehicleno = $row['vehicleno'];

                                $q = "select * from vehicle where status='UnBooked'";
                                $run = mysqli_query($a,$q);
                                $num = mysqli_num_rows($run);
                                if($r <= $num)
                                {
                                    ?>
                                    <tr>
                                        <td>Status</td>
                                        <td><input type="text" name="status" value="Available" disabled="disabled" title="Status"></td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td><input type="text" name="name" placeholder="Enter Name" title="Name"></td>
                                        <td>ID no.</td>
                                        <td><input type="text" name="idno" placeholder="Enter ID" title="ID"></td>
                                    </tr>
                                    <tr>
                                        <td>City</td>
                                        <td><select name="city">
                                            <option>--select--</option>
                                            <option>Mumbai</option>
                                            <option>Delhi</option>
                                            <option>Banglore</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>District</td>
                                        <td><select name="dis">
                                            <option>--select--</option>
                                            <option>Mumbai</option>
                                            <option>Delhi</option>
                                            <option>Banglore</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>State</td>
                                        <td><select name="state">
                                            <option>--select--</option>
                                            <option>Mumbai</option>
                                            <option>Delhi</option>
                                            <option>Banglore</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>Enter E-mail</td>
                                        <td><input type="text" name="emial" placeholder="Enter E-mail" title="E-mail"></td>
                                    </tr>
                                    <tr>
                                        <td>Checkin date</td>
                                        <td><input type="text" name="coin" value="<?php echo $ci; ?>" title="Check in"></td>
                                        <td>Checkout date</td>
                                        <td><input type="text" name="coout" value="<?php echo $co; ?>" title="Check out"></td>
                                    </tr>
                                    <tr>
                                        <td>Vehicle</td>
                                        <td><input type="text" name="vehicles" value="<?php echo $r; ?>" title="vehicles"></td>
                                    </tr>
                                    <td>
                                        <td><input style="width:120px; height:30px; border-radius:20px; opacity:0.7" type="submit" name="submit" value="submit"></td>
                                    </td>
                        <?php   
                                }
                                else
                                {
                                    ?>
                                        <tr>
                                            <td>Status</td>
                                            <td><input type="text" name="status" value="Not-Available" disabled="disabled" title="Status"></td>
                                        </tr>
                                    <?php
                                }
                        ?>
                        </table>
                    </form>
                    <?php
                        if(isset($_POST['submit']))
                        {
                            $name = $_POST['name'];
                            $idno = $_POST['idno'];
                            $city = $_POST['city'];
                            $dis = $_POST['dis'];
                            $state = $_POST['state'];
                            $email = $_POST['email'];
                            $coin = $_POST['coin'];
                            $coout = $_POST['coout'];
                            $vehicle = $_POST['vehicles'];
                            if(mysqli_query($a,"insert into form(name,city,dis,email,state,cindate,coutdate,vehicle,idno) values('$name','$city','$dis',
                                '$email','$state','$coin','$coout','$vehicle','$idno')"))
                            {
                                mysqli_query($a,"update manage set status='Booked' where vehicleno=$vehicleno");
                                header("Location:f1.php");
                            }
                            else
                            {
                                echo "data not inserted";
                            }
                        }
                    ?>
                </div>
            </div>  
        </div>
    </div>
        
    </div>
</body>
</html>
