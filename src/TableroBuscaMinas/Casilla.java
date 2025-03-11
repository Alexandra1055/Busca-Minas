package TableroBuscaMinas;

public class Casilla {
    protected int fila;
    protected int columna;
    protected boolean mina;
    protected int numeroMinaCerca;
    protected boolean tapada;
    protected boolean bandera;

    public Casilla(int fila, int columna, boolean tapada) {
        this.fila = fila;
        this.columna = columna;
        this.tapada = tapada;
        this.mina = false;
        this.numeroMinaCerca = 0;
        this.bandera = false;
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

    public void setNumeroMinaCerca(int numeroMinaCerca) {
        this.numeroMinaCerca = numeroMinaCerca;
    }
}
