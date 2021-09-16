import java.util.Random;
import java.util.stream.IntStream;

public class BestLabaInTheWorld1 {
    public static short[] CreatingFirstMass() {
        short[] a = new short[20];

        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = (short) (i + 1);
        }
        return a;

    }

    public static float[] CreatingSecondMass(float min, float max) {

        Random rand = new Random();

        float[] x = new float[20];

        for (int i = 0; i < x.length; i++) {
            x[i] = min + rand.nextFloat() * (max + 10);

        }
        return x;
    }

    public static double[][] CreatingThirdMass(short[] a, float[] x) {
        double table[][] = new double[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (a[i] == 3) {
                    table[i][j] = TerribleFormula1(x[j]);
                } else if (ChechIfNumInList(a[i])) {
                    table[i][j] = TerribleFormula2(x[j]);
                } else {
                    table[i][j] = TerribleFormula3(x[j]);
                }
            }
        }
        return table;
    }

    public static double TerribleFormula1(float x) {

        double value = Math.PI * Math.pow((Math.pow(((x + (1.0 / 3)) / x), x)) / ((Math.pow(x / 2, 3)) - 4), 2);
        return value;

    }

    public static double TerribleFormula2(float x) {
        double value = Math.tan(Math.tan(1 - x));
        return value;
    }

    public static double TerribleFormula3(float x) {
        double value = Math.pow(Math.pow(Math.exp(Math.asin((x - 2) / 16)), 2 * Math.pow(Math.tan(x), 1.0 / 3)), 1.0 / 3);
        return value;
    }

    public static boolean ChechIfNumInList(int x) {
        int[] n = {4, 8, 9, 10, 12, 14, 15, 16, 17, 19};
        return IntStream.of(n).anyMatch(a -> a == x);
    }

    public static void main(String[] args) {
        float min = -10;
        float max = 6;


        short[] a = CreatingFirstMass();
        float[] x = CreatingSecondMass(min, max);
        double[][] table = CreatingThirdMass(a, x);

        for (double[] i : table) {
            for (double j : i) {
                if (j > 0) {
                    System.out.printf(" %.5f ", j);
                } else if (j < 0) {
                    System.out.printf("%.5f ", j);
                } else {
                    System.out.print(j + "     ");
                }

            }
            System.out.println();
        }
    }

}
