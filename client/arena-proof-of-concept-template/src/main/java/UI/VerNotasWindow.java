package UI;

import java.util.ArrayList;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import Domain.Estudiante;
import Domain.Nota;
import Domain.Tarea;
import ViewModel.MostrarTareasVM;

public class VerNotasWindow extends Dialog<MostrarTareasVM> {

	public VerNotasWindow(WindowOwner owner) {
		super(owner, new MostrarTareasVM());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		Table<MostrarTareasVM> table = new Table<MostrarTareasVM>(mainPanel, MostrarTareasVM.class);
		table.bindItemsToProperty("tareas");
		new Column<MostrarTareasVM>(table).setTitle("id").setFixedSize(200).bindContentsToProperty("id");
		new Column<MostrarTareasVM>(table).setTitle("title").setFixedSize(200).bindContentsToProperty("title");
		new Column<MostrarTareasVM>(table).setTitle("description").setFixedSize(200).bindContentsToProperty("description");
		//new Column<MostrarTareasVM>(table).setTitle("Calificación").setFixedSize(200).bindContentsToProperty("calificacion");
		//new Column<MostrarTareasVM>(table).setTitle("Aprobo").setFixedSize(200).bindContentsToProperty("aprobo");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::volver).setAsDefault();

	}

	protected void volver() {
		new MainWindow(this);
		this.close();
		super.executeTask();
		this.openDialog(new MainWindow(this));
	}
	
	protected void openDialog(Dialog<?> dialog) {
		    dialog.open();
		}
		

}