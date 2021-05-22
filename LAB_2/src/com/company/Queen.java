package com.company;

public class Queen {
    /**
     * размерность доски
     */
    /**
     * хранит растоновку ферзей. каждый ферзь находится на отдельной линии, на
     * одной линии находится не могут так как бъют друг друга.
     */
    private int[] state;
    /**
     * Порядковый номер комбинации
     */
    private int index = 1;

    /*
     * n - размерность доски и количество ферзей
     */
    public Queen(int n) {

        state = new int[n];

        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
    }

    /*
     * генерирует следующую комбинацию(расстоновку фигур)
     */
    public boolean next() {
        index++;
        return move(8 - 1);
    }

    /*
     * Двигает фигуру в указаной линии на одну клетку вправо и возвращает true.
     * Если фигура находится в крайнем положении, то фигура устанавливается в
     * первое положение и двигается фигура находящаяся на линии выше и так далее.
     * Если линий выше не осталось возвращает false.
     */
    private boolean move(int index) {
        if (state[index] < 8 - 1) {
            state[index]++;
            return true;
        }

        state[index] = 0;
        if (index == 0) {
            return false;
        } else {
            return move(index - 1);
        }
    }

    /*
     * Возврашает порядковый номер комбинации, которая в данный момент
     * установлена.
     */
    public int getIndex() {
        return index;
    }
//проверяем бьет ли наша королева другую фигуру если да то возвращаем фолс
    public boolean isPeace() {
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                // бъет ли по вертикали
                if (state[i] == state[j]) {
                    return false;
                }
                // бъет ли по диагонали
                if (Math.abs(i - j) == Math.abs(state[i] - state[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Выводит доску с фигурами.
     */
    public void printState() {
        for (int i = 0; i < state.length; i++) {
            int position = state[i];
            for (int j = 0; j < 8 ; j++) {
                System.out.print(j == position ? 'X' : '_');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen c = new Queen(8);
        int counter = 0;
        do {
            if (c.isPeace()) {
                counter ++;
                c.printState();
                System.out.println("----------------------");
            }
        } while (c.next());

        System.out.println("Итого: " + counter);
    }
}