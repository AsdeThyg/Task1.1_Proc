import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            float triangleSideA = getTriangleSide("A");
            float triangleSideB = getTriangleSide("B");
            float triangleSideC = getTriangleSide("C");

            float triangleArea = getTriangleArea(triangleSideA, triangleSideB, triangleSideC);

            System.out.println("Длина высоты к стороне A: " + getTriangleHeight(triangleSideA, triangleArea));
            System.out.println("Длина высоты к стороне B: " + getTriangleHeight(triangleSideB, triangleArea));
            System.out.println("Длина высоты к стороне C: " + getTriangleHeight(triangleSideC, triangleArea));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static float getTriangleSide(String triangleSideName) {
        System.out.println("Длина стороны " + triangleSideName + " треугольника:");
        float triangleSideLength = new Scanner(System.in).nextFloat();
        if (triangleSideLength<=0)
            throw new IllegalArgumentException("Длины сторон треугольника должны быть больше нуля");
        return triangleSideLength;
    }

    private static float getTriangleArea(float sideA, float sideB, float sideC){
        if ((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA))
            throw new IllegalArgumentException("Треугольник с заданными сторонами не существует");
        float semiPerimeter = (sideA + sideB + sideC)/2;
        return (float) Math.sqrt(semiPerimeter*(semiPerimeter-sideA)*(semiPerimeter-sideB)*(semiPerimeter-sideC));
    }

    private static float getTriangleHeight(float baseTriangleSide, float triangleArea){
        return (2 / baseTriangleSide) * triangleArea;
    }

}