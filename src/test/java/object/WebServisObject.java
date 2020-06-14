package object;

import java.util.Arrays;

public class WebServisObject {
    public String code;
    public MyUser[] data;

    @Override
    public String toString() {
        return "WebServisObject {" +
                "code='" + code + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
