import java.math.BigInteger;

public class ConversorBases {

    public static void convertir(String numero, int baseOrigen) {
        // 0) Verificamos que no sea nulo o vacío
        if (numero == null || numero.trim().isEmpty()) {
            System.out.println("Número vacío");
            return;
        }

        // 1) Normaliza el String (hex en mayúsculas)
        numero = numero.trim().toUpperCase();

        try {
            // 2) Valida e intenta parsear a long (puede lanzar excepción si no cabe)
            long valor = Long.parseLong(numero, baseOrigen);

            // 3) Si entra en long, convertimos a las otras bases
            String binario = Long.toString(valor, 2);
            String decimal = Long.toString(valor, 10);
            String hexadecimal = Long.toString(valor, 16).toUpperCase();

            // 4) Mostrar resultados
            System.out.println("Entrada (" + baseOrigen + "): " + numero);
            System.out.println("Binario    : " + binario);
            System.out.println("Decimal    : " + decimal);
            System.out.println("Hexadecimal: " + hexadecimal);
            System.out.println("Overflow?  : false");
        } catch (NumberFormatException e) {
            // 5) Si falla el parseo, usamos BigInteger
            BigInteger big = new BigInteger(numero, baseOrigen);

            // Convertimos con toString en distintas bases
            String binario = big.toString(2);
            String decimal = big.toString(10);
            String hexadecimal = big.toString(16).toUpperCase();

            // 6) Mostrar resultados
            System.out.println("Entrada (" + baseOrigen + "): " + numero);
            System.out.println("Binario    : " + binario);
            System.out.println("Decimal    : " + decimal);
            System.out.println("Hexadecimal: " + hexadecimal);
            System.out.println("Overflow?  : true");
        }
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        convertir("101101", 2);              // binario -> decimal y hex
        convertir("123456789", 10);          // decimal -> binario y hex
        convertir("7FFFFFFFFFFFFFFF", 16);   // hex grande que desborda long
    }
}
