/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

/**
* Esta clase generará las estadísticas y gráficas que se le mostrarán al usuario en base a su información. 
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
class Estadisticas {
    
	//[Atributos]
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
	private int mes;
	
	/**
	* Nombre del atributo...
	* Descripción...
	*/
    private int year;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private double ingresosTotales;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private double gastosTotales;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private double ahorrosTotales;
    
    /**
	* Nombre del atributo...
	* Descripción...
	*/
    private double montoNeto;
    
    //[Constructor]
    
    /**
	* Constructor de la clase Estadisticas.
	* @param codigoIdentificacion - Descripción...
	*/
    public Estadisticas(String codigoIdentificacion) {
    	 /*
         * Aquí se debe programar este método.
         */
    }
    
    //[Métodos]

    /**
	* Cálculo del monto neto (ingresos+gastos-ahorros) del mes especificado.
	* @param mes - Mes del que se desea calcular el monto neto.
	* @param year - Año del mes del que se calculará el monto neto.
	* @return montoNeto - Monto neto para el mes ingresado por el usuario.
	*/
    public double calcularMontoNeto(int mes, int year) {
    	double montoNeto = 0.0;
	    /*
         * Aquí se debe programar este método.
         */
	    return montoNeto;
    }
    
    /**
	* Generador de la estadísticas y gráficas que se mostrarán al usuario.
	* @return void - Este método no devuelde nada
	*/
    public void mostrarEstadisticas() {
    	 /*
         * Aquí se debe programar este método.
         */
    }
    
    //Aquí estarán el resto de sus métodos...
}