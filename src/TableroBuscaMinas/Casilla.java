package TableroBuscaMinas;

public class Casilla {
    protected int fila;
    protected int columna;
    protected boolean mina;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.mina = mina;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isMina() {
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
}
