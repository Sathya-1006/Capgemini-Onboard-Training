package Day2;

interface Check{
	void EvenOrOdd(int a);
}

class Calci implements Check{
	public void EvenOrOdd(int a) {
		System.out.println((a%2==0? "Even":"Odd"));
	}
}

public class EvenOdd{
	public static void main(String[] args) {
		Check check=new Calci();
		check.EvenOrOdd(19);
	}
}

