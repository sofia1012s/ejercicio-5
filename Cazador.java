import java.util.ArrayList;

public class Cazador extends Jugador {

    protected String nombreMascota;
    private Mascota mascota;
    private Jugador jugador;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public Cazador(String nombre, int puntosVida, int poderAtaque, int turno, int items, String mascota) {
        super(nombre, puntosVida, poderAtaque, turno, items,3);
    }

    /**
     * @param op
     * @param enemigo
     */
    public void items(int op, Enemigo enemigo) {
        switch (op) {
            case 1: // Restaurar 10 puntos de vida
                int puntos = puntosVida + 10;
                setPuntosVida(puntos);
                items = items - 1;
                break;
            case 2: // Atacar con el doble de daño
                int poderBonus = poderAtaque * 2;
                int vidaEnemigo = enemigo.getPuntosVida();
                vidaEnemigo = vidaEnemigo - poderBonus;
                enemigo.setPuntosVida(vidaEnemigo);
                items = items - 1;
                break;

            case 3: // Se ataca al enemigo con su mismo poder de ataque
                vidaEnemigo = enemigo.getPuntosVida();
                int ataqueEnemigo = enemigo.getPoderAtaque();
                vidaEnemigo = vidaEnemigo - ataqueEnemigo;
                enemigo.setPuntosVida(vidaEnemigo);
                items = items - 1;
                break;
            default:
                break;
        }
    }

    /**
     * @param puntos
     */
    public void setPuntosVida(int puntos) {
        puntosVida = puntos;
    }

    /**
     * @param enemigo
     */
    public void atacar(Enemigo enemigo) {
        int vidaEnemigo = enemigo.getPuntosVida();
        vidaEnemigo = vidaEnemigo - poderAtaque;
        Mascota mascota = getMascota();
        int ataque = mascota.getPoderAtaque();
        vidaEnemigo = vidaEnemigo - ataque;

        enemigo.setPuntosVida(vidaEnemigo);
    }

    /**
     * @return int
     */
    public int getItems() {
        return items;
    }

    public void setMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public Mascota getMascota() {
        
        return mascotas.get(0);
    }
    
    public int getTipo() {
        return 3;
    }

}
