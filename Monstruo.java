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
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

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
    public Monstruo( String tipo ) {
	++numGenericos;
	this.TIPO = tipo;
	this.HP_BASE = 15 + (int)(Math.random()*10);
	this.ATAQUE_BASE = 10 + (int)(Math.random()*10);
	this.DEFENSA_BASE = 10 + (int)(Math.random()*10);
	this.VELOCIDAD_BASE = 10 + (int)(Math.random()*10);
	this.apodo = "Pokemon genérico " + numGenericos;
	this.nivel = 1;
	this.estado = "ok";
	this.expNecesaria = 100;
    }

    public Monstruo(
	    String tipo,
	    int hpBase,
	    int ataqueBase,
	    int defBase,
	    int velBase,
	    String apodo,
	    byte nivel
    ){ 
	this.TIPO = tipo;
	this.HP_BASE = hpBase;
	this.ATAQUE_BASE = hpBase;
	this.DEFENSA_BASE = defBase;
	this.VELOCIDAD_BASE = velBasE;
	this.apodo = apodo;
	this.nivel = nivel;
	this.estado = "ok";
	this.expNecesarioa = 100 * nuvel;
    }

    // Atributos
    protected String apodo;
    protected byte nivel; // 0 -- 100
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected String estado = "Ok";
    protected int expNecesaria;

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
    
    /**
     * Método aplicado cuando un monstruo derrota a otro
     * por lo cual recibé cierta cantidad de experiencia
     * posibilitandole así subir de nivel
     * @param vencido Monstruo que se acaba de derrotar 
     * para acerse acreedor de experiencia
     */
    public void recibirExperiencia( Monstruo vencido ){
	// Se recibe 100 por un Monstruo nivel 1, 150 por el nivel 2
	//  200 por el nivel 3 etc..
	expNecesaria -= (vencido.nivel * 50 + 50);
	//Si la expNecesarioa es menor a 0 se pasa de nivel
	if( expNecesaria <= 0 ){
	    ++nivel;    
	    expNecesaria += 100*nivel;
	    System.out.println("Felicitaciones, tu "+
		    this.getClass().getName() + "\"" + apodo"\"" +
		    "ha subido al nivel: " + nivel
	    );
	}
    }
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

    // Sobreescritura del mEtodo toString de pokEmon que imprime sus 
    //  datos en tarjeta ascii
    public String toString(){
	File tarjetaPokemon = new File("./monstruos_ascii/pokemon1.txt");
	String espacio = r(" ",25); // 25 espacios
	try{
	    FileReader fr = new FileReader( tarjetaPokemon );
	    BufferedReader br = new BufferedReader( fr );
	    for( int i = 1; i <= 17; ++i ){
		System.out.println(espacio + br.readLine());
	    }
	    String mons = this.getClass().getName();
	    int espacio = mons.length();
	    String rd = r(".",espacio/2 + espacio %2);
	    String ri = r(".",espacio/2);
	    System.out.println("|"+rd+mons+ri+"|");
	    System.out.println(espacio + br.readLine());

	    fr.close();
	    br.close();
	}catch(FileNotFoundException fnfe){
	    System.out.println("Tarjeta de monstruo no encontrada");    
	}catch(IOException ioe){
	    System.out.println("Error al leer la tarjeta de monstruo");   
	}

    }

    public static r(String c,int n){
	String r = "";
	for(int i = 1; i <= n; ++i){
	    r += "c";
	} 
	return r;
    }
}
