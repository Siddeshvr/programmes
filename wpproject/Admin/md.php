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
                <center><table style="color:white;">
                    <tr>
                        <th width="25%" height="50px">Vehicle No</th>
                        <th width="25%" height="50px">Vehicle Type</th>
                        <th width="25%" height="50px">Price</th>
                        <th width="25%" height="50px">Status</th>
                        <th width="25%" height="50px">Option</th>
                    </tr>
                    <?php
                        $q1="select *from manage";
                        $run=mysqli_query($a,$q1);
                        while($row = mysqli_fetch_array($run))
                        {
                            $vno = $row['vehicleno'];
                            $vtype = $row['vehicletype'];
                            $vprice = $row['vehicleprice'];
                            $status = $row['status'];
                    ?>
                    <tr>
                        <td width="25%" height="50px"><center><?php echo $vno; ?></center></td>
                        <td width="25%" height="50px"><center><?php echo $vtype; ?></center></td>
                        <td width="25%" height="50px"><center><?php echo $vprice; ?></center></td>
                        <td width="25%" height="50px"><center><?php echo $status; ?></center></td>
                        <td><a href="co.php? vehicleno=<?php echo $vno;?>">Check Out</a></td>
                    </tr>
                    <?php
                        }
                    ?>
                </table></center>
            </div>    
        </div>
    </div>
</body>
</html>
