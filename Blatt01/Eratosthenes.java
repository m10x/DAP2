import java.util.Arrays; //Für Arrays.fill

public class Eratosthenes {
	
	public static void main(String[] args)
	{
		int arg1 = 0;
		try
		{
			arg1 = Integer.parseInt(args[0]); // mache das erste Argument zu einem Integer,
							  // damit gerechnet werden kann.
		}
		catch (Exception e)
		{
			System.out.println ("Es wurde ein ungültiger Parameter übergeben. Bitte benutze das Programm wie folgt:\njava Eratosthenes zahl ODER java Eratosthenes zahl -o");
			System.exit(0); // Beende Programm wenn falscher Paramter Typ übergeben wurde
		}

		boolean[] isPrime = new boolean[arg1 + 1];// Erstelle Boolean Array in der übergebenen Größe
		Arrays.fill(isPrime, true); 	      // Setze alles auf Wahr
		int countz = 0;			      // Zum zählen der Primzahlen
		String primz = "";		      // Zum auflisten der Primzahlen
		
		for ( int i = 2; i < arg1; i++)	      // Gehe alle Zahlen von 2 bis einschließlich vom Argument Übergeben durch
		{
			for ( int j = 2; j < i; j++)  // Gehe alle Zahlen von 2 bis vom Argument Übergeben durch
			{
				if (i % j == 0)       // Prüfe ob i vielfaches von j ist
					isPrime[i] = false; // Wenn wahr, dann ist i keine Primzahl und wird auf false gesetzt
			}
			if (isPrime[i])			// wenn i Primzahl ist, erhöhe den Zähler countz und füge Zahl in den String primz ein
			{
				countz++;
				primz += i + ",";
			}
		}
		System.out.println("Anzahl: " + countz + "\n"); // Gebe Anzahl der gefundenen Primzahlen aus
		if (args.length == 2 && args[1].equals("-o")) // Überprüfe ob 2ter Parameter vorhanden, wenn wahr dann überprüfe ob der 2te Parameter "-o" ist
			System.out.println("Primzahlen: " + primz); // Gebe alle gefundenen Primzahlen aus
	}
}
