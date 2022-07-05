public class Main {
    public static void main(String[] args) {
        Travel travel = new GraphTravel();
        travel.addEdge("POA", "BSB");
        travel.addEdge("BSB", "SSA");
        travel.addEdge("BSB", "NAT");
        travel.addEdge("SSA", "NAT");
        travel.addEdge("SDU", "SSA");
        travel.addEdge("VCP", "SSA");
        travel.addEdge("SSA", "REC");
        travel.addEdge("GRU", "REC");
        travel.addEdge("GRU", "NAT");
        travel.addEdge("BSB", "GRU");
        travel.addEdge("GRU", "BSB");
        travel.addEdge("GRU", "POA");

        System.out.println(travel.isReachable("GRU", "REC", 0));
        System.out.println(travel.isReachable("POA", "REC", 1));
    }
}
