package orshulyak.com.players;

import orshulyak.com.object.Cane;

/**
 * Created by Vlad on 27.09.2016.
 */


public class Georg extends Player {
    private int a;

    public Georg() {
        super("George");
    }

    @Override
    public void move(Cane cane) {
        int cakes = cane.getNumber();
        int last = cane.getLast();

        int x = (cakes-2)/4;
        int k = 1;

        if(last==0){
            cane.setNumber(cane.getNumber()-k);
            cane.setLast(k);
            System.out.println(this.getName() +" take "+ k +" canes. "+ cane.getNumber() + " left");
        }
        else if((last==2)&&(cakes==4)){
            cane.setNumber(cane.getNumber()-3);
            cane.setLast(3);
            System.out.println(this.getName() +" take 3 canes. "+ cane.getNumber() + " left");
        }
        else
        if(a>0) {
            if(last==2){
                a=0;
                cane.setNumber(cane.getNumber()-1);
                cane.setLast(1);
                System.out.println(this.getName() +" take 1 cane. "+ cane.getNumber() + " left");
            }
            else {
                a=0;
                cane.setNumber(cane.getNumber()-2);
                cane.setLast(2);
                System.out.println(this.getName() +" take 2 canes. "+ cane.getNumber() + " left");
            }
        }
        else{
            if(last==3){
                cane.setNumber(cane.getNumber() - 1);
                cane.setLast(1);
                System.out.println(this.getName() +" take 1 cane. "+ cane.getNumber() + " left");
            }
            else if(last==1){
                cane.setNumber(cane.getNumber()-3);
                cane.setLast(3);
                System.out.println(this.getName() +" take 3 canes. "+ cane.getNumber() + " left");
            }
            else{
                a=1;
                cane.setNumber(cane.getNumber()-3);
                cane.setLast(3);
                System.out.println(this.getName() +" take 3 canes. "+ cane.getNumber() + " left");
                }
            }
        }
    }

