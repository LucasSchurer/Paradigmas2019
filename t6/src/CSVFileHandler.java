import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class CSVFileHandler {
    private ArrayList<String> csvData;

    private static void download(String url, String fileName) throws IOException {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }

    private ArrayList<String> getDataFromFile(String fileName, String url, int nTry) {
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
            System.out.println("Error while opening the file. Please, check if the \"" + fileName
                    + "\" exists. Trying to download a new one...");

            try {
                download(url, fileName);
            } catch (IOException e1) {
                System.out.println("Error while downloading the file.");
            }

            return null;
        }
    }

    CSVFileHandler(String fileName, String url) throws IOException {
        setCSVData(getDataFromFile(fileName, url, 0));

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