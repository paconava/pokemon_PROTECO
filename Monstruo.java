/*
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Integrantes:
 *  MartInez Ortiz SaUl Axel
 *  Nava Luján Francisco José
 * PROTECO, generaciOn 33
 * Java bAsico, proyecto 1
 * FECHA 02/10/2016
 * DescripciOn: VersiOn en java del juego de pokemon
 *  sin interfaz grafica
 * Recursos o fuentes:

 */

//import java.util.Scanner;

/**
 * Clase abstracta Monstro que contiene un grupo de 
 * características y métodos que comparten los 
 *¨monstruos y un par de metodos abstractos para ser
 * definidas por las clases que hereden de esta
 * @author paco
 * @author saul
 */
public abstract class Monstruo{ 

    protected static final String TIPO; // Agua, fuego, hierba, elEctrico

    // Valores base para todo monstruo nivel 1 (aUn por definirse)
    protected static final int HP_BASE; // El hp de un monstruo nivel 1
    protected static final int ATAQUE_BASE; // El ataque de un monstruo nivel 1
    protected static final int DEFENSA_BASE; // La defensa de un monstruo nivel 1
    protected static final int VELOCIDAD_BASE; // La velocidad de un monstruo nivel 1
    
    // Tazas de aumento de atributos que otorgan las pociones
    //  aun por definir
    public static final int AUMENTO_HP = 0.2; // 20% 
    public static final int AUMENTO_ATAQUE =  0.10; // 10% 
    public static final int AUMENTO_DEFENSA = 0.15; // 15%

    // Constructor
    public int numGenericos = 0;
    public Monstruo(String apodo,String tipo,){ 
	
    }

    // Atributos
    protected String apodo;
    protected byte nivel; // 0 -- 100
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected String estado = "Ok";

    // el MEtodo recibirDaño venia  con ñ y lo deje igual
    /**
     * Método recibirDaño que le resta al monstruo que lo invoca
     * la cantidad de daño especificada en su argumento
     * @param danio Daño que le propina el monstruo adversario
     */
    protected void recibirDaño( int danio ){
	if(danio < 0){ danio = 0; }
	this.hp -= danio;
	if( this.hp <= 0 ){
	    this.estado = "Fuera de combate";    
	}
    }

    /**
     * Método recibirHp llamado cuando se usa una pocién
     */
    protected void recibirHp(){
	hp += (HP_BASE + nivel) * AUMENTO_HP;
    }

    /**
     * Método recibirAtaque llamado cuando se usa una poción
     */
    protected void recibirAtaque(){
	ataque += (ataque * AUMENTO_ATAQUE); 
    }

    /**
     * Método recibirDefensa llamado cuando se usa una poción
     */
    protected void recibirDefensa(){
	defensa += (defensa * AUMENTO_DEFENSA);
    }

    /**
     * Método que calcula el multiplicador que recibe el daño de que
     * dispone un monstruo al atacar a otro
     * @param objetivo Monstruo al cual se le va a realizar el ataque
     * @return Multiplicador que puede tener valor de 0.5, 1 o 2
     */
    protected double multiplicadorElemental( Monstruo objetivo ){
	if( this.TIPO.compareToIgnoreCase("fuego") == 0 ){
	    if( objetivo instanceof MonstruoHierva ){
		return 2;
	    }else if( objetivo instanceof MonstruoAgua || objetivo instanceof MonstruoFuego ){
		return 0.5;
	    }else{
		return 1;
	    } 
	}else if( this.TIPO.compareToIgnoreCase("agua") == 0 ){
	    if( objetivo instanceof MonstruoFuego ){
		return 2;
	    }else if( objetivo instanceof MonstruoAgua || objetivo instanceof MonstruoHierba ){
		return 0.5;
	    }else{
		return 1;
	    } 
	}else if( this.TIPO.compareToIgnoreCase("hierva") == 0 ){
	    if( objetivo instanceof MonstruoAgua ){
		return 2;
	    }else if( objetivo instanceof MonstruoHierba || objetivo instanceof MonstruoFuego){
		return 0.5;
	    }else{
		return 1;
	    } 
	}else if( this.TIPO.compareToIgnoreCase("electrico") == 0 ){
	    if( objetivo instanceof MonstuoAgua ){
		return 2;
	    }else if( objetivo instanceof MonstruoHierba || objetivo instanceof MonstuoElectrico ){
		return 0.5;
	    }else{
		return 1;
	    } 
	}
	return -1; // No conosco este nuevo tipo de pokEmon 
    }

    public abstract void ataque1(Monstruo objetivo);
    public abstract void ataque2(Monstruo objetivo);

    // Funciones estandar de consulta y modificaciOn
    public void setHp( int hp ){
	this.hp = hp;
    }
    public int getHp(){
	return this.hp;
    }
    public void setApodo( String apodo ){
	this.apodo = apodo;
    }
    public String getApodo(){
	return this.apodo;
    }
    public void setNivel( int nivel ){
	this.nivel = nivel;
    }
    public int getNivel(){
	return this.nivel;
    }
    public void setDefensa( int defensa ){
	this.defensa = defensa;
    }
    public int getDefensa(){
	return this.defensa;
    }
    public void setAtaque( int ataque ){
	this.ataque = ataque;
    }
    public int getAtaque(){
	return this.ataque;
    }
    public void setDefensa( int defensa ){
	this.defensa = defensa;
    }
    public int getDefensa(){
	return this.defensa;
    }
    public void setVelocidad( int velocidad ){
	this.velocidad = velocidad;
    }
    public int getVelocidad(){
	return this.velocidad;
    }
    public void setEstado( String estado ){
	this.estado = estado;
    }
    public String getEstado(){
	return this.estado;
    }
}