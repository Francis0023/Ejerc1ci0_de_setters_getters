import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int opción, id;
        String nombre, materia;
        double nota1, nota2, sumaNotas1b = 0, sumaNotas2b = 0, promedioTotal = 0;

        System.out.print("Cantidad de estudiantes que desea registrar: ");
        n = scanner.nextInt();

        Base[] estudiantes = new Base[n];

        do {
            System.out.println("****Menú de opciones****");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Mostrar datos");
            System.out.println("3. Modificar datos");
            System.out.println("4. Salir");
            System.out.print("Opción:");
            opción = scanner.nextInt();

            if (opción == 1) {
                for (int i = 0; i < estudiantes.length; i++) {
                    System.out.println("Estudiante " + (i + 1));
                    System.out.print("Nombre: ");
                    nombre = scanner.next();
                    System.out.print("Materia: ");
                    materia = scanner.next();
                    System.out.print("Nota 1: ");
                    nota1 = scanner.nextDouble();
                    System.out.print("Nota 2: ");
                    nota2 = scanner.nextDouble();
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    estudiantes[i] = new Base(nombre, materia, nota1, nota2, id);
                    sumaNotas1b += nota1;
                    sumaNotas2b += nota2;
                }
            } else if (opción == 2) {
                mostrarDatos(estudiantes, sumaNotas1b, sumaNotas2b);
            } else if (opción == 3) {
                System.out.print("Ingrese el ID del estudiante a modificar: ");
                int idModificar = scanner.nextInt();
                modificarDatos(estudiantes, idModificar);
            } else if (opción == 4) {
                System.out.println("Ha salido del programa exitosamente");
            } else {
                System.out.println("Opción incorrecta, intente nuevamente");
            }

        } while (opción != 4);
    }

    private static void mostrarDatos(Base[] estudiantes, double sumaNotas1b, double sumaNotas2b) {
        double promedio1b = sumaNotas1b / estudiantes.length;
        double promedio2b = sumaNotas2b / estudiantes.length;

        System.out.println("Promedio del curso primer bimestre: " + promedio1b);
        System.out.println("Promedio del curso segundo bimestre: " + promedio2b);

        for (Base estudianteDatos : estudiantes) {
            estudianteDatos.mostrarDatos();
            double promedioIndividual = estudianteDatos.getNota1() + estudianteDatos.getNota2();

            if (promedioIndividual > 14) {
                System.out.println("Estudiante aprobado");
            } else if (promedioIndividual > 9 && promedioIndividual < 14) {
                System.out.println("Estudiante debe rendir examen supletorio");
            } else {
                System.out.println("Estudiante reprobado");
            }
        }

        double promedioTotal = (promedio1b + promedio2b) / 2;
        System.out.println("Promedio total del curso: " + promedioTotal);
    }

    private static void modificarDatos(Base[] estudiantes, int idModificar) {
        boolean encontrado = false;

        for (Base estudiante : estudiantes) {
            if (estudiante.getId() == idModificar) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Modificando datos del estudiante con ID " + idModificar);
                System.out.print("Nuevo Nombre: ");
                estudiante.setNombre(scanner.next());
                System.out.print("Nueva Materia: ");
                estudiante.setMateria(scanner.next());
                System.out.print("Nueva Nota 1: ");
                estudiante.setNota1(scanner.nextDouble());
                System.out.print("Nueva Nota 2: ");
                estudiante.setNota2(scanner.nextDouble());

                System.out.println("Datos modificados correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún estudiante con el ID proporcionado.");
        }
    }
}



