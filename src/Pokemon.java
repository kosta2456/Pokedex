public class Pokemon{
    private int attack;
    private int defense;
    private int speed;
    private String species;


    public Pokemon(String newSpecies){
        species = newSpecies;
        attack = (species.length() * 7 + 9);
        defense = (species.length() * 5 + 17);
        speed = (species.length() * 6 + 13);
    }
    //gets all the stats of the pokemon based on the species name length
    public java.lang.String getSpecies() {
        return species;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies;}

    public int getAttack() {
        return attack;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

    public int getDefense() {

        return defense;
    }
    public void setDefense(int newDefence){
        defense = newDefence;
    }
    public int getSpeed() {

        return speed;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    //gets the original value of attack defense and speed of a species and then changes that value as the species "evolves"
    public void SetEvolve(){
        setAttack(getAttack() * 2);
        setDefense(getDefense() * 4);
        setSpeed(getSpeed() * 3);
    }

}