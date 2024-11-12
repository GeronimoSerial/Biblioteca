import java.util.Calendar;
import java.util.ArrayList;

public class Docente extends Socio {
    private String area;

    public Docente (int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo, String p_area){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamo);
        this.setArea(p_area);
    }

    public Docente(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos, String p_area){
        super(p_dniSocio, p_nombre, p_diasPrestamo, p_prestamos);
        this.setArea(p_area);
    }

    private void setArea(String p_area){
        this.area = p_area;
    }

    public String getArea(){
        return this.area;
    }

    public boolean esResponsable(){
        Calendar fecha = Calendar.getInstance();
        for (Prestamo unPrestamo: this.getPrestamos()){
            if (unPrestamo.vencido(fecha)){
                return false;
            }
        }

        return true;
    }

    public void cambiarDiasPrestamo(int p_dias){
        if(this.esResponsable()){
            this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
        }
    }

    public String soyDeLaClase(){
        return "Docente";
    }
}