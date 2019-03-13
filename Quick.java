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

   //int pivot = 3;

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
   /*while (start != end){
     if (data[start] > data[pivot]){
       data[pivot] = old; //swap smaller one with pivot
       int oldTwo = data[start];
       data[start] = old;
       data[pivot] = oldTwo;
       pivot++;
       start++;
     }
     else{
       start++;
     }
   }
   return pivot;*/
   return pivot;
 }
  
  public void quicksort(int[] data){

  }
  public void quicksortH(int[] data, int lo, int hi){

  }

}
