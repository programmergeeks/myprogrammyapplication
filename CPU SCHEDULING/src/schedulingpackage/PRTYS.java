
package schedulingpackage;

/**
 *
 * @author Gherome Bañados
 */
import java.util.Scanner;


public class PRTYS 
{
    Scanner input = new Scanner(System.in);
    int x,n,p[],pp[],bt[],w[],t[],awt=0,atat,i;
    
   //n is number of process
   //p is process
   //pp is process priority
   //bt is process burst time
   //w is wait time
   // t is turnaround time
   //awt is average waiting time
   //atat is average turnaround time
    
    public void userInputs()
    {
        p = new int[10];
        pp = new int[10];
        bt = new int[10];
        w = new int[10];
        t = new int[10];
        System.out.println();
        System.out.println("=====Priority Scheduling=====");
        System.out.print("# of process : ");
        n = input.nextInt();
        System.out.print("\n\t Enter burst time : Time priorities \n");

        for(i=0;i<n;i++)
        {
           System.out.print("\nProcess["+(i+1)+"]:");
           bt[i] = input.nextInt();
           pp[i] = input.nextInt();
           p[i]=i+1;
        }
    }    
    public void sortingPriorities()
    {
        for(i=0;i<n-1;i++)
        {
          for(int j=i+1;j<n;j++)
          { 
            if(pp[i]>pp[j])
            {
                x=pp[i];
                pp[i]=pp[j];
                pp[j]=x;
                x=bt[i];
                bt[i]=bt[j];
                bt[j]=x;
                x=p[i];
                p[i]=p[j];
                p[j]=x;
            }
          }
        }
     w[0]=0;
     awt=0;
     t[0]=bt[0];
     for(i=1;i<n;i++)
     {
        w[i]=t[i-1];
        awt+=w[i];
        t[i]=w[i]+bt[i];
     }
     
    }
    
    public void displayInfo()
    {
        userInputs();
        sortingPriorities();
        System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Priority \n");
        for(i=0;i<n;i++)
        {
            System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+pp[i]+"\n");
        }
        System.out.println("\n");
        System.out.println("Total Wait Time : "+awt);
        System.out.println("Average Wait Time : "+(awt/=n));
    }
    
}
