import java.io.IOException;
import java.util.ArrayList;

class EnadeUFSMExplorer {
    public static void main(String[] args) {
        try {
            CSVFileHandler csvHandler = new CSVFileHandler("enade1.csv");

            System.out.println("Colunas: " + csvHandler.getColumns());

            System.out.println("\n\n");

            CourseData element = new CourseData(csvHandler.getCSVData().get(1));
            System.out.println(element.toString());

        } catch (IOException e) {
            return;
        }

    }
}