public class EuclidDistance implements Distance
{
	public EuclidDistance()
	{
		
	}

	public double distance(Point p1, Point p2)
	{
		return Math.sqrt( Math.pow(p2.get(0) - p1.get(0) ,2.0) + Math.pow(p2.get(1) - p1.get(1) ,2.0) ); //Wurzel( (q1 - p1)^2 + (q2 - p2)^2 )
	}
}
