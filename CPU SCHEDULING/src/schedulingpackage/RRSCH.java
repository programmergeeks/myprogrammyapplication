
package schedulingpackage;

/**
 *
 * @author James Alwin Aljecera
 */
import java.util.Scanner;

public class RRSCH 
{
    int i,j,k,q,sum=0,n;
    int[]bt,wt,a; 
    Scanner input = new Scanner(System.in);
    public void userInputs()
    {      
        System.out.println();
        System.out.println("=====Round Robin Scheduling=====");
        System.out.print("# of process: ");
        n = input.nextInt();
        bt = new int[n];
        wt = new int[n];
        a = new int[n];
        for(i=0;i<n;i++)
        {
            System.out.println("Enter burst time for P"+(i+1));
            bt[i]= input.nextInt();
        }
        System.out.println("Enter time quantum:");
        q = input.nextInt();       
    }
    public void calculationForRoundRobin()
    {
        for(i=0;i<n;i++)
        {
            a[i]=bt[i];
        }
        for(i=0;i<n;i++)
        {
            wt[i]=0;
        }
        
        do
        {
            for(i=0;i<n;i++)
            {
                if(bt[i]>q)
                {
                    bt[i]-=q;
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(bt[j]!=0))
                        wt[j]+=q;
                    }   
                }
                else
                {
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(bt[j]!=0))
                        wt[j]+=bt[i];
                    }
                    bt[i]=0;
                }
            }
            sum=0;
            for(k=0;k<n;k++)
            sum=sum+bt[k];
        }
        while(sum!=0);
    }
    public void displayInfo()
    {
        userInputs();
        calculationForRoundRobin();
        System.out.println("Process\t\tBT\tWT");
        for(i=0;i<n;i++)
        {
            System.out.println("P"+(i+1)+"\t\t"+a[i]+"\t"+wt[i]+"\n");
        }
        float avg_wt=0;
        for(j=0;j<n;j++)
        {
            avg_wt+=wt[j];
        }
        System.out.println("Total Waiting Time: "+avg_wt);
        System.out.println("Average Waiting Time: "+(avg_wt/n));
    }
}
