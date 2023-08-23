package grafo.aydacencia;
import java.util.*;
public class Menu {

	public void menu() {
		GrafoAdcia grafo = new GrafoAdcia(20);
        RecorridoProfundidad recorrido = new RecorridoProfundidad();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arco");
            System.out.println("3. Recorrido en profundidad");
            System.out.println("4. Buscar en lista de adyacencia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del vértice: ");
                    String nombreVertice = scanner.nextLine();
                    VerticeAdy nuevoVertice = new VerticeAdy(nombreVertice);
                    grafo.agregarVertice(nuevoVertice);
                    System.out.println("Vértice agregado: " + nuevoVertice.nomVertice());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del vértice origen: ");
                    String nombreOrigen = scanner.nextLine();
                    System.out.print("Ingrese el nombre del vértice destino: ");
                    String nombreDestino = scanner.nextLine();

                    VerticeAdy origen = grafo.buscarVertice(nombreOrigen);
                    VerticeAdy destino = grafo.buscarVertice(nombreDestino);

                    if (origen != null && destino != null) {
                        grafo.agregarArco(origen, destino);
                        System.out.println("Arco agregado entre " + origen.nomVertice() + " y " + destino.nomVertice());
                    } else {
                        System.out.println("Uno o ambos vértices no existen en el grafo.");
                    }
                    break;
                case 3:
                	System.out.print("Ingrese el nombre del vértice para iniciar el recorrido: ");
                    String nombreInicio = scanner.nextLine();
                    VerticeAdy inicio = grafo.buscarVertice(nombreInicio);

                    if (inicio != null) {
                        System.out.print("Recorrido en profundidad a partir de " + inicio.nomVertice() + ": ");
                        recorrido.RecorridoP(inicio);
                    } else {
                        System.out.println("El vértice de inicio no existe en el grafo.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del vértice origen: ");
                    String nombreOrigenBuscar = scanner.nextLine();
                    System.out.print("Ingrese el nombre del vértice destino: ");
                    String nombreDestinoBuscar = scanner.nextLine();

                    VerticeAdy origenBuscar = grafo.buscarVertice(nombreOrigenBuscar);
                    VerticeAdy destinoBuscar = grafo.buscarVertice(nombreDestinoBuscar);

                    if (origenBuscar != null && destinoBuscar != null) {
                        boolean adyacente = grafo.adyacente(origenBuscar, destinoBuscar);
                        System.out.println("¿Son adyacentes " + origenBuscar.nomVertice() + " y " + destinoBuscar.nomVertice() + "? " + adyacente);
                    } else {
                        System.out.println("Uno o ambos vértices no existen en el grafo.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
