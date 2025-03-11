package JuegoBuscaMinas;
import TableroBuscaMinas.Tablero;
import TableroBuscaMinas.TableroFactory;

import java.util.Scanner;



public class Juego_Busca_Minas {

    public static void main(String[] args) {
        Scanner imprimir = new Scanner(System.in);
        Display display = new Display();
        Tablero tablero = display.mostrarMenuNiveles();
        display.imprimirTablero(tablero);
        boolean minaDestapada = false;
        while (!minaDestapada){
            System.out.print("Dime una fila: ");
            int fila = imprimir.nextInt();
            System.out.println();
            System.out.print("Dime una columna: ");
            int columna = imprimir.nextInt();

            System.out.println("¿Que quieres hacer: \n Destapar (-D-)\uD83D\uDD0D \n Colocar Bandera (-B-)\uD83D\uDEA9");
            char accion = imprimir.next().charAt(0);

            if (accion == 'D' || accion == 'd') {
                tablero.destaparCasilla(fila, columna);
            } else if (accion == 'B' || accion == 'b') {
                tablero.colocarBandera(fila, columna);
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                continue;
            }


            display.imprimirTablero(tablero);
            minaDestapada = tablero.comprobarMinas();
        }

    }
}
