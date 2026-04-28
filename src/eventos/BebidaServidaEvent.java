package eventos;

public class BebidaServidaEvent {
    public final String mesaId;
    public final String bebida;

    public BebidaServidaEvent(String mesaId, String bebida) {
        this.mesaId = mesaId;
        this.bebida = bebida;
    }
}