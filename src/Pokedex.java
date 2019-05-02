import java.util.ArrayList;
import java.util.Collections;

public class Pokedex implements PokedexInterface {
    int numberPokemon = 0;
    int[] pokemonStats;
    ArrayList<String> pokemonNames = new ArrayList<>();

//default constructor
    public Pokedex(int numberPokemon){
        this.numberPokemon=numberPokemon;
        pokemonStats =  new int[3];
       }


       //gets the pokemon from the array. First is checks the size of the initialized array.
       // It then goes onto the array and lists them in order of how they were inputed.
       // The order changes when the user uses the sort pokemon method
    public String[] listPokemon() {
        if (pokemonNames.size() == 0){
            return null;
        }
        String[] pokemonList = new String[numberPokemon];
        for (int x = 0; x < pokemonNames.size(); x++) {
            pokemonList[x] = pokemonNames.get(x);
            System.out.println((x + 1) + ". " + pokemonList[x]);
        }
        if(pokemonList.length == 0){
            return null;
        }
        else {
            return pokemonList;
        }
    }

    //adds pokemon to the pokedex array and checks for duplicates while ignoring the case
    public boolean addPokemon(String species) {
        if (pokemonNames.size() >= numberPokemon) {
            return false;
        } else {
            if (cancelCasing(species, pokemonNames)) {
                return false;
            } else {
                pokemonNames.add(species);
                return true;
            }
        }
    }

    //pulls the stats of a pokemon based on class pokemon and initializes thier values based on String species length.
    public int[] checkStats(String species){
if(cancelCasing(species, pokemonNames)){
        Pokemon getStats = new Pokemon(species);
        pokemonStats[0] = getStats.getAttack();
        pokemonStats[1] = getStats.getDefense();
        pokemonStats[2] = getStats.getSpeed();
        return pokemonStats;
    }
        else{
            int[] nullArray = null;
            return nullArray;
    }
    }

    //puts the list of pokemon in order
    public void sortPokedex()
    {
        Collections.sort(pokemonNames, String.CASE_INSENSITIVE_ORDER);
    }


    //Calls to pokemon and then gets the evolved stats of the pokemon the user inputs if it is in the array.
    //if its not on the array it will return false
    public boolean evolvePokemon(String species){
        if (cancelCasing(species, pokemonNames))
        {
            Pokemon getStats = new Pokemon(species);
            getStats.SetEvolve();
            return true;
       }
       else
        {
            return false;
        }

    }

    //Code adapted from user Rahul https://stackoverflow.com/users/1871769/rahul
    //Date written(December 24, 2012)
    // https://stackoverflow.com/questions/14018478/string-contains-ignore-case
    //This is a method that will get rid of casing when a user inputs the species and for
    //comparing the string to others in the array to check for duplicates.
    static boolean cancelCasing(String species, ArrayList<String> pokemonNames) {
        for (String x : pokemonNames) {
            if (x.equalsIgnoreCase(species)) {
                return true;
            }
        }
        return false;
    }



}



