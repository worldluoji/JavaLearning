import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo {
    public static int countWord(String filename, String word) throws IOException {
        if (filename == null || "".equals(filename) || word == null || "".equals(word)) {
            return 0;
        }
        File file = new File(filename);
        if (!file.exists()) {
            return 0;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = br.readLine();
        int count = 0;
        while(line != null) {
            while (line.contains(word)) {
                line = line.substring(line.indexOf(word) + word.length());
                count++;
            }
            line = br.readLine();
        }
        return count;
    }
    public class MyTask extends Thread implements Runnable {
        @Override
        public void run() {

        }
    }
    public static void main(String[] args) throws IOException {

    }
}
