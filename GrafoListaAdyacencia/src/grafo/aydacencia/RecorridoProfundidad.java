package grafo.aydacencia;

public class RecorridoProfundidad {

	public void RecorridoP(VerticeAdy inicio) {
        boolean[] visitados = new boolean[GrafoAdcia.maxVerts];
        RecorridoPRecursivo(inicio, visitados);
    }

    private void RecorridoPRecursivo(VerticeAdy vertice, boolean[] visitados) {
        visitados[vertice.numVertice] = true;
        System.out.print(vertice.nomVertice() + " ");

        for (VerticeAdy adyacente : vertice.lad) {
            if (!visitados[adyacente.numVertice]) {
            	RecorridoPRecursivo(adyacente, visitados);
            }
        }
    }
}
