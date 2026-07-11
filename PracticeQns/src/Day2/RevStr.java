package Day2;


@FunctionalInterface
interface Reverse{
	void rev(String s);
}


public class RevStr {
	public static void main(String[] args) {
		Reverse r=(s)->
			System.out.println(new StringBuilder(s).reverse().toString());
		
		
		r.rev("Sathya");
	}
	
}
