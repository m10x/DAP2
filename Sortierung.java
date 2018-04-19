import java.util.Random;
import java.util.Arrays;

public class Sortierung
{
	public static void main(String[] args)
	{
		try
		{
			int laenge = Integer.parseInt(args[0]); //Das 1. Argument legt die Array länge fest
			assert laenge > 0 : laenge + " ist nicht groesser 0"; //Teste ob 1. Argument größer 0 ist
			int[] feld = new int[laenge]; //Erzeuge Array mit übergebenen länge
			Random numberGenerator = new Random(); //Erzeuge zufälligen Zahlen ersteller

			long tStart, tEnd, msecs; //Zur Zeitmessung benötigt

			boolean merge = true; //Soll merge- oder insertionSort benutzt werden?

			for (int i = 0; i < feld.length; i++) //Gehe das komplette Array durch
			{
				if (args.length == 3) //Wurden 3 Argumente übergeben?
				{
					if (args[1].equals("insert")) //Ist das 2. Argument 'insert'? Dann soll insertionSort benutzt werden, und nicht merge!
						merge = false;
					else if (!args[1].equals("merge")) //Ist das 2. Argument auch nicht gleich 'merge'? Dann wurden falsche Argumente übergeben! Löse Exception aus
						throw new Exception("Falsche Argumente übergeben!");
					if (args[2].equals("auf")) //Wenn das 3. Argument 'auf' ist, fülle das Array austeigend von 1 bis Array Länge!
						feld[i] = 1 + i;
					else if (args[2].equals("ab")) //Wenn das 3. Argument 'ab' ist, fülle das Array absteigend von Array Länge bis 1!
						feld[i] = feld.length - i;
					else if (args[2].equals("rand")) //Wenn das 3. Argument 'rand' ist, fülle das Array mit zufällig generierten Zahlen!
						feld[i] = numberGenerator.nextInt();
					else //Wenn keines der 3 vorherigen Optionen auf das 3. Argument zutrifft, wurden falsche Argumente übergeben! Löse Exception aus!
						throw new Exception("Falsche Argumente übergeben!");

				}
				else if (args.length == 1) // Wurde nur 1 Argument übergeben? Dann bleibt merge = true und das Feld wird mit zufällig generierten Zahlen gefüllt!
					feld[i] = numberGenerator.nextInt();
				else // Wurde nicht 1 oder 3 Argumente übergeben? Fehler! Löse Exception aus!
					throw new Exception("Falsche Argumente übergeben!");
			}
			if (feld.length <= 100) //Ist die Feldlänge kleiner gleich 100? Dann gebe das Array aus bevor es sortiert wurde!
			{
				System.out.println(Arrays.toString(feld));
			}

			if (merge) //Ist merge=true? Dann sortiere nach dem MergeSort Algorithmus und messe die Zeit!
			{
				tStart = System.currentTimeMillis();
				mergeSort(feld);
				tEnd = System.currentTimeMillis();
				msecs = tEnd - tStart;
				System.out.println("MergeSort hat "+msecs+" Millisekunden benötigt.");
			}
			else //merge ist also false? Dann sortiere nach dem InsertionSort Algorithmus und messe die Zeit!
			{
				tStart = System.currentTimeMillis();
				insertionSort(feld);
				tEnd = System.currentTimeMillis();
				msecs = tEnd - tStart;
				System.out.println("InsertionSort hat "+msecs+" Millisekunden benötigt.");
			}

			if (isSorted(feld)) //Ist das Feld sortiert? Dann gebe dies durch eine Nachricht aus!
				System.out.println("Feld sortiert!");
			else //Das Feld ist also nicht sortiert? Dann gebe dies durch eine Nachricht aus!
				System.out.println("Feld NICHT sortiert!");

			if (feld.length <= 100) // Ist die Feldlänge kleiner gleich 100? Dann gebe das sortierte Array aus!
			{
				System.out.println(Arrays.toString(feld));
			}
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Sortierung {länge} {{insert/merge} auf/ab/rand}\nwobei {länge} eine Zahl größer 0 seien muss.");
			System.exit(0);
		}

	}

	public static void mergeSort(int[] array) 
	{
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length-1);
		assert isSorted(array);
	}

	public static void mergeSort(int[] array, int[] tmpArray, int left, int right) 
	{
		System.out.println("MergeSort wurde ausgeführt!!");
		if (left < right)
		{
			int middle = (left + right) / 2;
			mergeSort(array, tmpArray, left, middle);
			mergeSort(array, tmpArray, middle + 1, right);
		}
	}

	public static void insertionSort(int[] array) //Methode zum sortieren eines Arrays nach InsertionSort Algorithmus!
	{
		int key; //Für das aktuell einzusortierende Element
		for (int j = 1; j < array.length; j++) //Gehe das gesamte Array ab der 2. Stelle durch!
		{
			key = array[j]; //Zwischenspeichere das aktuelle Array Element!
			int i = j;
			while (i > 0 && array[i - 1] > key)
			{
				array[i] = array[i - 1];
				i = i - 1;
			}
			array[i] = key;
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
