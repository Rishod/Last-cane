package orshulyak.com.players;

import orshulyak.com.object.Cane;

import java.util.Scanner;

/**
 * Created by Vlad on 27.09.2016.
 */
public class User extends Player {

    public User(String name) {
        super(name);
    }

    @Override
    public void move(Cane cane) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.print("Your choice: ");
        choice = sc.nextInt();
        if(choice == cane.getLast()){
            System.out.println("You cannot copy your opponent's previous move. Please try again");
            move(cane);
        }

        else if( choice > 3 || choice < 0){
            System.out.println("You cannot take canes more than 3 or less than 0. Please try again");
            move(cane);
        }
        else {
            cane.setLast(choice);
            cane.setNumber(cane.getNumber() - choice);
            System.out.printf("%s take %d %s. %d canes left", this.getName(), choice, choice == 1 ? "cane" : "canes", cane.getNumber());
            System.out.println();
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

}
