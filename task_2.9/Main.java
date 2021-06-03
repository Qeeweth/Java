/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] array = {9,7,5,3,2};
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                x++;
            }
        }
        if (x == 0) {
            System.out.println("нет");
        }
        else {
            System.out.println("да");
        }
    }
}
