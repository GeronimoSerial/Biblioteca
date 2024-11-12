import java.util.ArrayList;
/**
 * Clase Libro 
 * Posee las caracteristicas necesarias para administrar la informacion de un libro: titulo,edicion,editorial etc;
 * 
 * 
 * @author Aquino Paul
 * @version 1
 */

public class Libro{
 
    //atributos de la clase Libro
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList <Prestamo> prestamos;
    
    /**
     * Metodo constructor Libro
     * 
     * @param String p_titulo titulo del libro
     * @param int p_edicion numero de edicion del libro
     * @param String p_editorial editorial del libro
     * @param int p_anio anio del libro
     * @param ArrayList<Prestamo> p_prestamos recibe la coleccion de prestamos 
     * 
     */
    public Libro(String p_titulo , int p_edicion , String p_editorial , int p_anio , ArrayList <Prestamo> p_prestamos){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }
    
    /**
     * Metodo constructor Libro
     * 
     * @param String p_titulo titulo del libro
     * @param int p_edicion numero de edicion del libro
     * @param String p_editorial editorial del libro
     * @param int p_anio anio del libro
     * 
     */
    public Libro(String p_titulo , int p_edicion , String p_editorial , int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo> ());//incializa el contenedor 
    }
    
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }
    
    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;
    }
    
    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }
    
    private void setAnio(int p_anio){
        this.anio = p_anio;
    }
    
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public int getEdicion(){
        return this.edicion;
    }
    
    public String getEditorial(){
        return this.editorial;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    
    /**
     * Metodo agregarPrestamo
     * 
     * @param Prestamo p_prestamo recibe por parametro un prestamo
     * 
     * @return true si se puede agregar el elemento a la coleccion de lo contrario false
     * 
     */
    public boolean agregarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * Metodo quitarPrestamo
     * 
     * @param Prestamo p_prestamo recibe por parametro un prestamo 
     * 
     * @return true si se puede eliminar el elemento de la coleccion de lo contrario false
     * 
     */
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Metodo ultimoPrestamo
     * 
     * @return el ultimoPrestamo de la coleccion 
     */
    public Prestamo ultimoPrestamo(){
        return this.getPrestamos().get(this.getPrestamos().size() - 1);
    }
    
    
    /**
     * Metodo prestado 
     * 
     * Verifica en la coleccion de Prestamos si se encuentra un libro con el mismo titulo
     * 
     * @return true si se encuentra el libro en la coleccion de lo contrario retorna false
     * 
     */
    public boolean prestado(){   
        for(Prestamo unPrestamo : this.getPrestamos()){
            if(unPrestamo.getLibro().getTitulo().equals(this.getTitulo())){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Metodo toString
     * 
     * @return un String con el titulo del libro
     */
    public String toString(){
        return "Titulo: " + this.getTitulo();
    }
    
}
