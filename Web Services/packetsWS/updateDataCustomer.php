

<?php

//$array = json_decode(entity, true);

$value = json_decode(file_get_contents('php://input'), true);

//echo $value['user'];
//echo md5($value['password']);


//consultar en BD

//formato para salida



// Conectao, seleccionando la base de datos
$link = mysql_connect('localhost', 'root', '')
    or die('No se pudo conectar: ' . mysql_error());
//echo 'Connected successfully';
mysql_select_db('packets') or die('No se pudo seleccionar la base de datos');


// Realizar una consulta MySQL
$query = "UPDATE customers SET name = '".$value['newName']."', last_name = '".$value['newLastName']."', address = '".$value['newAddress']."', phone = '".$value['newPhoneNumber']."', postal_code = '".$value['newPostalCode']."', city = '".$value['newCity']."', state = '".$value['newState']."', country = '".$value['newCountry']."', email = '".$value['newEmail']."', company_name = '".$value['newCompanyName']."', rfc = '".$value['newRFC']."', position = '".$value['newPosition']."' WHERE username = '".$value['user']."'";
$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());


	     echo json_encode('guardado');

    


// Cerrar la conexión
mysql_close($link);

?>