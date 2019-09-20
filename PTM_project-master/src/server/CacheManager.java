package server;

public interface CacheManager {
    /**
     * Check either if the problem is already in cache or not.
     * @param problem
     * @return true if already exists.
     */
    Boolean check(String problem);
    //TODO: fill this java doc;
    /**
     *
     * @param problem
     * @param solution
     */
    void save(String problem,String solution);

    //TODO:

    /**
     *
     * @param problem
     * @return
     */
    String load(String problem);




}
