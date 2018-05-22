public class Point 
{
	private int d;
	private double[] values;

	public Point(int d, double... values)
	{
		if ( d < 1 || values == null || values.length != d ) 
      			throw new IllegalArgumentException( "Values null oder leer oder d null" );

		this.d = d;
		this.values = values;
	}

	public double get(int i)
	{
		return values[i];
	}

	public int dim()
	{
		return d;
	}
}
