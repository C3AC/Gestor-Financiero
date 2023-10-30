/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* Esta clase se encargará de manejar la lectura y escritura de datos en los archivos csv en los que se almacenarán los datos del programa (persistencia).
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class ArchivoCSV {
	
	//[Atributos]
	
	/**
	* Ruta del archivo con el que se trabajará. 
	* Este atributo especifica la ubicación del archivo en el sistema.
	*/
	private String rutaArchivo;

	//[Constructor]
	
	/**
	* Constructor de la clase ArchivoCSV.
	* @param rutaArchivo La ruta del archivo con el que se trabajará. 
	*/
    public ArchivoCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;}

    //[Métodos]
    
	/**
	 * Lee los datos de registros desde el archivo csv.
	 * @param lista_tickets La lista en la que se almacenarán los registros leídos del archivo csv.
	 * @return Este método no devuelve nada.
	 * @throws IOException Si ocurre un error al leer (o encontrar) el archivo.
	 */
	public void leerArchivo() {
        // Implementación para leer el archivo CSV
    }

    /**
	* Escribe los datos de los registros brindados en el archivo csv.
	* @param lista_registros La lista de registros a escribir en el archivo csv.
	* @return Este método no devuelve nada.
	* @throws IOException Si ocurre un error al escribir (o encontrar) el archivo.
	*/
    public void escribirArchivo(List<Registro> lista_registros) {
        // Implementación para escribir en el archivo CSV
    }
    
    //Aquí estáran el resto de sus métodos...
}