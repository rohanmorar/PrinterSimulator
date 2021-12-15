public class OutsidePrintJob extends PrintJob 
{	public double calcCost()
	{	return super.getNumPages()* PAGE_COST;
	}
	OutsidePrintJob(String name, int prio, int num_pgs) 
	{	super(name, prio, num_pgs);
		// TODO Auto-generated constructor stub
	}
	final double PAGE_COST = 0.10;
}
