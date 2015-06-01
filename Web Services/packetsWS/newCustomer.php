
<?php
header("Content-Type: text/html;charset=utf-8");
//$array = json_decode(entity, true);

$value = json_decode(file_get_contents('php://input'), true);




// Conectao, seleccionando la base de datos
$link = mysql_connect('localhost', 'root', '')
    or die('No se pudo conectar: ' . mysql_error());
//echo 'Connected successfully';
mysql_select_db('packets') or die('No se pudo seleccionar la base de datos');

$query = "SELECT username FROM customers WHERE username = '".$value['username']."'";
$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());
$fila = mysql_fetch_array($result);
//echo 'esto';
//echo $fila['username'];

if($fila['username'] == $value['username']){

    echo json_encode('dupliUsername');



}else{


// Realizar una consulta MySQL
$query = "INSERT INTO customers (name, last_name, address, phone, postal_code, city, state, country, degree, email, username, password, company_name, rfc, position) VALUES ('".$value['name']."', '".$value['lastName']."', '".$value['address']."', '".$value['phoneNumber']."', '".$value['postalCode']."', '".$value['city']."', '".$value['state']."', '".$value['country']."', '".$value['degree']."', '".$value['email']."', '".$value['username']."', MD5('".$value['password']."'), '".$value['companyName']."', '".$value['rfc']."', '".$value['position']."')";
$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());


	echo json_encode($result, true);
}
	
// Liberar resultados



// Cerrar la conexión
mysql_close($link);

?>