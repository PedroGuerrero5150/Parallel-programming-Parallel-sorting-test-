import java.time.Duration;
import java.time.Instant;

public class SequentialSearch implements Runnable {
   private final int high;
   private final int low;
   private final int key;
   private final SortedArray array;
   private int foundIndex;
   private boolean found;

   
   // constructor
   public SequentialSearch(int low, int high, int key, SortedArray array) {
      this.low = low;
      this.high = high;
      this.key = key;
      this.array = array;
      found = false;
   }
   
   public void setFoundIndex (int foundIndex){
      this.foundIndex = foundIndex;
   }     
   
   public int getFoundIndex () {
      return foundIndex;
   }

   @Override
   public void run() {                                       
    int index = -1;
    int [] arreglo = array.getArray();
        
    // busqueda lineal
    for (int i = low; i < high; i++) {
      if (arreglo[i] == key) {
        foundIndex = i+1;
        found = true;
        break;
        }
      }
   } 
} 
