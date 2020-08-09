package ru.geekbrains.lesson5;

public abstract class Animals {
    protected final String name;

    protected int maxRunDistance;
    protected float maxJumpDistance;
    protected int maxSwimDistance;

    protected Animals (String name) {
        this.name = name;
    }


    public void run(int distance) {
        if (distance <= this.maxRunDistance) System.out.println(this.name + " пробежал " + distance);
        else System.out.println(this.name + " пробежал только " + this.maxRunDistance + " из " + distance);
        //else System.out.println(maxRunDistance);
    }

    public void jumpOver(float height) {
        if (height <= maxJumpDistance) System.out.println(this.name + " Перепрыгнул");
        else System.out.println(this.name + " Недопгруныл");
    }
}
