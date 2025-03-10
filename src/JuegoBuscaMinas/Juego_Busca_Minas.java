package JuegoBuscaMinas;
import TableroBuscaMinas.Tablero;

import java.util.Scanner;



public class Juego_Busca_Minas {

    public static void main(String[] args) {
        Scanner imprimir = new Scanner(System.in);
        System.out.println("Busca Minas: ");

        Tablero tablero = new Tablero(5,5,3);
        tablero.imprimirTablero();
        boolean minaDestapada = false;
        while (!minaDestapada){
            System.out.print("Dime una fila: ");
            int fila = imprimir.nextInt();
            System.out.println();
            System.out.print("Dime una columna: ");
            int columna = imprimir.nextInt();

            tablero.destaparCasilla(fila,columna);

            tablero.imprimirTablero();
            minaDestapada = tablero.comprobarMinas();
        }

    }
}
