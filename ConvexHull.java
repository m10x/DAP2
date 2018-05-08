public class ConvexHull {
	
	public static void main(String[] args)
	{
		try
		{
			Point[] points = makePoints();
			
			List<Point> huelle = simpleConvex(points);
			System.out.println("Huelle: " + huelle);

		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus!
		{
			System.out.println(e);
			System.exit(0); //Beende Programm
		}
	}

	public List<Point> simpleConvex(Point[] P)
	{
		List<Point> huelle = new LinkedList<Point>();
		for (int i = 0; i < P.length; i++)
		{
			for (int j = 0; j < P.length; j++)
			{
				if (i != j)
				{
					for (int k = 0; k < P.length; k++)
					{
						if (k != i && k != j)
						{
							//teste ob k links von gerade i j
							huelle.add(P[k]);
						}
					}
				}
			}
		}
		return huelle;
	}

	public Point[] makePoints()
	{
		Point[] points = new Point[];

		java.util.Random numberGenerator = new java.util.Random(); //Erzeuge 6 zufaellige Zahlen im Bereich -1000 bis 1000
		int grenze = 1000; 
		double[] rand = new double[2]
		for (int i = 0; i < 1000; i++)
		{
			rand[0] = numberGenerator.nextDouble() * grenze;
			if(numberGenerator.nextBoolean())
				rand[0] *= -1;
			rand[1] = numberGenerator.nextDouble() * grenze;
			if(numberGenerator.nextBoolean())
				rand[1] *= -1;
			Point tmp = new Point(2,rand[0],rand[1]);
			points[i] = tmp;
		}
		
		return points;
	}
}

