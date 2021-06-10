/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */

public class Main {
    public static void main(String[] args) {
        String[] values = {"Мама","Мыла","Раму"};
        int x = 1;
        int z = 2;
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + values[x] + values[z]);
            x = ++x;
            z = ++z;
            if (x == values.length) {
                x = 0;
            }
            else if (z == values.length) {
                z = 0;
            }
        }
        String[] values2 = {"Мыла", "Мама", "Раму"};
        int h = 1;
        int g = 2;
        for (int i = 0; i < values2.length; i++) {
            System.out.println(values2[i] + values2[h] + values2[g]);
            h = ++h;
            g = ++g;
            if (h == values2.length) {
                h = 0;
            }
            else if (g == values2.length) {
                g = 0;
            }

        }
    }
}
