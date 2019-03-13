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
     return start;
   }
   Random r = new Random();
   int pivot = r.nextInt(end-start+1)+start;
   swap(data, start, pivot);
   pivot = start;
   start++;
   while(start!=end){
     if (data[pivot] < data[start]){
       swap(data, start, end);
       end--;
     }
     else{
       swap(data, start, pivot);
       pivot++;
       start++;
     }
   }
   if (data[pivot] > data[start]){
     swap(data, start, pivot);
     pivot++;
     start--;
     end--;
   }
   return pivot;
 }

  public void quicksort(int[] data){
    return quciksortH(data,0,data.length);
  }
  public void quicksortH(int[] data, int lo, int hi){
    if (lo>=hi){
      return;
    }
    int pivot = partition(data,lo,hi);
    quicksortH(data,lo,pivot-1);
    quicksortH(data,pivot+1,hi);
  }

}
