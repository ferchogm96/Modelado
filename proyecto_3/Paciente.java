import java.io.Serializable;

/**
 * Programa que representa a un paciente en una clínica
 */
public class Paciente implements Serializable{

   private String nombre;
   private String hora_consulta;
   private String min_consulta;
   private Paciente anterior;
   private Paciente siguiente;

   public Paciente(String nombre, String hora, String min){
      this.nombre = nombre;
      this.hora_consulta = hora;
      this.min_consulta = min;
      this.anterior = null;
      this.siguiente = null;
   }

   /**
    * @return el nombre del paciente
    */
   public String getNombre(){
      return this.nombre;
   }

   /**
    * @return la hora de consulta del paciente
    */
   public String getHora(){
      return this.hora_consulta;
   }

   /**
    * @return la hora de consulta del paciente
    */
   public String getMin(){
      return this.min_consulta;
   }

   /**
    * @return el paciente anterior
    */
   public Paciente getAnterior(){
      return this.anterior;
   }
   
   /**
    * @return el paciente siguiente
    */
   public Paciente getSiguiente(){
      return this.siguiente;
   }

   /**
    * Modifica el nombre del paciente
    */
   public void setNombre(String nombre){
      this.nombre = nombre;
   }

   /**
    * Modifica la hora de consulta del paciente
    */
   public void setHora(String hora){
      this.hora_consulta = hora;
   }
   
   /**
    * Modifica la hora de consulta del paciente
    */
   public void setMin(String min){
      this.min_consulta = min;
   }

   /**
    * Modifica la info del paciente anterior
    */
   public void setAnterior(Paciente ant){
      this.anterior = ant;
   }

   /**
    * Modifica la info del paciente siguiente
    */
   public void setSiguiente(Paciente sig){
      this.siguiente = sig;
   }

   /**
    * Representación en cadena del paciente
    */
   public String toString(){
      return this.nombre+". Hora de consulta: "+this.hora_consulta+":"+this.min_consulta+" hrs.";
   }

}
