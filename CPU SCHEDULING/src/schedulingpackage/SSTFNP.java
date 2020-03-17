
package schedulingpackage;

/**
 *
 * @author John Ford Kilat
 */
import java.util.Scanner;
import java.util.Arrays;

public class SSTFNP 
{
    Scanner input = new Scanner(System.in);
    int numberOfProcess;
    int[] bTime;
    int[] sortedBTime;
    int value,wTime=0;
    double averageWTime = 0;
    int totalWTime = 0;
    
    public void displayInfo()
    {
        System.out.println();
        System.out.println("=====SSTF (Non Preemptive) Scheduling=====");
        System.out.print("# of process: ");
        numberOfProcess = input.nextInt();
        bTime = new int[numberOfProcess];
        sortedBTime = new int[numberOfProcess];
        
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println("Enter the burst time of P" + (x+1));
            value = input.nextInt();
            bTime[x] = value;
        }
        
        sortingBurstTime();
        totalWaitingTime();
        averageWaitingTime();
        System.out.println("Total Waiting Time " + totalWTime + "\n");
        System.out.println("Average Waiting Time " + averageWTime + "\n");
    }
    public void sortingBurstTime()
    {
        System.arraycopy(bTime, 0, sortedBTime, 0, numberOfProcess);
        Arrays.sort(sortedBTime);
    }
    
    public void totalWaitingTime()
    {
        for(int x = 0; x < numberOfProcess - 1; x++)
        {
            wTime = wTime + sortedBTime[x];
            totalWTime += wTime;
        }
    }
    
    public void averageWaitingTime()
    {
        averageWTime = totalWTime / numberOfProcess;
        System.out.println("PROCESS \tBURST TIME");
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println((x+1)+ "\t\t" + bTime[x]);
        }
    }
    
}
