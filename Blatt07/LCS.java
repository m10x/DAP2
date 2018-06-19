import java.util.Random;
import java.util.Arrays;

public class LCS
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 1) // Kein Argument übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			int laenge = Integer.parseInt(args[0]); //Das 1. Argument legt die Array länge fest
			Random numberGenerator = new Random(); //Erzeuge zufälligen Zahlen ersteller
			String folge1 = randStr(laenge, numberGenerator);
			String folge2 = randStr(laenge, numberGenerator);

			//Vorlesung Beispiel
			/*folge1 = "ABCBDAB";
			folge2 = "BDCABAD";
			laenge = folge1.length();*/

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

			System.out.println("\n\nDie längste gemeinsame Teilfolge ist: "+lcsausgabe(folge1fix,folge2fix,teilfolge));

			System.out.println("\n\nDie Berechnung hat "+msecs+" Millisekunden gedauert\n");
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava LCS {Länge der Folgen}\n");
			System.exit(0);
		}
	}

	static String lcsausgabe(String sx, String sy, int[][] ints)
	{
		String z = "";
		int x = sy.length()-1;
		int y = sx.length()-1;
		int last = 0;
		while (ints[x][y] > 0)
		{
			if (ints[x-1][y-1] == ints[x][y])
			{
				x--;
				y--;
			}
			else if (ints[x-1][y] == ints[x][y])
			{
				x--;
			}
			else if (ints[x][y-1] == ints[x][y])
			{
				y--;
			}
			else if (ints[x][y] != last )
			{
				last = ints[x][y];
				z = sy.substring(y,y+1) + z;
			}
			else
			{
				x--;
				y--;
			}
			//System.out.println("\nx:"+x+" y:"+y+" z:"+z); Nur zum testen
		}

		return z;
	}

	static String randStr(int n, Random r) // erstelle zufällige Strings
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
		/*for (int i = 0; i < m; i++) Nicht nötig da schon standardmäßig mit 0 gefüllt
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
		if (x.charAt(i) == y.charAt(j)) //selber buchstabe
		{
			c[i][j] = c[i-1][j-1] + 1; //aktuell gleich des schräg links oberen
		}
		else
		{
			if(c[i-1][j] >= (c[i][j-1])) // linke größer als obere? aktuelle gleich das linke
				c[i][j] = c[i-1][j];
			else
				c[i][j] = c[i][j-1]; //aktuelle gleich das obere
		}
	}
}
