import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    // Constantes
    public static final double DISTANCIA_VRB_X_RIO = 322;
    public static final double DISTANCIA_VRB_X_BH = 269;
    public static final double PRECO_ALCOOL = 4.06; // R$/litro
    public static final Locale LOCALE_BR = new Locale("pt", "BR");

    // Formatos reutilizáveis
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(LOCALE_BR);
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(LOCALE_BR);

    public static void main(String[] args) {
        double consumoKmPorLitro = 10;

        exibirResumoViagem("VRB_X_RIO", DISTANCIA_VRB_X_RIO, consumoKmPorLitro);
        System.out.println("=====================================");
        exibirResumoViagem("VRB_X_BH", DISTANCIA_VRB_X_BH, consumoKmPorLitro);
    }

    private static void exibirResumoViagem(String local, double distancia, double consumoKmPorLitro) {
        System.out.println("Local: " + local);
        System.out.println("Litros de Alcool necessario: " + formatarLitrosNecessarios(distancia, consumoKmPorLitro));
        System.out.println("Gasto em reais: " + calcularGasto(distancia, consumoKmPorLitro));
    }

    private static double calcularLitrosNecessarios(double distancia, double consumoKmPorLitro) {
        return distancia / consumoKmPorLitro;
    }

    private static String formatarLitrosNecessarios(double distancia, double consumoKmPorLitro) {
        double litros = calcularLitrosNecessarios(distancia, consumoKmPorLitro);
        return NUMBER_FORMAT.format(litros);
    }

    private static String calcularGasto(double distancia, double consumoKmPorLitro) {
        double gasto = calcularLitrosNecessarios(distancia, consumoKmPorLitro) * PRECO_ALCOOL;
        return CURRENCY_FORMAT.format(gasto);
    }
}
