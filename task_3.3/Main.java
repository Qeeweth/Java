/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        System.out.println(num(7,7));

    }
    public static boolean num(int a, int b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }

    }
}
