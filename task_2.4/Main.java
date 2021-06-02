/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер вклада: ");
        double deposit = scan.nextDouble();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер процента: ");
        double percent = in.nextDouble();
        int time = 5;
        percent = percent / 100;
        for (int i = 0; i < time; i++) {
            deposit += deposit * percent;
            System.out.println(deposit);




        }

    }
}
