import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrayASize = 50;
        int arrayBSize = 20;

        float[] arrayA = new float[arrayASize];
        float[] arrayB = new float[arrayBSize];

        fillInArray(arrayA, arrayASize);
        showArray(arrayA, arrayASize);
        orderArray(arrayA, arrayASize, arrayB, arrayBSize);

    }
    public static void fillInArray(float[] a, int aS) {
        Random r = new Random();

        for (int i = 0; i < aS; i++) {
            a[i] = r.nextFloat(0, 99);
        }
    }
    public static void showArray(float[] a, int aS) {
        int breaker = 0;

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < aS; i++) {
            if (breaker == 4) {
                if (a[i] >= 0 && a[i] <= 9) {
                    System.out.print(" |  " + df.format(a[i]) + " |");
                } else {
                    System.out.print(" | " + df.format(a[i]) + " |");
                }
                System.out.println("");
                breaker = 0;
            } else {
                if (a[i] >= 0 && a[i] <= 9) {
                    System.out.print(" |  " + df.format(a[i]));
                } else {
                    System.out.print(" | " + df.format(a[i]));
                }

                breaker++;
            }
        }
    }
    public static void orderArray(float [] a, int aS, float[] b, int bS){


        Arrays.sort(a);
        showArray(a, aS);

        for(int i = 0; i < bS; i++){
            b[i] = a[i];
            if (i > 9) {
                b[i] = 0.50F;
            }
        }

        showArray(b, bS);
    }
}