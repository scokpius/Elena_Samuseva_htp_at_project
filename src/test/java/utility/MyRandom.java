package utility;

public class MyRandom {
    private static java.util.Random random = new java.util.Random();

    public static String randomPassword(final int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(random.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }
}
