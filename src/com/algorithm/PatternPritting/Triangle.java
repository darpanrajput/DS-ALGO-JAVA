package com.algorithm.PatternPritting;

public class Triangle {
    public static void main(String[] args) {
//        Triangle();
//        rightAngleTriangle();
        rightAngleMirrorTriangle();
    }

    public static void Triangle(){
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5-i-1; j++) {
                System.out.print(" ");
            }

            for (int K = 0; K < i + 1; K++) {
                System.out.print("_*_");
            }

            System.out.println("\n");
        }
    }
    public static void rightAngleTriangle(){
        for (int i = 0; i < 5; i++) {
            for (int K = 0; K < i + 1; K++) {
                System.out.print("_*_");
            }
            for (int j = 0; j < 5-i-1; j++) {
                System.out.print(" ");
            }



            System.out.println("\n");
        }
    }

    public static void rightAngleMirrorTriangle(){
        for (int i = 0; i <=5; i++) {

            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }
            for (int K = 5; K >= i + 1; K--) {
                System.out.print(" * ");
            }



            System.out.println("\n");
        }
    }
}
