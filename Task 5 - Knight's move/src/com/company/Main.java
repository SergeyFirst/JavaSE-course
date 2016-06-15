package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int N = 20;

    public static void main(String[] args) {

        //Объявление переменных
        int [][] chessBoard = new int[N][N];
        int currentX = 0;
        int currentY = 0;
        int counter  = 1;

        //Начальная отметка
        chessBoard[currentX][currentY] = counter;

        //Обход поля
        while (!isItFinish(chessBoard)) {

            List<Point> possibleSteps = getPossibleSteps(chessBoard, currentX, currentY);

            //Если возможных шагов нет, а не пройденные клетки остались, то это ошибка
            if (possibleSteps.size() == 0) {
                System.out.println("Не удалось обойти всё поле");
                break;
            }

            Point selectedStep = possibleSteps.get(0);
            int minCountOfPossibleSteps = getPossibleSteps(chessBoard, selectedStep.x,selectedStep.y).size();

            //Обход всех возможных шагов и поиск шага с наименьшим возможным числом переходов
            for (Point step : possibleSteps){
                int countOfPossibleSteps = getPossibleSteps(chessBoard, step.x, step.y).size();
                if (minCountOfPossibleSteps > countOfPossibleSteps) {
                    selectedStep = step;
                    minCountOfPossibleSteps = countOfPossibleSteps;
                }
            }

            //Сделаем выбранный шаг
            currentX = selectedStep.x;
            currentY = selectedStep.y;

            counter++;
            chessBoard[currentX][currentY] = counter;
        }

        //Выведем результат
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

        //Возможные шаги относительно текущего положения
        Point[] allPossibleSteps = {new Point(1,-2), new Point(2,-1),  new Point(2,1),
                                    new Point(1,2),  new Point(-1,2),  new Point(-2,1),
                                    new Point(-2,1), new Point(-2,-1), new Point(-1,-2)};

        //Обход всех возможных шагов и определение в какую клетку ещё можно пойти
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
     * Вспомогательный класс для хранения координат
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
