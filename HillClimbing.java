package onkar;
//TSP using Hill-climbing



import java.util.*;
public class HillClimbing
{

	public double[][] fillDistanceMatrix(int size,int seed)
	{
		double[][] distance=new double[size][size];
		Random random=new Random(seed);
		for(int i=0;i<size;i++)
			for(int j=i+1;j<size;j++)
			{
				distance[i][j]=random.nextDouble();
				distance[j][i]=distance[i][j];
			}
		return distance;
	}
	public double swap(int[] tour,int tourIndexA,int tourIndexB,double[][] distances) {
		return 0;
	}
	
	public double getBestTour(int[] tour, double[][] distances, int restarts, int seed)
	{
		Random random=new Random(seed);
		for(int i=0;i<restarts;i++)
		{
			randomizeTour(tour,random);
		}
		return 0;
	}
	public void randomizeTour(int[] tour,Random random)
	{
		for(int i=0;i<tour.length;i++)
			tour[i]=i;
	}
	public static void main(String[] args)
	{
		int[] sizes= {10,20,30,40};
		int[] seeds= {1,2,3,4};
		int[] restarts= {20,20,20,20};
		HillClimbing obj=new HillClimbing();
		for(int i=0;i<sizes.length;i++)
		{
			double[][] distance=obj.fillDistanceMatrix(sizes[i],seeds[i]);
			int[] tour =new int[sizes[i]];
			double cost=obj.getBestTour(tour,distance,restarts[i],seeds[i]);
			System.out.println("The following tour costs"+cost);
			for(int j=0;j<tour.length;j++)
				System.out.println(tour[j]+"");
			System.out.println();
		}
		
	}

}