public class Edge {
  private Vertex startVertex;
  private Vertex endVertex;
  private Integer weight;

  public Edge(Vertex startVertex, Vertex endVertex, Integer weight) {
    this.startVertex = startVertex;
    this.endVertex = endVertex;
    this.weight = weight;
  }

  public Vertex getStart() {
    return this.startVertex;
  }

  public Vertex getEnd() {
    return this.endVertex;
  }

  public Integer getWeight() {
    return this.weight;
  }
}
