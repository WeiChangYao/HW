import java.util.Arrays;
import java.util.Random;
public class HW{
 public void partition ( int [] data, int start, int end){
  Random r = new Random();
  int pivot = r.nextInt(end-start)+start;
  int old = data[0]; //pivot swaps with first number
  data[0] = pivot;
  data[pivot] = old;
  pivot = 0;
  //int start = 1; //indexes for start and end
  //int end = data.length-1;
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
}
  public static void main(String[]args){
    int[] ary = new int[5];
    ary = int[4,2,3,1,6]
    partition(ary,0,4);
    System.out.println(ary);
  }
}
