package eventos;

public class ComidaPreparadaEvent {
    public final String pedidoId;
    public final String plato;

    public ComidaPreparadaEvent(String pedidoId, String plato) {
        this.pedidoId = pedidoId;
        this.plato = plato;
    }
}