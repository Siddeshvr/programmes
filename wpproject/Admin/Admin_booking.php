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
                    <ul id="a1">
                        <li><a href="Admin_home.php">Home</a></li>
                        <li><a href="manage.php">Manage</a></li>
                        <li><a href="Admin_booking.php">Booking</a></li>
                        <li><a href="md.php">Management</a></li>
                        <li><a href="#">Help</a></li>
                    </ul>
                </div>
            </div>  
            <div id="banner"><br><br><br>
                <h1 style="color:white; text-align:center">Welcome Admin</h1>
                <table style="color:white;">
                    <tr>
                        <th width="10%" height="50px">Name</th>
                        <th width="10%" height="50px">Id No.</th>
                        <th width="10%" height="50px">City</th>
                        <th width="10%" height="50px">District</th>
                        <th width="10%" height="50px">State</th>
                        <th width="10%" height="50px">Check In Date</th>
                        <th width="10%" height="50px">Check Out Date</th>
                        <th width="10%" height="50px">Vehicle</th>
                    </tr>
                    <?php
                        $q1="select *from form";
                        $run=mysqli_query($a,$q1);
                        while($row = mysqli_fetch_array($run))
                        {
                            $name = $row['name'];
                            $idno = $row['idno'];
                            $city = $row['city'];
                            $dis = $row['dis'];
                            $state = $row['state'];
                            $coin = $row['coin'];
                            $coout = $row['coout'];
                            $vehicle = $row['vehicles'];
                    ?>
                    <tr>
                        <td width="10%" height="50px"><center><?php echo $name; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $idno; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $city; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $dis; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $state; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $coin; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $coout; ?></center></td>
                        <td width="10%" height="50px"><center><?php echo $vehicle; ?></center></td>
                    </tr>
                    <?php
                        }
                    ?>
                </table>
            </div>    
        </div>
    </div>
</body>
</html>
