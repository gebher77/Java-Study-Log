package entities;

import entities.enums.Color;

public abstract class Shape {

    private Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Declaração método abstrato
    //Quando uma classe tem um método abstrato, a classe também tem que se tornar abstrata
    public abstract double area();

}
