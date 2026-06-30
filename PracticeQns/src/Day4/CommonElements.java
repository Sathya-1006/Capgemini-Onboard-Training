package Day4;

import java.util.*;

public class CommonElements {
	public static void main(String[] args) {
		int[] arr1= {1,3,2,4,6,4};
		int[] arr2= {1,2,4,5,6}; //ans: 1,2,4
		
		
		HashSet<Integer> result=new HashSet<>();
		
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i] == arr2[j]) {
					result.add(arr1[i]);
				}
			}
		}
		System.out.println(result);
	}
}
