import java.util.ArrayList;
import java.util.Arrays;

class CourseData {
    private ArrayList<String> data;
    private String courseName;
    private String year;
    private String test;
    private String questionType;
    private String questionID;
    private String object;
    private String detailedObject;
    private String courseSuccesses;
    private String regionSuccesses;
    private String countrySuccesses;
    private String countryCourseSuccessesDifference;
    private String text;
    private String image;
    private String testURL;
    private String synopsisURL;
    private String courseURL;
    private String cropURL;

    private void setData(String data) {
        ArrayList<String> organizedData = new ArrayList<String>();
        ArrayList<String> unorganizedData = new ArrayList<String>(Arrays.asList(data.split(",")));
        StringBuffer sBuffer = new StringBuffer();

        // Precisa ter tamanho 18
        String element;
        int index = 0;
        int length = unorganizedData.size();

        System.out.println(length);
    }

    CourseData(String data) {
        setData(data);
    }

    public void printData() {
        for (String s : this.data) {
            System.out.println(s + "\n");
        }
    }

}