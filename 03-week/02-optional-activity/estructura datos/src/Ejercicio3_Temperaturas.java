public class EstadisticasTemperaturas {

    public static void calcularEstadisticas(String datos) {
        // 0) Verificamos que no sea nulo o vacío
        if (datos == null || datos.trim().isEmpty()) {
            System.out.println("No hay datos");
            return;
        }

        // 1) Separa con split(",") y parsea a double
        String[] partes = datos.split(",");
        double[] valores = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            valores[i] = Double.parseDouble(partes[i].trim());
        }

        // 2) Recorre para obtener min, max y sum
        double min = valores[0];
        double max = valores[0];
        double suma = 0.0;
        for (int i = 0; i < valores.length; i++) {
            double v = valores[i];
            if (v < min) min = v;
            if (v > max) max = v;
            suma += v;
        }

        // 3) Promedio = sum / n
        double promedio = suma / valores.length;

        // 4) Varianza y desviación estándar
        // var = promedio de (xi - avg)^2
        double sumaCuadrados = 0.0;
        for (int i = 0; i < valores.length; i++) {
            double dif = valores[i] - promedio;
            sumaCuadrados += dif * dif;
        }
        double varianza = sumaCuadrados / valores.length;
        double desviacion = Math.sqrt(varianza);

        // 5) Mostrar resultados
        System.out.println("Temperaturas: " + datos);
        System.out.println("Mínimo    : " + min);
        System.out.println("Máximo    : " + max);
        System.out.println("Promedio  : " + promedio);
        System.out.println("Desviación: " + desviacion);
    }

    public static void main(String[] arg
