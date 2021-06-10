/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 6;
        cat1.weight = 4;
        cat1.strength = 8;

        Cat cat2 = new Cat();
        cat2.age = 7;
        cat2.weight = 5;
        cat2.strength = 9;

        System.out.println(cat2.fight(cat1));
        if (cat2.fight(cat1) == cat1.fight(cat2)) {
            System.out.println("Ничья");
        }
        if (cat2.fight(cat1)) {
            System.out.println("Победил cat2");
        }
        if (cat1.fight(cat2)) {
            System.out.println("Победил cat2");
        }
    }
}
    class Cat {
        public int age;
        public int weight;
        public int strength;

        public Cat() {

        }

        public boolean fight(Cat anotherCat) {
            int cat1 = 0;
            int cat2 = 0;
            if (this.age > anotherCat.age) {
                cat2++;
            } else {
                cat1++;
            }
            if (this.weight > anotherCat.weight) {
                cat2++;
            } else {
                cat1++;
            }
            if (this.strength > anotherCat.strength) {
                cat2++;
            } else {
                cat1++;
            }
            return cat2 > cat1;
        }
    }
