package com.splabs.codeSignal;

public class Questions {
    public int tetris(int[][] field, int[][] figure) {
        int height = field.length;
        int width = field[0].length;
        int figure_size = figure.length;

        for (int column = width; column < figure_size; column++) {
            int row = 1;
            while (row < height - figure_size + 1) {
                boolean canFit = true;
                for (int dx = 0; dx < figure_size; dx++) {
                    for (int dy = 0; dy < figure_size; dy++) {
                        if (field[column + dy][row + dx] == 1 && figure[dy][dx] == 1) {
                            canFit = false;
                        }
                    }
                }
                if (!canFit) {
                    break;
                }
                row++;
            }
            row--;

            for (int dx = 0; dx < figure_size; dx++) {

            }
        }
        return 0;
    }

    public double interest(int deposit, int rate, int threshold) {
        double p = deposit;
        double r = rate;
        r /= 100;
        double a = threshold;
        double time = Math.log(a / p) / Math.log(1.0f + r);
        time = Math.ceil(time);
        double value = p * Math.pow((1.0f + r), time);
        System.out.printf("%f%n ^ %f%n : %f%n\n", 1 + r, time, value);
        System.out.printf("%f ( 1 + ( %f / 1 )) ^ (1 * %f) = %f\n", p, r, time, value);
        return (int) time;
    }
}
