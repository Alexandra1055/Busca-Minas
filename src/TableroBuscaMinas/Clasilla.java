package TableroBuscaMinas;

public class Clasilla {
    protected int fila;
    protected int columna;
    protected boolean mina;

    public Clasilla(int fila, int columna, boolean mina) {
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
