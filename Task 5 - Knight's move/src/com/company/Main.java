package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //���������� ����������
        int n = 20;
        int [][] chessBoard = new int[n][n];

        int currentX = 0;
        int currentY = 0;
        int counter  = 1;

        //��������� �������
        chessBoard[currentX][currentY] = counter;

        //����� ����
        while (!isItFinish(chessBoard)) {

            List<Point> possibleSteps = getPossibleSteps(chessBoard, currentX, currentY);

            //���� ��������� ����� ���, � �� ���������� ������ ��������, �� ��� ������
            if (possibleSteps.size() == 0) {
                System.out.println("�� ������� ������ �� ����");
                break;
            }

            Point selectedStep = possibleSteps.get(0);
            int minCountOfPossibleSteps = getPossibleSteps(chessBoard, selectedStep.x,selectedStep.y).size();

            //����� ���� ��������� ����� � ����� ���� � ���������� ��������� ������ ���������
            for (Point step : possibleSteps){
                int countOfPossibleSteps = getPossibleSteps(chessBoard, step.x, step.y).size();
                if (minCountOfPossibleSteps > countOfPossibleSteps) {
                    selectedStep = step;
                    minCountOfPossibleSteps = countOfPossibleSteps;
                }
            }

            //������� ��������� ���
            currentX = selectedStep.x;
            currentY = selectedStep.y;

            counter++;
            chessBoard[currentX][currentY] = counter;
        }

        //������� ���������
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(String.format("%6d", chessBoard[i][j]));
            }
            System.out.println("");
        }

    }

    public static boolean isItFinish(int [][] chessBoard){
        boolean result = true;
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                result = (chessBoard[i][j] == 0) ? false : result;
            }
        }
        return result;
    }

    public static List<Point> getPossibleSteps(int [][] chessBoard, int currentX, int currentY) {

        List<Point> result = new ArrayList();

        //��������� ���� ������������ �������� ���������
        Point[] allPossibleSteps = {new Point(1,-2), new Point(2,-1),  new Point(2,1),
                                    new Point(1,2),  new Point(-1,2),  new Point(-2,1),
                                    new Point(-2,1), new Point(-2,-1), new Point(-1,-2)};

        //����� ���� ��������� ����� � ����������� � ����� ������ ��� ����� �����
        for (Point step : allPossibleSteps) {
            if ((currentX + step.x >= chessBoard.length)
                    || (currentX + step.x < 0)
                    || (currentY + step.y >= chessBoard[0].length)
                    || (currentY + step.y < 0)
                    || (chessBoard[currentX + step.x][currentY + step.y] != 0)) {
                continue;
            } else {
                result.add(new Point(currentX + step.x, currentY + step.y));
            }
        }
        return result;
    }

    /**
     * ��������������� ����� ��� �������� ���������
     */
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
