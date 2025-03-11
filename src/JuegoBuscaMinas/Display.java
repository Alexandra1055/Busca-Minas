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
        String nivel="";

        switch (opcion){
            case 1:
                nivel = "principiante";
                break;
            case 2:
                nivel= "intermedio";
            case 3:
                nivel= "experto";

            default:
                System.out.println("Por defecto, se usa el nivel principiante.");
                nivel= "principiante";
        }
        return TableroFactory.crearTablero(nivel,0,0,0);

    }

    private Tablero obtenerTableroPersonalizado(){

        System.out.print("Introduce el numero de filas: ");
        int filas = imprimir.nextInt();

        System.out.print("Introduce el numero de columna: ");
        int columnas = imprimir.nextInt();

        System.out.print("Introduce el numero de minas: ");
        int minas = imprimir.nextInt();

        return TableroFactory.crearTablero("personalizado",filas,columnas,minas);
    }


    public static void imprimirTablero(Tablero tablero){

        Casilla[][] casillas = tablero.getCasillas();
        for (int i = 0; i < casillas.length; i++) {
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
            System.out.println("");
        }
    }



}
