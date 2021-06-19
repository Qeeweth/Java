/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(1, 5, 11, 9, 4, 7, -6, -17, 21, 44));
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        for (int i = 0; i < num.size(); i++) {
            if (0 < num.get(i) && 10 > num.get(i)) {
                num2.add(num.get(i));
            }
        }
        System.out.println(num2);
    }
}
