/*
Author : Bhavya Soriya
This class contains all the Information about User like its source,Destination,Date,..,etc.
This is Stored in a static object supobj
This class cotains Various methods to handel the input of the user in command interface 
*/


package Train;
import java.util.*;

//import Date.DateS;

//import Date.setDate;
//import Default.AC;
//import Default.InvalidEx;
//import Default.CostGenerate;
import Default.*;
import Date.*;
import TIER.*;
public class Train {
	public static Train supobj=new Train();
	public static ACTier t1=new ACTier();
	public static Tier2  t2=new Tier2();
	public static Tier3 t3=new Tier3();
	public int cost,tier,dist,date,month,year,seat;
	public int seatAvail,seatTotal,seatBook,index;
	public String src,dest,code="",usercode="",name="",dat="";
	setDate dt=new setDate();

	// This class will add x number of days to current Date
	public static String getNextDate(int x){
    	Calendar c1=Calendar.getInstance();
    	c1.add(Calendar.DATE, x);
    	return c1.getTime().toString();
    }

    // This class when called will ask user for Date
	public void generateDate()
	{
		System.out.println("AFTER HOW MANY DAYS YOU WANT TO TRAVEL(1 to 7)");
		try {
            Scanner sc=new Scanner(System.in);
            supobj.date = sc.nextInt();
            if(supobj.date<=0 || supobj.date>7)
            {
            	throw new InvalidEx("Invalid Input.");
            }
            //dt.setDt(date);
            supobj.dat=getNextDate(date);
            System.out.println("You have selected:"+dat);
        }
		catch(InvalidEx e)
		{
			System.out.println("Enter the date within range.");
			supobj.generateDate();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter only numbers");
			supobj.generateDate();
		}
        catch(Exception e)
        {
            System.out.println("INVALID INPUT");
            supobj.generateDate();
        }
	}

	// This Class will return the distance between the Source and destination of object calliing it
	public int genrateDist()
	{
		//System.out.println(supobj.src);
		//System.out.println(supobj.dest);
		if(supobj.src.equalsIgnoreCase("Ahmedabad")||supobj.dest.equalsIgnoreCase("Ahmedabad"));
		{
			if(supobj.src.equalsIgnoreCase("Rajkot")||supobj.dest.equalsIgnoreCase("Rajkot"))  supobj.dist=215;
			if(supobj.src.equalsIgnoreCase("Surat")||supobj.dest.equalsIgnoreCase("Surat")) supobj.dist=263;
			if(supobj.src.equalsIgnoreCase("Vadodara")||supobj.dest.equalsIgnoreCase("Vadodara")) supobj.dist=111;
		}
		if(supobj.src.equalsIgnoreCase("Rajkot")||supobj.dest.equalsIgnoreCase("Rajkot"))
		{
			if(supobj.src.equalsIgnoreCase("Surat")||supobj.dest.equalsIgnoreCase("Surat")) supobj.dist=444;
			if(supobj.src.equalsIgnoreCase("Vadodara")||supobj.dest.equalsIgnoreCase("Vadodara")) supobj.dist=289;
		}
		if(supobj.src.equalsIgnoreCase("Surat")||supobj.src.equalsIgnoreCase("Surat"))
		{
			if(supobj.src.equalsIgnoreCase("Vadodara")||supobj.dest.equalsIgnoreCase("Vadodara")) supobj.dist=154;
		}
		//System.out.println("Distance is "+Main.obj.dist);
		return supobj.dist;
	}
	
	// This class handels getting input of Source of Customer 
	public void setSrc()
	{
		try{
			Scanner sc=new Scanner(System.in);
			System.out.print("\nEnter Source:");
			supobj.src=sc.nextLine();	
			if(!(supobj.src.equalsIgnoreCase("Ahmedabad")||supobj.src.equalsIgnoreCase("Rajkot")||supobj.src.equalsIgnoreCase("Surat")||supobj.src.equalsIgnoreCase("Vadodara")))
				throw new InvalidEx();
		}
		catch(InvalidEx e)
		{
			System.out.println("This is not a valid source");
			supobj.setSrc();
		}
		catch(InputMismatchException ioe)
		{
			System.out.println("Enter valid String");
			supobj.setSrc();
		}
	}

	// This class handels getting input of Destination of Customer 
	public void setdest()
	{
		try{
			Scanner sc=new Scanner(System.in);
			System.out.print("\nEnter Destination:");
			supobj.dest=sc.nextLine();	
			if(!(supobj.dest.equalsIgnoreCase("Ahmedabad")||supobj.dest.equalsIgnoreCase("Rajkot")||supobj.dest.equalsIgnoreCase("Surat")||supobj.dest.equalsIgnoreCase("Vadodara")))
				throw new InvalidEx("This is not a valid Destination");
			if(supobj.dest.equalsIgnoreCase(src))
			{
				throw new InvalidEx("Error!Source and Destination cannot be same.");
			}
		}
		catch(InvalidEx e)
		{
			supobj.setdest();
		}
		catch(InputMismatchException ioe)
		{
			System.out.println("Enter valid String");
			supobj.setdest();
		}
	}


	public void setSeat()
	{
		try{
			UpdateData obj2=new UpdateData();
			obj2.setSeat();
			obj2.update();
			Scanner sc=new Scanner(System.in);
			if(supobj.tier==1)
			{
				System.out.println("Currently "+t1.seatAvail+" seats are available under this Option.");
				System.out.print("\nEnter Number of seat to book:");
				supobj.seat=sc.nextInt();
				
				if(supobj.seat<=0)
					throw new InvalidEx("This is not a valid Seat number");
				
				if(supobj.seat>t1.seatAvail)
					throw new InvalidEx(supobj.seat+" seat is not available in this train");
			}
			if(supobj.tier==2)
			{
				System.out.println("Currently "+t2.seatAvail+" seats are available under this Option.");
				System.out.print("\nEnter Number of seat to book:");
				supobj.seat=sc.nextInt();
				
				if(supobj.seat<=0)
					throw new InvalidEx("This is not a valid Seat number");
				
				if(supobj.seat>t2.seatAvail)
					throw new InvalidEx(supobj.seat+" seat is not available in this train");
			}
			if(supobj.tier==3)
			{
				System.out.println("Currently "+t3.seatAvail+" seats are available under this Option.");
				System.out.print("\nEnter Number of seat to book:");
				supobj.seat=sc.nextInt();
				
				if(supobj.seat<=0)
					throw new InvalidEx("This is not a valid Seat number");
				
				if(supobj.seat>t3.seatAvail)
					throw new InvalidEx(supobj.seat+" seat is not available in this train");
				
			}
			obj2.update();
			//System.out.println("Currently "+seatAvail+" seats are available under this Option.");
			
			//System.out.print("\nEnter Number of seat to book:");
			//Main.obj.seat=sc.nextInt();	
//			if(supobj.seat<=0)
//				throw new InvalidEx("This is not a valid Seat number");
//			
//			if(Main.obj.seat>Main.obj.seatAvail)
//				throw new InvalidEx(Main.obj.seat+" seat is not available in this train");
		}
		catch(InvalidEx e)
		{
			supobj.setSeat();
		}
		catch(InputMismatchException ioe)
		{
			System.out.println("Enter valid Number");
			supobj.setSeat();
		}
	}
	public void setCost()
	{
		CostGenerate ct = new CostGenerate();
		//System.out.println("Seats:"+seat);
		supobj.cost = supobj.seat * ct.cst(supobj.tier,supobj.genrateDist());
	}
	public void setTier()
	{
		try {
            System.out.println("WHICH Tire YOU WANT TO SELECT");
            System.out.println("1-> AC\n2-> Tier 2\n3-> Tier 3");
            Scanner sc = new Scanner(System.in);
            supobj.tier = sc.nextInt();
            if(!(supobj.tier==1||supobj.tier==2||supobj.tier==3))
            {
                throw new  InvalidEx("Invalid Tier it can be either 1 or 2 or 3");
            }
		}catch(InvalidEx e)
		{
			supobj.setTier();
		}
	}
	public void setCode()
	{
		string temp=src.toUpperCase();
		supobj.code+=temp.charAt(0);
		supobj.code+=""+supobj.src.charAt(1)+""+supobj.src.charAt(2);
		temp=supobj.dest.toUpperCase();
		supobj.code+=temp.charAt(0);
		supobj.code+=""+supobj.dest.charAt(1)+""+supobj.dest.charAt(2);
		// if(supobj.src.charAt(0)>=65 && supobj.src.charAt(0)<=90)
		// 	supobj.code+=supobj.src.charAt(0);
		// else
		// 	supobj.code+=(char)(supobj.src.charAt(0)-32);

		// if(supobj.dest.charAt(0)>=65 && supobj.dest.charAt(0)<=90)
		// 	supobj.code+=""+supobj.dest.charAt(0);
		// else
		// 	supobj.code+=(char)(supobj.dest.charAt(0)-32);
		
	}
	public void setUserCode()
	{
		try {
			System.out.print("Enter the index of train you want to select(1to"+GetData.dt.data.length+"):");
			Scanner sc=new Scanner(System.in);
			supobj.index=sc.nextInt();
			if(GetData.dt.data.length<index||index<=0)
				throw new InvalidEx("Invalid Index Entered");
			String temp=GetData.dt.data[index-1];
			supobj.usercode+=""+temp.charAt(0)+""+temp.charAt(1)+temp.charAt(2)+temp.charAt(3)+temp.charAt(4)+temp.charAt(5)+temp.charAt(6)+temp.charAt(7)+temp.charAt(8);
		}
		catch(InvalidEx e)
		{
			supobj.setUserCode();
		}
		catch(Exception e)
		{
			System.out.println("Invalid index");
			supobj.setUserCode();
		}
	}
	//public abstract void genrateCost();
}
