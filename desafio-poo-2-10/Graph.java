import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  class Graph {
    private int[] id;

    public Graph(int N) {
      id = new int[N];
      for (int i = 0; i < N; ++i) {
        id[i] = i;
      }
    }

    public int find(int p) {
      while (p != id[p]) {
        // path compression
        id[p] = id[id[p]];
        p = id[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int pid = find(p);
      int qid = find(q);

      id[qid] = pid;
    }

    public int getScc() {
      Set<Integer> seen = new HashSet<>();

      for (int i = 0; i < id.length; ++i) {
        seen.add(find(i));
      }

      return seen.size();
    }

    public int quantidadeDeComponentesFortementeConectados(int n, int[][] connections) {
      for (int[] conn : connections) {
        int u = conn[0];
        int v = conn[1];
        this.union(u, v);
      }

      int scc = this.getScc();

      return connections.length >= n - 1 ? scc : -1;
    }
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> caminhosCriticos = new ArrayList<>();

    for (int i = 0; i < connections.size(); i++) {
      Graph graph = new Graph(n);
      int[][] novosCaminhos = removeUmCaminhoDaListaDeCaminhos(connections, i);

      final boolean caminhoCritico = graph.quantidadeDeComponentesFortementeConectados(n, novosCaminhos) > 1;

      if (caminhoCritico) {
        caminhosCriticos.add(connections.get(i));
      }
    }

    return caminhosCriticos;
  }

  private int[][] removeUmCaminhoDaListaDeCaminhos(final List<List<Integer>> caminhos, int idxRemover) {
    int[][] novosCaminhos = new int[caminhos.size() - 1][2];

    int idx = 0;
    for (int j = 0; j < caminhos.size(); j++) {
      if (idxRemover == j)
        continue;

      novosCaminhos[idx][0] = caminhos.get(j).get(0);
      novosCaminhos[idx++][1] = caminhos.get(j).get(1);
    }

    return novosCaminhos;
  }
}