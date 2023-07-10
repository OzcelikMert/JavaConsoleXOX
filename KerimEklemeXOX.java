import java.util.Scanner;
import KerimEklemeXOXBoard;

public class KerimEklemeXOX {
    static int Player2Point = 0;
    static int Player1Point = 0;
    static int MatchRound = 1;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        KerimEklemeXOXBoard board = new KerimEklemeXOXBoard();
        char currentPlayer = 'X';
        showStartMessage();

        while (true) {
            System.out.println("Sıra sende: " + currentPlayer);
            System.out.print("Lütfen 'Satır' koordinatını girin (1-3): ");
            int row = read.nextInt();
            System.out.print("Lütfen 'Sütun' koordinatını girin (1-3): ");
            int col = read.nextInt();
            board.makeMove((row - 1), (col - 1), currentPlayer);
            board.printBoard();

            if (board.isGameOver()) {

                if (currentPlayer == 'X')
                    Player1Point++;
                else
                    Player2Point++;

                System.out.println("Oyun bitti! Kazanan Taraf: " + currentPlayer);
                break;
            } else if (board.isBoardFull()) {
                System.out.println("Oyun bitti! Dostluk kazandı, berabere.");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        showPlayersStatusMessage();
        System.out.print("Yeniden oynamak ister misiniz? (Evet/Hayır): ");
        String playAgain = read.next();

        if (playAgain.toLowerCase().equalsIgnoreCase("evet")) {
            MatchRound++;
            System.out.print("Tüm veriler sıfırlansın mı? (Evet/Hayır): ");
            String resetData = read.next();
            if (resetData.toLowerCase().equalsIgnoreCase("evet")) {
                MatchRound = 1;
                Player1Point = 0;
                Player2Point = 0;
            }
            main(args);
        } else {
            System.out.println("Oyun sonlandırıldı.");
        }

        read.close();
    }

    public static void showStartMessage() {
        System.out.println("*******************************");
        System.out.println(MatchRound + ". Round Başladı İyi Eğlenceler!");
        System.out.println("*******************************");
    }

    public static void showPlayersStatusMessage() {
        System.out.println("*******************************");
        System.out.println("X Oyuncusunun Puanı: " + Player1Point);
        System.out.println("O Oyuncusunun Puanı: " + Player2Point);
        System.out.println("*******************************");
    }
}