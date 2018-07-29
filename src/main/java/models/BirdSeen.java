package models;

//modeled on class lecture and demo
//model of way to track my birding life list
public class BirdSeen {
    private static int COUNT = 1;

    public String speciesName;
    public String locationSeen;
    public String dateSeen;
    public int id;

    public BirdSeen(String speciesName, String locationSeen, String dateSeen){
        this.speciesName = speciesName;
        this.locationSeen = locationSeen;
        this.dateSeen= dateSeen;
        this.id = COUNT++;
    }

    public String toString(){
        return "On " + id + "at " + locationSeen + ": " + speciesName + "was seen.";
    }
}
