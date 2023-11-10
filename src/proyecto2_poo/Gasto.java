/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 4]
Creación: 06 de octubre del 2023
Última modificación: 09 de noviembre del 2023*/

package proyecto2_poo;

/**
* Esta será una subclase de Registro, que será específica para representar los gastos que registre el usuario.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Gasto extends Registro {
	
	//[Atributos]
	
	/**
	* Categoría a la que pertenece el gasto. 
	* Hay 9 categorías (las cuales engloban todos los gastos posibles) que ya están establecidas y se le enlistarán al usuario.
	*/
	private String categoria;
		
	//[Constructor]
	
	/**
	* Constructor de la clase Registro.
	* @param monto El monto asociado al gasto. 
	* @param descripcion La descripción o comentario relacionado con el gasto. 
	* @param mes El mes en el que se registra el gasto. 
	* @param year El año en el que se registra el gasto. 
	* @param tipo_registro El tipo de registro. 
	* @param categoria La categoría a la que pertenece el gasto. 
	*/
	public Gasto(double monto, String descripcion, int mes, int year, String tipo_registro, String categoria) {
		super(monto, descripcion, mes, year, tipo_registro);
		this.categoria = categoria;}

	//[Métodos]
	
	/**
	 * Obtiene la categoría a la que pertenece el gasto. 
	 * @return La categoría a la que pertenece el gasto. 
	 */
	public String getCategoria() {
		return categoria;}
	
	/**
	 * Formatea la información del gasto al formato reconocido por el archivo csv.
	 * @return La información del gasto en el formato reconocido por el archivo csv.
	 */
	@Override
	public String formatoCSV() {
		
		//Crear un array de 6 strings (cada uno corresponderá a un encabezado del csv de registros)
		String[] datos = new String[6];
				
		//Guardar cada atributo en su posición correspondiente en el array (convertir los atributos numéricos a strings)
		datos[0] = "" + monto;
		datos[1] = descripcion;
		datos[2] = "" + mes;
		datos[3] = "" + year;
		datos[4] = "" + tipo_registro;
		datos[5] = categoria;
				
		//Unificar todos los elementos del array en un solo string, separados por comas (,)
		String linea_datos = String.join(",", datos);
		
		return linea_datos;}
}