/**
 *                     - [Clase Socio] -
 *            La cual posee todas las características ensenciales para poder representar a lo que su nombre lleva
 *            "Socio" . Siendo una clase mas general, pudiendo compartir sus comportamientos y atributos con las hijas, 
 *            Docente y Estudiante.
 *            
 *            @author Leonel Alegre
 *            @version 01
 */

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Socio{
   private int dniSocio;
   private String nombre;
   private int diasPrestamo;
   private ArrayList<Prestamo> prestamos;
   
   /**
    *                    Método Constructor [ Socio ] 
    * @param int p_dniSocio numero de documento del Socio.
    * @param String p_nombre nombre que correspondera al Socio de la Biblioteca
    * @param int p_diasPrestamo dias asignados de prestamo según las normas.
    * @param ArrayList<Prestamo> p_prestamos contenedor en el cual estaran alojados los prestamos correpondientes a un Socio
    */
   public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
       this.setDniSocio(p_dniSocio);
       this.setNombre(p_nombre);
       this.setDiasPrestamo(p_diasPrestamo);
       this.setPrestamos(p_prestamos);
   }
   
   /**
    * Método Constructor [ Socio ] 
    * @param int p_dniSocio numero de documento del Socio.
    * @param String p_nombre nombre que correspondera al Socio de la Biblioteca
    * @param int p_diasPrestamo dias asignados de prestamo según las normas.
    * @param Prestamo p_prestamo recibe el unico prestamo del Socio como inicio

    */
   public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo){
       this.setDniSocio(p_dniSocio);
       this.setNombre(p_nombre);
       this.setDiasPrestamo(p_diasPrestamo);
       this.setPrestamos(new ArrayList<Prestamo> ());
       this.agregarPrestamo(p_prestamo);
   }
   
   
   private void setDniSocio(int p_dniSocio){
       this.dniSocio = p_dniSocio;
   }
   public int getDniSocio(){
       return this.dniSocio;
   }
   
   private void setNombre(String p_nombre){
       this.nombre = p_nombre;
   }
   public String getNombre(){
       return this.nombre;
   }
   
   protected void setDiasPrestamo(int p_diasPrestamo){
       this.diasPrestamo = p_diasPrestamo;
   }
   public int getDiasPrestamo(){
       return this.diasPrestamo;
   }
   
   private void setPrestamos(ArrayList<Prestamo> p_prestamo){
       this.prestamos = p_prestamo;
   }
   public ArrayList<Prestamo> getPrestamos(){
       return this.prestamos;
   }
   
   public boolean agregarPrestamo(Prestamo p_prestamo){
       return this.getPrestamos().add(p_prestamo);
   }
   
   public boolean quitarPrestamo(Prestamo p_prestamo){
       return this.getPrestamos().remove(p_prestamo);
   }
   
   /**
    * Método cantLibrosPrestados.
    * 
    * El cual retorna la cantidad de libros que estan a disposición del Socio.
    * 
    * @return totalLibrosPrestados el cual llevara la suma de los libros
    */
   public int cantLibrosPrestados(){
       int totalLibrosPrestados = 0;
       
       for(Prestamo unPrestamo: this.getPrestamos()){
           if(unPrestamo.getFechaDevolucion() == null){
               totalLibrosPrestados ++;
           }
       }
       
       return totalLibrosPrestados;
   }
   
   public String toString(){
       return "DNI: "+this.getDniSocio()+" || "+this.getNombre()+"("+this.soyDeLaClase()+")"+"|| Libros Prestados: "+this.cantLibrosPrestados();
   }
   
   /**
    * Método puedePedir
    * 
    * El cual devuelve verdadero si es que el Socio no tiene ningun prestamo vencido
    */
   public boolean puedePedir(){
        Calendar hoy = Calendar.getInstance();
        boolean puede = true;
        
        for(int i = 0; i < this.getPrestamos().size() ; i++){
            puede = puede && (this.getPrestamos().get(i)).vencido(hoy);
        }
        
        return puede;
   }
   
   public abstract String soyDeLaClase();
}