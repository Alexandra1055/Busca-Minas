package JuegoBuscaMinas;

public enum Nivel {
    PRINCIPIANTE(8,8,10),
    INTERMEDIO(16,16,40),
    DIFICIL(16,30,99),
    PERSONALIZADO(0,0,0);

    private final int FILAS;
    private final int COLUMNAS;
    private final int MINAS;

    Nivel(int filas, int columnas, int minas){
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.MINAS = minas;
    }


    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getMINAS() {
        return MINAS;
    }
}
