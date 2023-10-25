package service;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Usuario;


public class UsuarioService {

	
	// código común a los otros métodos lo metemos en un método private
	private Stream<Usuario> getUsuarios(){
		
		
		String ruta="c:\\temp\\usuarios.json";
		Gson gson =new Gson();
		
		try(FileReader reader = new FileReader(ruta);)
		{
			
			Usuario[] usuarios=gson.fromJson(reader, Usuario[].class);
			return Arrays.stream(usuarios); //devuelve stream de objetos empleados
			
		}catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //devolvemos un stream vacío si hay excepcion
		}
	
		
	}
	
	
	//le paso objeto Usuario línea completa de json
	public boolean autenticar(Usuario user) {
		return 
				getUsuarios() //stream<User>
				.anyMatch(u->u.getUsuario().equals(user.getUsuario())&&u.getPassword().equals(user.getPassword())); //boolean
		
	}

	
	
	
	
}
