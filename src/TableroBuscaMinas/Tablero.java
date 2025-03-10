package TableroBuscaMinas;

public class Tablero {
    Casilla[][] casillas;

    int numFilas;
    int numColumnas;
    int numMinas;

    public Tablero(int numFilas, int numColumnas, int numMinas){
        this.numFilas=numFilas;
        this.numColumnas=numColumnas;
        this.numMinas=numMinas;

        iniciarCasillas();
    }

    public void iniciarCasillas(){
        casillas = new Casilla[this.numFilas][this.numColumnas];

        for (int fila = 0; fila < casillas.length; fila++) {
            for (int columna = 0; columna < casillas[fila].length; columna++) {
             casillas[fila][columna]= new Casilla(fila,columna,true);
            }

        }
        generarMinas();
        calcularMinasCerca();
    }

    private void generarMinas(){
        int minasGeneradas = 0;

        while(minasGeneradas != numMinas){
            int filaTemp = (int)(Math.random()* casillas.length);
            int columnaTemp = (int)(Math.random()* casillas[0].length);
            if (!casillas[filaTemp][columnaTemp].esMina()){
                casillas[filaTemp][columnaTemp].setMina(true);
                minasGeneradas++;
            }
        }
    }

    private int contadorDeMinas(int fila, int columna) {
        int[][] direcciones = {
                {-1, -1}, {-1, 0},{-1, 1},
                {0, -1},          {0, 1},
                {1, -1},  {1, 0}, {1, 1}
        };

        int minasAlrededor = 0;

        for (int i = 0; i < direcciones.length; i++) {
            int nuevaFila = fila + direcciones[i][0];
            int nuevaColumna = columna + direcciones[i][1];

            if (nuevaFila >= 0 && nuevaFila < numFilas &&
                    nuevaColumna >= 0 && nuevaColumna < numColumnas &&
                    casillas[nuevaFila][nuevaColumna].esMina()) {
                minasAlrededor++;
            }
        }

        return minasAlrededor;
    }

    private void calcularMinasCerca(){
        for(int fila=0; fila<numFilas; fila++){
            for(int col=0; col<numColumnas; col++){
                if(!casillas[fila][col].esMina()){
                    int contador = contadorDeMinas(fila, col);
                    casillas[fila][col].setNumeroMinaCerca(contador);
                }
            }
        }
    }

    public boolean comprobarMinas(){
        for(int fila=0; fila<numFilas; fila++){
            for(int col=0; col<numColumnas; col++){
                if(casillas[fila][col].esMina() && !casillas[fila][col].estaTapada()){
                    return true;
                }
            }
        }
        return false;
    }

    public void destaparCasilla(int fila, int columna){

        if (!casillas[fila][columna].estaTapada()) {
            return;
        }

        casillas[fila][columna].setTapada(false);

        if(casillas[fila][columna].getNumeroMinaCerca() == 0){
            ceroCercano(fila,columna);
        }
    }

    private void ceroCercano(int fila, int columna) {
        int[][] direcciones = {
                {-1, -1}, {-1, 0},{-1, 1},
                {0, -1},          {0, 1},
                {1, -1},  {1, 0}, {1, 1}
        };

        for (int i = 0; i < direcciones.length; i++) {
            int nuevaFila = fila + direcciones[i][0];
            int nuevaColumna = columna + direcciones[i][1];

            if (nuevaFila >= 0 && nuevaFila < numFilas &&
                    nuevaColumna >= 0 && nuevaColumna < numColumnas) {
                Casilla casillaCercana = casillas[nuevaFila][nuevaColumna];

                if (casillaCercana.estaTapada() && !casillaCercana.esMina()){
                    casillaCercana.setTapada(false);

                    if (casillaCercana.getNumeroMinaCerca() == 0){
                        ceroCercano(nuevaFila,nuevaColumna);
                    }
                }
            }
        }
    }

    public void imprimirTablero(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {

                if(casillas[i][j].estaTapada()){
                    System.out.print("[ ]");
                }else{
                    System.out.print(casillas[i][j].esMina() ? "[*]" : "[" +casillas[i][j].getNumeroMinaCerca() +"]");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Tablero tableroPrueba = new Tablero(6,6,5);

        tableroPrueba.imprimirTablero();
    }
}
