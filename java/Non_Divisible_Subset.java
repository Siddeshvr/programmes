import java.util.*;

public class Non_Divisible_Subset 
{
    public static void main(String[] args) 
    {
        Scanner jin = new Scanner(System.in);
        int n = jin.nextInt();
        int k = jin.nextInt();
        int [] arr = new int[k];
        for(int i=0;i<n;i++)
            arr[jin.nextInt()%k]++;     //All type of reminders...consider k=4...remainders must be 0,1,2,3...but load how may such will come...
        jin.close();
        
        int result=0;
        if(k%2==0) result++;  // it will not have any conjugate pair
        result=result+Math.min(arr[0],1);//If no number wholly divisible(remainder zero) dont add it to pair else add once
        for(int j=1;j<=k/2;j++) 
            if(j!=k-j) 
                result+=Math.max(arr[j],arr[k-j]);
        System.out.println(result);
     }
}