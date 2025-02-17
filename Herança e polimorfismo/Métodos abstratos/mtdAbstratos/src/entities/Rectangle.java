package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
    // Uma classe concreta que estende uma classe abstrata deve implementar todos os métodos abstratos dela.
    // Caso contrário, a própria classe também deve ser declarada como abstrata.

    private Double width;
    private Double height;

    public Rectangle() {
        super();
    }

    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    @Override
    public double area() {
        return width * height;
    }
}
