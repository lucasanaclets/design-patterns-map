package factory;

import entities.Circle;
import entities.Square;
import entities.Triangle;
import enums.TypeTriangle;
import exceptions.ExceptionInstance;

public class GeometricShapesFactory {

    public static Circle createCircle(int raio) throws ExceptionInstance {
        return Circle.getInstance(raio);
    }

    public static Triangle createIsoscelesTriangle() throws ExceptionInstance {
        return Triangle.getInstance(TypeTriangle.ISOSCELES);
    }

    public static Triangle createEquilateralTriangle() throws ExceptionInstance {
        return Triangle.getInstance(TypeTriangle.EQUILATERO);
    }

    public static Triangle createRectangleTriangle() throws ExceptionInstance {
        return Triangle.getInstance(TypeTriangle.RETANGULO);
    }

    public static Square createSquare(int lado) throws ExceptionInstance {
        return Square.getInstance(lado);
    }
}