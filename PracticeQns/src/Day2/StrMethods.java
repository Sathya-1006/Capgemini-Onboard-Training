package Day2;




public class StrMethods {
	public static void main(String[] args) {
		//Scanner obj=new Scanner(System.in);
		String str=" Oh my god";
		String s="saplings";
		String s1="sap";
		
		String[] n=str.split(" ");
		
		
		System.out.println("1. CharAt: "+str.charAt(4));
		System.out.println("2. Length: "+str.length());
		System.out.println("3. Concatination: "+str.concat("!!!"));
		System.out.println("4. Replace: "+str.replace("my","oh"));
		System.out.println("5. IndexOf: "+str.indexOf("o"));
		System.out.println("6. Substring: "+str.substring(1,3));
		System.out.println("7. Upper case: "+str.toUpperCase());
		System.out.println("8. Lower case: "+str.toLowerCase());
		System.out.println("9. Trim: "+str.trim());
		System.out.println("10. LastIndex: "+str.lastIndexOf("h"));
		System.out.println("11. IsEmpty?: "+s.isEmpty());
		System.out.println("12. IsEmpty?: "+s.isBlank());
		System.out.println("13. Equals: "+s.equals(s1));
		System.out.println("14. Equals Ignore case: "+s1.equalsIgnoreCase(s));
		System.out.println("15. contains: "+s.contains(s1));
		System.out.println("16. CompareTo: "+s.compareTo(s1));
		System.out.println("17. CompareTo Ignore Case: "+s.compareToIgnoreCase(s1));
		
		System.out.println("18. Split: "+str.split(" "));
		
		System.out.println("19. Join: "+String.join("",n)); // join is a static method and should be called using String object
		
		System.out.println("20. Starts with: "+str.startsWith(" "));
		
		System.out.println("21. Ends with: "+str.endsWith("d"));
		
		System.out.println("22. toCharArray: "+new String(s.toCharArray()));
		
		
	}
}
