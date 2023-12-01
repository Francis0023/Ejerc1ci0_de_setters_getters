import java.sql.SQLOutput;

public class Base {
    public String nombre;
    public String materia;
    public double nota1, nota2;
    public int id;

    public Base(String nombre, String materia, double nota1, double nota2, int id) {
        this.nombre = nombre;
        this.materia = materia;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void mostrarDatos(){
        System.out.println("ID: "+getId()+"   Nombre: "+getNombre()+"   Materia: "+getMateria()+"   Nota 1: "+getNota1()+"    Nota 2: "+getNota2());
    }

}
