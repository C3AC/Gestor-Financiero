/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

/**
* Esta clase generará las estadísticas y gráficas que se le mostrarán al usuario en base a su información. 
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
class Estadisticas {
    
	//[Atributos]
	
	/**
	* Mes para el que se calcularán las estadísticas y gráficas. 
	* Se solicitará al usuario que ingrese el mes en formato numérico. 
	*/
	private int mes;
	
	/**
	* Año del mes para el que se calcularán las estadísticas y gráficas. 
	* Se solicitará al usuario que ingrese el año en formato numérico. 
	*/
    private int year;
    
    /**
	* Ingresos totales.
	* Es la suma total de los ingresos del usuario en el mes y año especificados.
	* Este atributo representa un valor monetario en quetzales (Q). 
	*/
    private double ingresosTotales;
    
    /**
	* Gastos totales.
	* Es la suma total de los gastos del usuario en el mes y año especificados.
	* Este atributo representa un valor monetario en quetzales (Q). 
	*/
    private double gastosTotales;
    
    /**
	* Ahorros totales.
	* Es la suma total de ahorros del usuario en el mes y año especificados.
	* Este atributo representa un valor monetario en quetzales (Q). 
	*/
    private double ahorrosTotales;
    
    /**
	* Monto neto. 
	* Este valor se obtiene restando los gastos totales de los ingresos y los ahorros totales en el mes y año especificados.
	* Este atributo representa un valor monetario en quetzales (Q). 
	*/
    private double montoNeto;
    
    //[Constructor]
    
    /**
	* Constructor de la clase Estadisticas.
	* @param codigoIdentificacion Código de identificación (ID) del usuario.
	*/
    public Estadisticas(String codigoIdentificacion) {
    	 /*
         * Aquí se debe programar este método.
         */}
    
    //[Métodos]

    /**
	* Cálculo del monto neto del mes y año especificados.
	* @param mes El mes del que se desea calcular el monto neto.
	* @param year El año del mes del que se calculará el monto neto.
	* @return El monto neto para el mes ingresado por el usuario (en Q).
	*/
    public double calcularMontoNeto(int mes, int year) {
    	double montoNeto = 0.0;
	    /*
         * Aquí se debe programar este método.
         */
	    return montoNeto;}
    
    /**
	* Generador de la estadísticas y gráficas que se mostrarán al usuario.
	* @return Este método no devuelde nada
	*/
    public void mostrarEstadisticas() {
    	 /*
         * Aquí se debe programar este método.
         */}
    
    //Aquí estarán el resto de sus métodos...
}