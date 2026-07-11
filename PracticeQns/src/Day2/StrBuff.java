package Day2;


public class StrBuff {
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("Hey Adam");
		
		
		System.out.println("Append: "+ str.append("!"));// inserts at last
		System.out.println("Insert: "+ str.insert(4, " This is Olive.")); //inserts at the said position
		System.out.println("Delete: "+ str.delete(0,4));
		//System.out.println("Delete character: "+ str.deleteChartAt(0));
		System.out.println("CharAt: "+ str.charAt(4));
		System.out.println("Append: "+ str.append("!"));
		System.out.println("Reverse: "+ str.reverse());
		
		
	}

}
