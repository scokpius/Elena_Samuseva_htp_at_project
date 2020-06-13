package utility;

import javax.xml.crypto.MarshalException;
import java.io.*;

public class WriteReadFail {
    private static StringBuilder text = new StringBuilder();

    public static void writerToFile(String resultFile, String login, String password) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
            pw.print(login + "\n" + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readInFileToStringBuilder(String fileName) {
        try (BufferedReader fileText = new BufferedReader (new FileReader(fileName))
        ){
            String line;
            while ((line = fileText.readLine()) != null){
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("File cannot be read!!!");
        }
        return text.toString();
    }


}
