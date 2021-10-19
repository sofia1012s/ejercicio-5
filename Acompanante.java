public abstract class Acompanante extends Combatiente{

    protected String lider; 
    public Acompanante(String nombre, int puntosVida, int poderAtaque, int turno, int items, String lider) {
        super(nombre, puntosVida, poderAtaque, turno, items);
        //TODO Auto-generated constructor stub
    }

    public abstract void items(Enemigo enemigo, Jugador jugador);


    
}
