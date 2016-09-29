package orshulyak.com.players;

import orshulyak.com.object.Cane;

/**
 * Created by Vlad on 28.09.2016.
 */
public class Miki extends Player {
    public Miki() {
        super("Miki");
    }

    @Override
    public void move(Cane cane) {
        int canes = cane.getNumber();
        int last = cane.getLast();

        int idea = (canes + 2) % 4;
        int answ =  idea == last ? 3 : idea;

        if(last == answ){
            answ = 2;
        }

        if(answ==0){
            if(last == 2 || canes == 2)
                answ = 1;
            else
                answ = 2;
        }


        cane.setNumber(cane.getNumber()-answ);
        cane.setLast(answ);
        System.out.println(this.getName() +" take " + answ +" canes. "+ cane.getNumber() + " canes left");

        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i= 0; i< cane.getNumber(); i++){
            System.out.print("| ");
        }
        System.out.println();
    }
}
