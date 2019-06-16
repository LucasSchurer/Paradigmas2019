import java.util.ArrayList;

import java.io.FileWriter;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class TextFile {
    private String fileName;

    TextFile(String name) {
        setFileName(name);
    }

    public ArrayList<String> getFileContent() {
        ArrayList<String> fileContent = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(this.fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }

            fr.close();
            fr.close();

            return fileContent;
        } catch (IOException e) {
            return null;
        }
    }

    public void setFileName(String name) {
        if (name.endsWith(".txt")) {
            this.fileName = name;
        } else {
            this.fileName = name + ".txt";
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    public void copyArrayListToFile(ArrayList<String> arrayList) {
        try {
            FileWriter fw = new FileWriter(this.fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuffer strBuffer = new StringBuffer();

            for (String s : arrayList) {
                s = s + "\n";
                strBuffer.append(s);
            }

            bw.write(strBuffer.toString());
            bw.close();

        } catch (IOException e) {

        }
    }
}