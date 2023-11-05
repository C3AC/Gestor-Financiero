/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase 3]
Creación: 06 de octubre del 2023
Última modificación: 05 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.ArrayList;
import java.io.BufferedReader;
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

	//[Constructor]
	
	/**
	* Constructor de la clase ArchivoCSV.
	*/
    public ArchivoCSV() {
    	}

    //[Métodos]
    
    /**
	* Escribe los datos de los usuarios brindados en el archivo csv.
	* @param lista_usuarios La lista de usuarios a escribir en el archivo csv.
	* @return Este método no devuelve nada.
	*/
    public void guardarUsuariosCSV(ArrayList<Usuario> lista_usuarios) {
		String filename = "usuarios.csv";
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(filename);
			fileWriter.append("CodigoIdentificacion,Nombre,Apellido,Sexo,Edad,TipoPerfil\n");
			
			for (Usuario usuario : lista_usuarios) {
				fileWriter.append(usuario.getCodigoIdentificacion());
				fileWriter.append(",");
				fileWriter.append(usuario.getNombre());
				fileWriter.append(",");
				fileWriter.append(usuario.getApellido());
				fileWriter.append(",");
				fileWriter.append(usuario.getSexo());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getEdad()));
				fileWriter.append(",");
				fileWriter.append(usuario.getTipo_perfil());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeAlimentosYBebidas()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeVivienda()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeTransporte()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeSalud()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeEducacion()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeEntretenimiento()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeRopaYCalzado()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeComunicaciones()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(usuario.getPorcentajeOtros()));
				fileWriter.append("\n");
			}
		} 
		
		catch (IOException e) {
			System.out.println("Error al guardar los datos en el archivo CSV.");
		} 
		
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el lector de archivos.");
			}
		}
	}

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
					lista_porcentajes.add(Double.parseDouble(data[i]));
				}
				
				usuario.setLista_porcentajes(lista_porcentajes);
				lista_usuarios.add(usuario);
			}
		} 
		
		catch(FileNotFoundException ex) {//No se debe hacer nada, ya que solo sucederá cuando sea la primera vez que se corre el programa y aún no se ha creado el archivo.
			}
		
		catch (IOException e) {
			System.out.println("Error al cargar los datos del archivo CSV.");
		}
		
		finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			}
				
				catch (IOException e) {
				System.out.println("Error al cerrar el lector de archivos.");
			}
		}
		
		return lista_usuarios;
	}

	/**
	 * Genera una lista con los IDs de los usuarios brindados.
	 * @param lista_usuarios La lista de usuarios de los que se desea extraer el ID.
	 * @return La lista de IDs de los usuarios brindados.
	 */
	public ArrayList<String> extraerIDsUsuarios(ArrayList<Usuario> lista_usuarios) {
		ArrayList<String> lista_ids = new ArrayList<>();
		
		for (Usuario usuario : lista_usuarios) {
			lista_ids.add(usuario.getCodigoIdentificacion());
		}
		
		return lista_ids;
	}
	public static void guardarRegistrosCSV(ArrayList<Registro> lista_registros,Usuario usuario_activo) {
		String filename = usuario_activo.getNombre_completo() + ".csv";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filename);
			fileWriter.append("Descripcion,Monto,TipoRegistro,Mes,Year,Extra\n");
			for (Registro registro : lista_registros) {
				fileWriter.append(registro.getDescripcion());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(registro.getMonto()));
				fileWriter.append(",");
				fileWriter.append(registro.getTipo_registro());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(registro.getMes()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(registro.getYear()));
				fileWriter.append(",");
				if (registro instanceof Gasto) {
					Gasto gasto = (Gasto) registro;
					fileWriter.append(gasto.getCategoria());
				}
				else if (registro instanceof Ahorro) {
					fileWriter.append("N/A");
				}
				fileWriter.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo CSV.");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el FileWriter.");
			}
		}
	}
	public static ArrayList<Registro> cargarRegistrosCSV(String nombreCompletoUsuario) {
		String filename = nombreCompletoUsuario + ".csv";
		ArrayList<Registro> lista_registros = new ArrayList<>();
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			String line = "";
			fileReader.readLine(); // skip header
			while ((line = fileReader.readLine()) != null) {
				String[] data = line.split(",");
				if (data[0].equals(nombreCompletoUsuario)) {
					String descripcion = data[1];
					double monto = Double.parseDouble(data[2]);
					String tipoRegistro = data[3];
					int mes = Integer.parseInt(data[4]);
					int year = Integer.parseInt(data[5]);
					String tipo = data[6];
					Registro registro;
					if (tipoRegistro.equals("Ingreso")) {
						registro = new Ingreso(monto, descripcion, mes, year, tipo);
					} else { // Gasto
						String categoria = data[7];
						registro = new Gasto(monto, descripcion, mes, year, tipo, categoria);
					}
					lista_registros.add(registro);
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo CSV.");
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el FileReader.");
			}
		}
		return lista_registros;
	}
}