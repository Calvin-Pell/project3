package src.mod;

public class Sword {
    //INSTANCE VARIABLES
    private Position _pos;
    public boolean isHeld = false;

    //GETTERS
    public Position getPosition() { return this._pos; }


    //CONSTRUCTOR
    public Sword(Maze z) {
        this._pos = z.getSwordPos();
    }

    /*
     *Simulates the user picking up the sword by setting isHeld to true.
     */
    public void pickUp() {
        this.isHeld = true;
    }

    /*
     *Simulates the user using the sword by setting isHeld to false.
     */
    public void useSword() {
        this.isHeld = false;
    }

}
