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
import java.util.List;

/**
* Esta clase representará a cada usuario del programa
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Usuario {
    
	//[Atributos]
	
	/**
	* nombre
	* Este atributo almacena el nombre del usuario, es decir, su nombre de pila.
	*/
	private String nombre;
	
	/**
	* apellido
	*  Almacena el apellido del usuario, que representa su apellido de familia o apellido paterno
	*/
    private String apellido;
    
    /**
	* sexo
	*  Este atributo almacena el sexo o género del usuario. Puede ser "masculino" o "femenino", o cualquier otra representación que indique el género del usuario.
	*/
    private Boolean sexo;
    
    /**
	* edad:
	* Almacena la edad del usuario como un valor numérico entero. Representa la edad en años del usuario.
	*/
    private int edad;
    
    /**
	* tipoPerfil
	* Este atributo almacena el tipo de perfil del usuario, que indica la categoría o rol al que pertenece el usuario. Puede ser "Padre/Madre", "Freelancer", "Estudiante" u otro tipo de perfil que el programa admita.
	*/
    private String tipoPerfil;
    
    /**
	* codigoIdentificacion
	* Almacena un código único de identificación generado automáticamente para cada usuario. Este código sirve para identificar de manera única a cada usuario dentro del sistema.
	*/
    private String codigoIdentificacion;
    
    /**
	* registros
	* Es una lista que almacena los registros financieros asociados al usuario. Estos registros pueden incluir ingresos, gastos o ahorros que el usuario haya registrado en su perfil financiero..
	*/
    private ArrayList<Registro> registros;
    
    /**
	* lista_porcentajes
	* Esta lista se utiliza para almacenar porcentajes de distribución en categorías financieras. Puede ser utilizada para asignar porcentajes a diferentes categorías de gastos o ahorros, dependiendo de la lógica de tu aplicación
	*/
    private ArrayList<Double> lista_porcentajes;

    //[Constructor]
    
    /**
	* Constructor de la clase Usuario.
	* @param nombre - Este atributo almacena el nombre del usuario, es decir, su nombre de pila.
	* @param apellido -  Almacena el apellido del usuario, que representa su apellido de familia o apellido paterno.
	* @param sexo - : Este atributo almacena el sexo o género del usuario. Puede ser "masculino" o "femenino", o cualquier otra representación que indique el género del usuario..
	* @param edad - Almacena la edad del usuario como un valor numérico entero. Representa la edad en años del usuario
	* @param tipo_perfil - Este atributo almacena el tipo de perfil del usuario, que indica la categoría o rol al que pertenece el usuario. Puede ser "Padre/Madre", "Freelancer", "Estudiante" u otro tipo de perfil que el programa admita.
	*/
    public Usuario(String nombre, String apellido, Boolean sexo, int edad, String tipoPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.tipoPerfil = tipoPerfil;
        this.codigoIdentificacion = generarCodigo();
        this.registros = new ArrayList<>();
        this.lista_porcentajes = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
    }

    //[Métodos]

    /**
	* Generador del código único de identificación.
	* @return codigo - El código único de identificación del usuario.
	*/
    private String generarCodigo() {
        //Generación del código único de identificación
        String codigo = "COD" + hashCode();
    	return codigo;
    }

    /**
	* Agregar un nuevo registro al usuario.
	* @param registro - Registro (ingreso, ahorro o gasto) que se desea agregar
	* @return void - Este método no devuelve nada
	*/
    public void agregarRegistro(Registro registro) {
        registros.add(registro);
    }
    
    /**
	* Mostrar los registros al usuario.
	* @return void - Este método no devuelve nada
	*/
    public void verRegistros() {
        /*
         * Aquí se debe programar este método.
         */
    }
    
    /**
	* Eliminar un registro elegido por el usuario.
	* @return void - Este método no devuelve nada
	*/
    public void eliminarRegistro() {
        /*
         * Aquí se debe programar este método.
         */
    }
    
    /**
   	* Eliminar un registro elegido por el usuario.
   	* @param categoria - Categoría que se desea modificar.
   	* @param porcentaje - Nuevo porcentaje para dicha categoría.
   	* @return void - Este método no devuelve nada
   	*/
       public void distribuirPorcentajes(String categoria, double porcentaje) {
           /*
            * Aquí se debe programar este método.
            */
       }
    
    //Aquí estarán el resto de sus métodos...
}