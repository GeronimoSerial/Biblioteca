import java.util.Calendar;
import java.util.ArrayList;

public class Estudiante extends Socio {
    private String carrera;

    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera, Prestamo p_prestamo){
        super(p_dniSocio, p_nombre, 0, p_prestamo);
        this.setCarrera(p_carrera);
    }

    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera, ArrayList<Prestamo> p_prestamos){
        super(p_dniSocio, p_nombre, 0, p_prestamos);
        this.setCarrera(p_carrera);
    }

    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;
    }

    public String getCarrera(){
        return this.carrera;
    }

    public boolean puedePedir(){
        Calendar fecha = Calendar.getInstance();
        for (Prestamo unPrestamo: this.getPrestamos()){
            if (unPrestamo.vencido(fecha) && this.cantLibrosPrestados() > 3){
                return false;
            }
        }
        return true;
    }

    public String soyDeLaClase() {
        return "Estudiante";
    }
}