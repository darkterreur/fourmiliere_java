package modele;

import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.PrintWriter;

/**
 * Permet d'écrire et de lire dans un fichier
 * 
 */
public class Fichier
{
	/**
	 * Ecriture
	 * @param path
	 * @param text
	 */
	public static void ecrire(String path, String text) 
	{
		PrintWriter ecri ;
		
		try {
			ecri = new PrintWriter(new FileWriter(path));
			
			ecri.print(text);
			ecri.flush();
			ecri.close();
		} catch (NullPointerException a) {
			System.out.println("Erreur : pointeur null");
		} catch (IOException a) {
			System.out.println("Problème d'IO");
		}
	}
 
	/**
	 * Lecture
	 * @param path
	 * @return
	 */
	public static String lire (String path) 
	{
		BufferedReader lect ;
		String tmp = "";
		
		try {
			lect = new BufferedReader(new FileReader(path));
			
			while (lect.ready()==true) {
				tmp += lect.readLine()+System.getProperty("line.separator"); 
			}
		} catch (NullPointerException a) {
			System.out.println("Erreur : pointeur null");
		} catch (IOException a) {
			System.out.println("Problème d'IO");
		}
		
		return tmp;
	} 
}