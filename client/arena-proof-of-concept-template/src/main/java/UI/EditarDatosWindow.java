package UI;

import java.util.ArrayList;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import Domain.Estudiante;
import HTTP.RequestService;
import JSON.Parser;
import Repo.RepoEstudiante;
import ViewModel.EditarDatosVM;

public class EditarDatosWindow extends Dialog<EditarDatosVM> {

	public EditarDatosWindow(WindowOwner owner) {
		super(owner, new EditarDatosVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		this.setTitle("Edicion Datos Alumno");
		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty("nombre");
		new Label(form).setText("Apellido");
		new TextBox(form).bindValueToProperty("apellido");
		new Label(form).setText("Legajo");
		new TextBox(form).bindValueToProperty("legajo");
		new Label(form).setText("Usuario Git");
		new TextBox(form).bindValueToProperty("usuarioGit");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Guardar").onClick(this::guardar).setAsDefault();
	}

	protected void guardar() {
		Estudiante estudianteSerializado = RepoEstudiante.getInstance().dameUno();
		
		RequestService.getInstance().actualizarEstudiante("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", Parser.serializarEstudiante(estudianteSerializado));
		this.close();
		super.executeTask();
		this.openDialog(new MainWindow(this));
	}
	
	protected void openDialog(Dialog<?> dialog) {
		    dialog.open();
		}
		
	

}
