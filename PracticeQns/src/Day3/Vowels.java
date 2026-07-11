package Day3;

/*ASCII Value
 * 
 * Digits [0-9]  -> 0 => 48, 9 => 57
 * small a => 97, z=>122
 * Capital A=> 65, Z=> 90
 * Special character between 32 & 126
 * 
 */

public class Vowels {
	public static void main(String[] args) {
		StringBuilder str=new StringBuilder("Hypothesis89".toLowerCase());
		
		int vowcnt=0;
		int conscnt=0;
		int digcnt=0;
		int splcnt=0;
		
		for(int i=0;i<str.length();i++) {
			char ch= str.charAt(i);
			
			//vowels check
			if(ch >= 97 && ch<=122) {
				if(ch == 'a' || ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u') {
					vowcnt++;
				}
				else {
					conscnt++;
				}
			}
			
			//digits check
			else if(ch>=48 && ch<=57) {
				digcnt++;
			}
			
			//Special char cnt
			else {
				splcnt++;
			}
			
		}
		System.out.println("Vowel count: "+vowcnt);
		System.out.println("Consonants count: "+conscnt);
		System.out.println("Digits count: "+digcnt);
		System.out.println("Special char count: "+splcnt);
		
		
	}
}
