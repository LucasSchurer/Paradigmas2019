import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CSVFileHandler {
    private ArrayList<String> csvData;

    private ArrayList<String> getDataFromFile(String fileName) {
        ArrayList<String> data = new ArrayList<String>();

        // Realiza a abertura do arquivo.
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            if ((line = br.readLine()) != null) {
                data.add(line);
            }

            StringBuffer sBuffer = new StringBuffer();

            while ((line = br.readLine()) != null) {
                sBuffer.append(line);
                if (line.endsWith(",")) {
                    data.add(sBuffer.toString());
                    sBuffer.setLength(0);
                }
            }

            fr.close();
            br.close();

            return data;

        } catch (IOException e) {
            // Caso o arquivo não exista ou não possa ser aberto,
            // retorna uma mensagem de erro e define o valor do ArrayList para nulo.
            System.out.println("Error while opening the file. Please, check if the \"" + fileName + "\" exists.");
            return null;
        }
    }

    CSVFileHandler(String fileName) throws IOException {
        setCSVData(getDataFromFile(fileName));

        if (this.csvData == null) {
            throw new IOException();
        }
    }

    public void setCSVData(ArrayList<String> data) {
        this.csvData = data;
    }

    public ArrayList<String> getCSVData() {
        return this.csvData;
    }

    public void printCSVData() {
        for (String s : this.csvData) {
            System.out.println(s + "\n");
        }
    }

    public String getColumns() {
        return this.csvData.get(0);
    }

}