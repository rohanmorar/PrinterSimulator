import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Printer 
{
	public static void main(String[] args) throws FileNotFoundException, UnderflowException 
	{	BinaryHeap<PrintJob> bh = new BinaryHeap<PrintJob>();
		File file = new File("/Users/rohanmorar/Desktop/DSAL/input.txt");
		Scanner scan = new Scanner(file);
		System.out.println("Min to Max priority ordered jobs: \n");
		System.out.println(" Name	|  Priority #	|  # of Pages	|	Cost");
		System.out.println("-----------------------------------------------------------");
		while(scan.hasNextLine())
		{	String fName;
			int userPrio, numbPagesP;
			char flagIndicator;
			String lineFetched = scan.nextLine();
			String[] splitItems = lineFetched.split("\t");

			fName = splitItems[0].trim();
			userPrio = Integer.parseInt(splitItems[1].trim());
			numbPagesP = Integer.parseInt(splitItems[2].trim());
			flagIndicator = splitItems[3].charAt(0);
			
			if(flagIndicator == 'I')
			{	PrintJob iPrint = new PrintJob(fName, userPrio, numbPagesP);
				bh.insert(iPrint);
			}
			else if(flagIndicator == 'O')
			{	OutsidePrintJob oPrint = new OutsidePrintJob(fName,userPrio, numbPagesP);
				bh.insert(oPrint);
			}
			else
			{	System.out.println("Invalid Flag.");
			}			
		}
		while(!bh.isEmpty()) 
		{
			PrintJob inP = bh.deleteMin();
			if(inP.getClass() == PrintJob.class)
			{	System.out.println(inP.getName() + "	|	" +						  
						+ inP.getPrio() + "	|	" 
							+ inP.getNumPages() + "	|	" + "No Cost");
			}
			else if (inP.getClass() == OutsidePrintJob.class)
			{	OutsidePrintJob outP = (OutsidePrintJob) inP;
				System.out.println(outP.getName() + "	|	" +						  
						 + outP.getPrio() + "	|	" +
						 + outP.getNumPages() + "	|	" + "$" + outP.calcCost()+"0");
			}
			else
			{	System.out.println("Invalid class match");
			}
		}
	}
}

