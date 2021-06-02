/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        int[] array = {2,3,4,5};
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum *= array[i];



        }
        System.out.println(sum);
    }
}
