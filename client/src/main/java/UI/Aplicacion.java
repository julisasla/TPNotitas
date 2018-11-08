package UI;

import java.io.IOException;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Domain.Fixture;
import UI.*;

public class Aplicacion extends Application{

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Fixture.initialize();
		new Aplicacion().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}
}