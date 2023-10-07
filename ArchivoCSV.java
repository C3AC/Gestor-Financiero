/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

//Importar las librerías que harán falta
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* Esta clase se encargará de manejar la lectura y escritura de datos en los archivos csv en los que se almacenarán los datos del programa.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class ArchivoCSV {
	
	//[Atributos]
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	private String rutaArchivo;

	//[Constructor]
	
	/**
	* Constructor de la clase ArchivoCSV.
	* @param rutaArchivo - Descripción...
	*/
    public ArchivoCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    //[Métodos]
    
    /**
	* Lectura del archivo csv. 
	* @return void - Este método no devuelve nada.
	*/
    public void leerArchivo() {
        // Implementación para leer el archivo CSV
    }

    /**
	* Escritura del archivo csv. 
	* @return void - Este método no devuelve nada.
	*/
    public void escribirArchivo(List<String> informacion) {
        // Implementación para escribir en el archivo CSV
    }
    
    //Aquí estáran el resto de sus métodos...
}