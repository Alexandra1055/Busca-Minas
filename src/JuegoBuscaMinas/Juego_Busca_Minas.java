package JuegoBuscaMinas;
import TableroBuscaMinas.Tablero;
import TableroBuscaMinas.TableroFactory;




public class Juego_Busca_Minas {

    public static void main(String[] args){
        Display display = new Display();
        Tablero tablero = display.mostrarMenuNiveles();
        display.jugar(tablero);

    }
}
