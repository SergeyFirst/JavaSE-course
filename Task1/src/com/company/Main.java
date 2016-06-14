package com.company;

public class Main {

    public static void main(String[] args) {

        int SIZE = 12;

        /*
        ***********
        **       **
        * *     * *
        *  *   *  *
        *   * *   *
        *    *    *
        *   * *   *
        *  *   *  *
        * *     * *
        **       **
        ***********
        */
        System.out.println("(1)");

        for (int i = 0; i <= SIZE; i++){
            for (int j = 0; j <= SIZE; j++){
                if((i == 0) || (i == SIZE) || (j==0) || (j == SIZE) || (i == j) || (i == SIZE - j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        /*
                  *
                 **
                * *
               *  *
              *   *
             *    *
            *     *
           *      *
          *       *
         *        *
        ***********
        */
        System.out.println("(2)");

        for (int i = 0; i <= SIZE; i++){
            for (int j = 0; j <= SIZE; j++){
                if((i == SIZE) || (j == SIZE) || (i == SIZE - j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        /*
             *
            * *
           *   *
          *     *
         *       *
        ***********
        */

        System.out.println("(3)");

        for (int i = 0; i <= SIZE / 2; i++){
            for (int j = 0; j <= SIZE; j++){
                if((i == SIZE / 2) || (SIZE / 2 - i == j) || (i + SIZE / 2 == j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        /*
             *
            * *
           *   *
          *     *
         *       *
        *         *
         *       *
          *     *
           *   *
            * *
             *
        */

        System.out.println("(4)");

        for (int i = 0; i <= SIZE; i++){
            for (int j = 0; j <= SIZE; j++){
                if((SIZE / 2 - i == j) || (i + SIZE / 2 == j) || (i == j + SIZE / 2) || (SIZE * 3 / 2 - i == j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
