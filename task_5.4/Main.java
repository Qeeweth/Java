
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new InputStreamReader((new FileInputStream(fileName))));
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (reader.ready()) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0) {
                numbers.add(num);
            }
        }
        reader.close();
        Collections.sort(numbers);

        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
