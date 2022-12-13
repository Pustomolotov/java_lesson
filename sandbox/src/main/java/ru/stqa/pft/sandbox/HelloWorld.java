package ru.stqa.pft.sandbox;

public class HelloWorld {
	public static void main (String [] args){
		hello("world");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point point = new Point(10, 17, 25, 15);

		System.out.println("Расстояние между точками " + "p1" + "("+point.x1 + ":" + point.y1 + ")" + " и " + "p2" + "(" + point.x2 + ":" + point.y2 + ")" + " =" + point.distance());

	}

	public static void hello(String somebody){
		System.out.println("Hello " + somebody + "!");
	}

}