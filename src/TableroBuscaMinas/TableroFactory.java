package TableroBuscaMinas;

public class TableroFactory {

    public static Tablero crearTablero (String nivel, int numFilasPerso, int numColumnasPerso, int numMinasPerso){
        switch (nivel.toLowerCase()){
            case "principiante":
                return new Tablero(8,8,10);
            case "intermedio":
                return new Tablero(16,16,40);
            case "experto":
                return new Tablero(16,30,99);
            case "personalizado":
                return new Tablero(numFilasPerso,numColumnasPerso,numMinasPerso);

            default:
                System.out.println("Por defecto, se usa el nivel principiante.");
                return new Tablero(8,8,10);
        }
    }
}
