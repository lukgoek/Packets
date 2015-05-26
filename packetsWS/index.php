
<?php

echo "Web Service";

//Recivir parametros


$tipo;
$parametros;
//consultar en BD

//formato para salida
$personajes = array();

$personajes[0] = ["nombre" => "GOKU"];
$personajes[1] = ["nombre" => "VEGETA"];
$personajes[2] = ["nombre" => "TRUNKS"];


// Conectando, seleccionando la base de datos
$link = mysql_connect('localhost', 'root', '')
    or die('No se pudo conectar: ' . mysql_error());
echo 'Connected successfully';
mysql_select_db('packets') or die('No se pudo seleccionar la base de datos');


// Realizar una consulta MySQL
$query = 'SELECT * FROM customers';
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

// Liberar resultados
mysql_free_result($result);

echo json_encode($personajes);
// Cerrar la conexión
mysql_close($link);
?>