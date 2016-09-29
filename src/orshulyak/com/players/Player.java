package orshulyak.com.players;

import orshulyak.com.object.Cane;

/**
 * Created by Vlad on 27.09.2016.
 */
public abstract class Player {
    private String name;
    private boolean isFirst;

    public Player(String name) {
        this.name = name;
    }

    public abstract void move(Cane cane);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        this.isFirst = first;
    }
}
