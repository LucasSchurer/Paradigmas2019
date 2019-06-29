import java.util.ArrayList;
import java.util.Arrays;

class CourseData {
    private ArrayList<String> data;
    private String courseName = "-";
    private String year = "-";
    private String test = "-";
    private String questionType = "-";
    private String questionID = "-";
    private String object = "-";
    private String detailedObject = "-";
    private String answerKey = "-";
    private String courseSuccesses = "-";
    private String regionSuccesses = "-";
    private String countrySuccesses = "-";
    private String countryCourseSuccessesDifference = "-";
    private String text = "-";
    private String image = "-";
    private String testURL = "-";
    private String synopsisURL = "-";
    private String courseURL = "-";
    private String cropURL = "-";

    CourseData(String data) {
        setData(data);
        setCourseName();
        setYear();
        setTest();
        setQuestionType();
        setQuestionID();
        setObject();
        setDetailedObject();
        setAnswerKey();
        setCourseSuccesses();
        setRegionSuccesses();
        setCountrySuccesses();
        setCountryCourseSuccessesDifference();
        setText();
        setImage();
        setTestURL();
        setSynopsisURL();
        setCourseURL();
        setCropURL();
    }

    @Override
    public String toString() {
        return "Course name: " + this.courseName + "\n" + "Year: " + this.year + "\n" + "Test: " + this.test + "\n"
                + "Question type: " + this.questionType + "\n" + "Question ID: " + this.questionID + "\n" + "Object: "
                + this.object + "\n" + "Detailed object: " + this.detailedObject + "\n" + "Answer key: "
                + this.answerKey + "\n" + "Course successes: " + this.courseSuccesses + "\n" + "Region successes: "
                + this.regionSuccesses + "\n" + "Country successes: " + this.countrySuccesses + "\n" + "Difference: "
                + this.countryCourseSuccessesDifference + "\n" + "Text: " + this.text + "\n" + "Image: " + this.image
                + "\n" + "Test URL: " + this.testURL + "\n" + "Synopsis URL: " + this.synopsisURL + "\n"
                + "Course URL: " + this.courseURL + "\n" + "Crop URL: " + this.cropURL;
    }

    public void setData(String data) {
        ArrayList<String> organizedData = new ArrayList<String>(
                Arrays.asList(data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));

        this.data = organizedData;
    }

    public void setCourseName() {
        String element;

        try {
            element = this.data.get(0);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.courseName = element;
    }

    public void setYear() {
        String element;

        try {
            element = this.data.get(1);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.year = element;
    }

    public void setTest() {
        String element;

        try {
            element = this.data.get(2);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.test = element;
    }

    public void setQuestionType() {
        String element;

        try {
            element = this.data.get(3);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.questionType = element;
    }

    public void setQuestionID() {
        String element;

        try {
            element = this.data.get(4);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.questionID = element;
    }

    public void setObject() {
        String element;

        try {
            element = this.data.get(5);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.object = element;
    }

    public void setDetailedObject() {
        String element;

        try {
            element = this.data.get(6);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.detailedObject = element;
    }

    public void setAnswerKey() {
        String element;

        try {
            element = this.data.get(7);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.answerKey = element;
    }

    public void setCourseSuccesses() {
        String element;

        try {
            element = this.data.get(8);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.courseSuccesses = element;
    }

    public void setRegionSuccesses() {
        String element;

        try {
            element = this.data.get(9);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.regionSuccesses = element;
    }

    public void setCountrySuccesses() {
        String element;

        try {
            element = this.data.get(10);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.countrySuccesses = element;
    }

    public void setCountryCourseSuccessesDifference() {
        String element;

        try {
            element = this.data.get(11);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.countryCourseSuccessesDifference = element;
    }

    public void setText() {
        String element;

        try {
            element = this.data.get(12);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.text = element;
    }

    public void setImage() {
        String element;

        try {
            element = this.data.get(13);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.image = element;
    }

    public void setTestURL() {
        String element;

        try {
            element = this.data.get(14);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.testURL = element;
    }

    public void setSynopsisURL() {
        String element;

        try {
            element = this.data.get(15);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.synopsisURL = element;
    }

    public void setCourseURL() {
        String element;

        try {
            element = this.data.get(16);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.courseURL = element;
    }

    public void setCropURL() {
        String element;

        try {
            element = this.data.get(17);

            if (element == null)
                element = "---";

        } catch (IndexOutOfBoundsException e) {
            element = "---";
        }

        if (element.startsWith("\"") && element.endsWith("\"")) {
            element = element.substring(1, element.length());
            element = element.substring(0, element.length() - 1);
        }

        if (element.equals("") || element.equals("-") || element.equals(" "))
            element = "---";

        this.cropURL = element;
    }

    public ArrayList<String> getData() {
        return this.data;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getYear() {
        return this.year;
    }

    public String getTest() {
        return this.test;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public String getQuestionID() {
        return this.questionID;
    }

    public String getObject() {
        return this.object;
    }

    public String getDetailedObject() {
        return this.detailedObject;
    }

    public String getAnswerKey() {
        return this.answerKey;
    }

    public String getCourseSuccesses() {
        return this.courseSuccesses;
    }

    public String getRegionSuccesses() {
        return this.regionSuccesses;
    }

    public String getCountrySuccesses() {
        return this.countrySuccesses;
    }

    public String getCountryCourseSuccessesDifference() {
        return this.countryCourseSuccessesDifference;
    }

    public String getText() {
        return this.text;
    }

    public String getImage() {
        return this.image;
    }

    public String getTestURL() {
        return this.testURL;
    }

    public String getSynopsisURL() {
        return this.synopsisURL;
    }

    public String getCourseURL() {
        return this.courseURL;
    }

    public String getCropURL() {
        return this.cropURL;
    }

    public void printData() {
        for (String s : this.data) {
            if (s != null)
                System.out.println(s + "\n");
        }
    }

}