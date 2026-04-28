import java.util.List;
import eventos.*;

public class SistemaDePedidos {
    private final EventBus bus;

    public SistemaDePedidos(EventBus bus) {
        this.bus = bus;
    }

    public void recibirPedido(String mesa, String pedidoId, List<String> items) {
        System.out.println("[SISTEMA DE PEDIDOS] Nueva orden de " + mesa + " | Pedido: " + pedidoId + " | Ítems: " + items);

        bus.publicar(new PedidoRealizadoEvent(mesa, pedidoId, items));
    }
}