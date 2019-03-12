import java.util.Arrays;
import java.util.Random;
public class Partition{
 public static void swap (int [] dayta, int x, int y){
  int old = dayta[x];
  dayta[x] = dayta[y];
  dayta[y] = old;
 }
 public static int partition ( int [] data, int start, int end){
  Random r = new Random();
  int pivot = r.nextInt(end-start+1)+start;
  int old = data[start]; //pivot swaps with start number
  data[start] = data[pivot];
  data[pivot] = old;
  pivot = start; //pivot index is the original start index
  start++;
  while(start!=end){
    if (data[pivot] < data[start]){
      swap(data, start, end);
      end--;
    }
    else{
      pivot++;
      start++;
    }
  }
  if (data[pivot] < data[start]){
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
  public static void main(String[]args){
    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    partition(data1,0,6);
    System.out.println(Arrays.toString(data1));
  }
}
