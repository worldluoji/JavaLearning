import com.google.common.annotations.VisibleForTesting;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIDGenerator implements IDGenerator {

    private static final int RANDOM_LEN = 6;
    private static final List<Character> dict;
    private static int dictSize;

    static {
        dict = new ArrayList<Character>();
        for (char c = '0'; c <= '9'; c++) {
           dict.add(c); 
        }
        for (char c = 'a'; c <= 'z'; c++) {
           dict.add(c); 
        }
        for (char c = 'A'; c <= 'Z'; c++) {
           dict.add(c); 
        }
        dictSize = dict.size();
    }

    @Override
    public String generate() throws IDGeneratorException {
        String lastFiledOfHostName = null;
        try {
            lastFiledOfHostName = getLastFieldOfHostName(); 
        } catch (final UnknownHostException e) {
            e.printStackTrace();
            throw new IDGeneratorException(); 
        }
        return lastFiledOfHostName + System.currentTimeMillis() + getRandomAlphaBetaMetric(RANDOM_LEN);
    }

    private String getLastFieldOfHostName() throws UnknownHostException {
        final String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(hostName);
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException();
        }
        return getLastSubStrSplittedByDot(hostName);
    }

    @VisibleForTesting
    protected String getLastSubStrSplittedByDot(final String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] tokens = hostName.split("\\.");
        return tokens[tokens.length-1];
    }

    @VisibleForTesting
    protected String getRandomAlphaBetaMetric(final int len) {
        if (len <= 0 ) {
            throw new IllegalArgumentException();
        }
        char[] randomChars = new char[len];
        int count = 0;
        Random random = new Random();
        while (count < len) {
            final int randomInt = random.nextInt(dictSize);
            randomChars[count++] = dict.get(randomInt);
        }
        return new String(randomChars);
    }
}
