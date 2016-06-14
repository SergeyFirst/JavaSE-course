package com.company;

public class Printer {

    int Size;

    public Printer(int Size){
        this.Size = Size;
    }

    public void PrintCrossedSquare() {
        int i = -1;
        while (Size > i++){
            int j = -1;
            while (Size > j++){
                if((i == 0) || (i == Size) || (j==0) || (j == Size) || (i == j) || (i == Size - j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

    public void PrintRegularTriangle() {
        int i = -1;
        while (Size > i++) {
            int j = -1;
            while (Size > j++)
                if ((i == Size) || (j == Size) || (i == Size - j)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            System.out.println("");
        }

    }

    public void PrintIsoscelesTriangle() {
        int i = -1;
        while (Size / 2 > i++){
            int j = -1;
            while (Size > j++) {
                if((i == Size / 2) || (Size / 2 - i == j) || (i + Size / 2 == j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

    public void PrintRhombus () {
        int i = -1;
        while (Size > i++){
            int j = -1;
            while (Size > j++){
                if((Size / 2 - i == j) || (i + Size / 2 == j) || (i == j + Size / 2) || (Size * 3 / 2 - i == j)){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
