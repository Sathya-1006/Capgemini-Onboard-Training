package Day2;


@FunctionalInterface
interface Palin{
	void pal(String s);
}

class Pal implements Palin{
	public void pal(String s) {
		String temp=s.toLowerCase();
		String rev = new StringBuilder(temp).reverse().toString();
		if(rev.equals(temp)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a Palindrome");
		}
	}
}
public class Palindrome {
	public static void main(String[] args) {
	Palin p=new Pal();
	//p.pal("Malayalam");
	//p.pal("Malayal");
	p.pal("wow");
	}
}
