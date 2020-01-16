import java.util.*;

public class MergeSortingAlgorithm {
	public static void main(String[] args) {
		int[] arr=new int[]{2,4,1,6,8,5,3,7};
		System.out.println(Arrays.toString(arr));
		MergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void MergeSort(int[] a) {
		int n=a.length;
		int mid=n/2;
		if(n<2) {
			return;
		}
		int[] l=new int[mid];
		int[] r=new int[n-mid];
		for(int i=0;i<mid;i++) {
			l[i]=a[i];
		}
		for(int i=mid,j=0;i<n;i++) {
			r[j]=a[i];j+=1;
		}
		
		MergeSort(l);
		MergeSort(r);
		Merge(l,r,a);
	}
	
	public static void Merge(int[] l, int[] r, int[] a) {
		int i=0,j=0,k=0;int count=0;
		while(i<l.length && j<r.length) {
			if(l[i]<=r[j]) {
				a[k]=l[i];
				i+=1;
				//k+=1;
			}else {
				a[k]=r[j];
				j+=1;
				++count;
			}
			k+=1;
		}
		
		while(i<l.length) {
			a[k]=l[i];
			i++;
			k++;
		}
		while(j<r.length) {
			a[k]=r[j];
			k+=1;
			j++;
		}
		
	}
	
}
