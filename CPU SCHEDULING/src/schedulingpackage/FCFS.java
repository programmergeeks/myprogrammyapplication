
package schedulingpackage;

/**
 *
 * @author Jann Brizo (BSIT-2A)
 */

import java.util.Scanner;

public class FCFS 
{
    Scanner input = new Scanner(System.in);
    int numberOfProcess,value;
    int waitingTime = 0;
    double averageWaitingTime = 0;
    int totalWaitingTime = 0;
    int[] burstTime;
    
    public void displayInfo()
    {
        System.out.println();
        System.out.println("=====FCFS Scheduling=====");
        System.out.print("# of process: ");
        numberOfProcess = input.nextInt();
        burstTime = new int[numberOfProcess];
         for(int x = 0; x < numberOfProcess; x++)
         {
            System.out.println("Enter the burst time of P" + (x+1));
            value = input.nextInt();
            burstTime[x] = value;
         }
         
         displayingData();
         averageWaitingTime();
         System.out.println("Total Waiting Time " + totalWaitingTime + "\n");
         System.out.println("Average Waiting Time " + averageWaitingTime + "\n");
    }
    public void averageWaitingTime()
    {
         for(int x = 0; x < numberOfProcess - 1; x++)
         {
            waitingTime = waitingTime + burstTime[x];
            totalWaitingTime += waitingTime;
         }
         averageWaitingTime = totalWaitingTime / numberOfProcess;

    }
    public void displayingData()
    {      
        System.out.println("PROCESS \tBURST TIME");
        for(int x = 0; x < numberOfProcess; x++){
            System.out.println((x+1)+ "\t\t" + burstTime[x]);
        }
    }
}
