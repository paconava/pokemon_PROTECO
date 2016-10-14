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
import java.io.File;

/**
 * Clase que hereda de Monstruo y lo extiende definiendo
 * algunas características específicas de los monstruos
 * tipo hierba
 * @author paco 
 * @author saul
*/
public abstract class MonstruoHierba extends Monstruo{
    // Constructor genErico
    public MonstruoHierba(){
	super( "hierba" );	
    }
    // Constructor completo
    public MonstruoHierba(
	    int hpBase,
	    int atqBase,
	    int defBase,
	    int velBase,
	    String apodo,
	    byte nivel
    ){
	super(
		"hierba",
		hpBase,
		atqBase,
		defBase,
		velBase,
		appodo,
		nivel
	);

    }

    public void ataque1(Monstruo enemigo){
	int danioInfringido;

	System.out.println("¡" + this.apodo + "realiza impactrueno");
	danioInfringido = causarDanio( enemigo );
	System.out.pritln("El enemigo ha recibido: " + danioInfringido +
		" de naño en este turno"
	);

	if( enemigo.estado.compareTo("fuera de combate") == 0 ){
	    recibirExperiencia( enemigo );    
	}
    }
}
