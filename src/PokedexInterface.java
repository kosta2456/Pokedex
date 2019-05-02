
public interface PokedexInterface{

    String[] listPokemon();

    public boolean addPokemon(String species);

    int[] checkStats(String species);

    void sortPokedex();

    boolean evolvePokemon(String species);





}