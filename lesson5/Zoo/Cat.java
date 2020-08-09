package ru.geekbrains.lesson5.Zoo;

import ru.geekbrains.lesson5.Animals;

public class Cat extends Animals {

    public Cat (String name) {
        super(name);
        this.maxRunDistance = runDistance();
        this.maxJumpDistance = jumpDistance();
    }

    private int runDistance() {
        int a = 10;
        int b = 200;
        this.maxRunDistance = (int)(Math.random() * (b - a) + a);
        return this.maxRunDistance;
    }

    private float jumpDistance() {
        int a = 1;
        int b = 4;
        this.maxJumpDistance = (float) (Math.random() * (b - a) + a);
        return this.maxJumpDistance;
    }
}
