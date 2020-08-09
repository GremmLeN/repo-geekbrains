package ru.geekbrains.lesson5.Zoo;

import ru.geekbrains.lesson5.Animals;

public class Dog extends Animals {

    public Dog (String name) {
        super(name);
        this.maxRunDistance = runDistance();
        this.maxJumpDistance = jumpDistance();
        this.maxSwimDistance = swimdistance();
    }

    public final void swim(int distance) {
        if (distance <= maxSwimDistance) System.out.println(this.name + " проплыл " + distance);
        else System.out.println(this.name + " не поплыл, долековато...");
    }

    private int runDistance() {
        int a = 100;
        int b = 1000;
        this.maxRunDistance = (int)(Math.random() * (b - a) + a);
        return this.maxRunDistance;
    }

    private float jumpDistance() {
        int a = 1;
        int b = 5;
        this.maxJumpDistance = (float) (Math.round((Math.random() * (b - a) + a) * 100.0) / 100.0);
        return this.maxJumpDistance;
    }

    private int swimdistance() {
        int a = 1;
        int b = 20;
        this.maxSwimDistance = (int)(Math.random() * (b - a) + a);
        return this.maxSwimDistance;
    }
}
