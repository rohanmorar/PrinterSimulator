import java.lang.Comparable;

public class PrintJob implements Comparable<PrintJob>
{	//initialization
	PrintJob(String name, int prio, int num_pgs)
	{	u_name = name;
		user_priority = prio;
		num_pages = num_pgs;
	}	
	// get/set methods for user's name
	public void setName(String n)
	{	u_name = n;
	}
	public String getName()
	{	return u_name;
	}
	// get/set methods for user's priority
	public void setPrio(int p)
	{	user_priority = p;
	}
	public int getPrio()
	{	return user_priority;
	}
	// get/set methods for the number of pages
	public void setNumPages(int np)
	{	num_pages = np;
	}
	public int getNumPages()
	{	return num_pages;
	}
	@Override
	public int compareTo(PrintJob o) 
	{	// TODO Auto-generated method stub
		int person_a = this.getNumPages() * this.getPrio();
		int person_b = o.getNumPages() * o.getPrio();
		
		if(person_a > person_b)
		{	return 1;
		}
		else if(person_a < person_b)
		{	return -1;
		}
		else
		{	return 0;
		}			
	}
	private String u_name;
	private int user_priority;
	private int num_pages;
}