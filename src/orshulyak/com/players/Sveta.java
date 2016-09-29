package orshulyak.com.players;

import orshulyak.com.object.Cane;

/**
 * Created by Vlad on 28.09.2016.
 */
public class Sveta extends Player {
    public Sveta() {
        super("Sveta");
    }

    @Override
    public void move(Cane cane) {
        int canes = cane.getNumber();
        int last = cane.getLast();

        if (canes % 4 == 1) {
            cane.setNumber(cane.getNumber()-3);
            cane.setLast(3);
            System.out.println(this.getName() +" take 3 canes. "+ cane.getNumber() + " left");
        } else if (canes % 4 == 3) {
            cane.setNumber(cane.getNumber()-1);
            cane.setLast(1);
            System.out.println(this.getName() +" take 1 cane. "+ cane.getNumber() + " left");
        } else if (canes % 4 == 0) {
                cane.setNumber(cane.getNumber()-3);
                cane.setLast(3);
                System.out.println(this.getName() +" take 3 canes. "+ cane.getNumber() + " left");
        }
        else {
            cane.setNumber(cane.getNumber() - 2);
            cane.setLast(2);
            System.out.println(this.getName() + " take 2 canes. " + cane.getNumber() + " left");
        }
    }
}
