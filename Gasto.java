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
	* Nombre del atributo...
	* Descripción...
	*/
	private String categoria;
	
	/**
	* Nombre del atributo
	* Descripción...
	*/
	private ArrayList<String> lista_categorias = new ArrayList<String>(Arrays.asList("Alimentos y bebidas","Vivienda","Transporte","Salud","Educación","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"));
		
	//[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto - Descripción...
	* @param descripcion - Descripción...
	* @param mes - Descripción...
	* @param year - Descripción...
	* @param categoria - Descripción...
	*/
	public Gasto(double monto, String descripcion, int mes, int year, String categoria) {
		super(monto, descripcion, mes, year);
		this.categoria = categoria;
	}
	
	//[Métodos]

    //Aquí estarán sus métodos específicos...
}