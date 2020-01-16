import java.util.*;
import java.io.*;

public class QuickSort {
	
	 
	
	public static void main(String[] args) throws Exception {
		
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//int n=Integer.parseInt(br.readLine().trim());
		//String name=br.readLine();
		//System.out.println(n+" "+name);
		
		int[] arr=new int[] {10,22,0,9,20,5,8,11,29,1};
		
		int l=0;
		int r=9;
		System.out.println("Elements are:");
		System.out.println(Arrays.toString(arr));
		
		quickSort(arr,l,r);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void Print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] a, int start, int end) {
		if(start>=end) {
			return;
		}
	
		int index=Partition(a,start,end);
		quickSort(a,start,index-1);
		quickSort(a, index+1, end);
	
	}
	
	public static int Partition(int[] a, int start, int end) {
		int pivot=a[end];
		int pIndex=start;
		for(int i=start;i<end;i++) {
			if(a[i]<=pivot) {
				int temp=a[i];
				a[i]=a[pIndex];
				a[pIndex]=temp;
				
				pIndex+=1;
			}
		}
		int temp=a[pIndex];
		a[pIndex]=a[end];
		a[end]=temp;
		
		return pIndex;
	}
	
	
	
}
