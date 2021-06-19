/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> cities = new ArrayList<>();
        List<String> addresses = new ArrayList<String>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            cities.add(city);
            addresses.add(family);
        }

        String cityIndex = reader.readLine();

        for (int i = 0; i < cities.size(); i++) {
            if (cityIndex.equals(cities.get(i))) {
                System.out.println(addresses.get(i));
            }
        }
    }
}





