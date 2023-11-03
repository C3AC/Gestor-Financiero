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
* Esta clase representará a cada usuario del programa
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Usuario {
    
	//[Atributos]
	
    /**
	* Código de identificación (ID) del usuario.
	* Este código de 6 dígitos sirve para identificar de manera única a cada usuario dentro del sistema.
	*/
    private String codigoIdentificacion;
	
	/**
	* Nombre del usuario.
	*/
	private String nombre;
	
	/**
	* Apellido del usuario.
	*/
    private String apellido;
    
    /**
	* Sexo del usuario.
	*  Este atributo almacena el sexo del usuario. Las opciones disponibles son: Masculino ("m") y Femenino ("f").
	*/
    private String sexo;
    
    /**
	* Edad del usuario.
	* Este atributo será un valor numérico entero.
	*/
    private int edad;
    
    /**
	* Tipo de perfil del usuario.
	* Este atributo indica la categoría o rol al que pertenece el usuario. Las opciones disponibles son: "Padre/Madre", "Freelancer", "Estudiante".
	*/
    private String tipo_perfil;
    
    /**
	* Lista de registros financieros del usuario. 
	* Esta lista almacena registros financieros asociados al usuario. Estos registros pueden incluir ingresos, gastos o ahorros que el usuario haya registrado en su perfil.
	*/
    private ArrayList<Registro> registros;
    
    /**
	* Lista de distribución de porcentajes de categorías. 
	* Esta lista se utiliará para almacenar los porcentajes que le asignó el usuario a cada categoría. 
	*/
    private ArrayList<Double> lista_porcentajes;

    //[Constructor]
    
    /**
	* Constructor de la clase Usuario.
	* @param nombre El nombre del usuario.
	* @param apellido El apellido del usuario.
	* @param sexo El sexo del usuario.
	* @param edad La edad del usuario.
	* @param tipo_perfil El tipo de perfil del usuario.
	*/
    public Usuario(String id, String nombre, String apellido, String sexo, int edad, String tipo_perfil) {
        this.codigoIdentificacion = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.tipo_perfil = tipo_perfil;
        this.registros = new ArrayList<Registro>();
        this.lista_porcentajes = new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));}

    //[Métodos]
   
    /**
   	* Modificar el porcentaje de alguna categoría de gastos (si se puede).
   	* @param categoria La categoría de la que se desea modificar el porcentaje.
   	* @param porcentaje El nevo porcentaje para dicha categoría.
   	* @return Este método no devuelve nada.
   	*/
    public void distribuirPorcentajes(String categoria, double porcentaje) {
    	
    	ArrayList<String> categorias = new ArrayList<String>(Arrays.asList("Alimentos y bebidas","Vivienda","Transporte","Salud","Educacion","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"));
    	
    	//Obtener el índice de la categoría que desea modificar el usuario
    	int indice_categoria = categorias.indexOf(categoria);
    	
    	//Establecer el porcentaje indicado a la categoría
    	lista_porcentajes.set(indice_categoria, porcentaje);}
    

    /**
     * Sumar todos los valores de la lista de distribución de porcentajes de categorías.
     * @return La suma de los valores de la lista de distribución de porcentajes de categorías.
     */
    public double sumaPorcentajes() {
    	double totalPorcentajes = 0;
    	
    	for(int i=0;i<lista_porcentajes.size();i++) {
    		totalPorcentajes += lista_porcentajes.get(i);}
    	
    	return totalPorcentajes;}

    /**
	 * Obtiene el código de identificación (ID) del usuario.
	 * @return El código de identificación (ID) del usuario.
	 */
	public String getCodigoIdentificacion() {
		return codigoIdentificacion;}

	/**
	 * Obtiene el nombre completo del ususario (nombre y apellido separados por un espacio). 
	 * @return El nombre completo del usuario.
	 */
	public String getNombre_completo() {
		return nombre + " " + apellido;}
	
	/**
	 * Obtiene el tipo de perfil del usuario.
	 * @return El tipo de perfil del usuario.
	 */
	public String getTipo_perfil() {
		return tipo_perfil;}

	/**
	 * Obtiene la lista de registros financieros del usuario.
	 * @return La lista de registros financieros del usuario.
	 */
	public ArrayList<Registro> getRegistros() {
		return registros;}
	
	/**
	 * Obtiene la lista de distribución de porcentajes de categorías. 
	 * @return La lista de distribución de porcentajes de categorías. 
	 */
	public ArrayList<Double> getLista_porcentajes() {
		return lista_porcentajes;}

	/**
	 * Modifica la lista de registros financieros del usuario.
	 * @param registros La nueva lista de registros financieros para el usuario.
	 * @return Este método no devuelve nada.
	 */
	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;}
	
}