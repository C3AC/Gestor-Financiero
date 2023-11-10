/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 4]
Creación: 06 de octubre del 2023
Última modificación: 09 de noviembre del 2023*/

package proyecto2_poo;

/**
* Esta será una superclase que se utilizará para instanciar los ingresos, gastos y ahorros.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
abstract class Registro {
	
	//[Atributos]
	
	/**
	* Monto asociado al registro financiero. 
	* Este atributo representa un valor monetario en quetzales (Q). 
	*/
	protected double monto;
	
	/**
	* Descripción o comentario relacionado con el registro financiero. 
	* Este atributo puede proporcionar detalles adicionales sobre el ingreso, gasto o ahorro.
	*/
	protected String descripcion;
	
	/**
	* Mes en el que se realiza el registro financiero. 
	* Se solicitará al usuario que ingrese el mes en formato numérico. 
	*/
	protected int mes;
	
	/**
	* Año en el que se realiza el registro financiero. 
	* Se solicitará al usuario que ingrese el año en formato numérico. 
	*/
	protected int year;
	
	/**
	* Tipo de registro.
	* Hay 3 tipos de registro posibles: Gasto, Ingreso y Ahorro.
	*/
	protected String tipo_registro;

    //[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto El monto asociado al registro financiero. 
	* @param descripcion La descripción o comentario relacionado con el registro financiero. 
	* @param mes El mes en el que se realiza el registro financiero. 
	* @param year El año en el que se realiza el registro financiero. 
	* @param tipo_registro El tipo de registro.
	*/
	public Registro(double monto, String descripcion, int mes, int year, String tipo_registro) {
		this.monto = monto;
		this.descripcion = descripcion;
		this.mes = mes;
		this.year = year;
		this.tipo_registro = tipo_registro;}
	
    //[Métodos]

	/**
	 * Obtiene el monto asociado al registro financiero. 
	 * @return El monto asociado al registro financiero. 
	 */
	public double getMonto() {
		return monto;}

	/**
	 * Obtiene la descripción o comentario relacionado con el registro financiero. 
	 * @return La descripción o comentario relacionado con el registro financiero. 
	 */
	public String getDescripcion() {
		return descripcion;}

	/**
	 * Obtiene el mes en el que se realiza el registro financiero. 
	 * @return El mes en el que se realiza el registro financiero. 
	 */
	public int getMes() {
		return mes;}

	/**
	 * Obtiene el año en el que se realiza el registro financiero. 
	 * @return El año en el que se realiza el registro financiero. 
	 */
	public int getYear() {
		return year;}

	/**
	 * Obtiene el tipo de registro. 
	 * @return El tipo de registro. 
	 */
	public String getTipo_registro() {
		return tipo_registro;}
	
	/**
	 * Método abstracto para formatear la información del registro al formato reconocido por el archivo csv.
	 * @return La información del registro en el formato reconocido por el archivo csv.
	 */
	public abstract String formatoCSV();
	
}