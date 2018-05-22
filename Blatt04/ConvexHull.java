import java.util.List;
import java.util.LinkedList;
import java.lang.Math.*;

public class ConvexHull {
	
	public static void main(String[] args)
	{
		try
		{
			Point[] points = makePoints();
			
			simpleConvex(points);
			//List<Point> huelle = simpleConvex(points);
			//System.out.println("Huelle: " + huelle);

		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus!
		{
			System.out.println(e);
			System.exit(0); //Beende Programm
		}
	}

	public static List<Point> simpleConvex(Point[] P)
	{
		List<Point> huelle = new LinkedList<Point>();
		int j = 0;
		int k = 0;
		boolean kandidat = true;
		
		for (int i = 0; i < P.length; i++)
		{
			kandidat = true;
			j = 0;
			while(j < P.length && kandidat)
			{
				k = 0;
				if (i != j)
				{
					while(k < P.length && kandidat)
					{
						if (k != i && k != j)
						{
							if (isLeft(P[i],P[j],P[k]))
							{
								kandidat = false;
							}
						}
						k++;
					}
				}
				j++;
			}
			if(kandidat)
				System.out.printf("\n(%f,%f) gehört zur ConvexHülle",P[k-1].get(0),P[k-1].get(1));
				//Hier zur Liste hinzufügen
		}
		return huelle;
	}

	private static boolean isLeft(Point a, Point b, Point c) //Berechne Kreuzprodukt der Vektoren AC und AB
	{
		double[] ab = new double[2];
		double[] ac = new double[2];

		ab[0] = b.get(0) - a.get(0);
		ab[1] = b.get(1) - a.get(1);

		ac[0] = c.get(0) - a.get(0);
		ac[1] = c.get(1) - a.get(1);

		if ((ab[0] * ac[1] - ac[0] * ab[1]) > 0) //Wenn Kreuzprodukt > 0 dann liegt links
			return true;

		return false;
	}

	private static boolean isInTriangle(double x, double y, double... t) {

		double a = Math.signum((t[0] - t[2]) * (y - t[1]) - (t[1] - t[3]) * (x - t[0]));

		double b = Math.signum((t[2] - t[4]) * (y - t[3]) - (t[3] - t[5]) * (x - t[2]));

		double c = Math.signum((t[4] - t[0]) * (y - t[5]) - (t[5] - t[1]) * (x - t[4]));

		return a == 0 || b == 0 || c == 0 || (a == b && b == c);

	}

	public static Point[] makePoints()
	{
		Point[] points = new Point[1000];

		java.util.Random numberGenerator = new java.util.Random(); //Erzeuge 6 zufaellige Zahlen im Bereich -1000 bis 1000
		int grenze = 100; 
		double[] rand = new double[2];
		for (int i = 0; i < 1000; i++)
		{
			boolean inDreieck = false;
			while(inDreieck == false)
			{
				rand[0] = numberGenerator.nextDouble() * grenze;
				//if(numberGenerator.nextBoolean())
				//	rand[0] *= -1;
				rand[1] = numberGenerator.nextDouble() * grenze;
				//if(numberGenerator.nextBoolean())
				//	rand[1] *= -1;

				if (isInTriangle(rand[0],rand[1],10,10,10,100,100,10))
				{
					Point tmp = new Point(2,rand[0],rand[1]);
					points[i] = tmp;
					System.out.printf("\n(%f,%f) liegt im Dreieck",rand[0],rand[1]);
					inDreieck = true;
				}
				else
					System.out.printf("\n(%f,%f) liegt NICHT im Dreieck",rand[0],rand[1]);
			}
		}
		
		return points;
	}
}
