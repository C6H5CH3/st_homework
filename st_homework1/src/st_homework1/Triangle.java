package st_homework1;

public class Triangle {
	public String tri(int a, int b, int c){
		int temp;
		if (a > b){
			temp = a;
			a = b;
			b = temp;
		}
		if (b > c){
			temp = c;
			c = b;
			b = temp;
		}
		if (a > b){
			temp = a;
			a = b;
			b = temp;
		}
		if (a + b <= c){
			return "not a triangle";
		}
		if (a == b && b == c){
			return "equilateral";
		}
		else if (a == b || b == c){
			return "isosceles";
		}
		else{
			return "scalene";
		}
	}
}
