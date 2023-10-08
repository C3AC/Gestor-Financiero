/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 2]
Creación: 06 de octubre del 2023
Última modificación: 08 de octubre del 2023*/

package proyecto2_poo;

import java.util.ArrayList;
import java.util.List;
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
		
		//Tipos de perfiles disponibles
		String [] tipos_de_perfiles = {"Padre/Madre","Freelancer","Estudiante"};
		
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		
		boolean menu_principal = true;
		while(menu_principal) {
			System.out.println("\n\nBIENVENIDO/A A TU GESTOR FINANCIERO");
			System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Crear un perfil.\n2. Acceder a un perfil.\n3. Salir del programa.");
			
			int decision_principal = 0;
			try {decision_principal = scanInt.nextInt();} 
			catch(Exception e) {
				System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
				scanInt.nextLine();
				continue;}
				
			switch(decision_principal)
			{
				case 1:{//Crear un perfil
					
					int decision_perfil = 0;
					boolean seleccion_perfil = true;
					while(seleccion_perfil) {
						
						System.out.println("\nCREAR UN PERFIL");
						System.out.println("Seleccione el numero correspondiente a su categoria: ");
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
					
						if(tipos_de_perfiles[decision_perfil].equals("Padre/Madre")) {//El tipo de perfil es de padre/madre
							System.out.println("\nPADRE/MADRE");
							
							String nombre,apellido,tipoPerfil,sexo1;
							boolean sexo;
							int edad;
							
							tipoPerfil = tipos_de_perfiles[decision_perfil];
							
							System.out.println("Ingrese cada dato requerido seguido de un enter: ");
							System.out.println("-Nombre");
							nombre = scanString.nextLine();
							System.out.println("-Apellido");
							apellido = scanString.nextLine();
							System.out.println("-Sexo (M/F)");
							sexo1 = scanString.nextLine().toLowerCase();

							if (sexo1.equals("m")) {
								sexo = true;
							} else if (sexo1.equals("f")) {
								sexo = false;
							} else {
								System.out.println("\n**ERROR** El sexo ingresado no es válido.");
								continue;
							}
							System.out.println("-Edad");
							edad = scanInt.nextInt();
							
							System.out.println("Mensaje de confirmacion [Padre/Madre].");

							Usuario newuser = new Usuario(nombre,apellido,sexo,edad,tipoPerfil);
						}
							
							
						else if (tipos_de_perfiles[decision_perfil].equals("Freelancer")) {
							System.out.println("\nFREELANCER");
							String nombre,apellido,tipoPerfil,sexo1;
							boolean sexo;
							int edad;
							
							tipoPerfil = tipos_de_perfiles[decision_perfil];
							
							System.out.println("Ingrese cada dato requerido seguido de un enter: ");
							System.out.println("-Nombre");
							nombre = scanString.nextLine();
							System.out.println("-Apellido");
							apellido = scanString.nextLine();
							System.out.println("-Sexo (M/F)");
							sexo1 = scanString.nextLine().toLowerCase();

							if (sexo1.equals("m")) {
								sexo = true;
							} else if (sexo1.equals("f")) {
								sexo = false;
							} else {
								System.out.println("\n**ERROR** El sexo ingresado no es válido.");
								continue;
							}
							System.out.println("-Edad");
							edad = scanInt.nextInt();

							Usuario newuser = new Usuario(nombre,apellido,sexo,edad,tipoPerfil);
							
							System.out.println("Mensaje de confirmacion [Freelancer].");
						}
						
						else if(tipos_de_perfiles[decision_perfil].equals("Freelancer")) {//El tipo de perfil es de estudiante
							System.out.println("\nESTUDIANTE");
							
							String nombre,apellido,tipoPerfil,sexo1;
							boolean sexo;
							int edad;
							
							tipoPerfil = tipos_de_perfiles[decision_perfil];
							
							System.out.println("Ingrese cada dato requerido seguido de un enter: ");
							System.out.println("-Nombre");
							nombre = scanString.nextLine();
							System.out.println("-Apellido");
							apellido = scanString.nextLine();
							System.out.println("-Sexo (M/F)");
							sexo1 = scanString.nextLine().toLowerCase();

							if (sexo1.equals("m")) {
								sexo = true;
							} else if (sexo1.equals("f")) {
								sexo = false;
							} else {
								System.out.println("\n**ERROR** El sexo ingresado no es válido.");
								continue;
							}
							System.out.println("-Edad");
							edad = scanInt.nextInt();

							Usuario newuser = new Usuario(nombre,apellido,sexo,edad,tipoPerfil);

							
							System.out.println("Mensaje de confirmacion [Estudiante].");
						}
					break;}
				
				case 2:{//Acceder a un perfil
					
					String codigo_acceso = "";
					boolean acceder_perfil = true;
					while(acceder_perfil) {
						
						System.out.println("\nACCEDER A UN PERFIL");
						System.out.println("Ingrese su codigo de identificacion: ");
						
						try {codigo_acceso = scanString.nextLine().toUpperCase();}
						catch(Exception e) {
							System.out.println("\n**ERROR** El codigo fue ingresado en un formato incorrecto.");
							scanString.nextLine();
							continue;}
						
						/*
						 * Aquí se deben verificar que el código esté dentro de la lista de códigos. De momento crearé una simple con un código de prueba.
						 */
						
						List<String> codigos = new ArrayList<>();
						codigos.add("COD123");
						
						if(codigos.contains(codigo_acceso)) {
							acceder_perfil = false;}
						
						else {
							System.out.println("\nPERFIL NO ENCONTRADO.\nNo hay ningun perfil con el codigo de identificacion ingresado. Verifique que el codigo sea correcto o que su perfil ya exista.");
							break;}
					}
					
					boolean menu_secundario = true;
					while(menu_secundario) {
						System.out.println("\n[TIPO DE PERFIL]\nBienvenido/a, [Nombre del usuario]");
						System.out.println("\nIngrese el numero correspondiente a la opcion que desea realizar:\n1. Ingresos.\n2. Gastos.\n3. Ahorros.\n4. Estadisticas y graficas.\n5. Regresar a la pantalla de inicio.");
						
						int decision_secundaria = 0;
						try {decision_secundaria = scanInt.nextInt();} 
						catch(Exception e) {
							System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
							scanInt.nextLine();
							continue;}
							
						switch(decision_secundaria) {
						
							case 1:{//Ingresos
								boolean menu_ingresos = true;
								while(menu_ingresos) {
									System.out.println("\nINGRESOS");
									System.out.println("Ingrese el numero correspondiente a la opcion que desea realizar:\n1. Registrar nuevo ingreso.\n2. Ver ingresos.\n3. Eliminar ingreso.\n4. Regresar.");
									
									int decision_ingresos = 0;
									try {decision_ingresos = scanInt.nextInt();} 
									catch(Exception e) {
										System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
										scanInt.nextLine();
										continue;}
									
									switch(decision_ingresos) {
									
										case 1:{//Registrar nuevo ingreso
											System.out.println("\nREGISTRAR NUEVO INGRESO");



											break;}
										
										case 2:{//Ver ingresos
											System.out.println("\nVER INGRESOS");
											/*
											 * Aquí se deben mostrar los ingresos.
											 */
											break;}
										
										case 3:{//Eliminar ingreso
											System.out.println("\nELIMINAR INGRESO");
											/*
											 * Aquí se debe eliminar el ingreso elegido por el usuario.
											 */
											break;}
										
										case 4:{//Regresar
											//Terminar el bucle del menú de ingresos
											menu_ingresos = false;
											break;}
										
										default:{//Opción no disponible (programación defensiva)
											System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}
			
								break;}
						
							case 2:{//Gastos
								boolean menu_gastos = true;
								while(menu_gastos) {
									System.out.println("\nGASTOS");
									System.out.println("Ingrese el numero correspondiente a la opcion que desea realizar:\n1. Distributir porcentajes. \n2.Registrar nuevo gasto.\n3. Ver gastos.\n4. Eliminar gasto.\n5. Regresar.");
									
									int decision_gastos = 0;
									try {decision_gastos = scanInt.nextInt();} 
									catch(Exception e) {
										System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
										scanInt.nextLine();
										continue;}
									
									switch(decision_gastos) {
									
										case 1:{//Distribuir porcentajes
											System.out.println("\nDISTRIBUIR PORCENTAJES");
											/*
											 * Aquí se debe permitir al usuario realizar la distribución entre las categorías. 
											 */
											break;}
										
										case 2:{//Registrar nuevo ingreso
											System.out.println("\nREGISTRAR NUEVO GASTO");
											/*
											 * Aquí se debe realizar el registro del gasto.
											 */
											break;}
										
										case 3:{//Ver ingresos
											System.out.println("\nVER GATOS");
											/*
											 * Aquí se deben mostrar los gastos.
											 */
											break;}
										
										case 4:{//Eliminar ingreso
											System.out.println("\nELIMINAR GASTO");
											/*
											 * Aquí se debe eliminar el gasto elegido por el usuario.
											 */
											break;}
										
										case 5:{//Regresar
											//Terminar el bucle del menú de gastos
											menu_gastos = false;
											break;}
										
										default:{//Opción no disponible (programación defensiva)
											System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}
								break;}
							
							case 3:{//Ahorros
								boolean menu_ahorros = true;
								while(menu_ahorros) {
									System.out.println("\nAHORROS");
									System.out.println("Ingrese el numero correspondiente a la opcion que desea realizar:\n1. Registrar nuevo ahorro.\n2. Ver ahorros.\n3. Eliminar ahorro.\n4. Regresar.");
									
									int decision_ahorros = 0;
									try {decision_ahorros = scanInt.nextInt();} 
									catch(Exception e) {
										System.out.println("\n**ERROR** La decision ingresada debe ser un numero.");
										scanInt.nextLine();
										continue;}
									
									switch(decision_ahorros) {
									
										case 1:{//Registrar nuevo ingreso
											System.out.println("\nREGISTRAR NUEVO AHORRO");
											/*
											 * Aquí se debe realizar el registro del ahorro.
											 */
											break;}
										
										case 2:{//Ver ingresos
											System.out.println("\nVER AHORROS");
											/*
											 * Aquí se deben mostrar los ahorros.
											 */
											break;}
										
										case 3:{//Eliminar ingreso
											System.out.println("\nELIMINAR AHORRO");
											/*
											 * Aquí se debe eliminar el ahorro elegido por el usuario.
											 */
											break;}
										
										case 4:{//Regresar
											//Terminar el bucle del menú de ahorros
											menu_ahorros = false;
											break;}
										
										default:{//Opción no disponible (programación defensiva)
											System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}}}
								break;}
							
							case 4:{//Estadisticas y graficas
								System.out.println("\nESTADISTICAS Y GRAFICAS");
								/*
								 * Aquí se deben mostrar las estadística y gráficas.
								 */
								break;}
							
							case 5:{//Regresar a la pantalla de inicio
								//Terminar el bucle del menú secundario
								menu_secundario = false;
								break;}
							
							default:{//Opción no disponible (programación defensiva)
								System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}
						
						}
					}
					
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
					System.out.println("\n**ERROR**\nEl numero ingresado no se encuentra entre las opciones disponibles.");}
			}
		}
	}
}