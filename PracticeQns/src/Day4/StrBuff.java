package Day4;

public class StrBuff {
public static void main(String[] args) {
	StringBuffer sb=new StringBuffer("HHHHHHHHHHHHHHHHHH"); // when this 16 bit of capacity is completely occupied, then it allocates memory according to the formula
	System.out.println(sb.length());//5
	System.out.println(sb.capacity());// default capacity 16 + 5 (Hello)
	System.out.println(sb.append("w"));
	System.out.println(sb.capacity()); //(16*2)+2
}
}
