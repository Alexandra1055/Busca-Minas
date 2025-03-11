package JuegoBuscaMinas;
import TableroBuscaMinas.Casilla;
import TableroBuscaMinas.Tablero;

public class EstadoJuego {

    public static boolean comprobrarVictoria (Tablero tablero){
        boolean todasDestapadas = true;
        boolean banderasCorrectas = true;

        Casilla[][] casillas = tablero.getCasillas();

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].estaTapada() && !casillas[i][j].esMina()){
                    todasDestapadas = false;
                }
                if (casillas[i][j].tieneBandera() && !casillas[i][j].esMina()){
                    banderasCorrectas = false;
                }
            }
        }
        return todasDestapadas || banderasCorrectas;
    }

    public static boolean comprobarDerrota (Tablero tablero){
        Casilla[][] casillas = tablero.getCasillas();

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (!casillas[i][j].estaTapada() && casillas[i][j].esMina()){
                    return true;
                }
                if (casillas[i][j].tieneBandera() && !casillas[i][j].esMina()){
                    return true;
                }
            }
        }
        return false;
    }

}
