
<?php
header("Content-Type: text/html;charset=utf-8");
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
$query = "SELECT username, password FROM customers WHERE username = '".$value['user']."'";
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

//echo $fila[0];
//echo ' == ';
//echo $value['user'];
   
        
if($fila[0] == $value['user']){
    
//echo $fila[1];
//echo ' == ';
//echo MD5($value['password']);

	if($fila[1] == MD5($value['password'])){
        

	echo json_encode(true, true);

	}

}
	
// Liberar resultados
mysql_free_result($result);


// Cerrar la conexión
mysql_close($link);

?>