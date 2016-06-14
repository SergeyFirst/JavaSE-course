package com.company;

public class Main {

    public static void main(String[] args) {

        int n = 15;
        int [][] matrix = new int[n][n];
        int counter = 0;
        int x = -1;
        int y = 0;
        int directionX = 1;
        int directionY = 0;

        while (counter < n * n) {
            counter++;
            x += directionX;
            y += directionY;
            matrix[x][y] = counter;

            if ((x + directionX == n) || (y + directionY == n)
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%6d", matrix[i][j]));
            }
            System.out.println("");
        }

    }

}
