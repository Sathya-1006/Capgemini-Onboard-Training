package Day2;

interface Sq{
	void sq(int a);
}

class SquareCalc implements Sq{
	public void sq(int a) {
		System.out.println(a*a);
	}
}


public class Square {
	public static void main(String[] args) {
		Sq obj=new SquareCalc();
		obj.sq(5);
	}
}
