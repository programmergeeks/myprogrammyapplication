
package schedulingpackage;

/**
 *
 * @author John Ford Kilat
 */
import java.util.Scanner;

public class SSTFP 
{    
    int numberOfProcess,value;
    Scanner input = new Scanner(System.in);
    int[] bTime, aTime, duplicateBTime, wTime;
    int complete = 0, t = 0, minm = Integer.MAX_VALUE,shortest = 0, finish_time, totalWTime =0; 
    double averageWTime = 0; 
    boolean check = false;
    
    public void displayInfo()
    {
        System.out.println();
        System.out.println("=====SSTF (Preemptive) Scheduling=====");
        System.out.print("# of processes: ");
        numberOfProcess = input.nextInt();
        bTime = new int[numberOfProcess];
        aTime = new int[numberOfProcess];
        wTime = new int[numberOfProcess];
        duplicateBTime = new int[numberOfProcess];
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println("Enter the burst time of P" + (x+1));
            value= input.nextInt();
            bTime[x] = value;
        }
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println("Enter the arrival time of P" + (x+1));
            value = input.nextInt();
            aTime[x] = value;
        }  
        System.arraycopy(bTime, 0, duplicateBTime, 0, numberOfProcess);  
        checkingShortestSeekTimeFirst();
        calculateTotalWaitingTime();
        calculateAverageWaitingTime();
        System.out.println("Total Waiting Time  "+ totalWTime + "\n");
        System.out.println("Average Waiting Time " + averageWTime + "\n");
        
    }
    public void checkingShortestSeekTimeFirst()
    {
         while(complete != numberOfProcess) {
            for(int x = 0; x<numberOfProcess; x++){
                if((aTime[x] <= t) && (duplicateBTime[x] < minm) && duplicateBTime[x] > 0){
                    minm = duplicateBTime[x];
                    shortest = x;
                    check = true;
                }
            }
            if(check == false){
                t++;
                continue;
            }
            duplicateBTime[shortest]--;
            
            minm = duplicateBTime[shortest]; 
            
            if (minm == 0) 
            {
                minm = Integer.MAX_VALUE; 
            }
            
            if(duplicateBTime[shortest] == 0){
                complete++;
                check = false;
                finish_time = t + 1; 
                
                wTime[shortest] = finish_time - bTime[shortest] - aTime[shortest];
                
                if(wTime[shortest] < 0 ){
                    wTime[shortest] = 0;
                }
                
            }
            t++;    
        }
    }
    
    public void calculateTotalWaitingTime()
    {
        for(int x = 0 ; x< numberOfProcess; x++)
        {
            totalWTime += wTime[x];
        }
    }
    public void calculateAverageWaitingTime()
    {         
        averageWTime = totalWTime;
        averageWTime /= numberOfProcess;
        System.out.println("PROCESS \tBURST TIME\t ARRIVAL TIME");
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println((x+1)+ "\t\t" + bTime[x] + "\t\t" + aTime[x]);
        }
    }
    
}
