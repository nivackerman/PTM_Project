package server;

/**
 * receive's a string and return's the revers'ed string.
 */
public class StringReverser implements Solver<String,String> {
    @Override
    public String solve(String problem) {
        return new StringBuilder(problem).reverse().toString();
    }

    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.solve("asaf"));
    }
}
