package Abstraction.RectSquare;

import lombok.Getter;

public abstract class Quadrilatero {
    @Getter
    int base, height;

    abstract public void setBase(int b);

    abstract public void setHeight(int h);

    public int area() {
        return (this.getBase() * this.getHeight());
    }

    public String toString() {
        String s = String.format("Rectangle %d x %d (area=%d)", this.getBase(), this.getHeight(), this.area());
        return (s);
    }
}