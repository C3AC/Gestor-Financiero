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
import java.util.List;

/**
* Esta clase representará a cada usuario del programa
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Usuario {
    
	//[Atributos]
	
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
    private Boolean sexo;
    
    /**
	* Edad del usuario.
	* Este atributo será un valor numérico entero.
	*/
    private int edad;
    
    /**
	* Tipo de perfil del usuario.
	* Este atributo indica la categoría o rol al que pertenece el usuario. Las opciones disponibles son: "Padre/Madre", "Freelancer", "Estudiante".
	*/
    private String tipoPerfil;
    
    /**
	* Código de identificación (ID) del usuario.
	* Este código sirve para identificar de manera única a cada usuario dentro del sistema.
	*/
    private String codigoIdentificacion;
    
    /**
	* Registros financieros del usuario. 
	* Esta lista almacena registros financieros asociados al usuario. Estos registros pueden incluir ingresos, gastos o ahorros que el usuario haya registrado en su perfil.
	*/
    private ArrayList<Registro> registros;
    
    /**
	* Porcentajes de categorías. 
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
    public Usuario(String nombre, String apellido, Boolean sexo, int edad, String tipoPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.tipoPerfil = tipoPerfil;
        this.codigoIdentificacion = generarCodigo();
        this.registros = new ArrayList<>();
        this.lista_porcentajes = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));}

    //[Métodos]

    /**
	* Generador del código único de identificación.
	* @return El código único de identificación del usuario.
	*/
    private String generarCodigo() {
        //Generación del código único de identificación
        String codigo = "COD" + hashCode();
    	return codigo;}

    /**
	* Agregar un nuevo registro al usuario.
	* @param registro Registro (ingreso, ahorro o gasto) que se desea agregar al usuario.
	* @return Este método no devuelve nada.
	*/
    public void agregarRegistro(Registro registro) {
        registros.add(registro);}
    
    /**
	* Mostrar los registros del usuario.
	* @return Este método no devuelve nada
	*/
    public void verRegistros() {
        /*
         * Aquí se debe programar este método.
         */}
    
    /**
	* Eliminar un registro elegido por el usuario.
	* @return Este método no devuelve nada
	*/
    public void eliminarRegistro() {
        /*
         * Aquí se debe programar este método.
         */}
    
    /**
   	* Modificar el porcentaje de alguna categoría de gastos. 
   	* @param categoria Categoría de la que se desea modificar el porcentaje.
   	* @param porcentaje Nuevo porcentaje para dicha categoría.
   	* @return Este método no devuelve nada
   	*/
       public void distribuirPorcentajes(String categoria, double porcentaje) {
           /*
            * Aquí se debe programar este método.
            */}
}