public class RLE {


    public static String comprimirRLE(String s) {
        //   cadena vacía
        if (s == null || s.length() == 0) return "";

        StringBuilder out = new StringBuilder(); // para construir el resultado
        int contador = 1;                        // cuántas veces seguidas va el mismo char

        // empezamos desde el segundo carácter comparando con el anterior
        for (int i = 1; i < s.length(); i++) {
            char anterior = s.charAt(i - 1);
            char actual   = s.charAt(i);

            if (actual == anterior) {
                // sigue 
                contador++;
            } else {
                // se cortó la racha: escribimos el bloque y reiniciamos
                out.append(anterior);
                out.append(contador);
                contador = 1;
            }
        }

        // Al final falta escribir el último bloque
        out.append(s.charAt(s.length() - 1));
        out.append(contador);

        return out.toString();
    }

    // Ratio = longitud_comprimida / longitud_original (como double)
    public static double ratioCompresion(String s) {
        if (s == null || s.length() == 0) return 1.0; // evitamos división por cero
        String comprimido = comprimirRLE(s);
        return (double) comprimido.length() / s.length();
    }

    // Pruebas simples
    public static void main(String[] args) {
        String[] pruebas = {
            "aaabbccccd",
            "AaaBBBccDD", // respeta mayúsculas y minúsculas tal cual
            "abc",
            "",
            "xxxxxxxxxx"
        };

        for (String p : pruebas) {
            String c = comprimirRLE(p);
            double r = ratioCompresion(p);
            System.out.println("Original   : \"" + p + "\"");
            System.out.println("Comprimido : \"" + c + "\"");
            System.out.println("Ratio      : " + r);
            System.out.println("----");
        }
    }
}
