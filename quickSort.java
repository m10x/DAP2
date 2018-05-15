import java.util.Random;
import java.util.Arrays;

public class Sortierung
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 1) // Keine Argumente übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			int laenge = Integer.parseInt(args[0]); //Das 1. Argument legt die Array länge fest
			assert laenge > 0 : laenge + " ist nicht groesser 0"; //Teste ob 1. Argument größer 0 ist
			int[] feld = new int[laenge]; //Erzeuge Array mit übergebenen länge
			Random numberGenerator = new Random(); //Erzeuge zufälligen Zahlen ersteller

			long tStart, tEnd, msecs; //Zur Zeitmessung benötigty

			for (int i = 0; i < feld.length; i++) //Gehe das komplette Array durch
			{
				feld[i] = numberGenerator.nextInt();
			}
			if (feld.length <= 100) //Ist die Feldlänge kleiner gleich 100? Dann gebe das Array aus bevor es sortiert wurde!
			{
				System.out.println(Arrays.toString(feld));
			}

			tStart = System.currentTimeMillis();
			quickSort(feld, 0, feld.length - 1);
			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;
			System.out.println("InsertionSort hat "+msecs+" Millisekunden benötigt.");

			if (isSorted(feld)) //Ist das Feld sortiert? Dann gebe dies durch eine Nachricht aus!
				System.out.println("Feld sortiert!\n");
			else //Das Feld ist also nicht sortiert? Dann gebe dies durch eine Nachricht aus!
				System.out.println("Feld NICHT sortiert!      ßn");

			if (feld.length <= 100) // Ist die Feldlänge kleiner gleich 100? Dann gebe das sortierte Array aus!
			{
				System.out.println(Arrays.toString(feld));
			}
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Sortierung {länge}\nwobei {länge} eine Zahl größer 0 seien muss.\n");
			System.exit(0);
		}

	}

	public static void quickSort(int[] array, int l, int r)
	{
		if (l < r)
		{
			int i = l;
			int j = r;
			int pivot = array[(l+r)/2];
			while (i <= j)
			{
				while (array[i] < pivot)
					i++;
				while (array[j] > pivot)
					j--;
				if (i <= j)
				{
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					i++;
					j--;
				}
			}
			quickSort(array, l, j);
			quickSort(array, i, r);
		}
	}

	public static boolean isSorted(int[] array) //Methode zum überprüfen, ob ein Array sortiert ist.
	{
		int aktuell = array[0]; //Speichere das erste Element des Arrays zwischen.
		for (int i = 1; i < array.length; i++) //Gehe das Array von der 2ten bis zur letzen Stelle durch!
		{
			if (aktuell > array[i]) //ist das aktuelle Element größer als das nächste? Dann ist das Array nicht sortiert!!
			{
				return false; //Gebe falsch zurück!
			}
			aktuell = array[i]; //Setze das zu vergleichende Element auf das nächste Element des Arrays!
		}
		return true; //Wenn die For-Schleiche durchgelaufen ist, ohne false zurückzugeben, ist das Array sortiert!
	}
}
