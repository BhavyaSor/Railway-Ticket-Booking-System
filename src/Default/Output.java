package Default;

import java.io.*;
import java.util.*;
import Train.*;
import TIER.*;
public class Output extends Train{

	public void  add() {
        try {
        	ArrayList<String> lines = new ArrayList<String>();
            String line = null;
            File file1 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output1.txt");
            File file2 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output2.txt");
            File file3 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output3.txt");
            File file4 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output4.txt");
            File file5 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output5.txt");
            File file6 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output6.txt");
            File file7 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Output7.txt");
            
            FileReader fr = null;
            BufferedReader br = null;
            
            switch(supobj.date)
            {
            case 1:{fr = new FileReader(file1);
            	br = new BufferedReader(fr);
            	break;}
            case 2:{fr = new FileReader(file2);
            		br = new BufferedReader(fr);
		 			break;}
            case 3:{fr = new FileReader(file3);
		 			br = new BufferedReader(fr);
		 			break;}
            case 4:{fr = new FileReader(file4);
		 			br = new BufferedReader(fr);
		 			break;}
            case 5:{fr = new FileReader(file5);
		 			br = new BufferedReader(fr);
		 			break;}
            case 6:{fr = new FileReader(file6);
		 			br = new BufferedReader(fr);
		 			break;}
            case 7:{fr = new FileReader(file7);
					br = new BufferedReader(fr);
					break;}
            }
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
            br.close();
            //FileReader fr = null;
            //BufferedReader br = null;
            FileWriter fw = null;
            BufferedWriter out = null;
            switch(supobj.date)
            {
            case 1:{fw = new FileWriter(file1);
            		out = new BufferedWriter(fw);
            		break;}
            case 2:{fw = new FileWriter(file2);
            		out = new BufferedWriter(fw);
		 			break;}
            case 3:{fw = new FileWriter(file3);
		 			out = new BufferedWriter(fw);
		 			break;}
            case 4:{fw = new FileWriter(file4);
		 			out = new BufferedWriter(fw);
		 			break;}
            case 5:{fw = new FileWriter(file5);
		 			out = new BufferedWriter(fw);
		 			break;}
            case 6:{fw = new FileWriter(file6);
		 			out = new BufferedWriter(fw);
		 			break;}
            case 7:{fw = new FileWriter(file7);
					out = new BufferedWriter(fw);
					break;}
            }
            
            for(String s : lines)
            {
            	out.write(s);
            	out.newLine();
            }
            String str="";
            str+=""+supobj.usercode+"-"+supobj.tier+"-"+supobj.seat;//+"-"+(Main.obj.seatBook+1)+"to"+(Main.obj.seatBook+Main.obj.seat);
            out.write(str);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	public void genTicket() {
		File f1 = new File("/Users/manthansoriya/Desktop/Study/2 YEAR/InnovativeAssigment/OOP/src/Final.txt");
		
		FileWriter fw=null;
		BufferedWriter bw =null;
		try {
			fw=new FileWriter(f1);
			bw = new BufferedWriter(fw);
			bw.write("				E-Ticket");
			bw.newLine();
			bw.write("------------------------------------------------------------------------------");
			bw.newLine();
			bw.write("Name:"+supobj.name);
			bw.newLine();
			bw.newLine();
			bw.write("Date:"+supobj.dat);
			bw.newLine();
			bw.write("Source:"+supobj.src);
			bw.newLine();
			bw.write("Destination:"+supobj.dest);
			bw.newLine();
			bw.write("Time:");
			for(int i=2;i<=8;i++)
			{
				bw.write(supobj.usercode.charAt(i));
			}
			bw.newLine();
			bw.write("Tier:"+supobj.tier);
			bw.newLine();
			bw.write("No. of tickets:"+supobj.seat);
			bw.newLine();
			bw.write("Seats:");
			for(int i=1;i<=supobj.seat;i++)
			{
				if(supobj.tier==1)
				{
					bw.write(""+(t1.seatBook+i)+" ");
				}
				if(supobj.tier==2)
				{
					bw.write(""+(t2.seatBook+i)+" ");
				}
				if(supobj.tier==3)
				{
					bw.write(""+(t3.seatBook+i)+" ");
				}
				//bw.write(.seatBook+i-1);
			}
			bw.newLine();
			bw.newLine();
			bw.write("Cost:"+supobj.cost+" Rupees");
			bw.newLine();
			bw.write("------------------------------------------------------------------------------");
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(Exception e) {
			//
		}
	}
}
