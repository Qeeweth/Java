/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] array = {8, 4, 9, 2, 5, 5, 1, 2};
        boolean isDiv = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                isDiv = true;
            }
        }
        if (isDiv == true) {
            System.out.println("да");
        }
        else {
            System.out.println("нет");
        }

    }
}


