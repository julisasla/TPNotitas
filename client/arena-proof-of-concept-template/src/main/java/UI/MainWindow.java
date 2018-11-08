package UI;

import java.util.ArrayList;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Domain.Estudiante;
import ViewModel.EditarDatosVM;

public class MainWindow extends Dialog<EditarDatosVM> {

	public MainWindow(WindowOwner owner) {
		super(owner, new EditarDatosVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		this.setTitle("Aplicacion Alumno");
		new Label(form).setText("Nombre");
		new Label(form).bindValueToProperty("nombre");
		new Label(form).setText("Apellido");
		new Label(form).bindValueToProperty("apellido");
		new Label(form).setText("Legajo");
		new Label(form).bindValueToProperty("legajo");
		new Label(form).setText("Usuario Git");
		new Label(form).bindValueToProperty("usuarioGit");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Ver Notas").onClick(this::verNotas).setAsDefault();
		new Button(actions).setCaption("Editar Mis Datos").onClick(this::editarDatos);
	}

	protected void editarDatos() {
		this.close();
		super.executeTask();
		this.openDialog(new EditarDatosWindow(this));
	}
	
	protected void verNotas() {
		this.close();
		super.executeTask();
		this.openDialog(new VerNotasWindow(this));	
	}
	
	protected void openDialog(Dialog<?> dialog) {
	    dialog.open();
	}
	
}
