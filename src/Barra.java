import eventos.*;

public class Barra implements Subscriber {
    private final EventBus bus;

    public Barra(EventBus bus) {
        this.bus = bus;
        bus.suscribir(PedidoRealizadoEvent.class, this);
    }

    @Override
    public void onEvent(Object event) {
        if (event instanceof PedidoRealizadoEvent) {
            PedidoRealizadoEvent pedido = (PedidoRealizadoEvent) event;
            for (String item : pedido.items) {
                if (item.toLowerCase().contains("cerveza") || item.toLowerCase().contains("bebida")) {

                    System.out.println("[BARRA] Se recibió la orden de la " + pedido.mesaId + ". Preparando: " + item + " (Tomará 2 segundos...)");

                    new Thread(() -> {
                        try {
                            Thread.sleep(2000); // 2 segundos
                            bus.publicar(new BebidaServidaEvent(pedido.mesaId, item));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
        }
    }
}