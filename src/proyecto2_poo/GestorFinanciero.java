/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.ArrayList;
import java.util.Scanner;

/**
* Esta clase es el driver program. Es decir, la clase que conectará todas las demás clases y hará funcionar el gestor financiero.
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 02/09/2023
*/
class GestorFinanciero {

	/**
	* Método principal.
	* En este método se desarrollará todo el programa.
	* @param String[] args
	* @return void - Este método no devuelve nada
	*/
	public static void main(String[] args) {
		
		//Lista en la que se almacenarán los usuarios del programa
		ArrayList<Usuario> lista_usuarios = new ArrayList <Usuario>();
		
		//Lista en la que se almacenarán los códigos de identificación del programa
		ArrayList<String> lista_ids = new ArrayList <String>();
		
		//Crear los scanners que registrarán los datos ingresados por el ususario
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		Scanner scanDouble = new Scanner(System.in);
		
		boolean menu_principal = true;
		while(menu_principal) {
			
			//Menú que se le mostrará al usuario
			System.out.println("\n\n-------------------BIENVENIDO/A A TU GESTOR FINANCIERO-------------------");
			System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Crear un perfil.\n2. Acceder a un perfil.\n3. Salir del programa.");
			
			int decision_principal = 0;
			try {decision_principal = scanInt.nextInt();} 
			catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número 
				System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
				scanInt.nextLine();
				continue;}
				
			switch(decision_principal) 
			{
				case 1:{//Crear un perfil
					System.out.println("\n----------------------------CREAR UN PERFIL----------------------------");
					crearPerfil(lista_usuarios,lista_ids,scanString,scanInt);
					break;}
				
				case 2:{//Acceder a un perfil
					System.out.println("\n---------------------------ACCEDER A UN PERFIL---------------------------");
					if(lista_usuarios.size()>0) {
						accederPerfil(lista_usuarios,lista_ids,scanString,scanInt,scanDouble);}
					else {
						System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun usuario registrado en el gestor financiero.");}
					break;}
				
				case 3:{//Salir del programa
					//Terminar el bucle del menú principal
					menu_principal = false;
					//Mostrar al ususario que ha abandonado el programa
					System.out.println("\nHa abandonado el programa exitosamente.");
					//Cerrar todos los scanners
					scanInt.close();
					break;}
				
				default:{//Opción no disponible (programación defensiva)
					System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}}
	
	/**
	 * Genera un código de identificacion (ID) de 6 dígitos para el usuario y verifica que no esté repetido.
	 * @param lista_usuarios La lista de usuarios de la que se obtienen los códigos de identificación que ya están en uso.
	 * @return El código de identificación (ID) único para el usuario.
	 */
	public static String generarID(ArrayList<Usuario> lista_usuarios) {
		String id_string = "";
		int id = 0, contador;
		
		//Ciclo para validar el id seleccionado
		boolean validar_id = true;
		while (validar_id) {
			contador = 0;//Setear el contador en 0
			id = (int)(Math.random()*899999)+100000; //Generar un número entero aleatorio entre 100000 y 999999 (6 dígitos)
			id_string = "" + id;//Convertir el id en string
			
			for(int i=0;i<lista_usuarios.size();i++) {//Por cada ticket de la lista de tickets
				Usuario usuario = lista_usuarios.get(i);
				if(id_string.compareTo(usuario.getCodigoIdentificacion())!=0) {//Si el id generado es diferente al id del i-ésimo ticket
					contador++;}}//Sumar 1 al contador
			
			if(contador==lista_usuarios.size()) {//Si el contador tiene la misma cantidad de elementos que la lista de tickets (ya que se sumó 1 por cada ticket con ID diferente)
				validar_id = false;}}//Salir del ciclo
		
		return id_string;}
	
	/**
	 * Registro de datos y creación de perfil.
	 * @param lista_usuarios La lista de usuarios en la que se deben almacenar los perfiles creados.
	 * @param lista_ids La lista en la que se deben almacenar los códigos de identificación de los perfiles creados.
	 * @param scanString El scanner para registrar los textos ingresados por el usuario.
	 * @param scanInt El scanner para registrar los números enteros ingresados por el usuario.
	 * @return Este método no devuelve nada.
	 */
	public static void crearPerfil(ArrayList<Usuario> lista_usuarios, ArrayList<String> lista_ids, Scanner scanString, Scanner scanInt) {
		
		//Tipos de perfiles disponibles
		String [] tipos_de_perfiles = {"Padre/Madre","Freelancer","Estudiante"};

		int decision_perfil = 0;
	    boolean seleccion_perfil = true;
	    while(seleccion_perfil) {
	        System.out.println("\nSeleccione el numero correspondiente a su categoria de perfil: ");
	        for(int i=0;i<tipos_de_perfiles.length;i++) {
	            System.out.println((i+1) + ". " + tipos_de_perfiles[i]);}
	        
	        try {decision_perfil = scanInt.nextInt()-1;} 
	        catch(Exception e) {
	            System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
	            scanInt.nextLine();
	            continue;}
	        
	        if((decision_perfil>=0)&&(decision_perfil<tipos_de_perfiles.length)) {
	            seleccion_perfil = false;} 
	        
	        else {
	            System.out.println("\n**ERROR** El numero ingresado no se encuentra entre las opciones disponibles.");}}
	    
	    if(tipos_de_perfiles[decision_perfil].equals("Padre/Madre")) {//El tipo de perfil es de Padre/Madre
	        
	    	System.out.println("\nPADRE/MADRE");
	        
	    	//Atributos necesarios para la creación del perfil
	    	String id,nombre_completo,nombre="",apellido="",tipo_perfil,sexo="";
	        int edad=0;
	        
	        //[Registro de datos para crear el perfil de Padre/Madre]
	        
	        id = generarID(lista_usuarios);
	        
	        //Ciclo para validar el nombre completo del usuario
	        boolean validar_nombre = true;
			while(validar_nombre) {
				System.out.println("Ingrese su primer nombre y apellido separados por un espacio (ej. 'Nombre Apellido'):");
				nombre_completo = scanString.nextLine();
				String[] nombre_completo_usuario = nombre_completo.trim().split(" ");
				
				if(nombre_completo_usuario.length==2) {//Si el nombre ingresado tiene 2 palabras
					validar_nombre = false;//Salir del ciclo
					nombre = nombre_completo_usuario[0];
					apellido = nombre_completo_usuario[1];}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** Ingrese sus datos en el formato solicitado.\n");}}
	        
			//Ciclo para validar el sexo del usuario
	        boolean validar_sexo = true;
			while(validar_sexo) {
				System.out.println("Ingrese su sexo ('M' o 'F'):");
				sexo = scanString.nextLine().toUpperCase();
				
				if(sexo.equals("M")||sexo.equals("F")) {
					validar_sexo = false;}//Salir del ciclo}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** El sexo ingresado no es valido.\n");}}
			
			//Iniciar ciclo para el try-catch de la edad del ususario
			boolean validar_edad = true;
			while(validar_edad) {
				try {System.out.println("Ingrese su edad (en formato numerico):");
					edad = scanInt.nextInt();}
				
				catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
					System.out.println("**ERROR** La edad debe ser un dato numerico entero.\n");
					scanInt.nextLine();
					continue;}
				
				if(edad<=0) {//Si la edad ingresada es menor o igual a 0
					System.out.println("**ERROR** La edad no puede ser menor o igual a 0.\n");}
				
				else {//Salir del ciclo
					validar_edad = false;}}
			
			tipo_perfil = tipos_de_perfiles[decision_perfil];
	        
			//Instanciar el perfil y agregarlo a la lista de ususarios (también agregar su código de la lista de códigos).
	        Usuario nuevo_usuario = new Usuario(id,nombre,apellido,sexo,edad,tipo_perfil);
	        lista_usuarios.add(nuevo_usuario);
	        lista_ids.add(id);
	        
	        //Notificar al usuario y brindarle su código de identificación.
	        System.out.println("\nPERFIL CREADO EXITOSAMENTE.");
	        System.out.println(nombre + " (" + tipo_perfil + "), su codigo de identificacion es: " + id + ". \nSe le recomienda guardar este ID, ya que sera necesario para acceder a su perfil.");}
	    
	    else if(tipos_de_perfiles[decision_perfil].equals("Freelancer")) {//El tipo de perfil es de Freelancer
	        
	    	System.out.println("\nFREELANCER");
	        
	    	//Atributos necesarios para la creación del perfil
	    	String id,nombre_completo,nombre="",apellido="",tipo_perfil,sexo="";
	        int edad=0;
	        
	        //[Registro de datos para crear el perfil de Freelancer]
	        
	        id = generarID(lista_usuarios);
	        
	        //Ciclo para validar el nombre completo del usuario
	        boolean validar_nombre = true;
			while(validar_nombre) {
				System.out.println("Ingrese su primer nombre y apellido separados por un espacio (ej. 'Nombre Apellido'):");
				nombre_completo = scanString.nextLine();
				String[] nombre_completo_usuario = nombre_completo.trim().split(" ");
				
				if(nombre_completo_usuario.length==2) {//Si el nombre ingresado tiene 2 palabras
					validar_nombre = false;//Salir del ciclo
					nombre = nombre_completo_usuario[0];
					apellido = nombre_completo_usuario[1];}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** Ingrese sus datos en el formato solicitado.\n");}}
	        
			//Ciclo para validar el sexo del usuario
	        boolean validar_sexo = true;
			while(validar_sexo) {
				System.out.println("Ingrese su sexo ('M' o 'F'):");
				sexo = scanString.nextLine().toUpperCase();
				
				if(sexo.equals("M")||sexo.equals("F")) {
					validar_sexo = false;}//Salir del ciclo}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** El sexo ingresado no es valido.\n");}}
			
			//Iniciar ciclo para el try-catch de la edad del ususario
			boolean validar_edad = true;
			while(validar_edad) {
				try {System.out.println("Ingrese su edad (en formato numerico):");
					edad = scanInt.nextInt();}
				
				catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
					System.out.println("**ERROR** La edad debe ser un dato numerico entero.\n");
					scanInt.nextLine();
					continue;}
				
				if(edad<=0) {//Si la edad ingresada es menor o igual a 0
					System.out.println("**ERROR** La edad no puede ser menor o igual a 0.\n");}
				
				else {//Salir del ciclo
					validar_edad = false;}}
			
			tipo_perfil = tipos_de_perfiles[decision_perfil];
			
	        //Instanciar el perfil y agregarlo a la lista de ususarios (también agregar su código de la lista de códigos).
	        Usuario nuevo_usuario = new Usuario(id,nombre,apellido,sexo,edad,tipo_perfil);
	        lista_usuarios.add(nuevo_usuario);
	        lista_ids.add(id);
	        
	        //Notificar al usuario y brindarle su código de identificación.
	        System.out.println("\nPERFIL CREADO EXITOSAMENTE.");
	        System.out.println(nombre + " (" + tipo_perfil + "), su codigo de identificacion es: " + id + ". \nSe le recomienda guardar este ID, ya que sera necesario para acceder a su perfil.");}
	    
	    else if(tipos_de_perfiles[decision_perfil].equals("Estudiante")) {//El tipo de perfil es de Estudiante
	        
	    	System.out.println("\nESTUDIANTE");
	        
	    	//Atributos necesarios para la creación del perfil
	    	String id,nombre_completo,nombre="",apellido="",tipo_perfil,sexo="";
	        int edad=0;
	        
	        //[Registro de datos para crear el perfil de Estudiante]
	        
	        id = generarID(lista_usuarios);
	        
	        //Ciclo para validar el nombre completo del usuario
	        boolean validar_nombre = true;
			while(validar_nombre) {
				System.out.println("Ingrese su primer nombre y apellido separados por un espacio (ej. 'Nombre Apellido'):");
				nombre_completo = scanString.nextLine();
				String[] nombre_completo_usuario = nombre_completo.trim().split(" ");
				
				if(nombre_completo_usuario.length==2) {//Si el nombre ingresado tiene 2 palabras
					validar_nombre = false;//Salir del ciclo
					nombre = nombre_completo_usuario[0];
					apellido = nombre_completo_usuario[1];}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** Ingrese sus datos en el formato solicitado.\n");}}
	        
			//Ciclo para validar el sexo del usuario
	        boolean validar_sexo = true;
			while(validar_sexo) {
				System.out.println("Ingrese su sexo ('M' o 'F'):");
				sexo = scanString.nextLine().toUpperCase();
				
				if(sexo.equals("M")||sexo.equals("F")) {
					validar_sexo = false;}//Salir del ciclo}
				
				else {//Solicitar que lo vuelva a introducir
					System.out.println("**ERROR** El sexo ingresado no es valido.\n");}}
					
			//Iniciar ciclo para el try-catch de la edad del ususario
			boolean validar_edad = true;
			while(validar_edad) {
				try {System.out.println("Ingrese su edad (en formato numerico):");
					edad = scanInt.nextInt();}
				
				catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
					System.out.println("**ERROR** La edad debe ser un dato numerico entero.\n");
					scanInt.nextLine();
					continue;}
				
				if(edad<=0) {//Si la edad ingresada es menor o igual a 0
					System.out.println("**ERROR** La edad no puede ser menor o igual a 0.\n");}
				
				else {//Salir del ciclo
					validar_edad = false;}}
			
			tipo_perfil = tipos_de_perfiles[decision_perfil];
	        
			//Instanciar el perfil y agregarlo a la lista de ususarios (también agregar su código de la lista de códigos).
	        Usuario nuevo_usuario = new Usuario(id,nombre,apellido,sexo,edad,tipo_perfil);
	        lista_usuarios.add(nuevo_usuario);
	        lista_ids.add(id);
	        
	        //Notificar al usuario y brindarle su código de identificación.
	        System.out.println("\nPERFIL CREADO EXITOSAMENTE.");
	        System.out.println(nombre + " (" + tipo_perfil + "), su codigo de identificacion es: " + id + ". \nSe le recomienda guardar este ID, ya que sera necesario para acceder a su perfil.");}}

	/**
	 * Acceso a un perfil y todas las opciones dentro de este.
	 * @param lista_usuarios La lista de usuarios del gestor financiero. 
	 * @param lista_ids La lista de los códigos de identificación de los usuarios del gestor financiero.
	 * @param scanString El scanner para registrar los textos ingresados por el usuario.
	 * @param scanInt El scanner para registrar los números enteros ingresados por el usuario.
	 * @param scanDouble El scanner para registrar los números decimales ingresados por el usuario.
	 * @return Este método no devuelve nada.
	 */
	public static void accederPerfil(ArrayList<Usuario> lista_usuarios, ArrayList<String> lista_ids, Scanner scanString, Scanner scanInt, Scanner scanDouble) {
	    
	    //En esta variable se registrará el código de identificación ingresado por el ususario
	    int codigo_acceso = 0;
	   
	    //Iniciar ciclo para el try-catch del código de identificación del ususario
	    boolean acceder_perfil = true;
	    while(acceder_perfil) {
	        try{System.out.println("\nIngrese su codigo de identificacion: ");
	        codigo_acceso = scanInt.nextInt();}
	        	
			catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
				System.out.println("**ERROR** El codigo de identificacion debe ser un dato numerico.\n");
				scanInt.nextLine();
				continue;}
	        
	        acceder_perfil = false;}
	    
	    if(lista_ids.contains(""+codigo_acceso)) {//Si el código de acceso ingresado se encuentra entre los códigos del gestor financiero
				    
		    Usuario usuario_activo = lista_usuarios.get(lista_ids.indexOf(""+codigo_acceso));
		        
		    boolean menu_secundario = true;
		    while(menu_secundario) {
		        System.out.println("\n[" + usuario_activo.getTipo_perfil().toUpperCase() + "]\nBienvenido/a, "+ usuario_activo.getNombre_completo() +"");
		        System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Ingresos.\n2. Gastos.\n3. Ahorros.\n4. Estadisticas y graficas.\n5. Regresar a la pantalla de inicio.");
		        int decision_secundaria = 0;
		        try {decision_secundaria = scanInt.nextInt();}
		        catch(Exception e) {
		            System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
		            scanInt.nextLine();
		            continue;}
		        
		        switch(decision_secundaria) {
		        
		            case 1:{//Ingresos
						menuIngresos(usuario_activo,scanString,scanInt,scanDouble);
			            break;}
		            
		            case 2:{//Gastos
		            	menuGastos(usuario_activo,scanString,scanInt,scanDouble);
			            break;}
		            	
		            case 3:{//Ahorros
		            	menuAhorros(usuario_activo,scanString,scanInt,scanDouble);
			            break;}
		            	
		            case 4:{//Estadisticas y graficas
		                System.out.println("\n----------------------ESTADISTICAS Y GRAFICAS----------------------");
		                /*
		                 * Aquí se debe programar lo relacionado a las estadísticas y gráficas.
		                 */
		                break;}
		            
		            case 5:{//Regresar a la pantalla de inicio
		                
		            	//Terminar el bucle del menú secundario
		                menu_secundario = false;
		                
		                break;}
		            
					default:{//Opción no disponible (programación defensiva)
						System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}}
	    
	    else {//Si el código de identificación ingresado no se encuentra entre los códigos del gestor financiero
			System.out.println("\nPERFIL NO ENCONTRADO.\nNo hay ningun perfil con el codigo de identificacion ingresado. Verifique que el ID sea correcto o que su perfil ya exista.");}}

	/**
	 * Todas las acciones disponibles para los ingresos.
	 * @param usuario_activo El usuario que desea modificar o visualizar los ingresos su perfil.
	 * @param scanString El scanner para registrar los textos ingresados por el usuario.
	 * @param scanInt El scanner para registrar los números enteros ingresados por el usuario.
	 * @param scanDouble El scanner para registrar los números decimales ingresados por el usuario.
	 * @return Este método no devuelve nada.
	 */
	public static void menuIngresos(Usuario usuario_activo, Scanner scanString, Scanner scanInt, Scanner scanDouble) {
		
		//Lista que contiene todos los registros que tiene el usuario activo
		ArrayList<Registro> registros_activo = usuario_activo.getRegistros();
		//Lista para almacenar los ingresos que tiene el usuario activo
		ArrayList<Ingreso> ingresos_activo = new ArrayList<Ingreso>();
		//Lista para almacenar los ahorros y gastos que tiene el usuario activo
		ArrayList<Registro> otros_activo = new ArrayList<Registro>();
		
		for(Registro registro : registros_activo) {
			if(registro.getTipo_registro().equals("Ingreso")) {
				ingresos_activo.add((Ingreso)registro);}
			else {
				otros_activo.add(registro);}}
	
		boolean menu_ingresos = true;
	    while(menu_ingresos) {
	        System.out.println("\n--------------------------------INGRESOS--------------------------------");
	        System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Registrar nuevo ingreso. \n2. Ver ingresos.\n3. Eliminar ingreso.\n4. Regresar.");
	        
	        int decision_ingresos;
	        try {decision_ingresos = scanInt.nextInt();} 
	        catch(Exception e) {
	            System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
	            scanInt.nextLine();
	            continue;}
	        
	        switch(decision_ingresos) 
	        {
	            case 1:{//Registrar nuevo ingreso
	            	System.out.println("\n-------------------------REGISTRAR NUEVO INGRESO-------------------------");
	            	
	            	//Atributos necesarios para registrar un ingreso
	            	double monto=0.0;
	            	String descripcion;
	            	int mes=0, year=0;
	            	
	            	//[Registro de datos del ingreso]
	            	
	            	System.out.println("\nIngrese la descripcion del ingreso: ");
					descripcion = scanString.nextLine();
					
					//Iniciar ciclo para el try-catch y la validación del monto del ingreso
					boolean validar_monto = true;
					while(validar_monto) {
						try {System.out.println("Ingrese el monto del ingreso (en Q): ");
							monto = scanDouble.nextDouble();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El monto del ingreso debe ser un dato numerico.\n");
							scanDouble.nextLine();
							continue;}
						
						if(monto<=0) {//Si el monto ingresado es menor o igual a 0
							System.out.println("**ERROR** El monto del ingreso no puede ser menor o igual a Q0.\n");}
						
						else {//Salir del ciclo
							validar_monto = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del mes del ingreso
					boolean validar_mes = true;
					while(validar_mes) {
						try {System.out.println("Ingrese el mes del ingreso en formato numerico (ej. '4' para abril, '9' para septiembre): ");
							mes = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El mes debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(mes<1||mes>12) {//Si el mes ingresado no coincide con alguno de los meses del año (debe estar entre 1 y 12)
							System.out.println("**ERROR** El mes ingresado no es valido (debe estar entre 1 y 12).\n");}
						
						else {//Salir del ciclo
							validar_mes = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del año del ingreso
					boolean validar_year = true;
					while(validar_year) {
						try {System.out.println("Ingrese el year del ingreso: ");
							year = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El year debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(year>2023) {//Si el año ingresado es mayor al año actual
							System.out.println("**ERROR** El year del ingreso no puede ser mayor que el year actual (2023).\n");}
						
						else {//Salir del ciclo
							validar_year = false;}}
					
					//Instanciar el ingreso con los datos brindados por el usuario
					Ingreso nuevo_ingreso = new Ingreso(monto,descripcion,mes,year,"Ingreso");
					//Agregar el ingreso a la lista de ingresos del usuario activo
					ingresos_activo.add(nuevo_ingreso);
					
					//Notificar al usuario que se ha registrado el ingreso
					System.out.println("\nINGRESO REGISTRADO. \nEl ingreso (" + descripcion + ") ha sido registrado exitosamente.");
	            	
	                break;}
	            
	            case 2:{//Ver ingresos
	                System.out.println("\n------------------------------VER INGRESOS------------------------------");
	                if (ingresos_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun ingreso registrado.");}
	                
	                else {
	                    int num_ingreso = 1;
	                	for (Ingreso ingreso : ingresos_activo) {
	                        System.out.println("\n" + num_ingreso + ". " + ingreso.getDescripcion());
	                        System.out.println("    En el mes " + ingreso.getMes() + " del year " + ingreso.getYear() + ". Monto: Q" + ingreso.getMonto());
	                        num_ingreso++;}}
	                
	                break;}
	            
	            case 3:{//Eliminar ingreso
	                System.out.println("\n----------------------------ELIMINAR INGRESO----------------------------");
	                if (ingresos_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun ingreso registrado.");}
	                
	                else {
	                    int num_ingreso = 1;
	                	for (Ingreso ingreso : ingresos_activo) {
	                		System.out.println("\n" + num_ingreso + ". " + ingreso.getDescripcion());
	                        System.out.println("    En el mes " + ingreso.getMes() + " del year " + ingreso.getYear() + ". Monto: Q" + ingreso.getMonto());
	                        num_ingreso++;}
	                	System.out.println("\n" + num_ingreso + ". Cancelar operacion");
	                
		                //Esta variable contendrá el número del ingreso que el usuario desee eliminar
						int num_ingreso_eliminar = 0;
						//Iniciar ciclo para solicitar al usuario el numero de ingreso a eliminar(con try-catch)
						boolean seleccion_ingreso_eliminar = true;
						while(seleccion_ingreso_eliminar) {
							
							System.out.println("\nSeleccione el numero que corresponda al ingreso que desea eliminar: ");
							
							try {num_ingreso_eliminar = scanInt.nextInt()-1;} //Se le resta 1 para obtener el índice del ingreso en la lista de ingresos activos
							catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
								System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
								scanInt.nextLine();
								continue;}
							
							if((num_ingreso_eliminar>=0)&&(num_ingreso_eliminar<ingresos_activo.size())) {//Si el usuario elige una opción que sí está entre las opciones
								//Eliminar el ingreso indicado por el ususario
								ingresos_activo.remove(num_ingreso_eliminar);
								//Notificar al usuario que se ha eliminado el ingreso
								System.out.println("\nINGRESO ELIMINADO. \nEl ingreso ha sido eliminado exitosamente.");
								seleccion_ingreso_eliminar = false;} //Salir del ciclo
							
							else if(num_ingreso_eliminar==ingresos_activo.size()) {
								//Notificar al usuario que se ha cancelado exitosamente la operación.
								System.out.println("\nOPERACION CANCELADA. \nSe ha cancelado la eliminacion del ingreso.");
								seleccion_ingreso_eliminar = false;} //Salir del ciclo
							
							else {//Si el usuario elige una opción que no está entre las opciones
								System.out.println("\n**ERROR** El numero ingresado no se encuentra entre las opciones disponibles.");}}}
		                
	                break;}
	            
	            case 4:{//Regresar
	            	
	            	//Limpiar la lista de registros del ususario
	            	registros_activo.clear();
	            	
	            	//Agregarle a la lista los ingresos actualizados y el resto de registros que tenía
	            	registros_activo.addAll(ingresos_activo);
	            	registros_activo.addAll(otros_activo);
	            	
	            	//Establecer esta nueva lista para el usuario
	            	usuario_activo.setRegistros(registros_activo);
	            	
	                //Terminar el bucle del menú de ingresos
	                menu_ingresos = false;
	                break;}
	            
	            default:{//Opción no disponible (programación defensiva)
	                System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}}
	
	/**
	 * Todas las acciones disponibles para los gastos.
	 * @param usuario_activo El usuario que desea modificar o visualizar los gastos de su perfil.
	 * @param scanString El scanner para registrar los textos ingresados por el usuario.
	 * @param scanInt El scanner para registrar los números enteros ingresados por el usuario.
	 * @param scanDouble El scanner para registrar los números decimales ingresados por el usuario.
	 * @return Este método no devuelve nada.
	 */
	public static void menuGastos(Usuario usuario_activo, Scanner scanString, Scanner scanInt, Scanner scanDouble) {
		
		//Este array contiene las 9 categorías predefinidas para los gastos
		String[] lista_categorias = {"Alimentos y bebidas","Vivienda","Transporte","Salud","Educacion","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"};
		
		//Lista que contiene todos los registros que tiene el usuario activo
		ArrayList<Registro> registros_activo = usuario_activo.getRegistros();
		//Lista para almacenar los gastos que tiene el usuario activo
		ArrayList<Gasto> gastos_activo = new ArrayList<Gasto>();
		//Lista para almacenar los ingresos y ahorros que tiene el usuario activo
		ArrayList<Registro> otros_activo = new ArrayList<Registro>();
		
		for(Registro registro : registros_activo) {
			if(registro.getTipo_registro().equals("Gasto")) {
				gastos_activo.add((Gasto)registro);}
			else {
				otros_activo.add(registro);}}
	
		boolean menu_gastos = true;
	    while(menu_gastos) {
	        System.out.println("\n--------------------------------GASTOS--------------------------------");
	        System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Distributir porcentajes. \n2. Ver distribucion de porcentajes. \n3. Registrar nuevo gasto. \n4. Ver gastos.\n5. Eliminar gasto.\n6. Regresar.");
	        
	        int decision_gastos;
	        try {decision_gastos = scanInt.nextInt();} 
	        catch(Exception e) {
	            System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
	            scanInt.nextLine();
	            continue;}
	        
	        switch(decision_gastos) 
	        {
		        case 1:{//Distribuir porcentajes
		        	
		        	System.out.println("\n-------------------------DISTRIBUIR PORCENTAJES-------------------------");
		        	
		        	System.out.println("\n[Aclaraciones importantes]\nI. A continuacion, se le enlistaran las 9 categorias disponibles para que les \nasigne el porcentaje de su presupuesto que desea gastar en cada una de ellas.\n\nII. Si alguna categoria no le interesa, puede colocarle '0' como porcentaje.\n\nIII. El total de los 9 porcentajes asignados debera ser 100%; si llega a este \nlimite, se asignara automaticamente 0% a las categorias restantes.");
		        	
		        	double porcentaje_restante = 100;
		        	int contador = 0;
		        	
		        	System.out.println("\n\n[Distribucion de porcentajes]");
		        	while((porcentaje_restante>0)&&(contador<8)) {
		        		
		        		double porcentaje_ingresado;

		        		//Iniciar ciclo para el try-catch y la validación del porcentaje
						boolean validar_porcentaje = true;
						while(validar_porcentaje) {
							try {System.out.println("\n{Porcentaje restante: " + porcentaje_restante + "%}");
								System.out.println("Ingrese el porcentaje (%) que desea agregarle a la categoria '" + lista_categorias[contador] + "': ");
								porcentaje_ingresado = scanDouble.nextDouble();}
							
							catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
								System.out.println("**ERROR** El porcentaje debe ser un dato numerico.\n");
								scanDouble.nextLine();
								continue;}
							
							if((porcentaje_ingresado<0)||(porcentaje_ingresado>porcentaje_restante)) {//Si el porcentaje ingresado es menor a 0 o mayor al porcentaje restante
								System.out.println("**ERROR** El porcentaje ingresado no es valido (debe estar entre 0% y "+ porcentaje_restante + "%).\n");}
							
							else if(porcentaje_restante>=porcentaje_ingresado) {
								//Establecer el porcentaje para el usuario
								usuario_activo.distribuirPorcentajes(lista_categorias[contador],porcentaje_ingresado);
								porcentaje_restante -= porcentaje_ingresado;
								//Salir del ciclo
								validar_porcentaje = false;}}
						
						contador++;}
		        	
		        	if((porcentaje_restante==0)&&(contador==8)) {
		        		System.out.println("\nPORCENTAJES DISTRIBUIDOS. \nSe ha actualizado la distribucion de porcentajes exitosamente.");}
		        	
		        	else if((porcentaje_restante==0)&&(contador<8)) {
		           		System.out.println("\nDado que se ha llegado al limite de porcentaje disponible, se le ha asignado 0% al resto de las categorias.");
		           		System.out.println("\nPORCENTAJES DISTRIBUIDOS. \nSe ha actualizado la distribucion de porcentajes exitosamente.");}
		        	
		        	else if((porcentaje_restante>0)&&(contador==8)) {
		        		usuario_activo.distribuirPorcentajes(lista_categorias[contador], porcentaje_restante);
		        		System.out.println("\nEl porcentaje restante (" + porcentaje_restante + "%) ha sido asignado a la categoria '" + lista_categorias[contador] + "'.");
		        		System.out.println("\nPORCENTAJES DISTRIBUIDOS. \nSe ha actualizado la distribucion de porcentajes exitosamente.");}
		        	
		        	break;}
	        
		        case 2:{//Ver distribucion de porcentajes
	                System.out.println("\n----------------------VER DISTRIBUCION DE PORCENTAJES----------------------\n");
	                if (usuario_activo.sumaPorcentajes()!=100) {
	                    System.out.println("OPCION NO DISPONIBLE.\nPor el momento, no se han distribuido los porcentajes entre las categorias de gastos.");}
	                
	                else {
	                	ArrayList<Double> lista_porcentajes = usuario_activo.getLista_porcentajes();
	                	
	                    for(int i=0;i<lista_porcentajes.size();i++) {
	                    	System.out.println((i+1) + ". " + lista_categorias[i] + ": " + lista_porcentajes.get(i) + "%");}}
	                
	                break;}
		        
		        case 3:{//Registrar nuevo gasto
	            	System.out.println("\n-------------------------REGISTRAR NUEVO GASTO-------------------------");
	            	
	            	//Atributos necesarios para registrar un gasto
	            	double monto=0.0;
	            	String descripcion,categoria;
	            	int mes=0, year=0, num_categoria=0;
	            	
	            	//[Registro de datos del gasto]
	            	
	            	System.out.println("\nIngrese la descripcion del gasto: ");
					descripcion = scanString.nextLine();
					
					//Iniciar ciclo para el try-catch y la validación del monto del gasto
					boolean validar_monto = true;
					while(validar_monto) {
						try {System.out.println("Ingrese el monto del gasto (en Q): ");
							monto = scanDouble.nextDouble();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El monto del gasto debe ser un dato numerico.\n");
							scanDouble.nextLine();
							continue;}
						
						if(monto<=0) {//Si el monto ingresado es menor o igual a 0
							System.out.println("**ERROR** El monto del gasto no puede ser menor o igual a Q0.\n");}
						
						else {//Salir del ciclo
							validar_monto = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del mes del gasto
					boolean validar_mes = true;
					while(validar_mes) {
						try {System.out.println("Ingrese el mes del gasto en formato numerico (ej. '1' para enero, '6' para junio): ");
							mes = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El mes debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(mes<1||mes>12) {//Si el mes ingresado no coincide con alguno de los meses del año (debe estar entre 1 y 12)
							System.out.println("**ERROR** El mes ingresado no es valido (debe estar entre 1 y 12).\n");}
						
						else {//Salir del ciclo
							validar_mes = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del año del gasto
					boolean validar_year = true;
					while(validar_year) {
						try {System.out.println("Ingrese el year del gasto: ");
							year = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El year debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(year>2023) {//Si el año ingresado es mayor al año actual
							System.out.println("**ERROR** El year del gasto no puede ser mayor que el year actual (2023).\n");}
						
						else {//Salir del ciclo
							validar_year = false;}}
					
					//Iniciar ciclo para el try-catch de la categoria del gasto
					boolean validar_categoria = true;
					while(validar_categoria) {
						try {System.out.println("Seleccione el numero que corresponda a la categoria del gasto: ");
							for(int i=0;i<lista_categorias.length;i++) {//Enlistar las categorías
								System.out.println((i+1) + ". " + lista_categorias[i]);}
							num_categoria = scanInt.nextInt()-1;}//Se le resta 1 para obtener el índice de la categoría en el array, ya que se le había sumado 1 al mostrarlas
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** La decision ingresada debe ser un numero.\n");
							scanInt.nextLine();
							continue;}
						
						if((num_categoria>=0)&&(num_categoria<lista_categorias.length)) {//Si el usuario elige una opción que sí está entre las opciones
							validar_categoria = false;} //Salir del ciclo
						
						else {//Si el usuario elige una opción que no está entre las opciones
							System.out.println("**ERROR** El numero ingresado no se encuentra entre las opciones disponibles.\n");}}
					categoria = lista_categorias[num_categoria];//Registrar la categoria seleccionada
					
					//Instanciar el gasto con los datos brindados por el usuario
					Gasto nuevo_gasto = new Gasto(monto,descripcion,mes,year,"Gasto",categoria);
					//Agregar el gasto a la lista de gastos del usuario activo
					gastos_activo.add(nuevo_gasto);
					
					//Notificar al usuario que se ha registrado el gasto
					System.out.println("\nGASTO REGISTRADO. \nEl gasto (" + descripcion + ") ha sido registrado exitosamente.");
	            	
	                break;}
	            
	            case 4:{//Ver gastos
	                System.out.println("\n------------------------------VER GASTOS------------------------------");
	                if (gastos_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun gasto registrado.");}
	                
	                else {
	                    int num_gasto = 1;
	                	for (Gasto gasto : gastos_activo) {
	                        System.out.println("\n" + num_gasto + ". " + gasto.getDescripcion() + " [" + gasto.getCategoria() + "]");
	                        System.out.println("    En el mes " + gasto.getMes() + " del year " + gasto.getYear() + ". Monto: Q" + gasto.getMonto());
	                        num_gasto++;}}
	                
	                break;}
	            
	            case 5:{//Eliminar gasto
	                System.out.println("\n----------------------------ELIMINAR GASTO----------------------------");
	                if (gastos_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun gasto registrado.");}
	                
	                else {
	                    int num_gasto = 1;
	                    for (Gasto gasto : gastos_activo) {
	                    	System.out.println("\n" + num_gasto + ". " + gasto.getDescripcion() + " [" + gasto.getCategoria() + "]");
	                        System.out.println("    En el mes " + gasto.getMes() + " del year " + gasto.getYear() + ". Monto: Q" + gasto.getMonto());
	                        num_gasto++;}
	                	System.out.println("\n" + num_gasto + ". Cancelar operacion");
	                
		                //Esta variable contendrá el número del gasto que el usuario desee eliminar
						int num_gasto_eliminar = 0;
						//Iniciar ciclo para solicitar al usuario el numero de gasto a eliminar(con try-catch)
						boolean seleccion_gasto_eliminar = true;
						while(seleccion_gasto_eliminar) {
							
							System.out.println("\nSeleccione el numero que corresponda al gasto que desea eliminar: ");
							
							try {num_gasto_eliminar = scanInt.nextInt()-1;} //Se le resta 1 para obtener el índice del gasto en la lista de gastos activos
							catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
								System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
								scanInt.nextLine();
								continue;}
							
							if((num_gasto_eliminar>=0)&&(num_gasto_eliminar<gastos_activo.size())) {//Si el usuario elige una opción que sí está entre las opciones
								//Eliminar el gasto indicado por el ususario
								gastos_activo.remove(num_gasto_eliminar);
								//Notificar al usuario que se ha eliminado el gasto
								System.out.println("\nGASTO ELIMINADO. \nEl gasto ha sido eliminado exitosamente.");
								seleccion_gasto_eliminar = false;} //Salir del ciclo
							
							else if(num_gasto_eliminar==gastos_activo.size()) {
								//Notificar al usuario que se ha cancelado exitosamente la operación.
								System.out.println("\nOPERACION CANCELADA. \nSe ha cancelado la eliminacion del gasto.");
								seleccion_gasto_eliminar = false;} //Salir del ciclo
							
							else {//Si el usuario elige una opción que no está entre las opciones
								System.out.println("\n**ERROR** El numero ingresado no se encuentra entre las opciones disponibles.");}}}
		                
	                break;}
	            
	            case 6:{//Regresar
	            	
	            	//Limpiar la lista de registros del ususario
	            	registros_activo.clear();
	            	
	            	//Agregarle a la lista los gastos actualizados y el resto de registros que tenía
	            	registros_activo.addAll(gastos_activo);
	            	registros_activo.addAll(otros_activo);
	            	
	            	//Establecer esta nueva lista para el usuario
	            	usuario_activo.setRegistros(registros_activo);
	            	
	                //Terminar el bucle del menú de gastos
	            	menu_gastos = false;
	                break;}
	            
	            default:{//Opción no disponible (programación defensiva)
	                System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}}
	
	/**
	 * Todas las acciones disponibles para los ahorros.
	 * @param usuario_activo El usuario que desea modificar o visualizar los ahorros de su perfil.
	 * @param scanString El scanner para registrar los textos ingresados por el usuario.
	 * @param scanInt El scanner para registrar los números enteros ingresados por el usuario.
	 * @param scanDouble El scanner para registrar los números decimales ingresados por el usuario.
	 * @return Este método no devuelve nada.
	 */
	public static void menuAhorros(Usuario usuario_activo, Scanner scanString, Scanner scanInt, Scanner scanDouble) {
		
		//Lista que contiene todos los registros que tiene el usuario activo
		ArrayList<Registro> registros_activo = usuario_activo.getRegistros();
		//Lista para almacenar los ahorros que tiene el usuario activo
		ArrayList<Ahorro> ahorros_activo = new ArrayList<Ahorro>();
		//Lista para almacenar los ingresos y gastos que tiene el usuario activo
		ArrayList<Registro> otros_activo = new ArrayList<Registro>();
		
		for(Registro registro : registros_activo) {
			if(registro.getTipo_registro().equals("Ahorro")) {
				ahorros_activo.add((Ahorro)registro);}
			else {
				otros_activo.add(registro);}}
	
		boolean menu_ahorros = true;
	    while(menu_ahorros) {
	        System.out.println("\n--------------------------------AHORROS--------------------------------");
	        System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Registrar nuevo ahorro. \n2. Ver ahorros.\n3. Eliminar ahorro.\n4. Regresar.");
	        
	        int decision_ahorros;
	        try {decision_ahorros = scanInt.nextInt();} 
	        catch(Exception e) {
	            System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
	            scanInt.nextLine();
	            continue;}
	        
	        switch(decision_ahorros) 
	        {
	            case 1:{//Registrar nuevo ahorro
	            	System.out.println("\n-------------------------REGISTRAR NUEVO AHORRO-------------------------");
	            	
	            	//Atributos necesarios para registrar un ahorro
	            	double monto=0.0;
	            	String descripcion;
	            	int mes=0, year=0;
	            	
	            	//[Registro de datos del ahorro]
	            	
	            	System.out.println("\nIngrese la descripcion del ahorro: ");
					descripcion = scanString.nextLine();
					
					//Iniciar ciclo para el try-catch y la validación del monto del ahorro
					boolean validar_monto = true;
					while(validar_monto) {
						try {System.out.println("Ingrese el monto del ahorro (en Q): ");
							monto = scanDouble.nextDouble();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El monto del ahorro debe ser un dato numerico.\n");
							scanDouble.nextLine();
							continue;}
						
						if(monto<=0) {//Si el monto ingresado es menor o igual a 0
							System.out.println("**ERROR** El monto del ahorro no puede ser menor o igual a Q0.\n");}
						
						else {//Salir del ciclo
							validar_monto = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del mes del ahorro
					boolean validar_mes = true;
					while(validar_mes) {
						try {System.out.println("Ingrese el mes del ahorro en formato numerico (ej. '8' para agosto, '12' para diciembre): ");
							mes = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El mes debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(mes<1||mes>12) {//Si el mes ingresado no coincide con alguno de los meses del año (debe estar entre 1 y 12)
							System.out.println("**ERROR** El mes ingresado no es valido (debe estar entre 1 y 12).\n");}
						
						else {//Salir del ciclo
							validar_mes = false;}}
					
					//Iniciar ciclo para el try-catch y la validación del año del ahorro
					boolean validar_year = true;
					while(validar_year) {
						try {System.out.println("Ingrese el year del ahorro: ");
							year = scanInt.nextInt();}
						
						catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
							System.out.println("**ERROR** El year debe ser un dato numerico entero.\n");
							scanInt.nextLine();
							continue;}
						
						if(year>2023) {//Si el año ingresado es mayor al año actual
							System.out.println("**ERROR** El year del ahorro no puede ser mayor que el year actual (2023).\n");}
						
						else {//Salir del ciclo
							validar_year = false;}}
					
					//Instanciar el ahorro con los datos brindados por el usuario
					Ahorro nuevo_ahorro = new Ahorro(monto,descripcion,mes,year,"Ahorro");
					//Agregar el ahorro a la lista de ahorros del usuario activo
					ahorros_activo.add(nuevo_ahorro);
					
					//Notificar al usuario que se ha registrado el ahorro
					System.out.println("\nAHORRO REGISTRADO. \nEl ahorro (" + descripcion + ") ha sido registrado exitosamente.");
	            	
	                break;}
	            
	            case 2:{//Ver ahorros
	                System.out.println("\n------------------------------VER AHORROS------------------------------");
	                if (ahorros_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun ahorro registrado.");}
	                
	                else {
	                    int num_ahorro = 1;
	                	for (Ahorro ahorro : ahorros_activo) {
	                        System.out.println("\n" + num_ahorro + ". " + ahorro.getDescripcion());
	                        System.out.println("    En el mes " + ahorro.getMes() + " del year " + ahorro.getYear() + ". Monto: Q" + ahorro.getMonto());
	                        num_ahorro++;}}
	                
	                break;}
	            
	            case 3:{//Eliminar ahorro
	                System.out.println("\n----------------------------ELIMINAR AHORRO----------------------------");
	                if (ahorros_activo.size()==0) {
	                    System.out.println("\nOPCION NO DISPONIBLE.\nPor el momento, no hay ningun ahorro registrado.");}
	                
	                else {
	                    int num_ahorro = 1;
	                    for (Ahorro ahorro : ahorros_activo) {
	                        System.out.println("\n" + num_ahorro + ". " + ahorro.getDescripcion());
	                        System.out.println("    En el mes " + ahorro.getMes() + " del year " + ahorro.getYear() + ". Monto: Q" + ahorro.getMonto());
	                        num_ahorro++;}
	                	System.out.println("\n" + num_ahorro + ". Cancelar operacion");
	                
		                //Esta variable contendrá el número del ahorro que el usuario desee eliminar
						int num_ahorro_eliminar = 0;
						//Iniciar ciclo para solicitar al usuario el numero de ahorro a eliminar(con try-catch)
						boolean seleccion_ahorro_eliminar = true;
						while(seleccion_ahorro_eliminar) {
							
							System.out.println("\nSeleccione el numero que corresponda al ahorro que desea eliminar: ");
							
							try {num_ahorro_eliminar = scanInt.nextInt()-1;} //Se le resta 1 para obtener el índice del ahorro en la lista de ahorros activos
							catch(Exception e) {//En caso de que el usuario ingrese texto en lugar de un número
								System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
								scanInt.nextLine();
								continue;}
							
							if((num_ahorro_eliminar>=0)&&(num_ahorro_eliminar<ahorros_activo.size())) {//Si el usuario elige una opción que sí está entre las opciones
								//Eliminar el ahorro indicado por el ususario
								ahorros_activo.remove(num_ahorro_eliminar);
								//Notificar al usuario que se ha eliminado el ahorro
								System.out.println("\nAHORRO ELIMINADO. \nEl ahorro ha sido eliminado exitosamente.");
								seleccion_ahorro_eliminar = false;} //Salir del ciclo
							
							else if(num_ahorro_eliminar==ahorros_activo.size()) {
								//Notificar al usuario que se ha cancelado exitosamente la operación.
								System.out.println("\nOPERACION CANCELADA. \nSe ha cancelado la eliminacion del ahorro.");
								seleccion_ahorro_eliminar = false;} //Salir del ciclo
							
							else {//Si el usuario elige una opción que no está entre las opciones
								System.out.println("\n**ERROR** El numero ingresado no se encuentra entre las opciones disponibles.");}}}
		                
	                break;}
	            
	            case 4:{//Regresar
	            	
	            	//Limpiar la lista de registros del ususario
	            	registros_activo.clear();
	            	
	            	//Agregarle a la lista los ahorros actualizados y el resto de registros que tenía
	            	registros_activo.addAll(ahorros_activo);
	            	registros_activo.addAll(otros_activo);
	            	
	            	//Establecer esta nueva lista para el usuario
	            	usuario_activo.setRegistros(registros_activo);
	            	
	                //Terminar el bucle del menú de ahorros
	            	menu_ahorros = false;
	                break;}
	            
	            default:{//Opción no disponible (programación defensiva)
	                System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}}
	
	}