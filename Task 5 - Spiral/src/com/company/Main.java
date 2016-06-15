package com.company;

public class Main {

    private final static int N = 15;

    public static void main(String[] args) {

        int [][] matrix = new int[N][N];
        int counter = 0;
        int x = -1;
        int y = 0;
        int directionX = 1;
        int directionY = 0;

        while (counter < N * N) {
            counter++;
            x += directionX;
            y += directionY;
            matrix[x][y] = counter;

            if ((x + directionX == N) || (y + directionY == N)
                    ||(x + directionX == -1) || (y + directionY == -1)
                    || (matrix[x + directionX][y + directionY] != 0)) {
                if ((directionX == 1) && (directionY == 0)) {
                    directionX = 0;
                    directionY = 1;
                } else if ((directionX == 0) && (directionY == 1)) {
                    directionX = -1;
                    directionY = 0;
                } else if ((directionX == -1) && (directionY == 0)) {
                    directionX = 0;
                    directionY = -1;
                } else if ((directionX == 0) && (directionY == -1)) {
                    directionX = 1;
                    directionY = 0;
                }
            }

        }

        //Выведем результат
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(String.format("%6d", matrix[i][j]));
            }
            System.out.println("");
        }

    }

}
