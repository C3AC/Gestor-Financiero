/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

//Importar las librerías que harán falta
import java.util.ArrayList;
import java.util.Arrays;

/**
* Esta será una subclase de Registro, que será específica para representar los gastos específicos que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Gasto extends Registro {
	
	//[Atributos]
	
	/**
	* categoria
	* Almacena la categoría del gasto (ejemplo: "Alimentos y bebidas," "Vivienda," etc.).
	*/
	private String categoria;
	
	/**
	* lista_categorias
	* Una lista de categorías predefinidas para los gastos (ejemplo: "Salud," "Educación," etc.).
	*/
	private ArrayList<String> lista_categorias = new ArrayList<String>(Arrays.asList("Alimentos y bebidas","Vivienda","Transporte","Salud","Educación","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"));
		
	//[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto - Este atributo almacena el monto asociado al registro financiero. Puede representar un valor monetario en la moneda que desees.
	* @param descripcion - Almacena una descripción o comentario relacionado con el registro financiero. Puede proporcionar detalles adicionales sobre el ingreso, gasto o ahorro
	* @param mes - Representa el mes en el que se registra el evento financiero. Puede ser un número entero que corresponda al mes del año
	* @param year - Almacena el año en el que se registra el evento financiero. Puede ser un número entero que represente el año correspondiente
	* @param categoria -  El constructor de la clase Registro recibe como parámetros el monto, la descripción, el mes y el año asociados al registro financiero. Estos valores se utilizan para inicializar los atributos de la instancia de registro.
	*/
	public Gasto(double monto, String descripcion, int mes, int year, String categoria) {
		super(monto, descripcion, mes, year);
		this.categoria = categoria;
	}
	
	//[Métodos]

    //Aquí estarán sus métodos específicos...
}