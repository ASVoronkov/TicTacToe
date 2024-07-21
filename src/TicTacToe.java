
public class TicTacToe {
    private String[][] field;
    private String nowPlayer;

    public TicTacToe() {
        newGame();
    }

    public void newGame() {
        field = new String[][]{
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}
        };
        nowPlayer = "X";
        System.out.println("Началась новая игра!");
    }

    public void makeMove(int x, int y) {
        x -= 1;
        y -= 1;
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            System.out.println("Неверные координаты. Попробуйте еще раз.");
            return;
        }
        if (!field[x][y].equals("-")) {
            System.out.println("Ход невозможен, ячейка занята.");
        } else {
            field[x][y] = nowPlayer;
            if (game().equals("G")) {
                nowPlayer = nowPlayer.equals("X") ? "O" : "X";
                System.out.println("Ходит игрок " + nowPlayer);
            }
        }
    }

    public String game() {
        // Проверка диагоналей
        if (field[0][0].equals(field[1][1]) && field[1][1].equals(field[2][2]) && !field[0][0].equals("-")) return field[0][0];
        if (field[0][2].equals(field[1][1]) && field[1][1].equals(field[2][0]) && !field[0][2].equals("-")) return field[0][2];

        for (int i = 0; i < 3; i++) {
            // Проверка строк
            if (field[i][0].equals(field[i][1]) && field[i][1].equals(field[i][2]) && !field[i][0].equals("-")) return field[i][0];
            // Проверка столбцов
            if (field[0][i].equals(field[1][i]) && field[1][i].equals(field[2][i]) && !field[0][i].equals("-")) return field[0][i];
        }

        // Проверка на ничью
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("-")) return "G";
            }
        }

        return "D";
    }

    public boolean isGame() {
        return game().equals("G");
    }

    public void printBoard() {
        int size = field.length;

        // Печать заголовков столбцов
        System.out.print("   "); // Отступ для нумерации строк
        for (int col = 0; col < size; col++) {
            System.out.print("  " + (col + 1) + " ");
        }
        System.out.println();

        // Печать строк массива с нумерацией строк
        for (int row = 0; row < size; row++) {
            System.out.print(" " + (row + 1) + " "); // Нумерация строк
            for (int col = 0; col < size; col++) {
                System.out.print("| " + field[row][col] + " ");
            }
            System.out.println("|");

            // Печать разделительной линии между строками
            System.out.print("   ");
            for (int col = 0; col < size; col++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }
}
