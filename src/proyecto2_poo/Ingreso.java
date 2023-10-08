/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

/**
* Esta será una subclase de Registro, que será específica para representar los ingresos específicos que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Ingreso extends Registro {
	
	//[Constructor]
	
	/**
	* Constructor de la clase Ingreso.
	* @param monto - Descripción...
	* @param descripcion - Descripción...
	* @param mes - Descripción...
	* @param year - Descripción...
	*/
	public Ingreso(double monto, String descripcion, int mes, int year) {
		super(monto, descripcion, mes, year);
	}
	
	//[Métodos]

    //Aquí estarán sus métodos específicos...
}