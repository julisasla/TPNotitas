package Login;

import java.util.HashMap;
import java.util.Map;

import Domain.*;
import HTTP.RequestService;


public class Loggeo {
 private Map<Integer, String> tokens = new HashMap<>();
 
 private static Loggeo instancia;
 
 public static Loggeo getInstance() {
  if(instancia == null) {
   instancia = new Loggeo();
  }
  return instancia;
 }
 
 public void registrarToken(int legajo, String token) {
  tokens.put(legajo, token);
 }
 
 public void intentarLoguearA(int legajo) throws Exception{
  String token = obtenerToken(legajo);
  RequestService.getInstance().setToken(token);
 }
 
 public String obtenerToken(int legajo) throws Exception {
  if(!tokens.containsKey(legajo)) {
   throw new Exception();
  }
  return tokens.get(legajo);
 }
}