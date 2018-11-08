package ViewModel;

import org.uqbar.commons.model.annotations.Observable;

import Login.Loggeo;


@Observable
public class LoginVM {
 private int legajo;

 public int getLegajo() {
  return legajo;
 }

 public void setLegajo(int legajo) {
  this.legajo = legajo;
 }
 
 public void obtenerEstudiante() throws Exception {
   Loggeo.getInstance().intentarLoguearA(legajo);
 }
}