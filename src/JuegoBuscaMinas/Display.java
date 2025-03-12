package JuegoBuscaMinas;

import TableroBuscaMinas.Casilla;
import TableroBuscaMinas.Tablero;
import TableroBuscaMinas.TableroFactory;
import java.util.Scanner;
public class Display {

    Scanner imprimir = new Scanner(System.in);

    public Tablero mostrarMenuNiveles(){
        System.out.println("Busca Minas: ");
        System.out.println("Selecciona un nivel: ");
        System.out.println("1. Principiante (8x8, 10 minas)");
        System.out.println("2. Intermedio (16x16, 40 minas)");
        System.out.println("3. Experto (16x30, 99 minas)");
        System.out.println("4. Personalizado");

        int opcion = imprimir.nextInt();

        if (opcion == 4){
            return obtenerTableroPersonalizado();
        }else {
            return obtenerTableroPredefinido(opcion);
        }
    }

    private Tablero obtenerTableroPredefinido (int opcion){
        Nivel nivel;

        switch (opcion){
            case 1:
                nivel = Nivel.PRINCIPIANTE;
                break;
            case 2:
                nivel= Nivel.INTERMEDIO;
                break;
            case 3:
                nivel= Nivel.DIFICIL;
                break;

            default:
                System.out.println("Por defecto, se usa el nivel principiante.");
                nivel= Nivel.PRINCIPIANTE;
        }
        return TableroFactory.crearTablero(nivel,0,0,0);

    }

    private Tablero obtenerTableroPersonalizado(){
        Nivel nivel;

        System.out.print("Introduce el numero de filas: ");
        int filas = imprimir.nextInt();

        System.out.print("Introduce el numero de columna: ");
        int columnas = imprimir.nextInt();

        System.out.print("Introduce el numero de minas: ");
        int minas = imprimir.nextInt();

        return TableroFactory.crearTablero(Nivel.PERSONALIZADO,filas,columnas,minas);
    }


    public static void imprimirTablero(Tablero tablero){

        Casilla[][] casillas = tablero.getCasillas();
        for (int i = 0; i < casillas.length; i++) {

            System.out.print("- "+ i + " -");
            for (int j = 0; j < casillas[i].length; j++) {

                if(casillas[i][j].estaTapada()){
                    if(casillas[i][j].tieneBandera()){
                        System.out.print("[ \uD83D\uDEA9]");
                    } else {
                        System.out.print("[ \uD81A\uDCC2 ]");
                    }
                }else{
                    if (casillas[i][j].esMina()){
                        System.out.print( "[\uD83D\uDCA3]" );
                    }else{
                        System.out.print( "[ " + casillas[i][j].getNumeroMinaCercaConColor()+ " ]");
                    }

                }
            }
            System.out.println();
        }
        System.out.print(" - - ");

        for (int j = 0; j < casillas[0].length; j++) {
            System.out.print(" -"+ j + "- ");
        }
        System.out.println();
    }

    public void jugar (Tablero tablero){
        boolean juegoTerminado = false;
        while (!juegoTerminado){
            try{
                System.out.print("Dime una fila: ");
                int fila = imprimir.nextInt();
                System.out.println();
                System.out.print("Dime una columna: ");
                int columna = imprimir.nextInt();

                System.out.println("¿Que quieres hacer: " +
                        "\n Destapar (-D-)\uD83D\uDD0D " +
                        "\n Colocar Bandera (-B-)\uD83D\uDEA9");
                char accion = imprimir.next().charAt(0);

                if (accion == 'D' || accion == 'd') {
                    tablero.destaparCasilla(fila, columna);
                } else if (accion == 'B' || accion == 'b') {
                    tablero.colocarBandera(fila, columna);
                }
            } catch (NumberFormatException e){
                System.out.println("A ocurrido un error: " + e);
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                continue;
            }

            imprimirTablero(tablero);
        }

        System.out.println("Has ganado");
    }


}
