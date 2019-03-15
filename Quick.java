import java.util.Arrays;
import java.util.Random;
public class Quick{

  public static void swap (int [] dayta, int x, int y){
   int old = dayta[x];
   dayta[x] = dayta[y];
   dayta[y] = old;
  }
  public static int partition ( int [] data, int start, int end){
   if (data.length == 1){
     return start;  //for arrays with size 1
   }
   Random r = new Random();
   int pivot = r.nextInt(end-start+1)+start;   //random num within that range
   //int pivot = quickselect(data, (start+end)/2); //if my partition quickselect worked, this is what I'd have done
   swap(data, start, pivot);
   pivot = start;
   start++;
   while(start!=end){
     /*if (data[pivot] == data[start]){
       if (r.nextInt(2)==1){
          swap(data, start, end);
          //end--;
       }
     }*/
     if (data[pivot] < data[start]){
       swap(data, start, end);   //swaps end with start and removes end
       end--;
     }
     else{
       swap(data, start, pivot);  //swaps start and pivot and removes start
       pivot++;
       start++;
     }
   }
   if (data[pivot] > data[start]){
     swap(data, start, pivot);  //final swap. 
     pivot++;
     start--;
     end--;
   }
   return pivot;
 }

  public static void quicksort(int[] data){
    quicksortH(data,0,data.length-1);
  }
  public static void quicksortH(int[] data, int lo, int hi){
    if (lo>=hi){                            //just like what we did in class
      return;
    }
    int pivot = partition(data,lo,hi);
    quicksortH(data,lo,pivot-1);
    quicksortH(data,pivot+1,hi);
  }
  public static int quickselect(int []data, int k){ 
    /*int piv = partition(data,0,data.length-1);
    while (piv != k){
      if (piv < k){
        piv = partition(data,0,piv);
      }
      else{
        piv = partition(data,piv,data.length-1);
      }
    }
    return data[k];*/
    quicksort(data);
    return data[k];//tried using partition...
  }

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
