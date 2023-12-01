import java.util.Scanner;

public class Ahorcado {
    private static String[] palabras = {"manzana", "elefante", "pelota", "computadora", "libro", "celular", "escopeta", "uva"};
    private String palabraSecreta;
    private char[] palabrAdivinada;
    private int intentos;
    public Ahorcado() {
        palabraSecreta=palabras[(int)(Math.random()*palabras.length)];
        palabrAdivinada=new char[palabraSecreta.length()];
        for(int i=0; i<palabrAdivinada.length; i++) {
            palabrAdivinada[i]='_';
        }
        intentos=7;
    }
    public void juego(){
        Scanner scanner=new Scanner(System.in);
        while(intentos>0 && !haGanado()){
            System.out.println("Palabra: "+new String(palabrAdivinada));
            System.out.println("Intentos restantes: "+intentos);
            System.out.print("Ingresa una letra: ");
            char letra=scanner.next().charAt(0);
            if(adivinarLetra(letra)){
                System.out.println("Correcto, la letra está en la palabra.");
            } else {
                System.out.println("Incorrecto, la letra no está en la palabra.");
                intentos--;
            }
        }
        if(haGanado()){
            System.out.println("Ganaste, la palabra es: "+palabraSecreta);
        } else {
            System.out.println("Perdiste, la palabra era: "+palabraSecreta);
        }
        scanner.close();
    }
    private boolean adivinarLetra(char letra) {
        boolean letraAdivinada=false;
        for (int i=0; i<palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i)==letra) {
                palabrAdivinada[i]=letra;
                letraAdivinada=true;
            }
        }
        return letraAdivinada;
    }
    private boolean haGanado(){
        for(char c: palabrAdivinada) {
            if (c=='_') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Ahorcado juego=new Ahorcado();
        juego.juego();
    }
}
