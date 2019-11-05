<!DOCTYPE <!DOCTYPE html>
<html>
<head>
    <title>TMS</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="img/icon" href="img/icon.png">
</head>
<body>
    <div id="full">
        <div id="home" style="background-image:url('img/banner4.jpg'); width=100%;height=600px;">
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
        </div>
    </div>
        <div id="f1">
            <form action="r1.php" method="get">
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
                            <center><select name="vehicle">
                                <option>Plane</option>
                                <option>Train</option>
                                <option>Bus</option>
                                <option>Car</option>
                                <option>Bike</option>
                            </select></center>
                        </td>
                    </tr>
                </table></center>
            </form>
        </div>
        <div id="welcome">
            <h1 align="center">Tourism Management System</h1>
            <center><font size="4">
            India is known among modern travelers for its colorful culture, rich history, beautiful landscapes and breathtaking architecture.<br>
            As recently as 2003, India was receiving fewer than 3 million foreign tourist arrivals each year,but the numbers have changed<br>
            drastically since then. Foreign tourist arrival numbers in 2017 exceeded 10 million,and analysts expect to see more than<br>
            15 million tourists visiting India annually by 2025.India's rapidly growing tourism sector now plays a huge role <br>
            in the nation's economy, supporting tens of millions of jobs and generating billions of dollars each year.
            </font>
            <h2 style="color:blue;">Our Places</h2>
            </center>
        </div>
        <div id="g1">
            <div id="one"><img src="img/g4.jpg" width="100%">
                <center>
                    <h2 style="color:blue">Karnataka</h2>
                    Karnataka is a state known for its ancient sculptured temples,<br>
                    modern cities with shopping and nightlife.Tourist attraction<br>
                    and places in Karnataka includes palaces, temples,<br>
                    sea beaches and group of monuments at Hampi.
                </center>
            </div>
            <div id="two"><img src="img/g7.jpg" width="100%">
                <center>
                    <h2 style="color:blue">Kerala</h2>
                    Kerala, in south India, is often referred to as "God's Own Country"<br>
                    for its unspoiled tropical beauty.This coastal state has a <br>
                    destination for everyone -- whether it's the beach, mountains,<br>
                    adventure, wildlife, heritage or culture you're interested in. 
                </center>
            </div>
            <div id="three"><img src="img/g3.jpg" width="100%">
                <center>
                    <h2 style="color:blue">Goa</h2>
                    Goa is known for the spectacular beaches it has. In fact, the beaches<br>
                    of Goa are so good that they are renowned all over the world.People<br>
                    from every corner of the world come to visit Goa and it is also<br>
                    considered to house some of the best beaches in the whole world. 
                </center>
            </div>
        </div>
    </div>
</body>
</html>
