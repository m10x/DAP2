public class Triangle extends Simplex
{
	public Triangle(int d, Point... points)
	{
		if ( d < 1 || points == null || points.length != (d + 1) ) 
      			throw new IllegalArgumentException( "Values null oder leer oder d null" );

		this.d = d;
		this.points = points;
	}	

	public Point get(int i)
	{
		return points[i];
	}

	public boolean validate()
	{
		if (points.length != 3)
			return false;

		for (int i = 0; i < 3; i++)
		{
			if (points[i].dim() != 2)
				return false;
		}

		return true;
	}

	public double perimeter()
	{
		EuclidDistance giveme = new EuclidDistance();
		return giveme.distance(points[0],points[1]) + giveme.distance(points[1],points[2]) + giveme.distance(points[2],points[0]);
	}
}
