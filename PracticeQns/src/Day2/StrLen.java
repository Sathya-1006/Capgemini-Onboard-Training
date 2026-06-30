package Day2;


interface Length{
	void len(String str);
	
}

//Normal interface

class Find implements Length{
	public void len(String str) {
		System.out.println("Length of the string: "+str.length());
	}
}

public class StrLen {
public static void main(String[] args) {
	Length obj=new Find();
	obj.len("Sathya");
	

}
}


/* Lambda Expression
 * @FunctionalInterface
 * interface Length{
 * 
 *  void len(String s);
 *  
 * }
 * 
 * 
 * public class Main{
 * 
	 * public static void main(String[] args){
	 * 			 
	 * 		Length obj = (s) ->{
	 * 
	 * 		System.out.println(s.length());
	 * 
	 * 		}
	 * obj.len("Sathya");
	 * 
	 * 
	 * }
 * }
 * 
 * 
 * 
 */
