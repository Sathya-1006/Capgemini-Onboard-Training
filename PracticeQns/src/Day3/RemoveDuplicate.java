package Day3;


import java.util.*;



public class RemoveDuplicate {
	public static void main(String[] args) {
		String s="London";
		StringBuilder remove= new StringBuilder();
		
		HashSet<Character> seen = new HashSet<>();
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!seen.contains(ch)) {
				seen.add(ch);
				remove.append(ch);
			}
			
		}
		System.out.println(seen);
		System.out.println(remove);
	}
}
