public class Euclid {

	public static void main(String[] args)
	{
		try
		{
			int arg1 = Integer.parseInt(args[0]); // Wandle beide Argumente in einen Integer um
			int arg2 = Integer.parseInt(args[1]); // SAME ^
			System.out.println(EUCLID(arg1,arg2)); // Gebe den größten gemeinsamen Teiler aus, durch rekursiven aufruf von der Methode Euclid
		}
		catch (Exception e) // Fange Exceptions ab ( Wenn falscher Parameter typ übergeben wurde )
		{
			System.out.println("Falsche Parameter übergeben. Bitte benutze das Programm wie folgt:\njava Euclid zahl1 zahl2"); // Sende Fehlermeldung
			System.exit(0); // Beende Programm wenn falsche Parameter übergeben
		}
	}
	
	public static int EUCLID(int a, int b)
	{
		if ( b == 0 )            // Wenn b 0 ist, gebe a zurück
			return a;
		else			// ansonsten gib b und a modulo b zurück
			return EUCLID(b, a%b);
	}
}
