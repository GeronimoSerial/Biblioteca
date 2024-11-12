import java.util.ArrayList;
import java.util.Calendar;


/**
 *                     - [Clase Biblioteca] -
 *            Representa una biblioteca que maneja libros y socios.
 *            
 *            @author Bosch, Martin - Díaz, Franco - Escalante, Marcelo.
 *            @version 1
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;

    /**
     * Crea una nueva instancia de Biblioteca.
     *
     * @param p_nombre Nombre de la biblioteca.
     * @param p_libros Lista de libros de la biblioteca.
     * @param p_socios Lista de socios de la biblioteca.
     */
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros, ArrayList<Socio> p_socios) {
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(p_socios);
    }

    /**
     * Crea una nueva instancia de Biblioteca con un libro y un socio iniciales.
     *
     * @param p_nombre Nombre de la biblioteca.
     * @param p_libro  Libro inicial de la biblioteca.
     * @param p_socio  Socio inicial de la biblioteca.
     */
    public Biblioteca(String p_nombre, Libro p_libro, Socio p_socio) {
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.agregarLibro(p_libro);
        this.setSocios(new ArrayList<Socio>());
        this.agregarSocio(p_socio);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setLibros(ArrayList<Libro> p_libros) {
        this.libros = p_libros;
    }

    private void setSocios(ArrayList<Socio> p_socios) {
        this.socios = p_socios;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return Nombre de la biblioteca.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la lista de libros de la biblioteca.
     *
     * @return Lista de libros.
     */
    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    /**
     * Obtiene la lista de socios de la biblioteca.
     *
     * @return Lista de socios.
     */
    public ArrayList<Socio> getSocios() {
        return this.socios;
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param p_libro Libro a agregar.
     * @return true si el libro fue agregado, false en caso contrario.
     */
    public boolean agregarLibro(Libro p_libro) {
        return this.getLibros().add(p_libro);
    }

    /**
     * Elimina un libro de la biblioteca.
     *
     * @param p_libro Libro a eliminar.
     * @return true si el libro fue eliminado, false en caso contrario.
     */
    public boolean quitarLibro(Libro p_libro) {
        return this.getLibros().remove(p_libro);
    }

    /**
     * Crea un nuevo libro y lo agrega a la biblioteca.
     *
     * @param p_titulo   Título del libro.
     * @param p_edicion  Edición del libro.
     * @param p_editorial Editorial del libro.
     * @param p_anio     Año de publicación del libro.
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        Libro nuevoLibro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.agregarLibro(nuevoLibro);
    }

    /**
     * Agrega un socio a la biblioteca.
     *
     * @param p_socio Socio a agregar.
     * @return true si el socio fue agregado, false en caso contrario.
     */
    public boolean agregarSocio(Socio p_socio) {
        return this.getSocios().add(p_socio);
    }

    /**
     * Elimina un socio de la biblioteca.
     *
     * @param p_socio Socio a eliminar.
     * @return true si el socio fue eliminado, false en caso contrario.
     */
    public boolean quitarSocio(Socio p_socio) {
        return this.getSocios().remove(p_socio);
    }

    /**
     * Crea un nuevo socio estudiante y lo agrega a la biblioteca.
     *
     * @param p_dniSocio DNI del socio.
     * @param p_nombre   Nombre del socio.
     * @param p_carrera  Carrera del estudiante.
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        Socio nuevoSocioEstudiante = new Estudiante(p_dniSocio, p_nombre, p_carrera, new ArrayList<Prestamo>());
        this.agregarSocio(nuevoSocioEstudiante);
    }

    /**
     * Crea un nuevo socio docente y lo agrega a la biblioteca.
     *
     * @param p_dniSocio DNI del socio.
     * @param p_nombre   Nombre del socio.
     * @param p_area     Área de especialización del docente.
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) {
        Socio nuevoSocioDocente = new Docente(p_dniSocio, p_nombre, 0, new ArrayList<Prestamo>(), p_area);
        this.agregarSocio(nuevoSocioDocente);
    }

    /**
     * Presta un libro a un socio en una fecha determinada.
     *
     * @param p_fechaRetiro Fecha de retiro del libro.
     * @param p_socio       Socio que retira el libro.
     * @param p_libro       Libro a prestar.
     * @return true si el préstamo fue exitoso, false si el libro ya estaba prestado.
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        if (!p_libro.prestado()) {
            Prestamo nuevoPrestamo = new Prestamo(p_fechaRetiro, null, p_socio, p_libro);
            p_libro.agregarPrestamo(nuevoPrestamo);
            p_socio.agregarPrestamo(nuevoPrestamo);
            return true;
        }
        return false;
    }

    /**
     * Devuelve un libro a la biblioteca si estaba prestado.
     *
     * @param p_libro El libro a devolver.
     * @throws LibroNoPrestadoException si el libro no estaba prestado.
     */
    public void devolverLibro(Libro p_libro) throws LibroNoPrestadoException {
        if (!p_libro.prestado()) {
            throw new LibroNoPrestadoException(
                    "El libro '" + p_libro.getTitulo() + "' no se puede devolver ya que se encuentra en la biblioteca");
        }

        Calendar fechaActual = Calendar.getInstance();
        for (Prestamo prestamo : p_libro.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null) {
                prestamo.registrarFechaDevolucion(fechaActual);
            }
        }
    }

    /**
     * Cuenta el número de socios de un tipo específico.
     *
     * @param p_objeto El tipo de socio (por ejemplo, "Estudiante" o "Docente").
     * @return La cantidad de socios del tipo especificado.
     */
    public int cantidadDeSociosPorTipo(String p_objeto) {
        int cantidad = 0;
        for (Socio socio : this.getSocios()) {
            if (socio.soyDeLaClase().equalsIgnoreCase(p_objeto)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Obtiene la lista de préstamos vencidos.
     *
     * @return Una lista de préstamos vencidos.
     */
    public ArrayList<Prestamo> prestamosVencidos() {
        Calendar fechaActual = Calendar.getInstance();
        ArrayList<Prestamo> prestamosVencidos = new ArrayList<Prestamo>();

        for (Libro libro : this.getLibros()) {
            for (Prestamo prestamo : libro.getPrestamos()) {
                if (prestamo.vencido(fechaActual)) {
                    prestamosVencidos.add(prestamo);
                }
            }
        }
        return prestamosVencidos;
    }

    /**
     * Obtiene una lista de docentes que son responsables.
     *
     * @return Una lista de socios que son docentes responsables.
     */
    public ArrayList<Socio> docentesResponsables() {
        ArrayList<Socio> docentesResponsables = new ArrayList<Socio>();

        for (Socio socio : this.getSocios()) {
            if (socio instanceof Docente) {
                Docente docente = (Docente) socio;
                if (docente.esResponsable()) {
                    docentesResponsables.add(docente);
                }
            }
        }
        return docentesResponsables;
    }

    /**
     * Obtiene el nombre del socio que tiene actualmente prestado un libro específico.
     *
     * @param p_libro El libro que se busca.
     * @return El nombre del socio que tiene el libro.
     * @throws LibroNoPrestadoException si el libro no está prestado o no tiene un prestamo activo.
     */
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException {
        if (p_libro == null || !p_libro.prestado()) {
            throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
        }
        
        for (Prestamo prestamo : p_libro.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null) {  // Préstamo sin devolver
                return prestamo.getSocio().getNombre();
            }
        }
        
        throw new LibroNoPrestadoException("No se encontró un préstamo activo para este libro.");
    }

    /**
     * Imprime y devuelve una lista de todos los socios de la biblioteca.
     *
     * @return Una cadena que representa la lista de socios.
     */
    public String listaDeSocios() {
        System.out.println("Lista de Socios: ");
        String lista = "";
        int i = 1;
        for (Socio socio : this.getSocios()) {
            lista += (i++) + ")" + socio.toString() + "\n";
        }
        System.out.println("**********************");
        System.out.println("Cantidad de Socios del tipo estudiante: " + this.cantidadDeSociosPorTipo("Estudiante"));
        System.out.println("Cantidad de Socios del tipo docente: " + this.cantidadDeSociosPorTipo("Docente"));
        System.out.println("**********************");
        return lista;
    }

    /**
     * Busca un socio por su DNI.
     *
     * @param p_dni El DNI del socio.
     * @return El socio encontrado o null si no existe.
     */
    public Socio buscarSocio(int p_dni) {
        Socio socioEncontrado = null;

        for (Socio socio : this.getSocios()) {
            if (socio.getDniSocio() == p_dni) {
                socioEncontrado = socio;
            }
        }
        return socioEncontrado;
    }

    /**
     * Imprime y devuelve una lista de los títulos de todos los libros.
     *
     * @return Una cadena que representa la lista de títulos de libros.
     */
    public String listaDeTitulos(){
        System.out.println("Lista de titulos: ");
        String lista = "";
        int i = 1;
        for(Libro libro : this.getLibros()){
            lista += (i++) + ")" + libro.toString() + "\n";
        }
        return lista;
    }

    /**
     * Imprime y devuelve una lista de todos los libros en la biblioteca.
     *
     * @return Una cadena que representa la lista de libros.
     */
    public String listaDeLibros() {
        System.out.println("Lista de Libros: ");
        String lista = "";
        int i = 1;
        for (Libro libro : this.getLibros()) {
            if (libro.prestado()) {
                lista += (i++) + ")" + libro.toString() + "|| Prestado: (SI)" + "\n";
            } else {
                lista += (i++) + ")" + libro.toString() + "|| Prestado: (NO)" + "\n";
            }
        }
        return lista;
    }

    /**
     * Imprime y devuelve una lista de los docentes responsables.
     *
     * @return Una cadena que representa la lista de docentes responsables.
     */
    public String listaDeDocentesResponsables() {
        System.out.println("Lista de Docentes Responsables: ");
        String responsables = "";
        for (Socio docente : this.docentesResponsables()) {
            if (docente instanceof Docente && ((Docente) docente).esResponsable()) {
                responsables += "* " + docente.toString() + "\n";
            }
        }
        return responsables;
    }
}
