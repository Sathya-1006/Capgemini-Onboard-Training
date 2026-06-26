package Day4;
public class Occurrence {
	public static void main(String[] args) {
		int[] arr= {1,2,5,4,4,4,3,2,1,4};
		int target=4;
		int cnt=0;
		for(int n:arr) {
			if(n==target) {
				cnt++;
			}
		}
		if(cnt>0) {
			System.out.println(target +" occurrs: "+cnt+" times");
		}
		else {
			System.out.println("Element not found!");
		}
		
	}
}
