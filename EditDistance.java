import java.util.Arrays;

public class EditDistance
{
	public static void main(String[] args)
	{
		/*try
		{*/
			boolean einfach = true;
			if (args.length == 3) // Kein Argument übergeben?
			{
				if (args[2].equals("-o"))
					einfach = false;
				else
				{
					System.out.println("Falsche Argumente übergeben!\n");
					System.out.println("Bitte benutze das Programm folgendermaßen:\njava EditDistance {string1} {string2} {-o}\nwobei -o optional ist.");
					System.exit(0);
				}
			}
			else if (args.length != 2)
			{
				System.out.println("Falsche Argumente übergeben!\n");
				System.out.println("Bitte benutze das Programm folgendermaßen:\njava EditDistance {string1} {string2} {-o}\nwobei -o optional ist.");
				System.exit(0);
			}
			String a = args[0];
			String b = args[1];

			int distanz = distance(a,b);	
			int distanz2 = calculate(a,b);

			if (einfach)
			{
				System.out.println("\nDistanz fuer '"+a+"' --> '"+b+"': "+distanz2);
			}
			else
			{
				System.out.println("\nLoesung fuer '"+a+"' --> '"+b+"' mit Gesamtkosten "+distanz+":");
				System.out.println("=====================================================");
				printEditOperations(a,b);
			}
		/*}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava EditDistance {string1} {string2} {-o}\nwobei -o optional ist.");
			System.exit(0);
		}*/
	}

	static void printEditOperations(String a, String b)
	{
		char tmp;
		int durchgang = 1;
		int i = 0;
		while (!a.equals(b))
		{
			if (a.length() < i && b.length() < i)
			{
				tmp = a.charAt(i);
				a = a.substring(0,i)+b.charAt(i)+a.substring(i+1);
				System.out.println(durchgang+") 4 i:"+i+"Kosten 1: Ersetze "+tmp+" durch "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
				durchgang++;
				i++;
			}
			else if (a.length() < i) //a kleiner b => füge bi an ende von ai
			{
				a += b.charAt(i);
				System.out.println(durchgang+") 1 i:"+i+"Kosten 1: Fuege "+b.charAt(i)+" an Position "+durchgang+" ein --> "+a);
				durchgang++;
				i++;
			}
			else if (b.length() < i) //b kleiner a => entferne letzten char von a
			{
				tmp = a.charAt(i);
				a = a.substring(0, a.length() - 1);
				System.out.println(durchgang+") 2 i:"+i+"Kosten 1: Loesche "+tmp+" an Position "+durchgang+" --> "+a);
				durchgang++;
				i++;
			}
			else
			{
				if (a.charAt(i) == (b.charAt(i))) //ai == bi
				{
					System.out.println(durchgang+") 3 i:"+i+"Kosten 0: "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
					durchgang++;
					i++;
				}
				else if (a.length() < i+1 && b.length() < i+1)
				{
					tmp = a.charAt(i);
					a = a.substring(0,i)+b.charAt(i)+a.substring(i+1);
					System.out.println(durchgang+") 4 i:"+i+"Kosten 1: Ersetze "+tmp+" durch "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
					durchgang++;
					i++;
				}
				else if (b.length() < i+1)
				{
					//if (a.charAt(i+1).equals(b.charAt(i))
					//{
						tmp = a.charAt(i);
						a = a.substring(0, a.length() - 1);
						System.out.println(durchgang+") 5 i:"+i+"Kosten 1: Loesche "+tmp+" an Position "+durchgang+" --> "+a);
						durchgang++;
						i++;
					//}
				}
				else if(a.length() < i+1)
				{
					//if (a.charAt(i).equals(b.charAt(i+1)
					//{
						a += b.charAt(i);
						System.out.println(durchgang+") 6 i:"+i+"Kosten 1: Fuege "+b.charAt(i)+" an Position "+durchgang+" ein --> "+a);
						durchgang++;
						i++;
					//}
				}
				else
				{
					if (a.charAt(i) == b.charAt(i+1))
					{
						a = a.substring(0,i)+b.charAt(i)+a.substring(i);
						System.out.println(durchgang+") 7 i:"+i+"Kosten 1: Fuege "+b.charAt(i)+" an Position "+durchgang+" ein --> "+a);
						durchgang++;
						i++;
					}
					else if (a.charAt(i+1) == b.charAt(i))
					{
						tmp = a.charAt(i);
						a = a.substring(0, i)+a.substring(i+1);
						System.out.println(durchgang+") 8 i:"+i+"Kosten 1: Loesche "+tmp+" an Position "+durchgang+" --> "+a);
						durchgang++;
						i++;
					}
					else
					{
						tmp = a.charAt(i);
						a = a.substring(0,i)+b.charAt(i)+a.substring(i+1);
						System.out.println(durchgang+") 9 i:"+i+"Kosten 1: Ersetze "+tmp+" durch "+b.charAt(i)+" an Position "+durchgang+" --> "+a);
						durchgang++;
						i++;
					}
				}
			}
		}
	}

	//22222222222222222222222222
	static int distance(String a, String b)
	{
		a = a.toLowerCase();
        	b = b.toLowerCase();
        	// i == 0
        	int [] costs = new int [b.length() + 1];
        	for (int j = 0; j < costs.length; j++)
            		costs[j] = j;
        	for (int i = 1; i <= a.length(); i++) 
		{
            		// j == 0; nw = lev(i - 1, j)
            		costs[0] = i;
            		int nw = i - 1;
            		for (int j = 1; j <= b.length(); j++) 
			{
                		int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                		nw = costs[j];
                		costs[j] = cj;
			}
            	}
        	return costs[b.length()];
	}

	//111111111111111111111111
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
					dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(a.charAt(i - 1), b.charAt(j - 1)), dp[i - 1][j] + 1, dp[i][j - 1] + 1);
			}
		}
 
    		return dp[a.length()][b.length()];
	}

	public static int costOfSubstitution(char a, char b) 
	{
        	return a == b ? 0 : 1;
    	}

	public static int min(int... numbers) 
	{
        	return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    	}
}
