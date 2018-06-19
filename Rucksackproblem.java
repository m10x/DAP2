import java.util.Random;
import java.util.Arrays;

public class Rucksackproblem
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 3) // Keine Argumente übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			int n = Integer.parseInt(args[0]);
			int W = Integer.parseInt(args[1]);
			int p = Integer.parseInt(args[2]);

			Random r = new Random(); //Erzeuge zufälligen Zahlen ersteller
			int Low = (int) (0.8 * p);
			int High = (int) (1.25 * p);

			long tStart, tEnd, msecs; //Zur Zeitmessung benötigty

			Article[] a = new Article[n];

			for (int i = 0; i < n; i++)
			{
				a[i] = new Article(r.nextInt(High-Low)+Low,r.nextInt(90)+10);
			}

			tStart = System.currentTimeMillis();
			int loesung = Rucksack(n,a,W);
			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;
			System.out.println("Der Berechnete maximale Wert ist "+loesung+"\nDie Berechnung hat "+msecs+" Millisekunden benötigt.");

		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Rucksackproblem {Anzahl Waren} {Gewichtsschranke} {Multiplikator}\n");
			System.exit(0);
		}

	}

	public static int richtigGuterAlgorithmus()
	{
		//fehlend
	}

	public static int Rucksack(int n, Article[] a, int W)
	{
		int[][] Opt = new int[n][W];
		//for (int j = 0; j < W; j++) //nicht nötig, da bei initialisierung alles 0 ist
		//	Opt[0,j] = 0;
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < W; j++)
			{
				berechne(Opt,i,j,a);
			}
		}
		return Opt[n-1][W-1];
	}

	public static void berechne (int[][] Opt, int i, int j, Article[] a)
	{
		if( j < a[i].getWeight() )
			Opt[i][j] = Opt[i-1][j];
		else
			Opt[i][j] = Math.max(Opt[i-1][j],a[i].getValue()+Opt[i-1][j]-a[i].getWeight());
	}


		
}
