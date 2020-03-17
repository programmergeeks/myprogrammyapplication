package schedulingpackage;

//This code represents the startup of operating 5 different Disk Schedules
// 1. First Come, First Serve (FCFS)
// 2. Shortest Seek Time First (SSTF)
//    2.1 Non Preemptive (SSTFNP)
//    2.2 Preemptive (SSTFP)
// 3. Priority (PRTYS)
// 4. Round Robin (RRS)

/**
 *
 * @author James Alwin A. Aljecera
 * @author John Ford Kilat
 * @author Gherome Bañados
 * @author Jann Brizo
 */
import java.util.Scanner;

public class startupOperatingDiskScheduling 
{
    
    public static void main(String[] args) 
    {
        FCFS fcfs = new FCFS();
        SSTFP sstfp = new SSTFP();
        SSTFNP sstfnp = new SSTFNP();
        PRTYS prtys = new PRTYS();
        RRSCH rrsch = new RRSCH();
        int choose = -1;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.println("\n");
            System.out.println("==========DISK SCHEDULING OPERATION==========");
            System.out.println("1. First Come, First Serve (FCFS)");
            System.out.println("2. Shortest Seek Time First Non Preemptive(SSTFNP)");
            System.out.println("3. Shortest Seek Time First Preemptive (SSTFP)");
            System.out.println("4. Priority (PRTYS)");
            System.out.println("5. Round Robin (RRS)");
            System.out.println("Press '0' for terminating the process");
            System.out.println("\n");
            System.out.print("Which operation did you want to take? ");
            choose = input.nextInt();
            switch(choose)
            {
                case 0:
                {
                    System.out.println("Thank you and God Bless!");
                }
                break;
                case 1:
                {
                    fcfs.displayInfo();
                }
                break;
                case 2:
                {
                    sstfp.displayInfo();
                }
                break;
                case 3:
                {
                    sstfnp.displayInfo();
                }
                break;
                case 4:
                {
                    prtys.displayInfo();
                }
                break;
                case 5:
                {
                    rrsch.displayInfo();
                }
                break;
                default:
                {
                    System.out.println("Entered operation is invalid! Please try again.");                   
                }
                break;
            }
        }
        while(choose != 0);       
    }
    
}
