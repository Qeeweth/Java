/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите массив чисел: ");
        int arrayQuantity = in.nextInt();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите значения массива: ");
        int[] array = new int[arrayQuantity];
        for (int i = 0; i < arrayQuantity; i++) {
            array[i] = in.nextInt();
        }
        int num = 1;
        int max = 1;
        for (int i = 1; i < arrayQuantity; i++) {
            if (array[i - 1] == array[i]) {
                num++;
            }else if (num > max) {
                max = num;
                num = 1;
            }
        }
        if (num > max) {
            System.out.println(num);
        } else {
            System.out.println(max);
        }


    }
}
