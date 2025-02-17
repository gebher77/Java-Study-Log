package entities;

import entities.enums.Color;

public class Circle extends Shape {
    // Uma classe concreta que estende uma classe abstrata deve implementar todos os métodos abstratos dela.
    // Caso contrário, a própria classe também deve ser declarada como abstrata.

    private Double radius;

    public Circle(Color color) {
        super(color);
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
