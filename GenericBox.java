package dcst;

public class GenericBox<T> {
    private final T value;
    public GenericBox(T value) { this.value = value; }
    public T getValue() { return value; }
}
