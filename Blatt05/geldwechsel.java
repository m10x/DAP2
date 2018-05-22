import java.util.Arrays;
import java.util.*;

public class geldwechsel
{

	public static void main(String[] args)
	{
		try
		{
			if (args.length != 2) // Keine Argumente übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			if (args[0].equals("Euro"))
			{
				System.out.println("Euro wurde als Währung ausgewählt\n");
				int[] w = {200,100,50,20,10,5,2,1};
				int[] wechselgeld = change(Integer.parseInt(args[1]),w);
				System.out.println(Arrays.toString(wechselgeld));
			}
			else if (args[0].equals("Alternative"))
			{
				System.out.println("Alternative wurde als Währung aushewählt");
				int[] w = {200,100,50,20,10,5,4,2,1};
				int[] wechselgeld = change(Integer.parseInt(args[1]),w);
				System.out.println(Arrays.toString(wechselgeld));
			}
			else
				throw new Exception("Falsche Währung übergeben!");
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava geldwechsel {Euro/Alternative} {Geldmenge}\nwobei {Geldmenge} eine Zahl größer 0 seien muss.\n");
			System.exit(0);
		}
	}

	public static int[] change(int b,int[] w)
	{
		int i = 0;
		List<Integer> ints = new ArrayList<Integer>(); //Benutze Variable Liste
		while (b != 0)
		{
			if (i == w.length)
			{
				System.out.println("Bei der Berechnung des Wechselgeldes ist etwas schief gelaufen");
				System.exit(0);
			}
			if (b - w[i] >= 0)
			{
				b = b - w[i];
				ints.add(w[i]);
			}
			else
				i++;
		}
		int[] wechselgeld = new int[ints.size()]; //Kopiere inhalt von liste in array
		for (int j = 0; j < ints.size(); j++)
			wechselgeld[j] = ints.get(j);

		return wechselgeld;
	}
}
