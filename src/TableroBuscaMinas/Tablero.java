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
             casillas[fila][columna]= new Casilla(fila,columna);
            }

        }
        generarMinas();
    }

    private void generarMinas(){
        int minasGeneradas = 0;

        while(minasGeneradas != numMinas){
            int filaTemp = (int)(Math.random()* casillas.length);
            int columnaTemp = (int)(Math.random()* casillas[0].length);
            if (!casillas[filaTemp][columnaTemp].isMina()){
                casillas[filaTemp][columnaTemp].setMina(true);
                minasGeneradas++;
            }
        }
    }

    private void imprimirTablero(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].isMina() ? "*" : "0");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Tablero tableroPrueba = new Tablero(5,5,7);

        tableroPrueba.imprimirTablero();
    }
}
