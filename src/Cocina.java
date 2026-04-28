import eventos.*;

public class Cocina implements Subscriber {
    private final EventBus bus;

    public Cocina(EventBus bus) {
        this.bus = bus;
        bus.suscribir(PedidoRealizadoEvent.class, this);
    }

    @Override
    public void onEvent(Object event) {
        if (event instanceof PedidoRealizadoEvent) {
            PedidoRealizadoEvent pedido = (PedidoRealizadoEvent) event;
            for (String item : pedido.items) {
                if (item.toLowerCase().contains("hamburguesa") || item.toLowerCase().contains("comida")) {
                    new Thread(() -> {
                        try {
                            Thread.sleep(5000); // 5 segundos
                            bus.publicar(new ComidaPreparadaEvent(pedido.pedidoId, item));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
        }
    }
}