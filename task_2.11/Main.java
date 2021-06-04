/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 2, 6, 1, 5, 7, 8, 9};
        int x = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (x < 11) {
                j++;
                x = x + array[i];
            }
        }
        if (x > 10) {
            System.out.println(j);
        } else {
            System.out.println("Сумма чисел массива меньше или равна 10");
        }

    }
}
