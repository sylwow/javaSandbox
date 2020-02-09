import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class libraryCode {
    public static void main(String[] args) {
        library();
    }

    public static void library() {
        Scanner oi;
        try {
            File myObj = new File("codes.txt");
            oi = new Scanner(myObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int libraryLen = oi.nextInt();
        int requestLen = oi.nextInt();
        String code = oi.nextLine();
        Map<String, Integer> library = new HashMap<String, Integer>();
        while (libraryLen-- != 0) { //get codes into library
            code = oi.nextLine();
            Integer val = library.get(code);
            if (val == null)
                library.put(code, 1);
            else
                library.put(code, ++val);
        }
        while (requestLen-- != 0) {
            code = oi.nextLine();
            Integer val = library.get(code);
            if (val == null)
                System.out.println("BRAK");
            else
                System.out.println(val);
        }
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static void saveRandStrings() {
        try {
            File myObj = new File("codesolnynl.txt"); // Specify the filename
            myObj.createNewFile();
            int codes = 500000;
            int requests = 200000;
            FileWriter myWriter = new FileWriter("codesolnynl.txt");
            myWriter.write(codes + " ");
            myWriter.write(requests + "\n");
            while (codes-- != 0) {
                myWriter.write(randomAlphaNumeric(6) + "\n");
                if (codes % 1000 == 0)
                    System.out.println(codes);
            }
            while (requests-- != 0)
                myWriter.write(randomAlphaNumeric(6) + "\n");
            myWriter.close();
        } catch (Exception e) {
            ;
        }
    }

}
