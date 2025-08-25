public class ISBN13Validador {

    // Devuelve true si el ISBN cumple la regla del checksum
    public static boolean esValidoISBN13(String isbn) {
        // 1) Verifica longitud 13 y que no sea null
        if (isbn == null || isbn.length() != 13) return false;

        int suma = 0;

        // 2) Recorre cada carácter
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);

            // 3) Debe ser dígito
            if (!Character.isDigit(c)) return false;

            // 4) Convierte char a número restando '0'
            int d = c - '0';

            // 5) Multiplica alternando 1 y 3: en posiciones pares (0,2,4,...) usa 1; en impares usa 3
            int peso = (i % 2 == 0) ? 1 : 3;
            suma += d * peso;
        }

        // 6) El total debe ser múltiplo de 10
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        String prueba = "9780306406157";
        System.out.println("ISBN válido: " + esValidoISBN13(prueba));
    }
}
