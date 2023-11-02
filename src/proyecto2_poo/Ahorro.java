/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

/**
* Esta será una subclase de Registro, que será específica para representar los ahorros que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Ahorro extends Registro {
	
	//[Constructor]
	
	/**
	* Constructor de la clase Ahorro.
	* @param monto El monto asociado al ahorro. 
	* @param descripcion La descripción o comentario relacionado con el ahorro. 
	* @param mes El mes en el que se registra el ahorro. 
	* @param year El año en el que se registra el ahorro. 
	* @param tipo_registro El tipo de registro. 
	*/
	public Ahorro(double monto, String descripcion, int mes, int year, String tipo_registro) {
		super(monto, descripcion, mes, year, tipo_registro);}
	
}