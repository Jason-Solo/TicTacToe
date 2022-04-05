import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String [] arrList = throwExp();
        tttBoard(arrList);
        int c = 0;
        int i = 0;
        while (c < 9){
            int a = checkXPlayer(enterCD());
            while (!Objects.equals(arrList[a], " ")) {
                System.out.println("This cell is occupied! Choose another one!");
                a = checkXPlayer(reDo());
            }
            battleXO(arrList, a, i);
            i++;
            c++;
        }
        draw();
    }

    public static void battleXO(String [] xoEnter, int a, int i) {
        String [] xo = {"X","O","X","O","X","O","X","O","X"};

                xoEnter[a] = xo[i];
                tttBoard(xoEnter);
                checkWinner(xoEnter, xo[i]);

            }


    public static String enterCD() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String cordX;

        while (!scanner.hasNextInt()){
            System.out.println("You should enter numbers!");
            System.out.println("Enter the coordinates: ");
            scanner.nextLine();
        }
         cordX = scanner.nextLine();

        if (Integer.parseInt(String.valueOf(cordX.charAt(0))) > 3 || Integer.parseInt(String.valueOf(cordX.charAt(2))) > 3) {
            String cordX1;
            Scanner scanner1 = new Scanner(System.in);
            do {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter coordinates: ");
                cordX1 = scanner1.nextLine();
                System.out.println(cordX1.charAt(0) + " " + cordX1.charAt(2));
            } while (Integer.parseInt(String.valueOf(cordX1.charAt(0))) > 3 || Integer.parseInt(String.valueOf(cordX1.charAt(2))) > 3);

            return cordX1;
        }
        return cordX;
    }

    public static String reDo() {
        String cordX1;

                do {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Enter coordinates: ");
                    while (!scanner1.hasNextInt()){
                        System.out.println("You should enter numbers!");
                        System.out.println("Enter the coordinates: ");
                        scanner1.nextLine();
                    }

                    cordX1 = scanner1.nextLine();

                } while (Integer.parseInt(String.valueOf(cordX1.charAt(0))) > 3 || Integer.parseInt(String.valueOf(cordX1.charAt(2))) > 3);

                return cordX1;
            }

    public static String[] throwExp() {


        String letters = "         ";
        String [] arrLetters = new String[letters.length()];

        for (int i  = 0; i < letters.length(); i++) {
            arrLetters[i] = String.valueOf(letters.charAt(i));
        }
        return arrLetters;
    }

    public static int checkXPlayer(String xCord) {

        int[][] convertList = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

            return convertList[Integer.parseInt(String.valueOf(xCord.charAt(0))) - 1][Integer.parseInt(String.valueOf(xCord.charAt(2))) - 1];
    }

    public static void tttBoard (String [] arrL) {


        System.out.println("---------");
        System.out.println("| " + arrL[0] + " " + arrL[1] + " " + arrL[2] + " |");
        System.out.println("| " + arrL[3] + " " + arrL[4] + " " + arrL[5] + " |");
        System.out.println("| " + arrL[6] + " " + arrL[7] + " " + arrL[8] + " |");
        System.out.println("---------");
    }

    public static void checkWinner(String [] arrLetters, String xo) {

        if((arrLetters[0] + arrLetters[4] + arrLetters[8]).equals(xo + xo + xo)) {
            System.out.println(xo + " wins");
            System.exit(0);
        } if((arrLetters[2] + arrLetters[4] + arrLetters[6]).equals(xo + xo + xo)) {
            System.out.println(xo + " wins");
            System.exit(0);
        }
        for (int i  = 0; i < 9; i++) {
            if ((arrLetters[i] + arrLetters[i + 1] + arrLetters[i + 2]).equals(xo + xo + xo)) {
                System.out.println(xo + " wins");
                System.exit(0);
            }
            i++;
            i++;
        }
        for (int i  = 0; i < 3; i++) {
            if ((arrLetters[i] + arrLetters[i + 3] + arrLetters[i + 6]).equals(xo + xo + xo)) {
                System.out.println(xo + " wins");
                System.exit(0);
            }
        }
    }

    public static void draw(){
        System.out.println("Draw");
        System.exit(0);
    }
}
