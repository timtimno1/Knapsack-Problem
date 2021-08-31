package greedy;
/*
 * @author Tim
 * @version 1.0
 * 程式皆為原創 3A717037	四訊三甲	陳峰楷
 */
@SuppressWarnings("unused")
public class KnapsackProblem
{
	private byte n;

	private int w,maxProfit,numBest,P[], W[];
	
	//Object have include and best status
	private boolean bestset[],include[];
	
	//n is total object，w is full weight,P is every profit, W is every weight
	public KnapsackProblem(byte n,int w,int P[],int W[])
	{
		this.n=n;
		this.w=w;
		this.P=P;
		this.W=W;
		bestset=new boolean[n+1];
		include=new boolean[n+1];
	}
	
	public void knapsack(byte i,int profit,int weight)
	{
		if(weight<=w && profit>maxProfit)
		{
			maxProfit=profit;
			numBest=i;
			bestset=include.clone();
		}
		if(promising(i,profit,weight))
		{
			include[i+1]=true;		//take i+1
			knapsack((byte)(i+1),profit+P[i+1],weight+W[i+1]);
			include[i+1]=false;
			knapsack((byte)(i+1),profit,weight);
		}
	}
	
	private boolean promising(byte i,int profit,int weight)
	{
		int j,k;
		int totWeight;
		float bound;
		
		if(weight>=w)
			return false;
		else
		{
			j=i+1;
			bound=profit;
			totWeight=weight;
			while(j<=n && totWeight+W[j]<=w)
			{
				totWeight+=W[j];
				bound+=P[j];
				j++;
			}
			k=j;
			if(k <=n)
				bound+=(w-totWeight)*P[k]/W[k];
			return bound>maxProfit;
		}
			
	}
	public int getMaxProfit()
	{
		return maxProfit;
	}
	public int getNumBest()
	{
		return numBest;
	}
	public boolean[] getBestset()
	{
		return bestset;
	}
	public String toString()
	{
		StringBuilder to =new StringBuilder(numBest*2);
		for(int i=1;i<=numBest;i++)
			if(bestset[i])
				to.append("物品"+i + " ");
		return "最大金額為: " + maxProfit + "\n最佳狀況為:\n" + "拿了" + to;
	}
}
