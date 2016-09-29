package orshulyak.com.game;

import orshulyak.com.object.Cane;
import orshulyak.com.players.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Vlad on 27.09.2016.
 */
public class Game {
    private Cane cane;
    private Player bot;
    private Player user;
    private Player winner;
    public boolean isRepeat;


    public Game() {
        this.cane = new Cane();
        this.bot = new Miki();
        this.isRepeat = true;
    }

    public void sayHello(){
        System.out.println("******* Welcome to the game 'Last cane' *******");
        System.out.println("The rules are simple:");
        System.out.println("  1.Do not take the last cane. Try to make your opponent take it.");
        System.out.println("  2.When it is your turn, you can only take one, two or three canes. The same rules apply to your opponent on there turn. You cannot skip your move, so choose wisely how many canes to take. Both opponents will be able to see how many cakes the other takes on each turn.");
        System.out.println("  3.You cannot copy your opponent's previous move, likewise they cannot copy yours. If your opponent takes one cane, next move you can only choose between two or three. If you take three canes, your opponent can only choose one or two. This doesn't effect the first move, only to subsequent.");
        System.out.println("  4.If one of the players has no valid moves (e.g one cane left and previous move was one cane), that player will lose his turn and be skipped. Then the other player will be forced to take the last cane. This is the ONLY case of turn skipping.");
        System.out.println("  5.You can choose whether or not to go first. This decision is key to victory, so don't hurry, choose wisely!");
        System.out.println("");
        System.out.println("Let's start the game");
    }

    public void initPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = sc.next();
        this.user = new User(name);
        System.out.println("Your name is "+ user.getName());
        System.out.println("Your opponent is  " + bot.getName());
    }

    public void initGame(){
        System.out.println("Initialization game ...");
        cane.setNumber(new Random().nextInt(17)+6);
        cane.setLast(0);
        System.out.println("Trere are " + cane.getNumber() + " canes on the table");

        for (int i= 0; i<cane.getNumber(); i++)
            System.out.print("| ");
        System.out.println();
    }

    public void choseFirstMove(boolean again){
        Scanner sc = new Scanner(System.in);
        if(!again)
            System.out.println("Decide on who will be the move first (if you then enter 'me', else enter 'bot')");
        String answer = sc.next();

        switch (answer){
            case "me":
                System.out.println("You decide to move first");
                user.setFirst(true);
                bot.setFirst(false);
                break;
            case "bot":
                System.out.println("You decide to move second");
                user.setFirst(false);
                bot.setFirst(true);
                break;
            default:
                System.out.println("Incorrect answer. Please try again.");
                choseFirstMove(true);
                break;
        }
    }

    public void start(){
        while(winner == null){
            if(user.isFirst()){
                play(user,bot);
                if(winner != null)
                    break;
                else
                    play(bot,user);
            }
            else{
                play(bot,user);
                if(winner != null)
                    break;
                else
                    play(user,bot);
            }
        }
    }

    private void play(Player p1, Player p2){
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if( /*((cane.getLast() == 3 ) && cane.getNumber() == 2)
                ||*/ (cane.getLast() == 1 && cane.getNumber() == 1)){
            winner = p1;
        }
        else if(cane.getNumber() == 1 || (cane.getNumber() == 2 && cane.getLast()==1)){
            winner = p2;
        }
        else
            p1.move(cane);
        if(cane.getNumber() <= 0)
            winner = p2;
    }

    private void playBot(Player p1,Player p2){
        if( /*((cane.getLast() == 3 ) && cane.getNumber() == 2)
                ||*/ (cane.getLast() == 1 && cane.getNumber() == 1)){
            winner = p2;
        }
        else if(cane.getNumber() == 1 || (cane.getNumber() == 2 && cane.getLast()==1)){
            winner = p1;
        }
        else
            p1.move(cane);
    }


    public void showResult(){
        if(cane.getLast() == 1){
            if(cane.getNumber() == 2){
                System.out.println("You must take 2 canes");
            }
            else if(cane.getNumber() == 1){
                System.out.println("I can't take last cane becaus opponet take 1 cane before");
            }
//            else{
//                System.out.printf("%s take last cane!!!", winner == bot ? user.getName() : bot.getName());
//            }
        }
        else if(cane.getNumber() == 1 || cane.getNumber()<=0){
            System.out.printf("%s take last cane!!!", winner == bot ? user.getName() : bot.getName());
            System.out.println();
        }

        System.out.println("Winner is " + winner.getName());

    }

    public void repeat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to repeat? (yes/no)");
        String answer = sc.next();

        if(!answer.equals("yes"))
            isRepeat = false;
    }


    public void sayGodbay(){
        System.out.println("Godbay :)");
    }

    public void finished(){
        winner = null;
    }

}
