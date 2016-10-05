/*
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Integrantes:
 *  MartInez Ortiz SaUl Axel
 *  Nava Luján Francisco José
 * PROTECO, generaciOn 33
 * Java bAsico, proyecto 1
 * DescripciOn: VersiOn en java del juego de pokemon
 *  sin interfaz grafica
 * Recursos o fuentes:

 */

//import java.util.Scanner;
/**
 * <descripciOn>
 * @author paco 
 * @author saul
*/
class monstruoRaro extends MonstruoAgua{
    public void ataque2(Monstruo objetivo){}

    public static void main( String[] args ){
	monstruoRaro raro = new monstruoRaro();
	monstruoRaro monstruo2 = new monstruoRaro();
	monstruoRaro cosa = new monstruoRaro();

	System.out.println("El pokemon es: ");
	System.out.println(raro);
	System.out.println(monstruo2);
	System.out.println(cosa);
    }
}
