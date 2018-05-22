import java.util.Random;
import java.util.Arrays;

public class LCS
{
	public static void main(String[] args)
	{
		/*try
		{
			if (args.length != 1) // Kein Argument übergeben?
				throw new Exception("Falsche Argumente übergeben!");*/
			int laenge = Integer.parseInt(args[0]); //Das 1. Argument legt die Array länge fest
			Random numberGenerator = new Random(); //Erzeuge zufälligen Zahlen ersteller
			String folge1 = randStr(laenge, numberGenerator);
			String folge2 = randStr(laenge, numberGenerator);

			//Vorlesung Beispiel
			folge1 = "ABCBDAB";
			folge2 = "BDCABA";
			laenge = folge1.length();

			System.out.println("1.Folge: "+folge1+"\n2.Folge: "+folge2);

			laenge++;
			String folge1fix = "$"+folge1;
			String folge2fix = "%"+folge2;

			long tStart, tEnd, msecs;
			tStart = System.currentTimeMillis();

			int[][] teilfolge = lcslaenge(folge1fix,folge2fix);

			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;
			
			for (int i = 0; i < folge1fix.length(); i++)
			{
				System.out.println();
				for (int j = 0; j < folge2fix.length(); j++)
				{
					System.out.print(teilfolge[i][j]+" ");
				}
			}

			System.out.println("\n\nDie Berechnung hat "+msecs+" Millisekunden gedauert");
		/*}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava LCS {Länge der Folgen}\n");
			System.exit(0);
		}*/
	}

	static String lcsausgabe(String x, String y, int[][] ints)
	{
		String z = "";

		for (int i = x.length() - 1; i > 0; i--)
		{
			for (int j = y.length() - 1; j > 0; j--)
			{
				
			}
		}

		return z;
	}

	static String randStr(int n, Random r)
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while (--n>=0) {
			res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}

	static int[][] lcslaenge(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		int[][] c = new int[m][n];
		/*for (int i = 0; i < m; i++)
			c[i][0] = 0;
		for (int j = 0; j < n; j++)
			c[0][j] = 0;*/
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				laengenberechnung(x,y,c,i,j);
			}
		}
		return c;
	}

	static void laengenberechnung(String x, String y, int[][] c, int i, int j)
	{
		if (x.charAt(i) == y.charAt(j))
		{
			c[i][j] = c[i-1][j-1] + 1;
		}
		else
		{
			if(c[i-1][j] >= (c[i][j-1]))
				c[i][j] = c[i-1][j];
			else
				c[i][j] = c[i][j-1];
		}
	}
}
