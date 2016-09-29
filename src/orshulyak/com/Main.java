package orshulyak.com;

import orshulyak.com.game.Game;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Game game = new Game();
        game.sayHello();
        game.initPlayer();

        while (game.isRepeat){
            game.initGame();
            game.choseFirstMove(false);
            game.start();
            game.showResult();
            game.finished();
            game.repeat();
        }
         game.sayGodbay();
    }
}
