/*
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Integrantes:
 *  MartInez Ortiz SaUl Axel
 *  Nava Luján Francisco José
 * PROTECO, generaciOn 33
 * Java bAsico, proyecto 1
 * FECHA DD/MM/AAAA
 * DescripciOn: VersiOn en java del juego de pokemon
 *  sin interfaz grafica
 * Recursos o fuentes:

 */

//import java.util.Scanner;

public abstract class Monstruo{ 
    // MAximos valores aun por decidirse
    public static final int MAX_HP;
    public static final int MAX_NIVEL;
    public static final int MAX_VELOCIDAD;
    // No estoy seguro si ataque y defensa tendran
    //  valor mAximo
    
    // Tazas de aumento de las pociones aun por definir
    public static final int AUMENTO_HP = 1 + 20/100; // 20% o + 0.2
    public static final int AUMENTO_ATAQUE =  1 + 20/100; // 20% o + 0.2
    //public static 


    protected int hp;
    protected String apodo;
    protected byte nivel; // 0 -- 100
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected String estado = "Ok";
    protected String tipo;
    protected String debilidad;

    // Medodo recibirDaño venia  con ñ y lo deje igual
    public void recibirDaño( int danio ){
	this.hp -= danio;
	if( this.hp <= 0 ){
	    this.estado = "Fuera de combate";    
	}
    }

    public void recibirHp(){
	if( (hp + MAX_HP * AUMENTO_HP) < MAX_HP ){
	    this.hp += MAX_HP * AUMENTO_HP;
	}else{
	    this.hp = MAX_HP;
	}
    }

    public void recibirAtaque(){
	ataque *= AUMENTO_ATAQUE; 
    }

    public void recibirDefensa(){
	defensa *= AUMENTO_DEFENSA;
    }

    public int multiplicadorElemental( Monstruo objetivo ){
	if( this.tipo == objetivo.debilidad ){
	    return this.ataque * ();
	}
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
