package UI;

import java.util.ArrayList;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Domain.Estudiante;
import ViewModel.EditarDatosVM;
import ViewModel.LoginVM;
@SuppressWarnings("serial")
public class LoginWindow extends Dialog<LoginVM>{
 
 private Label legajoInexistenteError;
 
	public LoginWindow(WindowOwner owner) {
		super(owner, new LoginVM());
	}

 @Override
 public void createFormPanel(Panel mainPanel) {
  
  this.setTitle("Iniciar Sesion");
  mainPanel.setLayout(new VerticalLayout());
  
  new ErrorsPanel(mainPanel, "", 1);
  
  new Label(mainPanel).setText("Legajo");
  
  new TextBox(mainPanel).bindValueToProperty("legajo");
  
  legajoInexistenteError = new Label(mainPanel).setText(" ");
  
  //TODO por que funciona con los '::'? (cuando no se pasaba ningun parametro)
  new Button(mainPanel).setCaption("Entrar").onClick(this::intentarAbrirEstudianteView);
  
  new Button(mainPanel).setCaption("Salir").onClick(this::close);
 }
protected void openDialog(Dialog<?> dialog) {
    dialog.open();
}

 private void intentarAbrirEstudianteView() {
  try{
   getModelObject().obtenerEstudiante();
   this.close();
   this.openDialog(new MainWindow(this));
  }
  
  catch(Exception e){
   System.out.println("Legajo incorrecto");
   legajoInexistenteError.setText("Legajo incorrecto");
  }
 }
}