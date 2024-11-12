import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;

public class GestionBiblioteca {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n\n---------- [ GESTION BIBLIOTECA  ]----------");
        System.out.println("\n\n*--------------------------------------*");
        System.out.println("Ingresar nombre de la Biblioteca: ");
        System.out.println("*--------------------------------------*");

        String nombre = teclado.nextLine();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Socio> socios = new ArrayList<>();
        Biblioteca unaBiblioteca = new Biblioteca(nombre, libros, socios);

        boolean condicionBiblioteca = true;

        while (condicionBiblioteca) {
            System.out.println("\n\n\n*--------------------------------------*");
            System.out.println("                 [   MENÚ    ]            ");
            System.out.println("\nOpcion 1 :     [Socio]     ");
            System.out.println("Opcion 2 :     [Libro]  ");
            System.out.println("Opcion 3 :     [Prestamo]     ");
            System.out.println("Opcion 4 :     [Salir]     ");
            System.out.println("*--------------------------------------*");

            int opcionBiblioteca = teclado.nextInt();

            switch (opcionBiblioteca) {
                case 1:
                    boolean condicionSocio = true;
                    while (condicionSocio) {
                        System.out.println("*\n\n\n----------------------------------------------*");
                        System.out.println("                 [   MENÚ Socio  ]            ");
                        System.out.println("                                         ");
                        System.out.println("           Opcion 1 :       [ Agregar Docente ]       ");
                        System.out.println("           Opcion 2 :       [ Agregar Estudiante ]");
                        System.out.println("           Opcion 3 :       [ Quitar ]");
                        System.out.println("           Opcion 4 :       [ Buscar ]");
                        System.out.println("           Opcion 5 :       [ Mostrar Lista de Socios] ");
                        System.out.println(
                                "           Opcion 6 :       [ Mostrar Lista de Socios Docentes Responsables] ");
                        System.out.println("           Opcion 7 :       [ Mostrar cantidad por tipo de Socio ]");
                        System.out.println("           Opcion 8 :       [ Menú anterior ] ");
                        System.out.println("                                          ");
                        System.out.println("*-----------------------------------------------*");

                        int opcionSocio = teclado.nextInt();

                        switch (opcionSocio) {
                            case 1:
                                System.out.println("\n\n\n*-----------------------------------------------*");
                                System.out.println("                    [   Docente   ]       ");
                                System.out.println("\n*Ingresar Datos del Docente ");
                                System.out.println("Ingresar DNI del socio: ");

                                int dniDocente = teclado.nextInt();
                                teclado.nextLine();
                                System.out.println("Ingresar nombre: ");
                                String nombreDocente = teclado.nextLine();
                                System.out.println("Ingresar area: ");
                                String areaDocente = teclado.nextLine();
                                System.out.println("*-----------------------------------------------*");

                                unaBiblioteca.nuevoSocioDocente(dniDocente, nombreDocente, areaDocente);

                                System.out.println("\n ¡Se agrego correctamente el Docente! ");
                                break;

                            case 2:
                                System.out.println("\n\n*-----------------------------------------------*");
                                System.out.println("                 [   Estudiante   ]       ");
                                System.out.println("\n*Ingresar Datos del Estuadiante* ");

                                System.out.println("Ingresar DNI del socio: ");
                                int dniEstudiante = teclado.nextInt();
                                teclado.nextLine();
                                System.out.println("Ingresar nombre: ");
                                String nombreEstudiante = teclado.nextLine();
                                System.out.println("Ingresar carrera: ");
                                String carreraEstudiante = teclado.nextLine();
                                System.out.println("*-----------------------------------------------*");

                                unaBiblioteca.nuevoSocioEstudiante(dniEstudiante, nombreEstudiante, carreraEstudiante);

                                System.out.println("\n ¡Se agrego correctamente el Estudiante! ");
                                break;
                                
                            case 3:
                                System.out.println("*-----------------------------------------------*");
                                System.out.println("Ingresar Dni del socio: ");
                                System.out.println("*_______________________________________________*");
                                int dniEliminar = teclado.nextInt();
                                teclado.nextLine();

                                for (Socio unSocio : unaBiblioteca.getSocios()) {
                                    if (dniEliminar == unSocio.getDniSocio()) {
                                        unaBiblioteca.quitarSocio(unSocio);
                                        System.out.println("\n ¡Se elimino correctamente el socio!");
                                        break;
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("*\n\n_______________________________________________*");
                                System.out.println("Ingresar Dni del socio: ");
                                System.out.println("*_______________________________________________*");
                                int dniBuscar = teclado.nextInt();
                                teclado.nextLine();
                                Socio unSocio = unaBiblioteca.buscarSocio(dniBuscar);
                                System.out.println("\n\n" + unSocio.toString());
                                break;

                            case 5:
                                System.out.println(unaBiblioteca.listaDeSocios());
                                break;

                            case 6:
                                System.out.println(unaBiblioteca.docentesResponsables());
                                break;

                            case 7:
                            
                                System.out.println("Cantidad de socios del tipo Docente: " + unaBiblioteca.cantidadDeSociosPorTipo("Docente"));
                            
                                 System.out.println("Cantidad de socios del tipo Estudiante: " + unaBiblioteca.cantidadDeSociosPorTipo("Estudiante"));
                            // System.out.println("*\n\n_______________________________________________*");
                                // System.out.println("Ingrese el tipo de socio:");
                                // System.out.println("*_______________________________________________*");
                                // teclado.nextLine();
                                // String tipoSocio = teclado.nextLine();
                                // if (tipoSocio.equalsIgnoreCase("Docente")) {
                                //     System.out.println("Cantidad de Socios del tipo Docente: "
                                //             + unaBiblioteca.cantidadDeSociosPorTipo(tipoSocio));
                                // } else if (tipoSocio.equalsIgnoreCase("Estudiante")) {
                                //     System.out.println("Cantidad de Socios del tipo Estudiante: "
                                //             + unaBiblioteca.cantidadDeSociosPorTipo(tipoSocio));
                                // }
                                break;

                            case 8:
                                condicionSocio = false;
                                break;

                            default:
                                System.out.println("\n\nIngrese una opcion correcta ( 1 - 8 ) ");
                                break;
                        }
                    }
                break;
                case 2:
                    boolean condicionLibro = true;

                    while (condicionLibro) {
                        System.out.println("\n\n*-----------------------------------------------*");
                        System.out.println("                     [MENÚ Libro]            ");

                        System.out.println("Opcion 1 :       [ Agregar ]       ");
                        System.out.println("Opcion 2 :       [ Eliminar ]      ");
                        System.out.println("Opcion 3 :       [ Buscar ]        ");
                        System.out.println("Opcion 4 :       [ Lista de Libros ]     ");
                        System.out.println("Opcion 5 :       [ Menu anterior ]       ");
                        System.out.println("*-----------------------------------------------*");

                        int opcionLibro = teclado.nextInt();

                        switch (opcionLibro) {
                            case 1:
                                System.out.println("\n\n*-----------------------------------------------*");
                                System.out.println("                         [ LIBRO ]      ");
                                System.out.println("\nIngresar el titulo del libro : ");

                                teclado.nextLine();
                                String tituloLibro = teclado.nextLine();
                                System.out.println("Ingresar la edicion : ");
                                int edicionLibro = teclado.nextInt();
                                teclado.nextLine();
                                System.out.println("Ingresar la editorial : ");
                                String editorialLibro = teclado.nextLine();
                                System.out.println("Anio de publicacion :  ");
                                int anio = teclado.nextInt();
                                System.out.println("\n*-----------------------------------------------*");

                                unaBiblioteca.nuevoLibro(tituloLibro, edicionLibro, editorialLibro, anio);
                                // unaBiblioteca.agregarLibro(libro);

                                System.out.println("\n ¡Se agrego correctamente el Libro!");
                                break;

                            case 2:
                                System.out.println("\n*-----------------------------------------------*");
                                System.out.println("Ingresar el titulo del Libro: ");
                                System.out.println("\n*-----------------------------------------------*");

                                teclado.nextLine();
                                String tituloEliminar = teclado.nextLine();

                                for (Libro unLibro : unaBiblioteca.getLibros()) {
                                    if (tituloEliminar.equalsIgnoreCase(unLibro.getTitulo())) {
                                        unaBiblioteca.quitarLibro(unLibro);
                                        System.out.println("\n Se elimino correctamente el Libro! ");
                                        break;
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("\n*-----------------------------------------------*");
                                System.out.println("Ingresar el titulo del Libro: ");
                                System.out.println("\n*-----------------------------------------------*");

                                teclado.nextLine();
                                String tituloBuscar = teclado.nextLine();

                                for (Libro unLibro : unaBiblioteca.getLibros()) {
                                    if (tituloBuscar.equalsIgnoreCase(unLibro.getTitulo())) {
                                        System.out.println("se encontró el libro: " + unLibro.getTitulo());
                                    }
                                }
                                break;

                            case 4:
                                System.out.println(unaBiblioteca.listaDeLibros());
                                break;

                            case 5:
                                condicionLibro = false;
                                break;

                            default:
                                System.out.println("\n\n Ingrese una opcion correcta ( 1 - 5 )");
                                break;
                        }
                    }
                break;
                case 3:
                    boolean condicionPrestamo = true;

                    while (condicionPrestamo) {
                        System.out.println("*\n\n-------------------------------------*");
                        System.out.println("             [  MENÚ Prestamo  ]             ");
                        System.out.println("                                         ");
                        System.out.println("Opcion 1 :       [Realizar Prestamo de libro]     ");
                        System.out.println("Opcion 2 :       [Devolver Libro]        ");
                        System.out.println("Opcion 3 :       [Buscar Libro]          ");
                        System.out.println("Opcion 4 :       [Prestamos Vencidos]    ");
                        System.out.println("Opcion 5 :       [Menu anterior]         ");

                        int opcionPrestamo = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionPrestamo) {
                            case 1:
                                System.out.println("Ingrese el DNI del socio: ");
                                int dniPrestamo = teclado.nextInt();
                                teclado.nextLine();
                                
                                Socio socioPrestamo = unaBiblioteca.buscarSocio(dniPrestamo);
                                if (socioPrestamo == null) {
                                    System.out.println("Error: No se encontró el socio con DNI " + dniPrestamo);
                                    break;
                                }
                                
                                System.out.println("Ingresar el titulo del libro: ");
                                String tituloPrestamo = teclado.nextLine();
                                
                                Libro libroPrestamo = null;
                                for (Libro unLibro : unaBiblioteca.getLibros()) {
                                    if (tituloPrestamo.equalsIgnoreCase(unLibro.getTitulo())) {
                                        libroPrestamo = unLibro;
                                        break;
                                    }
                                }
                                
                                if (libroPrestamo == null) {
                                    System.out.println("Error: No se encontró el libro '" + tituloPrestamo + "'");
                                    break;
                                }
                                
                                if (libroPrestamo.prestado()) {
                                    System.out.println("Error: El libro ya está prestado");
                                    break;
                                }
                                
                                try {
                                    System.out.println("\n*--- Ingreso de Fecha de Retiro ---*");
                                    System.out.print("Ingrese el año (YYYY): ");
                                    int anio = teclado.nextInt();
                                    System.out.print("Ingrese el mes (1-12): ");
                                    int mes = teclado.nextInt() - 1; // Calendar usa meses 0-11
                                    System.out.print("Ingrese el día (1-31): ");
                                    int dia = teclado.nextInt();
                                    
                                    Calendar unaFecha = Calendar.getInstance();
                                    unaFecha.set(anio, mes, dia);
                                    
                                    // Validación básica de fecha
                                    if (anio < 2024 || mes < 0 || mes > 11 || dia < 1 || dia > 31) {
                                        throw new IllegalArgumentException("Fecha inválida");
                                    }
                                    
                                    unaBiblioteca.prestarLibro(unaFecha, socioPrestamo, libroPrestamo);
                                    System.out.println("\n¡Se prestó el libro '" + libroPrestamo.getTitulo() + 
                                                      "' al socio " + socioPrestamo.getNombre() + "!");
                                } catch (Exception e) {
                                    System.out.println("Error al realizar el préstamo: " + e.getMessage());
                                }
                                break;
                            case 2:
                                System.out.println("*\n-------------------------------------*");
                                System.out.println("Ingresar el titulo del libro: ");
                                System.out.println("*-------------------------------------*");

                                String tituloLibro = teclado.nextLine();
                                Libro libroDevolver = null;

                                for (Libro unLibro : unaBiblioteca.getLibros()) {
                                    if (unLibro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                                        libroDevolver = unLibro;
                                        try {
                                            unaBiblioteca.devolverLibro(libroDevolver);
                                            System.out.println("Se devolvio el libro: " + libroDevolver.getTitulo());
                                        } catch (LibroNoPrestadoException lnpe) {
                                            lnpe.printStackTrace();
                                        }
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("\n\nIngresar el titulo del libro: ");
                                String tituloBuscar = teclado.nextLine();
                                Libro libroEncontrado = null;

                                for (Socio unSocio : unaBiblioteca.getSocios()) {
                                    for (Prestamo prestamo : unSocio.getPrestamos()) {
                                        if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloBuscar)) {
                                            libroEncontrado = prestamo.getLibro();
                                            System.out.println("Se encontro el libro: " + libroEncontrado.getTitulo());
                                            try {
                                                System.out.println(unaBiblioteca.quienTieneElLibro(libroEncontrado));
                                            } catch (LibroNoPrestadoException lnpe) {
                                                lnpe.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("\n\n*** Prestamos Vencidos ***");
                                if (unaBiblioteca.prestamosVencidos().size() > 0) {
                                    unaBiblioteca.prestamosVencidos();
                                } else {
                                    System.out.println("No hay prestamos vencidos!");
                                }
                                break;
                            case 5:
                                condicionPrestamo = false;
                                break;
                            default:
                                System.out.println("\n\n Ingrese una opcion correcta ( 1 - 5 )");
                                break;
                        }
                    }
                break;
                case 4:
                    condicionBiblioteca = false;
                break;
                default:
                    System.out.println("");
                break;
            }
        }
        teclado.close();
    }
}