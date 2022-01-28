import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Formatter; 
import java.util.*;
import java.time.Duration;
import java.time.Instant;



public class parallelSearchTest {
   public static void main(String[] args) throws InterruptedException {

      for (int j = 0; j<2; j++)
      {
         int N = 4_000_000;
         int key = 2_000_000;
         Formatter tabla = new Formatter();
           
         if(j==1)//segunda vuelta clave no existente
         {
            tabla.format("%15s\n", "TABLA KEY NO EXISTENTE");
            key = -1;
         }
         else
         tabla.format("%15s\n", "TABLA KEY EXISTENTE");
          
         tabla.format("%15s %15s %15s %15s %15s %15s\n", "N/R", "1", "2", "4","8", "12");   
   
         for (int i=0; i<4; i++)
         {
            ExecutorService executorService1 = Executors.newCachedThreadPool();
            ExecutorService executorService2 = Executors.newCachedThreadPool();
            ExecutorService executorService4 = Executors.newCachedThreadPool();
            ExecutorService executorService8 = Executors.newCachedThreadPool();
            ExecutorService executorService12 = Executors.newCachedThreadPool();
            
            //arreglos tasks
            ArrayList <SequentialSearch> tasksr1 = new ArrayList <> ();
            
            SortedArray arreglo = new SortedArray(N);
   
            
            //R=1
            SequentialSearch s0 = new SequentialSearch(1,N, key, arreglo);
            
            //R=2
            SequentialSearch s1 = new SequentialSearch(1,N/2, key, arreglo); 
            SequentialSearch s2 = new SequentialSearch(N/2 +1 ,N, key, arreglo);       
            
            
            //R=4
            SequentialSearch s3 = new SequentialSearch(1,N/4, key, arreglo);
            SequentialSearch s4 = new SequentialSearch((N/4) + 1,N/2, key, arreglo);
            SequentialSearch s5 = new SequentialSearch((N/2) + 1,(N/2 + N/4), key, arreglo);
            SequentialSearch s6 = new SequentialSearch((N/2 + N/4) +1 ,N, key, arreglo);
            
            //R=8
            SequentialSearch s7 = new SequentialSearch(1,N/8, key, arreglo);
            SequentialSearch s8 = new SequentialSearch((N/8) +1,N/4, key, arreglo);
            SequentialSearch s9 = new SequentialSearch((N/4) +1,3 *(N/8), key, arreglo);
            SequentialSearch s10 = new SequentialSearch((3 * (N/8) +1), N/2 , key, arreglo);
            SequentialSearch s11 = new SequentialSearch(N/2 + 1,5*(N/8), key, arreglo);
            SequentialSearch s12 = new SequentialSearch(5 *(N/8) +1, 3 * (N/4), key, arreglo);
            SequentialSearch s13 = new SequentialSearch(3 * (N/4) + 1, 7 * (N/8), key, arreglo);
            SequentialSearch s14 = new SequentialSearch(7 * (N/8) + 1,N, key, arreglo);
            
            //R=12
            SequentialSearch s15 = new SequentialSearch(1,N/12, key, arreglo);
            SequentialSearch s16 = new SequentialSearch((N/12) + 1, N/6, key, arreglo);
            SequentialSearch s17 = new SequentialSearch((N/6)+1,N/4, key, arreglo);
            SequentialSearch s18 = new SequentialSearch((N/4) + 1,N/3, key, arreglo);
            SequentialSearch s19 = new SequentialSearch((N/3) + 1 ,5 * (N/12), key, arreglo);
            SequentialSearch s20 = new SequentialSearch((5 * (N/12)) +1 ,N/2, key, arreglo);
            SequentialSearch s21 = new SequentialSearch((N/2) + 1,7*(N/12), key, arreglo);
            SequentialSearch s22 = new SequentialSearch((7 * (N/12)) +1, 2*(N/3), key, arreglo);
            SequentialSearch s23 = new SequentialSearch((2* (N/3)) +1 , 3 *(N/4), key, arreglo);
            SequentialSearch s24 = new SequentialSearch((3 * (N/4)+1),5 *(N/6), key, arreglo);
            SequentialSearch s25 = new SequentialSearch((5 * (N/6)+1),11 * (N/12), key, arreglo);
            SequentialSearch s26 = new SequentialSearch((11 * (N/12)) + 1,N, key, arreglo);
      
      
            //ejecutar en paralelo
            
            //R=1
            long startTime1 = System.currentTimeMillis();
            
            executorService1.execute(s0);
            
            executorService1.shutdown();
            
            executorService1.awaitTermination(1, TimeUnit.MINUTES);
      		long endTime1 = System.currentTimeMillis();
      		long searchTime1 = endTime1 - startTime1;
   
   
            //R=2
            long startTime2 = System.currentTimeMillis();
            
            executorService2.execute(s1);
            executorService2.execute(s2);
            
            executorService2.shutdown();
            
            executorService2.awaitTermination(1, TimeUnit.MINUTES);
      		long endTime2 = System.currentTimeMillis();
      		long searchTime2 = endTime2 - startTime2; 
   
            //R=4
            long startTime4 = System.currentTimeMillis();
            
            executorService4.execute(s3);
            executorService4.execute(s4);
            executorService4.execute(s5);
            executorService4.execute(s6);
            
            executorService4.shutdown();
            
            executorService4.awaitTermination(1, TimeUnit.MINUTES);
      		long endTime4 = System.currentTimeMillis();
      		long searchTime4 = endTime4 - startTime4;
             
            //R=8
            long startTime8 = System.currentTimeMillis();
            
            executorService8.execute(s7);
            executorService8.execute(s8);
            executorService8.execute(s9);
            executorService8.execute(s10);
            executorService8.execute(s11);
            executorService8.execute(s12);
            executorService8.execute(s13);
            executorService8.execute(s14); 
            
            executorService8.shutdown();
            
            executorService8.awaitTermination(1, TimeUnit.MINUTES);
      		long endTime8 = System.currentTimeMillis();
      		long searchTime8 = endTime8 - startTime8;		
                      
            //R=12
            long startTime12 = System.currentTimeMillis();
            
            executorService12.execute(s15);
            executorService12.execute(s16);
            executorService12.execute(s17);
            executorService12.execute(s18);
            executorService12.execute(s19);
            executorService12.execute(s20);
            executorService12.execute(s21);
            executorService12.execute(s22);
            executorService12.execute(s23);
            executorService12.execute(s24);
            executorService12.execute(s25);
            executorService12.execute(s26);    
            
            executorService12.shutdown();
            
            executorService12.awaitTermination(1, TimeUnit.MINUTES);
      		long endTime12 = System.currentTimeMillis();
      		long searchTime12 = endTime12 - startTime12;
            
            tabla.format("%15s %15s %15s %15s %15s %15s\n",N, searchTime1 + "[ms]", searchTime2 + "[ms]",
             searchTime4 + "[ms]", searchTime8 + "[ms]", searchTime12 + "[ms]" );
   
            //aumentar N, key
            N*=5;
            key*=5;       
         }
           
         System.out.print(tabla);  
      }
   }
} 
