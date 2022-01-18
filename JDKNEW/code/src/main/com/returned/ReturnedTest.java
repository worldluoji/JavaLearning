package src.main.com.returned;

import java.nio.charset.StandardCharsets;

import src.main.com.returned.Returned.ErrorCode;
import src.main.com.returned.Returned.ReturnValue;

public class ReturnedTest {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-128");
        /**
        * 这样不需要异常处理，如果返回类型是ErrorCode，就进行错误处理，如果是ReturnVlaue，则说明正常处理
        * 不用异常处理，提高了性能，但也额外增加了我们对错误信息的打印处理，毕竟异常处理可以看到调用栈。
        **/
        switch (rt) {
            case ReturnValue rv -> {
                    Digest d = (Digest) rv.returnValue();
                    byte[] b = d.digest("Hello, world!".getBytes(StandardCharsets.UTF_8));
                    System.out.println(new String(b, StandardCharsets.UTF_8));
                }
            case ErrorCode ec ->
                    System.getLogger("co.ivi.jus.stack.union")
                          .log(System.Logger.Level.INFO, "Failed to get instance of SHA-128");
        }
    }

}
