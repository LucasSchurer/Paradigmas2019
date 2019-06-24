import java.io.IOException;
import java.util.ArrayList;

class EnadeUFSMExplorer {
    public static void main(String[] args) {
        try {
            CSVFileHandler csvHandler = new CSVFileHandler("enade.csv");

            System.out.println("Colunas: " + csvHandler.getColumns());

            ArrayList<String> data = csvHandler.getCSVData();

            System.out.println("\n\n");
            CourseData courseData = new CourseData(data.get(1));

        } catch (IOException e) {
            return;
        }

    }
}