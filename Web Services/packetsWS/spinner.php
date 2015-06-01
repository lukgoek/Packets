<?php


$value = json_decode(file_get_contents('php://input'), true);





// Conectao, seleccionando la base de datos
$link = mysql_connect('localhost', 'root', '')
    or die('No se pudo conectar: ' . mysql_error());
//echo 'Connected successfully';
mysql_select_db('packets') or die('No se pudo seleccionar la base de datos');


	if($value['queryType'] == 1){

		$query = "SELECT description FROM type_degree";
		$result = mysql_query($query) or die('Consulta fallida: ' . mysql_error());
		$fila = mysql_fetch_row($result);
	

		
		
    

		echo json_encode($fila, true);


	}

// Realizar una consulta MySQL



	     //echo json_encode($result, true);

    


// Cerrar la conexión
mysql_close($link);

?>