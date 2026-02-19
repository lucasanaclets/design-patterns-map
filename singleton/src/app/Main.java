package app;

import exceptions.ExceptionInstance;
import factory.GeometricShapesFactory;

public class Main {
    public static void main(String[] args) throws ExceptionInstance {
        System.out.println(GeometricShapesFactory.createCircle(5));
        System.out.println(GeometricShapesFactory.createSquare(4));
        System.out.println(GeometricShapesFactory.createSquare(3));

        System.out.println(GeometricShapesFactory.createEquilateralTriangle());
        System.out.println(GeometricShapesFactory.createIsoscelesTriangle());
        System.out.println(GeometricShapesFactory.createRectangleTriangle());
    }
}