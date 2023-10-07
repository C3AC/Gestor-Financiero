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
	* Nombre del atributo...
	* Descripción...
	*/
	private String nombre;
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
    private String apellido;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private String sexo;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private int edad;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private String tipoPerfil;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private String codigoIdentificacion;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private ArrayList<Registro> registros;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private ArrayList<Double> lista_porcentajes;

    //[Constructor]
    
    /**
	* Constructor de la clase Usuario.
	* @param nombre - Descripción...
	* @param apellido - Descripción...
	* @param sexo - Descripción...
	* @param edad - Descripción...
	* @param tipo_perfil - Descripción...
	*/
    public Usuario(String nombre, String apellido, String sexo, int edad, String tipoPerfil) {
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