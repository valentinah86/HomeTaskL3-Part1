package Application;

import java.io.*;

public class Results {

    public Results() {
    }

    public void writeResults (String filename, String data) throws FileNotFoundException {

        File file = new File(filename);
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                out.println(data + "\n");
                out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();

        }
    }


}
