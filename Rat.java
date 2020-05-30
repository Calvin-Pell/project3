package src.mod;

public class Rat {

    //INSTANCE VARIABLES
    private Position _curPos;
    private boolean _facingLeft = true;
    private boolean _isAlive = true;

    //GETTERS
    public Position getPosition() { return this._curPos; }
    public boolean checkAlive() { return this._isAlive; }

    //CONSTRUCTORS
    public Rat(Maze z) {
        this._curPos = z.getRat1Start();
    }
    public Rat(Maze z, Rat r1) {
        this._curPos = z.getRat2Start();
    }
    public Rat(Maze z, Rat r1, Rat r2) {
        this._curPos = z.getRat3Start();
    }

    /*
     *Checks if the rat needs to turn around by checking if it is currently facing a wall and
     * turns the rat around if necessary. Then moves the rat forward one space in the
     * direction it is facing.
     */
    public void move(Maze z) {
        if (this._facingLeft) {
            if (this._curPos.getCol() > 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
                this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() - 1);
            } else {
                this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() + 1);
                this._facingLeft = false;
            }
        } else if (this._curPos.getCol() < (z.getMaze()[0]).length - 1 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
            this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() + 1);
        } else {
            this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() - 1);
            this._facingLeft = true;
        }
    }

    /*
     *Simulates the rat being killed by setting isAlive to false.
     */
    public void killRat() {
        this._isAlive = false;
    }
}
