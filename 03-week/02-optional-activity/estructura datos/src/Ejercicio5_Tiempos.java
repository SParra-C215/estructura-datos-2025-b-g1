public class AgregacionTiempos {

    // Función para convertir HH:MM:SS a segundos
    private static int aSegundos(String tiempo) {
        String[] partes = tiempo.split(":"); // separa por ":"
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        int s = Integer.parseInt(partes[2]);
        return h * 3600 + m * 60 + s;
    }

    // Función para volver de segundos a HH:MM:SS
    private static String aHHMMSS(int segundos) {
        int h = segundos / 3600;
        int resto = segundos % 3600;
        int m = resto / 60;
        int s = resto % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void procesar(String[] tiempos) {
        if (tiempos == null || tiempos.length == 0) {
            System.out.println("Lista vacía");
            return;
        }

        // 1) Parseamos cada string a segundos
        int[] segs = new int[tiempos.length];
        for (int i = 0; i < tiempos.length; i++) {
            segs[i] = aSegundos(tiempos[i]);
        }

        // 2) Sumamos el total
        long total = 0;
        for (int t : segs) {
            total += t;
        }

        // 3) Promedio
        double promedio = (double) total / tiempos.length;

        // 4) Buscar el máximo y su índice
        int max = segs[0];
        int indiceMax = 0;
        for (int i = 1; i < segs.length; i++) {
            if (segs[i] > max) {
                max = segs[i];
                indiceMax = i;
            }
        }

        // 5) Convertir resultados a HH:MM:SS
        String totalHHMMSS = aHHMMSS((int) total);
        String promedioHHMMSS = aHHMMSS((int) promedio);
        String maxHHMMSS = aHHMMSS(max);

        // 6) Calcular porcentajes de cada tramo
        System.out.println("Resultados:");
        System.out.println("Tiempo total : " + totalHHMMSS);
        System.out.println("Promedio     : " + promedioHHMMSS);
        System.out.println("Más largo    : " + maxHHMMSS + " (posición " + indiceMax + ")");
        System.out.println("Porcentajes  :");
        for (int i = 0; i < segs.length; i++) {
            double porcentaje = ((double) segs[i] / total) * 100;
            System.out.printf("  Tramo %d (%s): %.2f %%\n", i, tiempos[i], porcentaje);
        }
    }

    public static void main(String[] args) {
        String[] lista = { "00:05:33", "00:12:17", "00:03:50" };
        procesar(lista);
    }
}
