package TableroBuscaMinas;

import JuegoBuscaMinas.Nivel;

public class TableroFactory {

    public static Tablero crearTablero (Nivel nivel, int numFilasPerso, int numColumnasPerso, int numMinasPerso){
        if ( nivel == Nivel.PERSONALIZADO){
            return new Tablero(numFilasPerso,numColumnasPerso,numMinasPerso);
        }
        return new Tablero(nivel.getFILAS(), nivel.getCOLUMNAS(), nivel.getMINAS());
    }
}
