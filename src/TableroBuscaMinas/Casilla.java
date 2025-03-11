package TableroBuscaMinas;

public class Casilla {
    protected int fila;
    protected int columna;
    protected boolean mina;
    protected int numeroMinaCerca;
    protected boolean tapada;
    protected boolean bandera;
    protected String numeroMinaCercaConColor;

    public Casilla(int fila, int columna, boolean tapada) {
        this.fila = fila;
        this.columna = columna;
        this.tapada = tapada;
        this.mina = false;
        this.numeroMinaCerca = 0;
        this.bandera = false;
        this.numeroMinaCercaConColor = "";
    }

    public boolean tieneBandera(){
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public boolean estaTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean esMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getNumeroMinaCerca() {
        return numeroMinaCerca;
    }

    public String getNumeroMinaCercaConColor() {
        return numeroMinaCercaConColor;
    }

    public void setNumeroMinaCerca(int numeroMinaCerca) {
        this.numeroMinaCerca = numeroMinaCerca;
        this.numeroMinaCercaConColor = colorNumeros(numeroMinaCerca) + numeroMinaCerca + "\033[0m";
    }
    private static String colorNumeros (int numero){
        switch (numero){
            case 1: return "\033[34m";
            case 2: return "\033[32m";
            case 3: return "\033[31m";
            case 4: return "\033[35m";
            case 5: return "\033[36m";
            case 6: return "\033[33m";
            default: return "\033[37m";
        }
    } /*Negro: \033[30m - Rojo: \033[31m - Verde: \033[32m - Amarillo: \033[33m
    - Azul: \033[34m - Magenta: \033[35m - Cyan: \033[36m - Blanco: \033[37m*/
}
