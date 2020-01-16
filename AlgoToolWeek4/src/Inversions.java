import java.util.*;

public class Inversions {
	
	public static int count=0;

    private static void MergeSort(int[] a) {
        
        int n=a.length;
        int mid=n/2;
        if (n<2) {
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
        //write your code here
        
        
    }
    
    public static void Merge(int[] a, int[] b,int[] r) {
    	int i=0,j=0,k=0;
    	int mid=(a.length+b.length)/2;
    	while(i<a.length && j<b.length) {
    		
    		if(a[i]<=b[j]) {
    			r[k]=a[i];
    			i+=1;
    		}else {
    			r[k]=b[j];
    			j+=1;
    			count+=(mid-i);
    			
    			//++count;
    		}
    		k+=1;
    	}
    	while(i<a.length) {
    		r[k]=a[i];
    		k+=1;
    		i+=1;
    		
    		
    	}
    	while(j<b.length) {
    		r[k]=b[j];
    		k+=1;
    		j+=1;
    		
    		
    	}
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        MergeSort(a);
        System.out.println(count);
    }
}

