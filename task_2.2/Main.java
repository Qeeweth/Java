/*Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
... */
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        while (a <= 10) {
            System.out.print(a + " ");
            while (b <= 9) {
                b++;
                System.out.print(a * b + " ");
            }
            a++;
            b = 1;
            System.out.println("");
        }

            }
        }



