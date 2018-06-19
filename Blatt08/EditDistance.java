import java.util.Arrays;

public class EditDistance
{
	public static void main(String[] args)
	{
		try
		{
			boolean einfach = true;
			if (args.length == 3) // Kein Argument übergeben?
			{
				if (args[2].equals("-o"))
					einfach = false;
				else
				{
					throwError(1);
				}
			}
			else if (args.length != 2)
			{
				throwError(1);
			}
			String a = args[0];
			String b = args[1];

			int distanz = calculate(a,b);

			if (einfach)
			{
				System.out.println("\nDistanz fuer '"+a+"' --> '"+b+"': "+distanz);
			}
			else
			{
				System.out.println("\nLoesung fuer '"+a+"' --> '"+b+"' mit Gesamtkosten "+distanz+":");
				System.out.println("=====================================================");
				printEditOperations(a,b);
			}

		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			throwError(0);
		}
	}

	static void throwError(int a)
	{
		if (a == 1)
			System.out.println("\nFalsche Argumente übergeben!\n");
		System.out.println("Bitte benutze das Programm folgendermaßen:\njava EditDistance {string1} {string2} {-o}\nwobei -o optional ist.\n");
		System.exit(0);
	}

	static void printEditOperations(String a, String b)
	{
		char tmp;
		int durchgang = 1;
		int i = 0;
		while (!a.equals(b))
		{
			if (a.length() < i+1 && b.length() < i+1) //Letztes Zeichen bei beiden?
			{
				tmp = a.charAt(i);
				a = a.substring(0,i)+b.charAt(i)+a.substring(i+1);
				System.out.println(durchgang+") "+"Kosten 1: Ersetze "+tmp+" durch "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
			}
			else if (a.length() < i+1) //a kleiner b => füge bi an ende von ai
			{
				a += b.charAt(i);
				System.out.println(durchgang+") "+"Kosten 1: Fuege "+b.charAt(i)+" an Position "+durchgang+" ein --> "+a);
			}
			else if (b.length() < i+1) //b kleiner a => entferne letzten char von a
			{
				tmp = a.charAt(i);
				a = a.substring(0, a.length() - 1);
				System.out.println(durchgang+") "+"Kosten 1: Loesche "+tmp+" an Position "+durchgang+" --> "+a);
			}
			else
			{
				if (a.charAt(i) == (b.charAt(i))) //ai == bi
				{
					System.out.println(durchgang+") "+"Kosten 0: "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
				}
				else
				{
					if (b.length() > i+2 && a.charAt(i) == b.charAt(i+1)) //a ist gleich der nachfolger von b
					{
						a = a.substring(0,i)+b.charAt(i)+a.substring(i);
						System.out.println(durchgang+") "+"Kosten 1: Fuege "+b.charAt(i)+" an Position "+durchgang+" ein --> "+a);
					}
					else if (a.length() > i+2 && a.charAt(i+1) == b.charAt(i)) //b ist gleich der nachfolger von a
					{
						tmp = a.charAt(i);
						a = a.substring(0, i)+a.substring(i+1);
						System.out.println(durchgang+") "+"Kosten 1: Loesche "+tmp+" an Position "+durchgang+" --> "+a);
					}
					else
					{
						tmp = a.charAt(i);
						a = a.substring(0,i)+b.charAt(i)+a.substring(i+1);
						System.out.println(durchgang+") "+"Kosten 1: Ersetze "+tmp+" durch "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
					}
				}
			}
			i++;
			durchgang++;
		}
	}

	static int calculate(String a, String b) 
	{
    	int[][] dp = new int[a.length() + 1][b.length() + 1];
 
    	for (int i = 0; i <= a.length(); i++) 
		{
        	for (int j = 0; j <= b.length(); j++) 
			{
        		if (i == 0)
        	        dp[i][j] = j;
        	   	else if (j == 0)
               		dp[i][j] = i;
			   	else 
					dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(a.charAt(i - 1), b.charAt(j - 1)), dp[i - 1][j] + 1, dp[i][j - 1] + 1); // min( {Ersetzung / Gleich} , {Löschung} , {Einfügung} )
			}
		}
 
    	return dp[a.length()][b.length()];
	}

	public static int costOfSubstitution(char a, char b) 
	{
        	return a == b ? 0 : 1; //wenn gleich 0 ansonsten 1
    }

	public static int min(int... numbers) 
	{
        	return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE); //Wenn es keine kleinste Zahl gibt (Array leer?) gib Max_Value zurück
    }
}
