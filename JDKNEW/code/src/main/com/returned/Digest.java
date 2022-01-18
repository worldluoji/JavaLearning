package src.main.com.returned;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import src.main.com.returned.Returned.ErrorCode;
import src.main.com.returned.Returned.ReturnValue;

public sealed abstract class Digest {
    private static final class SHA256 extends Digest {
        @Override
        byte[] digest(byte[] message) {
            MessageDigest messageDigest;
        
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(message);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    
    private static final class SHA512 extends Digest {
        @Override
        byte[] digest(byte[] message) {
            MessageDigest messageDigest;
        
            try {
                messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.update(message);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    // public static Digest of(String algorithm) throws NoSuchAlgorithmException {
    //     return switch (algorithm) {
    //         case "SHA-256" -> new SHA256();
    //         case "SHA-512" -> new SHA512();
    //         default -> throw new NoSuchAlgorithmException();
    //     };
    // }

    public static Returned<Digest> of(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> new ReturnValue(new SHA256());
            case "SHA-512" -> new ReturnValue(new SHA512());
            case null, default -> {
                //  这样可以打印调用栈
                System.getLogger("co.ivi.jus.stack.union")
                      .log(System.Logger.Level.INFO, "Unknown algorithm is specified " + algorithm, 
                           new Throwable("the calling stack"));
                yield new ErrorCode(-1);
            }
        };
    }

    abstract byte[] digest(byte[] message);
}