package src.mod;

import src.view.Window;

public class Maze {

    //INSTANCE VARIABLES
    private Window _w = new Window();
    private boolean[][] _maze;
    private Position _start;
    private Position _end;
    private Position _rat1Start;
    private Position _rat2Start;
    private Position _rat3Start;
    private Position _minStart;
    private Position _swordPos;
    boolean[][] _10x10map1;
    boolean[][] _10x10map2;
    boolean[][] _15x15map1;
    boolean[][] _15x15map2;
    boolean[][] _20x20map1;
    boolean[][] _20x20map2;
    boolean[][] _10x15map1;
    boolean[][] _10x15map2;
    boolean[][] _15x20map1;
    boolean[][] _15x20map2;

    //GETTERS
    public Position getPlayerStart() { return this._start; }
    public Position getMinStart() { return this._minStart; }
    public Position getRat1Start() { return this._rat1Start; }
    public Position getRat2Start() { return this._rat2Start; }
    public Position getRat3Start() { return this._rat3Start; }
    public Position getSwordPos() { return this._swordPos; }
    public Position getEnd() { return this._end; }
    public boolean[][] getMaze() { return this._maze; }

    //CONSTRUCTOR
    public Maze() {
        this._10x10map1 = new boolean[][] { { true, true, true, true, true, true, true, true, false, true }, { true, true, true, true, true, false, true, false, false, true }, { true, true, true, true, false, false, false, false, false, true }, { true, false, false, true, false, true, true, true, false, true }, { true, false, false, true, false, false, true, true, false, true }, { true, false, false, true, true, false, true, true, false, true }, { true, true, false, false, false, false, true, true, false, true }, { true, true, true, true, true, false, true, true, false, true }, { true, false, false, false, false, false, false, false, false, true }, { true, false, true, true, false, true, true, true, false, true } };
        this._10x10map2 = new boolean[][] { { true, true, true, false, false, false, true, true, false, true }, { true, true, false, false, false, false, true, true, false, true }, { false, false, false, true, true, true, true, true, false, true }, { true, false, true, true, false, false, false, false, false, true }, { false, false, true, true, false, true, false, true, true, true }, { true, false, true, true, true, true, false, true, true, true }, { true, false, false, false, false, true, false, true, true, true }, { true, false, false, true, false, false, false, true, true, true }, { true, false, true, true, true, true, false, false, true, true }, { false, false, true, true, true, true, true, false, false, false } };
        this._15x15map1 = new boolean[][] {
                {
                        false, false, false, false, false, false, false, true, true, true,
                        true, true, true, true, true }, {
                false, true, true, false, true, true, false, false, true, true,
                true, true, true, true, true }, {
                false, true, true, false, false, true, false, false, false, false,
                false, true, true, true, true }, {
                false, false, true, true, false, true, true, true, true, true,
                true, true, true, true, true }, {
                false, false, true, true, false, false, false, false, true, true,
                true, true, true, true, true }, {
                true, false, false, false, false, true, true, false, true, true,
                false, true, true, true, true }, {
                true, true, true, true, true, true, true, false, false, true,
                false, true, true, true, true }, {
                true, true, true, true, true, true, true, true, false, true,
                false, true, true, true, false }, {
                true, true, true, false, false, false, true, false, false, true,
                false, false, true, true, false }, {
                true, true, true, true, true, false, false, false, false, false,
                false, true, true, false, false },
                {
                        true, true, true, true, true, true, false, true, true, true,
                        true, true, false, false, true }, {
                true, true, false, false, false, true, false, true, true, true,
                true, false, false, true, true }, {
                true, true, false, false, false, false, false, true, false, false,
                false, false, true, true, true }, {
                true, true, false, false, false, true, false, false, false, true,
                true, true, true, true, true }, {
                true, true, true, true, true, false, false, true, false, false,
                false, true, true, true, true } };
        this._15x15map2 = new boolean[][] {
                {
                        false, true, true, true, true, true, true, false, false, false,
                        true, true, true, true, true }, {
                false, false, false, true, true, true, true, true, true, false,
                false, false, false, true, true }, {
                false, false, true, true, true, true, true, true, true, false,
                true, true, false, false, true }, {
                true, false, true, true, true, true, true, true, false, false,
                true, true, true, false, false }, {
                true, false, false, true, true, true, true, true, false, true,
                true, true, true, false, false }, {
                true, true, false, false, true, true, true, true, false, true,
                true, true, true, true, true }, {
                true, false, false, true, true, true, true, false, false, false,
                false, false, false, false, false }, {
                false, false, false, false, false, false, true, false, true, true,
                true, false, true, true, false }, {
                false, true, true, true, false, false, false, false, true, true,
                false, false, false, false, false }, {
                false, true, true, true, false, true, true, false, false, true,
                false, true, true, true, true },
                {
                        false, true, true, true, false, true, true, false, false, true,
                        false, false, true, true, true }, {
                false, false, false, false, false, true, true, true, true, true,
                true, false, false, true, true }, {
                true, false, true, true, true, true, true, true, true, true,
                true, true, false, true, true }, {
                true, true, true, true, true, false, false, false, true, false,
                false, false, false, true, true }, {
                false, false, false, false, false, false, true, false, false, false,
                true, true, true, true, true } };
        this._20x20map1 = new boolean[][] {
                {
                        true, true, true, true, true, true, false, false, false, true,
                        true, false, false, true, true, false, false, true, true, true }, {
                true, true, true, true, true, true, false, true, false, true,
                true, false, false, true, true, false, false, true, true, true }, {
                true, true, true, true, true, true, true, true, false, false,
                false, false, false, true, true, true, false, false, false, false }, {
                false, false, false, true, true, true, true, true, true, true,
                true, true, false, true, true, false, false, true, true, true }, {
                false, true, false, true, true, true, false, false, true, false,
                false, false, false, true, false, true, true, true, true, true }, {
                true, true, false, true, true, false, false, false, false, false,
                true, true, false, false, false, true, true, true, true, true }, {
                true, true, false, false, false, false, true, true, false, true,
                true, true, true, true, false, false, true, true, true, true }, {
                true, true, false, false, true, true, true, true, false, false,
                true, true, true, true, false, false, false, false, true, true }, {
                true, true, false, true, true, true, true, true, false, false,
                false, true, true, true, false, true, true, false, true, true }, {
                false, false, false, true, true, true, true, true, true, false,
                true, false, false, false, false, true, true, false, false, true },
                {
                        true, true, false, true, true, true, true, true, true, false,
                        false, false, false, true, true, true, true, true, false, false }, {
                true, true, false, false, false, false, false, false, false, false,
                true, false, true, true, true, true, true, true, true, false }, {
                false, false, false, true, true, true, true, false, true, true,
                true, false, true, false, true, true, true, true, true, true }, {
                true, true, false, false, true, true, true, false, true, true,
                true, true, true, false, true, true, true, true, true, true }, {
                true, true, true, false, true, true, true, false, true, true,
                true, false, false, false, false, true, true, true, true, true }, {
                true, true, false, false, true, false, false, false, true, true,
                true, true, false, true, true, true, true, true, true, true }, {
                true, true, false, false, false, false, false, false, true, true,
                false, false, false, true, true, true, true, true, true, true }, {
                true, true, true, false, true, true, true, false, true, true,
                true, false, false, false, false, true, true, true, true, true }, {
                false, false, false, false, true, true, true, false, true, true,
                true, true, true, false, true, true, true, true, true, true }, {
                true, true, false, true, true, true, true, false, true, true,
                true, true, true, false, true, true, true, true, true, true } };
        this._20x20map2 = new boolean[][] {
                {
                        false, true, true, true, true, true, true, true, false, true,
                        true, true, true, false, false, false, true, false, false, false }, {
                false, true, true, true, true, true, true, true, false, true,
                true, true, false, false, true, false, false, false, true, true }, {
                false, true, true, true, true, true, true, false, false, true,
                true, false, false, true, true, true, true, true, true, false }, {
                false, true, true, true, true, true, false, false, true, true,
                true, false, false, true, true, true, true, true, true, false }, {
                false, true, true, true, true, true, false, false, true, true,
                true, false, true, true, true, true, true, false, false, false }, {
                false, true, true, true, true, true, true, false, true, true,
                true, false, false, false, true, true, true, false, true, true }, {
                false, true, true, true, true, true, true, false, false, true,
                true, true, false, false, false, true, false, false, true, true }, {
                false, true, true, false, false, false, false, false, true, true,
                true, true, false, true, true, false, false, true, true, true }, {
                false, true, true, false, true, true, true, false, false, false,
                false, true, false, true, true, false, false, false, true, true }, {
                false, true, true, false, true, true, true, false, false, true,
                false, true, false, true, true, true, false, true, true, true },
                {
                        false, false, false, false, false, true, true, true, false, true,
                        false, false, false, true, true, false, true, true, true, true }, {
                false, false, true, true, true, true, true, true, false, false,
                true, true, true, false, true, true, false, false, true, true }, {
                false, false, false, true, true, true, true, true, true, false,
                true, true, true, false, false, true, false, true, true, true }, {
                true, true, false, false, false, true, false, true, false, false,
                true, true, true, true, false, true, false, false, true, true }, {
                true, true, false, true, false, true, false, false, false, true,
                true, true, true, true, false, true, false, false, true, true }, {
                true, false, false, true, false, false, false, true, false, false,
                true, true, true, true, false, false, false, true, true, true }, {
                false, false, true, true, true, false, true, true, false, true,
                true, true, true, true, false, true, true, true, true, true }, {
                false, false, false, true, false, false, false, true, false, true,
                true, true, true, false, true, false, false, false, false, false }, {
                false, true, false, false, false, true, false, false, false, false,
                true, true, true, false, false, false, true, true, true, false }, {
                false, false, true, false, true, true, false, true, true, false,
                true, true, true, true, true, false, true, true, true, false } };
        this._10x15map1 = new boolean[][] { {
                true, false, false, false, false, true, false, true, false, false,
                false, true, false, true, true }, {
                false, false, true, false, true, true, false, true, true, false,
                true, true, false, false, true }, {
                false, false, true, false, false, false, false, false, true, false,
                true, false, false, true, true }, {
                true, true, true, false, true, true, true, true, false, true,
                false, false, false, true, true }, {
                true, true, true, false, true, true, true, true, false, false,
                false, true, false, false, false }, {
                true, false, false, false, true, true, true, true, true, true,
                false, true, false, true, true }, {
                false, false, true, true, true, true, true, false, false, false,
                false, true, false, true, true }, {
                false, true, false, false, false, false, true, false, false, true,
                true, true, false, true, true }, {
                false, false, false, true, true, false, true, true, true, true,
                false, false, false, true, true }, {
                true, true, true, true, true, false, false, false, true, false,
                false, true, false, true, true } };
        this._10x15map2 = new boolean[][] { {
                true, true, true, true, false, false, false, true, true, true,
                true, true, false, false, true }, {
                true, false, false, true, false, true, false, true, true, true,
                false, false, false, true, true }, {
                true, false, false, false, false, true, false, true, true, true,
                false, true, false, true, true }, {
                true, false, true, true, true, true, false, false, false, true,
                false, true, false, false, false }, {
                true, true, false, true, true, true, true, true, false, false,
                false, true, true, false, false }, {
                false, false, false, false, false, true, true, true, false, true,
                true, true, false, true, true }, {
                true, true, false, true, false, false, false, false, false, true,
                true, false, false, true, true }, {
                true, false, false, true, false, true, true, false, true, true,
                true, false, false, false, true }, {
                true, true, true, false, false, true, true, false, false, true,
                false, false, true, false, false }, {
                true, false, false, false, false, true, true, true, false, false,
                false, true, true, false, false } };
        this._15x20map1 = new boolean[][] {
                {
                        true, true, true, false, true, true, false, false, true, false,
                        false, false, true, true, true, true, true, true, true, true }, {
                true, false, false, false, true, true, false, false, false, false,
                true, false, true, true, false, false, false, true, true, true }, {
                true, false, true, true, true, true, true, true, true, true,
                true, false, true, false, false, true, false, true, true, true }, {
                false, false, true, true, true, true, true, true, true, true,
                true, false, false, false, true, false, false, true, true, true }, {
                false, false, true, true, true, true, true, true, true, true,
                true, true, true, true, true, false, true, true, true, true }, {
                true, false, true, true, false, true, false, false, false, true,
                false, false, false, false, false, false, false, false, true, true }, {
                true, false, false, false, false, false, false, true, true, true,
                false, true, true, false, false, true, true, false, true, true }, {
                true, true, true, false, false, true, true, true, false, false,
                false, true, false, false, true, true, true, false, false, false }, {
                true, true, true, true, false, true, true, false, false, true,
                true, false, false, true, true, true, true, true, false, true }, {
                true, true, true, true, false, true, false, false, true, true,
                false, false, true, true, true, true, false, false, false, true },
                {
                        true, true, true, false, false, true, true, true, true, true,
                        false, true, true, false, false, false, false, true, true, true }, {
                false, true, true, false, true, true, true, true, false, false,
                false, true, true, false, true, true, false, true, true, true }, {
                false, false, true, false, false, true, false, false, false, true,
                false, false, false, true, true, false, false, true, true, true }, {
                true, false, true, false, false, false, false, false, false, true,
                false, true, false, true, false, false, true, true, true, true }, {
                true, false, false, false, true, true, false, false, true, true,
                true, false, true, false, false, true, true, true, true, true } };
        this._15x20map2 = new boolean[][] {
                {
                        false, true, true, true, false, true, true, true, true, true,
                        false, true, true, true, true, true, true, true, false, false }, {
                false, true, true, true, false, false, true, true, true, false,
                false, true, true, true, true, true, true, false, false, true }, {
                false, false, true, true, true, false, true, true, true, false,
                false, false, true, true, true, true, true, false, true, true }, {
                true, false, true, true, true, false, false, false, true, true,
                false, false, true, true, true, true, true, false, false, true }, {
                true, false, false, false, true, true, true, false, true, true,
                true, false, true, true, true, true, true, true, false, false }, {
                true, true, true, false, true, true, true, false, true, true,
                true, false, true, true, true, true, false, false, false, true }, {
                false, true, false, false, true, true, true, false, false, false,
                false, false, false, true, true, true, false, true, true, true }, {
                false, false, false, true, true, true, true, false, true, true,
                true, true, false, false, true, false, false, true, true, true }, {
                true, false, true, false, false, true, false, false, true, true,
                true, true, true, false, true, false, true, true, true, true }, {
                true, false, false, false, false, true, false, true, true, true,
                true, true, false, false, false, false, true, true, true, true },
                {
                        true, false, true, false, false, true, false, false, true, true,
                        false, false, false, true, true, false, true, true, true, true }, {
                false, false, true, true, false, true, true, false, false, false,
                true, false, false, true, true, false, false, false, true, true }, {
                true, true, false, false, false, true, false, false, true, false,
                true, false, true, true, true, true, true, false, true, true }, {
                true, true, false, false, false, false, false, true, false, false,
                true, false, false, true, true, false, true, false, true, true }, {
                true, true, true, true, true, true, true, true, true, false,
                false, true, false, false, true, true, false, false, false, true } };
        String[] sizes = { "10x10", "15x15", "20x20", "10x15", "15x20" };
        int x = this._w.option(sizes, "Choose the size of the maze");
        int random = (int)(Math.random() * 2.0D);
        if (x == 0) {
            if (random == 0) {
                this._maze = this._10x10map1;
                this._start = new Position(9, 4);
                this._end = new Position(0, 8);
                this._rat1Start = new Position(2, 8);
                this._rat2Start = new Position(5, 1);
                this._rat3Start = new Position(6, 3);
                this._minStart = new Position(4, 1);
                this._swordPos = new Position(9, 1);
            } else {
                this._maze = this._10x10map2;
                this._start = new Position(9, 0);
                this._end = new Position(4, 4);
                this._rat1Start = new Position(9, 9);
                this._rat2Start = new Position(1, 2);
                this._rat3Start = new Position(6, 4);
                this._minStart = new Position(0, 3);
                this._swordPos = new Position(9, 0);
            }
        } else if (x == 1) {
            if (random == 0) {
                this._maze = this._15x15map1;
                this._start = new Position(1, 3);
                this._end = new Position(8, 14);
                this._rat1Start = new Position(9, 10);
                this._rat2Start = new Position(12, 4);
                this._rat3Start = new Position(0, 4);
                this._minStart = new Position(7, 10);
                this._swordPos = new Position(13, 2);
            } else {
                this._maze = this._15x15map2;
                this._start = new Position(6, 8);
                this._end = new Position(14, 0);
                this._rat1Start = new Position(1, 11);
                this._rat2Start = new Position(11, 0);
                this._rat3Start = new Position(1, 0);
                this._minStart = new Position(0, 9);
                this._swordPos = new Position(10, 0);
            }
        } else if (x == 2) {
            if (random == 0) {
                this._maze = this._20x20map1;
                this._start = new Position(9, 0);
                this._end = new Position(11, 19);
                this._rat1Start = new Position(16, 17);
                this._rat2Start = new Position(4, 11);
                this._rat3Start = new Position(7, 15);
                this._minStart = new Position(0, 8);
                this._swordPos = new Position(19, 7);
            } else {
                this._maze = this._20x20map2;
                this._start = new Position(19, 0);
                this._end = new Position(0, 19);
                this._rat1Start = new Position(17, 17);
                this._rat2Start = new Position(4, 18);
                this._rat3Start = new Position(18, 7);
                this._minStart = new Position(0, 0);
                this._swordPos = new Position(19, 19);
            }
        } else if (x == 3) {
            if (random == 0) {
                this._maze = this._10x15map1;
                this._start = new Position(3, 3);
                this._end = new Position(9, 7);
                this._rat1Start = new Position(3, 11);
                this._rat2Start = new Position(1, 1);
                this._rat3Start = new Position(8, 10);
                this._minStart = new Position(9, 5);
                this._swordPos = new Position(0, 1);
            } else {
                this._maze = this._10x15map2;
                this._start = new Position(0, 13);
                this._end = new Position(3, 1);
                this._rat1Start = new Position(7, 12);
                this._rat2Start = new Position(2, 4);
                this._rat3Start = new Position(8, 2);
                this._minStart = new Position(5, 4);
                this._swordPos = new Position(9, 14);
            }
        } else if (random == 0) {
            this._maze = this._15x20map1;
            this._start = new Position(5, 8);
            this._end = new Position(9, 6);
            this._rat1Start = new Position(1, 6);
            this._rat2Start = new Position(12, 7);
            this._rat3Start = new Position(6, 2);
            this._minStart = new Position(0, 6);
            this._swordPos = new Position(0, 3);
        } else {
            this._maze = this._15x20map2;
            this._start = new Position(6, 9);
            this._end = new Position(0, 0);
            this._rat1Start = new Position(2, 9);
            this._rat2Start = new Position(13, 4);
            this._rat3Start = new Position(1, 18);
            this._minStart = new Position(3, 11);
            this._swordPos = new Position(0, 11);
        }
    }
}