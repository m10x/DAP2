public class Application {
	
	private static Triangle dreieck;
	private static double umfang;
	private static Point[] points = new Point[3];

	public static void main(String[] args)
	{
		try
		{	
			if (args.length == 6) //Wurden 6 Werte uebergeben?
			{	
				makePoints(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]));
				dreieck = new Triangle(2, points[0], points[1], points[2]);

				umfang = dreieck.perimeter(); // Gebe Umfang aus
				System.out.printf("Der Umfang des Dreiecks mit den 3 Eckpunkten (%f,%f) (%f,%f) (%f,%f) betraegt %f",Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]),umfang);
			}
			else if (args.length == 0) //Wurden keine Argumente uebergeben?
			{
				java.util.Random numberGenerator = new java.util.Random(); //Erzeuge 6 zufaellige Zahlen im Bereich -1000 bis 1000
				int grenze = 1000; 
				double[] rand = new double[6];
				for (int i = 0; i < 6; i++)
				{
					rand[i] = numberGenerator.nextDouble() * grenze;
					if(numberGenerator.nextBoolean())
						rand[i] *= -1;
				}

				makePoints(rand[0],rand[1],rand[2],rand[3],rand[4],rand[5]); //Erzeuge Triangle mit zufaelligen Werten und gebe den Umfang aus
				dreieck = new Triangle(2, points[0], points[1], points[2]);
				umfang = dreieck.perimeter();
				System.out.printf("Der Umfang des Dreiecks mit den 3 Eckpunkten (%f,%f) (%f,%f) (%f,%f) betraegt %f",rand[0],rand[1],rand[2],rand[3],rand[4],rand[5],umfang);
			}			
			else //Wurde eine falsche Anzahl an Argumenten uebergeben?
				throw new Exception("Falsche Argumente übergeben!");
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Application x1 y1 x2 y2 x3 y3\n");
			System.exit(0); //Beende Programm
		}
	}

	public static void makePoints(double x1,double y1,double x2,double y2,double x3,double y3)
	{
		double[] xy = new double[2];
		
		xy[0] = x1;
		xy[1] = y1;
		points[0] = new Point(2,xy[0],xy[1]);

		xy[0] = x2;
		xy[1] = y2;
		points[1] = new Point(2,xy[0],xy[1]);

		xy[0] = x3;
		xy[1] = y3;
		points[2] = new Point(2,xy[0],xy[1]);
	}
}
