import java.util.NoSuchElementException;
import java.util.Scanner;

class RandomPickerCmd {
    static void printWelcome(TextFile file) {
        System.out.println("=====================================");
        System.out.println("            Random Picker            ");
        System.out.println("=====================================");
        System.out.println("Selected text file: " + file.getFileName());
        System.out.println("Press \"Enter\" to go to the next item on the list.");
        System.out.println("Press \"CTRL + C\" to terminate the execution of the program.");

        System.out.println("Should I start shuffling the file?");
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        try {
            String fileName = args[0];
            RandomPicker randomPicker = new RandomPicker(fileName);

            printWelcome(randomPicker.getTextFile());

            try {
                Scanner scanner = new Scanner(System.in);
                String userInput = null;

                System.out.print(">> ");
                userInput = scanner.nextLine();
                randomPicker.shuffle();

                while (true) {
                    String element = randomPicker.getFirstElementStringList();
                    if (element != null) {
                        System.out.println("Element: " + element);
                    } else {
                        System.out.println("List is empty, I can't show you any items, sorry.");
                    }
                    System.out.print(">> ");
                    userInput = scanner.nextLine();
                }
            } catch (NoSuchElementException e) {
                System.out.println("\n\tExiting application.");
            } catch (NullPointerException e2) {
                System.out.println("\n\tError while opening file. Please, check if the name is correct.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("=====================================");
            System.out.println("                ERROR                ");
            System.out.println("=====================================");
            System.out.print("Please, select a file to open.\n");
            System.out.println("Example: java -cp ../classes; RandomPickerCmd names.txt");
            System.out.println("Exiting application.");
            return;
        }

    }
}