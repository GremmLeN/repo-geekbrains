package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.Zoo.*;

public class lesson5 {

    public static void main(String[] args) {

        Cat c = new Cat("Murzik");
        Dog d = new Dog("Gavchik");
        Cat c0 = new Cat("Gav");
        Dog d0 = new Dog("Keni");

        Animals[] Animals = {c, d, c0, d0};

        for (int i =0; i < Animals.length; i++) {
            Animals[i].run(200);
            Animals[i].jumpOver(1.5f);
            if(Animals[i] instanceof Dog) {
                Dog dog = (Dog) Animals[i];
                dog.swim(10);
            }
        }
    }
}
