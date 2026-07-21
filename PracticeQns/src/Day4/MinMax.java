package Day4;

import java.util.Arrays;

public class MinMax {
	public static void main(String[] args) {
		int[] arr= {39,45,37,89};
		maxi(arr);
		mini(arr);
		streammax(arr);
		
	}
	public static void maxi(int[] arr) {
		
		int max=arr[0];
		for(int n:arr) {
			if(n>max) {
				max=n;
			}
		}
		System.out.println("Maximum element: "+max);
	}
	
	
public static void mini(int[] arr) {
		
		int min=arr[0];
		for(int n:arr) {
			if(n<min) {
				min=n;
			}
		}
		System.out.println("Minimum element: "+min);
	}

	public static void streammax(int[] arr) {
		System.out.println("Maximum using stream: "+ Arrays.stream(arr).max().getAsInt());
		System.out.println("Minimum using stream: "+ Arrays.stream(arr).min().getAsInt());
	}
}
