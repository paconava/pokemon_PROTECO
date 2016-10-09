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

import java.util.Scanner;
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
	monstruoRaro monstruo4 = new monstruoRaro();
	new Scanner(System.in).nextLine();
	

	System.out.println("El pokemon es: ");
	System.out.println(raro);
	System.out.println(monstruo2);
	System.out.println(cosa);

	try{
	System.out.println("Ahí va la animación");
	Thread.sleep(1000);
	raro.animarDanio( (byte) 0);
	Thread.sleep(1000);
	monstruo2.animarDanio( (byte) 1);
	Thread.sleep(1000);
	cosa.animarDanio( (byte) 2);
	Thread.sleep(1000);
	monstruo4.recibirHp();
	}catch(Exception e){}
    }
}
