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
 * algunas características especificas de los Monstruos
 * tipo eléctrico
 * @author paco 
 * @author saul
*/
public abstract class MonstruoElectrico extends Monstruo{
    // Constructores
    /**
     * Constructor genérico, puede crear Monstruos sin
     * argumentos
     */
    public MonstruoElectrico(){
	super( "electrico" );	
    }
    /**
     * Constructor complet
     * @param archTarjeta Objeto de tipo File con la ubicación de la
     * tarjeta del Monstruo
     * @param hpBase La vida base del monstruo
     * @param atqBase El ataque base del monstruo
     * @param defBase La defensa base del monstruo
     * @param velBase La velocidad base del monstruo
     * @param apodo El apodo del monstruo
     * @param nivel El nivel en que inicia el monstruo
     */
    public MonstruoElectrico(
	    File archTarjeta,
	    int hpBase,
	    int atqBase,
	    int defBase,
	    int velBase,
	    String apodo,
	    byte nivel
    ){
	super(
		"electrico",
		File archTarjeta,
		hpBase,
		atqBase,
		defBase,
		velBase,
		apodo,
		nivel
	);

    }

    /**
     * Método ataque1, que sobreescribe el método
     * abstracto con el mismo nombre de la clase monstruo
     * @param enemigo Monstruo al cual se va a realizar el ataque
     */
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
