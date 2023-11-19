/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase Final]
Creación: 06 de octubre del 2023
Última modificación: 09 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
* Esta clase se encargará de manejar la lectura y escritura de datos en los archivos csv en los que se almacenarán los datos del programa (persistencia).
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class ArchivoCSV {

	//[Atributos]
	
	/** Array de strings que contendrá los encabezados del csv para los registros.
	 * Estos encabezados corresponden a todos los datos que almacenará el programa de los registros.*/
	private static final String[] encabezados_registros = {"monto","descripcion","mes","year","tipo_registro","categoria"};
	
	/** Array de strings que contendrá los encabezados del csv para los usuarios.
	 * Estos encabezados corresponden a todos los datos que almacenará el programa de los usuarios.*/
	private static final String[] encabezados_usuarios = {"id","nombre","apellido","sexo","edad","tipo_perfil","Alimentos y bebidas","Vivienda","Transporte","Salud","Educacion","Entretenimienro","Ropa y calzado","Comunicaciones","Otros"};
	
	//[Constructor]
	
	/**
	* Constructor de la clase ArchivoCSV.
	*/
    public ArchivoCSV() {}

    //[Métodos]
    
    /**
	* Escribe los datos de los usuarios brindados en el archivo csv.
	* @param lista_usuarios La lista de usuarios a escribir en el archivo csv.
	* @return Este método no devuelve nada.
	* @throws IOException Si ocurre un error al escribir (o encontrar) el archivo.
	*/
    public void guardarUsuariosCSV(ArrayList<Usuario> lista_usuarios) throws IOException {
    	
    	//Abrir el escritor y darle la ruta
    	FileWriter fileName = new FileWriter("usuarios.csv");
    	BufferedWriter escritura = new BufferedWriter(fileName);
    			
    	//Escribir los encabezados en el csv
    	String encabezado = String.join(",", encabezados_usuarios);
    	escritura.write(encabezado);
    	escritura.newLine();
    			
    	//Escribir los datos del los tickets de la lista al csv
    	for(int i=0;i<lista_usuarios.size();i++) {
    		String linea = lista_usuarios.get(i).formatoCSV();
    		escritura.write(linea);
    		escritura.newLine();}
    			
    	//Cerrar el escritor
    	escritura.close();}

    /**
	 * Lee los datos de los usuarios desde el archivo csv.
	 * @return La lista de usuarios leída del archivo csv.
	 */
	public ArrayList<Usuario> cargarUsuariosCSV() {
		String filename = "usuarios.csv";
		ArrayList<Usuario> lista_usuarios = new ArrayList<>();
		BufferedReader fileReader = null;
		
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(filename));
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] data = line.split(",");
				
				Usuario usuario = new Usuario(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]);
				
				ArrayList<Double> lista_porcentajes = new ArrayList<>();
				for (int i = 6; i < 15; i++) {
					lista_porcentajes.add(Double.parseDouble(data[i]));}
				
				usuario.setLista_porcentajes(lista_porcentajes);
				lista_usuarios.add(usuario);}} 
		
		catch(FileNotFoundException ex) {}//No se debe hacer nada, ya que solo sucederá cuando sea la primera vez que se corre el programa y aún no se ha creado el archivo.
		
		catch (IOException e) {
			System.out.println("Error al cargar los datos del archivo CSV.");}
		
		finally {
			try {
				if (fileReader != null) {
					fileReader.close();}}
				
				catch (IOException e) {
				System.out.println("Error al cerrar el lector de archivos.");}}
		
		return lista_usuarios;}

	/**
	 * Genera una lista con los IDs de los usuarios brindados.
	 * @param lista_usuarios La lista de usuarios de los que se desea extraer el ID.
	 * @return La lista de IDs de los usuarios brindados.
	 */
	public ArrayList<String> extraerIDsUsuarios(ArrayList<Usuario> lista_usuarios) {
		ArrayList<String> lista_ids = new ArrayList<>();
		
		for (Usuario usuario : lista_usuarios) {
			lista_ids.add(usuario.getCodigoIdentificacion());}
		
		return lista_ids;}
	
	/**
	* Escribe los datos de los registros de los usuarios en el archivo csv.
	* @param usuario_activo El usuario del que se desean guardar los registros.
	* @return Este método no devuelve nada.
	* @throws IOException Si ocurre un error al escribir (o encontrar) el archivo.
	*/
	public void guardarRegistrosCSV(Usuario usuario_activo) throws IOException {
		
		//Abrir el escritor y darle la ruta
    	FileWriter fileName = new FileWriter(usuario_activo.getNombre()+"_"+usuario_activo.getApellido()+usuario_activo.getCodigoIdentificacion()+".csv");
    	BufferedWriter escritura = new BufferedWriter(fileName);
    			
    	//Escribir los encabezados en el csv
    	String encabezado = String.join(",", encabezados_registros);
    	escritura.write(encabezado);
    	escritura.newLine();
    	
    	ArrayList<Registro> lista_registros = usuario_activo.getRegistros();
    	
    	//Escribir los datos del los tickets de la lista al csv
    	for(int i=0;i<lista_registros.size();i++) {
    		String linea = lista_registros.get(i).formatoCSV();
    		escritura.write(linea);
    		escritura.newLine();}
    			
    	//Cerrar el escritor
    	escritura.close();}
	
	/**
	* Lee los datos de los registros de los usuarios desde el archivo csv.
	* @param usuario_activo El usuario del que se desean cargar los registros.
	* @return La lista de registros del usuario leída del archivo csv.
	* @throws IOException Si ocurre un error al leer (o encontrar) el archivo.
	*/
	public ArrayList<Registro> cargarRegistrosCSV(Usuario usuario_activo) throws IOException {
		
		//Lista en la que se almacenarán los registros instanciados del csv
		ArrayList<Registro> lista_registros = new ArrayList<>();
		
		try {
		//Abrir el lector y darle la ruta
		FileReader fileName = new FileReader(usuario_activo.getNombre()+"_"+usuario_activo.getApellido()+usuario_activo.getCodigoIdentificacion()+".csv");
		BufferedReader lectura = new BufferedReader(fileName);
				
		//En esta variable se almacenará el contenido de la linea actual que se está leyendo
		String linea;
		
		//Saltarse la primera linea (los encabezados)
		lectura.readLine();
				
		while((linea = lectura.readLine())!=null) {//Mientras haya lineas con algun contenido
					
			//Separar la linea por comas, y almacenar todos los elementos en este array
			String[] contenido_csv = linea.split(",");
				
			//[Atributos generales para los registros]
			String descripcion, tipo_registro;
			double monto = 0;
			int mes = 0, year = 0;
			String monto_string, mes_string, year_string;
					
			//Obtener dichos atributos del array (convertir los strings a sus formatos correspondientes para los atributos numéricos)
			monto_string = contenido_csv[0].trim();
			try {monto = Double.parseDouble(monto_string);}
		    catch (NumberFormatException ex){
		    	ex.printStackTrace();}
					
			descripcion = contenido_csv[1].trim();
			
			mes_string = contenido_csv[2].trim();
			try {mes = Integer.parseInt(mes_string);}
		    catch (NumberFormatException ex){
		    	ex.printStackTrace();}
			
			year_string = contenido_csv[3].trim();
			try {year = Integer.parseInt(year_string);}
		    catch (NumberFormatException ex){
		    	ex.printStackTrace();}
					
			tipo_registro = contenido_csv[4].trim();
					
			if(tipo_registro.equals("Ingreso")) {//Si el registro es un ingreso
						
				//Instanciar el ingreso y agregarlo a la lista de registros
				Registro registro = new Ingreso(monto,descripcion,mes,year,tipo_registro);
				lista_registros.add(registro);}
			
			else if(tipo_registro.equals("Ahorro")) {//Si el registro es un ahorro
				
				//Instanciar el ahorro y agregarlo a la lista de registros
				Registro registro = new Ahorro(monto,descripcion,mes,year,tipo_registro);
				lista_registros.add(registro);}
			
			else if(tipo_registro.equals("Gasto")) {//Si el registro es un gasto
				
				//[Atributos específicos para los gastos]
				String categoria; 
				
				//Obtener dicho atributo del array
				categoria = contenido_csv[5].trim();
				
				//Instanciar el gasto y agregarlo a la lista de registros
				Registro registro = new Gasto(monto,descripcion,mes,year,tipo_registro,categoria);
				lista_registros.add(registro);}}
		
		//Cerrar el lector
		lectura.close();}
		
		catch(FileNotFoundException ex) {}//No se debe hacer nada, ya que solo sucederá cuando sea la primera vez que se corre el programa y aún no se ha creado el archivo.
		
		return lista_registros;}
}