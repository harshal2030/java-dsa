import java.util.ArrayList;

class Graph {
  private ArrayList<Vertex> vertices;
  private boolean isWeighted;
  private boolean isDirected;

  public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
    this.vertices = new ArrayList<Vertex>();
    this.isDirected = inputIsDirected;
    this.isWeighted = inputIsWeighted;
  }

  public Vertex addVertex(String data) {
    Vertex newVertex = new Vertex(data);
    this.vertices.add(newVertex);
    return newVertex;
  }

  public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
    if (!this.isWeighted) {
      weight = 0;
    }

    vertex1.addEdge(vertex2, weight);

    if (!this.isDirected) {
      vertex2.addEdge(vertex1, weight);
    }
  }

  public void removeEdge(Vertex vertex1, Vertex vertex2) {
    vertex1.removeEdge(vertex2);

    if (!this.isDirected) {
      vertex2.removeEdge(vertex1);
    }
  }

  public void removeVertex(Vertex vertex) {
    this.vertices.remove(vertex);
  }

  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }

  public boolean isWeighted() {
    return this.isWeighted;
  }

  public boolean isDirected() {
    return this.isDirected;
  }

  public Vertex getVertexByValue(String value) {
    for (Vertex vertex : this.vertices) {
      if (vertex.getData().equals(value)) {
        return vertex;
      }
    }

    return null;
  }

  public void print() {
    for (Vertex vertex : this.vertices) {
      vertex.print(this.isWeighted);
    }
  }

  public static void main(String[] args) {
    Graph busNetwork = new Graph(true, false);
    Vertex NMHStation = busNetwork.addVertex("Neemuch");
    Vertex INDBStation = busNetwork.addVertex("Indore");

    busNetwork.addEdge(NMHStation, INDBStation, 100);
    busNetwork.print();
  }
}
