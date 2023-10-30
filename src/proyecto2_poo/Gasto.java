/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.ArrayList;
import java.util.Arrays;

/**
* Esta será una subclase de Registro, que será específica para representar los gastos que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Gasto extends Registro {
	
	//[Atributos]
	
	/**
	* Categoría a la que pertenece el gasto. 
	* Estas categorías ya están establecidas en la lista que también es atributo de esta clase. 
	*/
	private String categoria;
	
	/**
	* Lista de categorías. 
	* Esta lista contiene las 9 categorías predefinidas para los gastos.
	*/
	private final ArrayList<String> lista_categorias = new ArrayList<String>(Arrays.asList("Alimentos y bebidas","Vivienda","Transporte","Salud","Educación","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"));
		
	//[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto El monto asociado al gasto. 
	* @param descripcion La descripción o comentario relacionado con el gasto. 
	* @param mes El mes en el que se registra el gasto. 
	* @param year El año en el que se registra el gasto. 
	* @param categoria La categoría a la que pertenece el gasto. 
	*/
	public Gasto(double monto, String descripcion, int mes, int year, String categoria) {
		super(monto, descripcion, mes, year);
		this.categoria = categoria;}
	
	//[Métodos]

    //Aquí estarán sus métodos específicos...
}