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
 * Clase que hereda de Monstruo y lo extiende definiendo
 * algunas características especificas de los Monstruos
 * tipo eléctrico
 * @author paco 
 * @author saul
*/
public abstract class MonstruoElectrico extends Monstruo{
    // Constructor genErico
    public MonstruoElectrico(){
	super( "electrico" );	
    }
    // Constructor completo
    public MonstruoElectrico(
	    int hpBase,
	    int atqBase,
	    int defBase,
	    int velBase,
	    String apodo,
	    byte nivel
    ){
	super(
		"electrico",
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

	System.out.prinlnt("¡" + this.apodo + "realiza latigazo");
	danioInfringido = causarDanio( enemigo );
	System.out.println("El enemigo ha recibido: " + danioInfringido +
		" de daño en este turo"
	);

	if( enemigo.estado.compareTo("fuera de combate") == 0 ){
	    recibirExperiencia( enemigo );
	}
    }
}
