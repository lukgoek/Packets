

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
$query = "SELECT name, last_name, phone, address, postal_code, city, state, country, degree, email, username, company_name, rfc, position, registration_date FROM customers WHERE username = '".$value['user']."'";
$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());
$fila = mysql_fetch_row($result);
// Imprimir los resultados en HTML
//echo "<table>\n";
while ($line = mysql_fetch_array($result, MYSQL_ASSOC)) {
    //echo "\t<tr>\n";
    foreach ($line as $col_value) {
        //echo "\t\t<td>$col_value</td>\n";

    }
    //echo "\t</tr>\n";
}
//echo "</table>\n";

   		//echo $fila[11];
   		//echo $fila[12];
   		//echo $fila[13];
        //echo $fila[14];
    

	echo json_encode($fila, true);


	
// Liberar resultados
mysql_free_result($result);


// Cerrar la conexión
mysql_close($link);

?>