import java.util.ArrayList;
import java.util.Collections;

class RandomPicker {
    private ArrayList<String> stringList;
    private TextFile file;

    RandomPicker(String fileName) {
        setTextFile(fileName);
        setStringList();
    }

    public void setTextFile(String fileName) {
        TextFile f = new TextFile(fileName);
        this.file = f;

        setStringList();
    }

    public void setStringList() {
        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent = this.file.getFileContent();

        this.stringList = fileContent;
    }

    public TextFile getTextFile() {
        return this.file;
    }

    public ArrayList<String> getStringList() {
        return this.stringList;
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
        Collections.shuffle(this.stringList);
        file.copyArrayListToFile(this.stringList);
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
}