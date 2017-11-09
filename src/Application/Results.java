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


    public void readResults (String filename) throws IOException {
        File file = new File(filename);
        String data;

        try (BufferedReader stream = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            System.out.println("data from file" + filename + "\n");
            while ((stream.readLine()) !=null) {
                data = stream.readLine();
                if (data!= null){
                    System.out.println("\n" + data);
                } else {break;}


            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
