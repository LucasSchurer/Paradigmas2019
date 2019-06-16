import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

class RandomPicker {
    private ArrayList<String> stringList;
    private TextFile file;

    RandomPicker(String fileName) {
        setTextFile(fileName);
        setStringList(this.file.getFileContent());
    }

    public void setTextFile(String fileName) {
        TextFile f = new TextFile(fileName);
        this.file = f;
    }

    public void setStringList(ArrayList<String> fileContent) {
        this.stringList = fileContent;
    }

    public TextFile getTextFile() {
        return this.file;
    }

    public ArrayList<String> getStringList() {
        return this.stringList;
    }

    public boolean checkStringListEmpty() {
        return this.stringList.isEmpty();
    }

    public void printStringList() {
        if (this.stringList == null) {
            return;
        }

        for (String line : this.stringList) {
            System.out.println(line);
        }
    }

    public void shuffle() {
        String urlString = "https://www.random.org/lists";

        Collections.shuffle(this.stringList);
    }

    public String getFirstElementStringList() {
        String element;

        if (this.stringList.isEmpty()) {
            element = null;
        } else {
            element = this.stringList.get(0);
            this.stringList.remove(0);
        }

        return element;
    }

    public String getFileName() {
        return file.getFileName();
    }
}