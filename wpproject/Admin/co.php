<?php
    include("../connection.php");
    $vno = $_GET['vehicleno'];
    if(mysqli_query($a,"update manage set status='UnBooked' where vehicleno=$vno"))
    {
        header("Location:md.php");
    }
?>