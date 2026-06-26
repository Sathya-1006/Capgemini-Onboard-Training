package Day4;

import java.util.Arrays;

public class LinearSearch {
	
	public static void main(String[] args) {
		int arr[]= {10,20,30,34,23,78};
		int target=23;
		search(arr,target);
		binsearch(arr,target);
		
	}
	
	public static void search(int arr[],int t) {
		
		//LinearSearch
		
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == t){
			index=i;
		}
	}
		if(index == -1){
			System.out.println("Target not found");
		
	}
	else {
		System.out.println("Target found at index: "+index);
	}
	
	}
	
	
	public static void binsearch(int[] arr,int t) {
		System.out.println("Binary:Target found at index: "+Arrays.binarySearch(arr,t));
	}
}
