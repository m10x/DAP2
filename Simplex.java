public abstract class Simplex
{
	public int d;
	public Point[] points;

	public Simplex()
	{
		//if ( d < 1 || points == null || points.length != (d + 1) ) 
      		//	throw new IllegalArgumentException( "Values null oder leer oder d null" );
//
//		this.d = d;
//		this.points = points;
	}

	public abstract Point get(int i);

	public abstract boolean validate();
}
