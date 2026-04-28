import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1 - Inicializar el Event Bus
        EventBus bus = new EventBus();

        // 2 - Inicializar los Componentes (Se suscriben internamente)
        Barra barra = new Barra(bus);
        Cocina cocina = new Cocina(bus);
        PanelLED panel = new PanelLED(bus);
        SistemaDeSonido sonido = new SistemaDeSonido(bus);
        SistemaDePedidos pedidos = new SistemaDePedidos(bus);
        Banda banda = new Banda(bus);

        // 3 - Simular el flujo
        System.out.println("--- Iniciando Taberna del Gólem Alquímico ---\n");

        // Pedido de comida y bebida
        pedidos.recibirPedido("Mesa 5", "pedido123", Arrays.asList("1 Cerveza", "1 Hamburguesa"));

        // La banda toca música en paralelo
        banda.tocarCancion("Los Seguidores de Dijkstra", "El Algoritmo del Amor", 180);

        // el hilo principal espera un poco para que los hilos de Barra y Cocina terminen de imprimir
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Fin Simulación---");
    }
}