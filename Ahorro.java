/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

/**
* Esta será una subclase de Registro, que será específica para representar los ahorros específicos que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Ahorro extends Registro {
	
	//[Constructor]
	
	/**
	* Constructor de la clase Ahorro.
	* @param monto -  Este atributo almacena el monto asociado al registro financiero. Puede representar un valor monetario en la moneda que desees.
	* @param descripcion - Almacena una descripción o comentario relacionado con el registro financiero. Puede proporcionar detalles adicionales sobre el ingreso, gasto o ahorro.
	* @param mes - Representa el mes en el que se registra el evento financiero. Puede ser un número entero que corresponda al mes del año.
	* @param year - Almacena el año en el que se registra el evento financiero. Puede ser un número entero que represente el año correspondiente.
	*/
	public Ahorro(double monto, String descripcion, int mes, int year) {
		super(monto, descripcion, mes, year);
	}
	
	//[Métodos]

    //Aquí estarán sus métodos específicos...
}