<!DOCTYPE <!DOCTYPE html>
<html>
<head>
    <title>TMS</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="img/icon" href="img/icon.png">
</head>
<body>
    <div id="full">
        <div id="home" style="background-image:url('img/banner4.jpg');background-size:100% 730px width=100%;height=730px;">
            <div id="header">
                <div id="logo">
                    <h1><font color="white">TMS</font></h1>
                </div>
                <div id="nav">
                    <ul>
                        <li><a href="./index.php">Home</a></li>
                        <li><a href="./contact.php">Contact Us</a></li>
                        <li><a href="./booking.php">Booking</a></li>
                        <!-- <li><a href="#">Our Places</a></li> -->
                        <!-- <li><a href="#">Help</a></li> -->
                    </ul>
                </div>
            </div>  
            <div id="banner"></div>  
            <div>
                <center><table>
                    <tr>
                        <th width="20%" height="50px">Destination</th>
                        <th width="20%" height="50px">Check In Date</th>
                        <th width="20%" height="50px">Check Out Date</th>
                        <th width="20%" height="50px">Vehicle</th>
                        <td rowspan="2"><input type="submit" value="Check" name="sub"></td>
                    </tr>
                    <tr>
                        <td width="20%" height="50px"><center><input type="text" name="d1" placeholder="Enter Destination"></center></td>
                        <td width="20%" height="50px"><center><input type="date" name="ci"></center></td>
                        <td width="20%" height="50px"><center><input type="date" name="co"></center></td>
                        <td width="20%" height="50px">
                            <center><select>
                                <option>Plane</option>
                                <option>Train</option>
                                <option>Bus</option>
                                <option>Car</option>
                                <option>Bike</option>
                            </select></center>
                        </td>
                    </tr>
                </table></center>
            </div>
        </div>
    </div>
</body>
</html>
