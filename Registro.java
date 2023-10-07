/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

/**
* Esta será una superclase que se utilizará para instanciar los ingresos, gastos y ahorros.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
abstract class Registro {
	
	//[Atributos]
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	protected double monto;
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	protected String descripcion;
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	protected int mes;
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	protected int year;

    //[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto - Descripción...
	* @param descripcion - Descripción...
	* @param mes - Descripción...
	* @param year - Descripción...
	*/
	public Registro(double monto, String descripcion, int mes, int year) {
		this.monto = monto;
		this.descripcion = descripcion;
		this.mes = mes;
		this.year = year;
	}
	
    //[Métodos]

	//Aquí estarán el resto de sus métodos...
}