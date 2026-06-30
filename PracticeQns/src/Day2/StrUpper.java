package Day2;

interface Upper{
	String strUp(String s);
}

class Up implements Upper{
	//Using return type
	public String strUp(String s) {
		
		return s.toUpperCase();
	}
}

public class StrUpper {
	public static void main(String[] args) {
		Upper obj=new Up();
		System.out.println(obj.strUp("sathya"));
	}
}
