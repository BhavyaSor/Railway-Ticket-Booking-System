package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;


public class DateS
{
	int dd,mm,yy;
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    
    int date1;
    Date d=new Date();
    void setDt(int day)
    {

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        //System.out.println(date);
        String d="";
        String m="";
        String y="";
        int i=-1;
        int count=0;
        while(i++<date.length()-1)
        {
            if(date.charAt(i)=='-')
            {
                count++;
            }
            else if(count==0)
            {
                d=d+date.charAt(i);


            }
            else if(count==1)
            {
              m=m+date.charAt(i);
            }
            else if(count==2)
            {
                y=y+date.charAt(i);
            }
        }
        //System.out.println(""+d+" "+m+" "+y);
        dd=Integer.parseInt(d);
        mm=Integer.parseInt(m);
        yy=Integer.parseInt(y);
        int temp=dd+day;

            //for feb
              if(mm==2)
              {
                  if(temp<=28)
                  {

                      dd=temp;
                  }
                  else if(temp>28)
                  {
                      temp=temp-28;
                      dd=temp;
                      mm=mm+1;
                  }
              }

                //for 31 days month
                if((mm == 1) || (mm == 3) || (mm == 5) || (mm == 7) || (mm == 10) || (mm == 8) || (mm == 12))
                {
                    if(temp<=31)
                    {

                        dd=temp;
                    }
                    else if(temp>31)
                    {
                        temp=temp-31;
                        dd=temp;
                        mm=mm+1;
                        if(mm>12)
                        {
                            mm=mm-12;
                            yy=yy+1;
                        }

                    }
                }
               //for 30 days month
               if(mm==4||yy==6||mm==9||mm==11)
               {
                if(temp<=30)
                {

                    dd=temp;
                }
                else if(temp>30)
                {
                    temp=temp-30;
                    dd=temp;
                    mm=mm+1;
                }

                }
        System.out.println("You've Selected This Date: "+""+dd+" "+mm+" "+yy);
    }


}