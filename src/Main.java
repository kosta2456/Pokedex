import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main extends Pokedex{
    public Main(int numberPokemon) {
        super(numberPokemon);
    }

    public static void main(String[] args) {
        int menu = 2;
        int menuOption = 0;
        String species = "";
        ArrayList<String> evolvePokemon = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your new PokeDex!");
        System.out.print("How many Pokemon are in your region?: ");
        boolean error = true;
        int pokedexSize = 0;
        //This is a while loop to check for error in the users input when trying to initialize the size of the array.
        while(error) {
            if (scan.hasNextInt()) {
                pokedexSize = scan.nextInt();
                error = false;
            }
            else {
                System.out.println("\n" + "That is not a valid choice. Try again." + "\n");
                System.out.print("How many Pokemon are in your region?: ");
                scan.next();
                error = true;
            }
            }
            //Pokedex is called upon and the array size is created based on the user input.
            Pokedex get = new Pokedex(pokedexSize);
            get.numberPokemon = pokedexSize;
            System.out.print("\n" + "Your new Pokedex can hold " + get.numberPokemon + " Pokemon. Let's start using it!" + "\n");
            menu = 1;

            while (menu == 1) {
                System.out.println("1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check a Pokemon's Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit");
                System.out.print("\n" + "What would you like to do? ");
                menu = 2;
                //error catching to see if a user inputs something that is not an int
                try {
                    menuOption = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\n" + "That is not a valid choice. Try again." + "\n");
                    menu = 1;
                    scan.next();
                    continue;
                }
                //Calls method listpokemon and get the list of user inputed pokemon
                if (menuOption == 1) {
                    if (get.pokemonNames.size() == 0) {
                        System.out.println("Empty" + "\n");
                        menu = 1;
                    } else {
                        get.listPokemon();
                        System.out.print("\n");
                        menu = 1;
                    }

                    //This adds poekmon to the array. It first checks to see if the array is full
                    //then it checks for duplicates. If non of those occur then the user input is
                    //added as a new pokemon
                } else if (menuOption == 2) {
                    System.out.print("\n" + "Please enter the Pokemon's Species: ");
                    species = scan.next();
                    System.out.print("\n");
                    if (get.pokemonNames.size() >= get.numberPokemon){
                        System.out.println("Max");
                    }
                    else if(cancelCasing(species, get.pokemonNames)){
                        System.out.println("Duplicate" + "\n");
                    }
                    get.addPokemon(species);
                    menu = 1;

                    //This will get the stats of a pokemon. If the pokemon has been evolved then it will pull its stats from the
                    // evolved pokemon array whose value changes the more you evolve it. Else if the species has not been evolved it
                    //will return the value of the the attack defense and speed based on the string species length based on the check
                    //stats method
                } else if (menuOption == 3) {
                    System.out.print("\n" + "Please enter the Pokemon of interest: ");
                    species = scan.next();
                    System.out.print("\n");
                    int pokemonStat[];
                    if (cancelCasing(species, get.pokemonNames)) {
                        if (cancelCasing(species, evolvePokemon)) {
                            Pokemon evolvedPokemon = new Pokemon(species);
                            evolvedPokemon.SetEvolve();
                            System.out.println("The stats for " + species + " are:");
                            System.out.println("Attack: " + evolvedPokemon.getAttack());
                            System.out.println("Defense: " + evolvedPokemon.getDefense());
                            System.out.println("Speed: " + evolvedPokemon.getSpeed());
                            evolvePokemon.remove(species);
                            menu = 1;
                        } else {
                            pokemonStat = get.checkStats(species);
                            System.out.println("The stats for " + species + " are:");
                            System.out.println("Attack: " + pokemonStat[0]);
                            System.out.println("Defense: " + pokemonStat[1]);
                            System.out.println("Speed: " + pokemonStat[2]);
                            System.out.print("\n");
                            menu = 1;
                        }
                    } else {
                        System.out.print("Missing");
                        System.out.print("\n");
                        menu = 1;
                    }
                    //this method will evolve a pokemon if it exists in the orignal array and then it will change its values
                    //based on the evolve pokemon method
                } else if (menuOption == 4) {
                    System.out.print("\n" + "Please enter the Pokemon of interest: ");
                    species = scan.next();
                    System.out.print("\n");
                    if (cancelCasing(species, get.pokemonNames)) {
                        get.evolvePokemon(species);
                        evolvePokemon.add(species);
                        System.out.println(species + " has evolved!");
                        menu = 1;
                    } else {
                        System.out.print("Missing");
                        System.out.print("\n");
                        menu = 1;
                    }
                //this will run the sort pokedex method and will sort all the objects in the array in alphebetical order.
                } else if (menuOption == 5) {
                    get.sortPokedex();
                    menu = 1;
                //exits the program
                } else if (menuOption == 6) {
                    return;
                //checks for a user input that is an integer put is out of bounds.
                } else {
                    System.out.println("\n" + "That is not a valid choice. Try again." + "\n");
                    menu = 1;
                }

            }

        }



    }





