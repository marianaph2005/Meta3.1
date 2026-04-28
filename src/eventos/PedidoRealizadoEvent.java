package eventos;

import java.util.List;

public class PedidoRealizadoEvent {
    public final String mesaId;
    public final String pedidoId;
    public final List<String> items;

    public PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) {
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = List.copyOf(items); // Aseguramos que la lista sea inmutable
    }
}