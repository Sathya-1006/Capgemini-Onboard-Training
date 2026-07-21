package Day2;

interface Maximum{
	void maximum(int a,int b);
}

class Calc implements Maximum{
	@Override
	public void maximum(int a,int b) {
		if(a>b) {
			System.out.println("Maximum: "+a);
		}
		else {
			System.out.println("Maximum: "+b);
		}
	}
}

public class Max{
	public static void main(String[] args) {
		Maximum maxi=new Calc();
		maxi.maximum(10,20);
		
	}
}