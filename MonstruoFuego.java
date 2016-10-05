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
 * Clase que extiende de Monstruo y lo extiende definiendo
 * algunas caractetísticas de forma específica para los 
 * monstruos de fuego
 * @author paco 
 * @author saul
*/
public abstract class MonstruoFuego extends Monstruo{
    // Constructor genErico
    public MonstruoFuego(){
	super( "fuego" );	
    }
    // Constructor completo
    public MonstruoFuego(
	    int hpBase,
	    int atqBase,
	    int defBase,
	    int velBase,
	    String apodo,
	    byte nivel
    ){
	super(
		"fuego",
		hpBase,
		atqBase,
		defBase,
		velBase,
		apodo,
		nivel
	);

    }

    public void ataque1(Monstruo enemigo){
	int danioInfringido;

	System.out.println("¡" + this.apodo + " realiza lanza llamas!");
	danioInfringido = calcDanio( enemigo );
	enemigo.recibirDaño( danioInfringido );
	System.out.println("El enemigo ha recibido: " + danioInfringido +
		" de daño en este turno"
	);

	if( enemigo.estado.compareToIgnoreCase("fuera de combate") == 0 ){
	    recibirExperiencia( enemigo );
	}
    }
}
