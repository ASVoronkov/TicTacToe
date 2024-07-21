import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);

        Runnable gameLoop = () -> {
            boolean playAgain;
            do {
                game.newGame();
                game.printBoard();

                while (game.isGame()) {
                    System.out.println("Введите координаты для хода (строка и столбец):");
                    try {
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        game.makeMove(x, y);
                        game.printBoard();
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод, попробуйте еще раз.");
                        sc.next(); // очистка некорректного ввода
                    }
                }

                String result = game.game();
                if (result.equals("X") || result.equals("O")) {
                    System.out.println("Победил игрок " + result);
                } else {
                    System.out.println("Ничья!");
                }

                System.out.println("Хотите сыграть снова? (да/нет)");
                String response = sc.next();
                playAgain = response.equalsIgnoreCase("да") || response.equalsIgnoreCase("yes");

            } while (playAgain);
        };

        Thread gameThread = new Thread(gameLoop);
        gameThread.start();

        try {
            gameThread.join(); // ждём завершения игрового потока
        } catch (InterruptedException e) {
            System.out.println("Игровой поток был прерван.");
        }
    }
}
