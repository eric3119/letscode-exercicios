import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // n = 4, conexoes = [[0,1],[1,2],[2,0],[1,3]]

        int n = 4;
        List<List<Integer>> conexoes = new ArrayList<>();
        conexoes.add(List.of(0, 1));
        conexoes.add(List.of(1, 2));
        conexoes.add(List.of(2, 0));
        conexoes.add(List.of(1, 3));
        // conexoes.add(List.of(2, 4));

        List<List<Integer>> caminhosCriticos = new Solution().criticalConnections(n, conexoes);

        imprimeResultado(caminhosCriticos);

        // n = 2, connections = [[0,1]]

        n = 2;
        conexoes = new ArrayList<>();
        conexoes.add(List.of(0, 1));

        caminhosCriticos = new Solution().criticalConnections(n, conexoes);

        imprimeResultado(caminhosCriticos);
    }

    private static void imprimeResultado(List<List<Integer>> caminhosCriticos) {
        System.out.printf("[");
        for (int i = 0; i < caminhosCriticos.size(); i++) {
            final List<Integer> tuple = caminhosCriticos.get(i);

            System.out.printf("[");
            System.out.printf("%d, %d", tuple.get(0), tuple.get(1));
            System.out.printf("]");

            if (i < caminhosCriticos.size() - 1)
                System.out.printf(", ");
        }
        System.out.printf("]\n");
    }
}
