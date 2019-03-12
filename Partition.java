import java.util.Arrays;
import java.util.Random;
public class Partition{
 public static int partition ( int [] data, int start, int end){
  Random r = new Random();
  int pivot = r.nextInt(end-start+1)+start;
  int old = data[start]; //pivot swaps with start number
  data[start] = data[pivot];
  data[pivot] = old;
  int startOld = start;
  pivot = startOld; //pivot index is the original start index
  start = pivot;
  while (start != end){
    if (data[start] < data[pivot]){
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
  return pivot;
}
  public static void main(String[]args){
    int[] ary = new int[]{0,7,8,9,4};
    partition(ary,0,4);
    System.out.println(Arrays.toString(ary));
  }
}
