import java.io.IOException;
import java.util.ArrayList;

class EnadeUFSMExplorer {
    public static void main(String[] args) {
        try {
            CSVFileHandler csvHandler = new CSVFileHandler("enade.csv");

            System.out.println("Colunas: " + csvHandler.getColumns());

            System.out.println("\n\n");

            csvHandler.printCSVData();

        } catch (IOException e) {
            return;
        }

    }
}