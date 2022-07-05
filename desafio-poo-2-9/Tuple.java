public class Tuple<K, V, T> {
    private K first;
    private V second;
    private T third;

    public Tuple(K first, V second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public K first() {
        return this.first;
    }

    public V second() {
        return this.second;
    }

    public T third() {
        return this.third;
    }
}
