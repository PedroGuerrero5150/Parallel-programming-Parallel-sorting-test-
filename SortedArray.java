import java.util.*;

public class SortedArray {

   private final int[] array; 
      
   // construct a SimpleArray of a given size
   public SortedArray(int size) {
      array = new int[size];
      
      for (int i=0; i<size; i++)
      array [i] = i+1;
      
   } 
   
     
   public int[] getArray ()
   {return array;}
   
   public void modifyArray(int position, int val)
   {array [position] = val;}

   
   @Override
   public synchronized String toString() {
      return Arrays.toString(array);
   } 
}

