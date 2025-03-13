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

        int filas=0;
        int columnas= 0;
        int minas = 0;

        do{
            System.out.print("Introduce el numero de filas (minimo 3, maximo 100): ");
            while (!imprimir.hasNextInt()) {
                System.out.println("Error: No has introducido un numero. \n Por favor introduce un numero valido.");
                imprimir.next();
            }

            filas = imprimir.nextInt();
            if (filas < 3){
                System.out.println("Error: El número de filas debe ser mayor o igual a 3. Inténtalo de nuevo.");
            }
        }while (filas < 3 || filas > 100);

        do{
            System.out.print("Introduce el numero de columnas (minimo 3, maximo 100): ");

            while (!imprimir.hasNextInt()) {
                System.out.println("Error: No has introducido un numero. \n Por favor introduce un numero valido.");
                imprimir.next();
            }
            columnas = imprimir.nextInt();
            if (columnas < 3){
                System.out.println("Error: El número de columnas debe ser mayor o igual a 3. Inténtalo de nuevo.");
            }
        }while (columnas < 3 || columnas > 100);

        int maxMinas = filas * columnas;

        do {
            System.out.print("Introduce el número de minas (debe ser menor a " + maxMinas + "): ");
            minas = imprimir.nextInt();
            if (minas >= maxMinas) {
                System.out.println("Error: El número de minas debe ser menor a " + maxMinas + ". Inténtalo de nuevo.");
            }
        } while (minas >= maxMinas);

        return TableroFactory.crearTablero(Nivel.PERSONALIZADO,filas,columnas,minas);
    }


    public static void imprimirTablero(Tablero tablero){

        Casilla[][] casillas = tablero.getCasillas();
        for (int i = 0; i < casillas.length; i++) {
            if (i <= 9) {
                System.out.print("- " + i + " -");
            }else {
                System.out.print("- " + i + "-");
            }
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
            if (j <= 9) {
                System.out.print("- " + j + " -");
            }else {
                System.out.print("- " + j + "-");
            }
        }
        System.out.println();
    }

    public void jugar (Tablero tablero){
        boolean juegoTerminado = false;
        while (!juegoTerminado){
            try{
                System.out.println();
                imprimirTablero(tablero);
                System.out.println();

                int fila = 0;
                int columna = 0;
                do {
                    System.out.print("Dime una fila (0-" + (tablero.getNumFilas() - 1) + "): ");

                    while (!imprimir.hasNextInt()) {
                        System.out.println("Error: No has introducido un numero. \n Por favor introduce un numero valido de (0-" + (tablero.getNumFilas() - 1) + ")");
                        imprimir.next();
                    }
                    fila = imprimir.nextInt();
                    if (fila < 0 || fila >= tablero.getNumFilas()) {
                        System.out.println("Error: fila debe ser un numero de (0-" + (tablero.getNumFilas() - 1) + ")");
                    }
                }while (fila < 0 || fila >= tablero.getNumFilas());

                System.out.println();

                do {
                    System.out.print("Dime una columna (0-" + (tablero.getNumColumnas() - 1) + "): ");

                    while (!imprimir.hasNextInt()) {
                        System.out.println("Error: No has introducido un numero. \n Por favor introduce un numero valido de (0-" + (tablero.getNumColumnas() - 1) + ")");
                        imprimir.next();
                    }
                    columna = imprimir.nextInt();
                    if (columna < 0 || columna >= tablero.getNumColumnas()) {
                        System.out.println("Error: columna debe ser un numero de (0-" + (tablero.getNumColumnas() - 1) + ")");

                    }
                }while (columna < 0 || columna >= tablero.getNumColumnas());


                char accion;

                do {
                    System.out.println("¿Que quieres hacer: " +
                            "\n Destapar (-D-)\uD83D\uDD0D " +
                            "\n Colocar Bandera (-B-)\uD83D\uDEA9");
                    accion = imprimir.next().toUpperCase().charAt(0);
                    if (accion != 'D' && accion != 'B'){
                        System.out.println("Error: Debes introducir un 'D' para destapar o una 'B' para colocar una bandera");
                    }
                }while (accion != 'D' && accion != 'B');

                if (accion == 'D') {
                    if (tablero.getCasillas()[fila][columna].esMina()){
                        tablero.destaparCasilla(fila, columna);
                        imprimirTablero(tablero);
                        System.out.println("Has perdido  (╥﹏╥)");
                        juegoTerminado = true;
                        break;
                    }
                    tablero.destaparCasilla(fila, columna);
                } else if (accion == 'B') {
                    tablero.colocarBandera(fila, columna);
                }
            } catch (Exception e){
                System.out.println("A ocurrido un error: " + e);
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                continue;
            }


            if (tablero.juegoGanado()){
                System.out.println("Enhorabuena! Has ganado o(˶^▾^˶)o");
                juegoTerminado = true;
            }
        }

    }


}
