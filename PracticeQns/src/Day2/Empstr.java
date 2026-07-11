package Day2;

@FunctionalInterface
interface Empty{
	void Emp(String str);
	
}

public class Empstr{
	public static void main(String[] args) {
		
		Empty obj = (str) -> {
			
			System.out.println(str.isEmpty());
		};
		obj.Emp("sathya");
	}
}
