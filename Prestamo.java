/**                      
 *   - Clase Prestamo -
 *   La cual se encarga de realizar los prestamos de la Biblioteca, dejando acentado en una ficha en los libros con los socios que hicieron poder del mismo, y a los socios permitiendo poder
 *   registrado la cantidad de libros a su disposición.
 *   
 *   @author Leonel Alegre
 *   @version 01
 */
import java.util.Calendar;
public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
    /**
     *                  [Prestamo]
     *     @param Calendar p_fechaRetiro fecha en la cual asistio el socio y obtuvo el libro
     *     @param Calendar p_fechaDevolucion fecha en la cual se tiene que devolver el libro
     *     @param Socio p_socio recibe los datos del socio para poder realizar la operación
     *     @param Libro p_libro recibe el libro el cual será asignado al Socio.
     */
    public Prestamo(Calendar p_fechaRetiro, Calendar p_fechaDevolucion, Socio p_socio, Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(p_fechaDevolucion);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro = p_fechaRetiro;
    }
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    
    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }
    public Socio getSocio(){
        return this.socio;
    }
    
    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }
    public Libro getLibro(){
        return this.libro;
    }
    
    /**
     * Metodo registrarFechaDevolucion
     * 
     * El cual permite poder asignarle una fecha al atributo fechaDevolucion, indicando la devolucion del mismo.
     * @param Calendar p_fecha
     */
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }
    
    /**
     * Método Vencido 
     *
     * El cual devuelve true si la fecha ingresada por el parametro es mayor que la fecha de vencimiento. 
     * (Fecha de vencimiento = fecha de retiro mas los dias de prestamo).
     * 
     * @param Calendar p_fecha fecha ingresa por el parametro
     * @return true si p_fecha es mayor que la fecha de vencimiento
     *
     */
    public boolean vencido(Calendar p_fecha){
        Calendar fechaVencimiento = this.getFechaRetiro();
        int diasPrestamo = this.getSocio().getDiasPrestamo();
        //sumamos los dias de prestamo con el de retiro
        fechaVencimiento.add(Calendar.DAY_OF_MONTH, diasPrestamo);
        return p_fecha.after(fechaVencimiento);
    }
    
    /**
     * Método toString
     * El cual devuelve una cadena de caracteres especifica en el enunciado del problema
     * Ej: 
     *        Retiro: 2014/10/15 - Devolución: 2014/10/28
            Libro: JAVA. Como Programar
            Socio: Juan Perez
     * 
     * @return devuelve el valor de la variable var
     */
    public String toString(){
        String var = "Retiro: "+this.getFechaRetiro().get(Calendar.YEAR)+"/"+this.getFechaRetiro().get(Calendar.MONTH)+"/"+this.getFechaRetiro().get(Calendar.DAY_OF_MONTH)+" - "+
        " Devolucion: "+this.getFechaDevolucion().get(Calendar.YEAR)+"/"+this.getFechaDevolucion().get(Calendar.MONTH)+"/"+this.getFechaDevolucion().get(Calendar.DAY_OF_MONTH)+"\n"+
        "Libro: "+this.getLibro().getTitulo()+"\n"+
        "Socio: "+this.getSocio().getNombre();
        
        return var;
    }
    
}