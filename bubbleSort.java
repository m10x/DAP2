import java.util.Arrays; //Für Arrays.fill
import java.lang.Float;

public class bubbleSort {
	
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 1) // Nicht 1 Argument übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			
			long tStart, tEnd, msecs; //Zur Zeitmessung benötigt
			float ziel = Float.parseFloat(args[0]); //Das erste Argument legt die gewünschte Dauer fest
			float dauer = 0; //wielange brauch der Algorithmus?
			int groesse = 500; //array groesse

			while(dauer < ziel)
			{
				groesse = groesse * 2;

				int[] feld = new int[groesse]; //Erstelle Array
				fillArray(feld); //Fülle Array

				tStart = System.currentTimeMillis(); //Beginne Zeitmessung
		
				bubbleSort(feld);

				tEnd = System.currentTimeMillis(); //Ende Zeitmessung
				msecs = tEnd - tStart; //Berechne benötigte Zeit
				System.out.println("BubbleSort hat "+msecs+" Millisekunden benötigt, bei einer Array groesse von "+groesse);

				dauer = (float)msecs;
				dauer = dauer / 1000;
				System.out.println("Dauer "+dauer+"   Ziel "+ziel);
			}

			System.out.println("\n\nStarte Binäre Suche\n\n");
			
			int oben = groesse;
			int unten = groesse / 2;
			int mitte = oben - (unten / 2);
			System.out.println("Der Mittelwert von "+unten+" und "+oben+" ist "+mitte);

			while((ziel - dauer) > 0.1f || (dauer - ziel) > 0.1f)
			{
				int[] feld = new int[mitte]; //Erstelle Array
				fillArray(feld); //Fülle Array

				tStart = System.currentTimeMillis(); //Beginne Zeitmessung
		
				bubbleSort(feld);

				tEnd = System.currentTimeMillis(); //Ende Zeitmessung
				msecs = tEnd - tStart; //Berechne benötigte Zeit
				System.out.println("BubbleSort hat "+msecs+" Millisekunden benötigt, bei einer Array groesse von "+mitte);

				dauer = (float)msecs;
				dauer = dauer / 1000;
				System.out.println("Dauer "+dauer+"   Ziel "+ziel);

				if((ziel - dauer) < 0) //Müssen wir die untere Seite betrachten?
				{
					oben = mitte; //setze neues oben
					mitte = mitte - (( mitte - unten ) / 2); //berechne neue mitte
				}
				else //oder die obere
				{
					unten = mitte; // setze neues unten
					mitte = mitte + (( oben - mitte ) / 2); //berechne neue mitte
				}

			}

		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung 	der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava bubbleSort {dauer}\nwobei {dauer} eine Zahl größer 0 seien muss.\n");
			System.exit(0); //Beende Programm
		}
	}

	public static void bubbleSort(int[] feld)
	{
		int tmp;
		for (int i = 1; i < feld.length; i++) //gehe gesamtes array ab array[1] durch
		{
			for (int j = feld.length - 1; j >= i; j--) // gehe Array von hinten bis array[i] durch
			{
				if (feld[j-1] > feld[j]) //ist das das jetzige Feld größer als das nächste?
				{
					tmp = feld[j-1]; //speichere den Wert des aktuellen Feldes zwischen
					feld[j-1] = feld[j]; //Setze jetzige Array Stelle gleich die nächste
					feld[j] = tmp; //Nächste Array Stelle bekommt den zwischengespeicherten Wert der aktuellen
				}
			}
		}
	}

	public static void fillArray(int[] feld)
	{
		for (int i = 0; i < feld.length; i++) //Gehe das komplette Array durch
		{
			feld[i] = feld.length - i; //Fülle es absteigend
		}
	}
}
