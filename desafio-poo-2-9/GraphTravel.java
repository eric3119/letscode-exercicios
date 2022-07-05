import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphTravel implements Travel {

    Map<String, Set<String>> graph = new HashMap<>();
    Set<String> vertices = new HashSet<>();

    @Override
    public void addEdge(String from, String to) {
        vertices.add(from);
        vertices.add(to);
        Set<String> nos = graph.get(from);

        if (nos == null) {
            nos = new HashSet<>();
            graph.put(from, nos);
        }

        nos.add(to);
    }

    @Override
    public boolean isReachable(String from, String to, int numberConnections) {
        Queue<Tuple<String, Integer, Set<String>>> q = new LinkedList<>();

        Map<String, Boolean> visited = new HashMap<>();

        for (String key : vertices) {
            visited.put(key, false);
        }

        Tuple<String, Integer, Set<String>> noInicial = new Tuple<>(
                from,
                -1,
                graph.get(from));

        q.add(noInicial);

        while (!q.isEmpty()) {
            final Tuple<String, Integer, Set<String>> no = q.poll();
            final String noAtual = no.first();
            final Integer level = no.second();
            final Set<String> children = no.third();

            visited.replace(noAtual, true);

            if (noAtual.equals(to) && level == numberConnections)
                return true;

            if (children != null)
                for (String child : children) {
                    if (visited.get(child))
                        continue;

                    Tuple<String, Integer, Set<String>> addQueue = new Tuple<>(
                            child,
                            level + 1,
                            graph.get(child));
                    q.add(addQueue);
                }
        }

        return false;
    }

}
