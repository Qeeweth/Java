/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 1, 7, 4, 9, 8};
        values(array, 0);

    }

    public static void values(int[] arr, int i) {
        if (i < arr.length) {
            System.out.println(arr[i]);
            values(arr, i + 1);
        }
    }
}







