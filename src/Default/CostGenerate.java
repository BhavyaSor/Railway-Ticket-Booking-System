package Default;
public class CostGenerate
{
    public int cst(int tier,int dist)
    {
    	int cost=0;
        if(tier==1)
        {
            cost=(dist)*2;
        }
        else if(tier==2)
        {
            cost=(dist);
        }
        else if(tier==3)
        {
            cost=dist/2;
        }
        return  cost;
    }

}