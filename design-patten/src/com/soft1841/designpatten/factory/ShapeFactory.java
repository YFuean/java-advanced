package com.soft1841.designpatten.factory;

public class ShapeFactory {
    public static Shape getCircleInstance(){
        return new Circle();
    }

    public static Shape getRectangleInstance(){
        return new Rectangle();
    }
}
