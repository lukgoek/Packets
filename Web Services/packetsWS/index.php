
<?php

$array = json_decode(entity, true);




//consultar en BD

//formato para salida
$Resultado;


// Conectao, seleccionando la base de datos
$link = mysql_connect('localhost', 'root', '')
    or die('No se pudo conectar: ' . mysql_error());
echo 'Connected successfully';
mysql_select_db('packets') or die('No se pudo seleccionar la base de datos');


// Realizar una consulta MySQL
$query = "SELECT username, password FROM customers WHERE username = '".$username."'";
$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());

// Imprimir los resultados en HTML
echo "<table>\n";
while ($line = mysql_fetch_array($result, MYSQL_ASSOC)) {
    echo "\t<tr>\n";
    foreach ($line as $col_value) {
        echo "\t\t<td>$col_value</td>\n";
    }
    echo "\t</tr>\n";
}
echo "</table>\n";

if($line[0] = $username){
	if($line[1] = $password){
		echo json_encode('true');

	}

}
// Liberar resultados
mysql_free_result($result);


// Cerrar la conexión
mysql_close($link);

?>