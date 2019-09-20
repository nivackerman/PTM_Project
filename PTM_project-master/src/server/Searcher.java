package server;

public interface Searcher {
    Backtrace search(Searchable<State> searchable);
}
