import impl.Cipher;
import impl.CesarCipher;

public class Test {
    public static void main(String[] args) {
        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode ("hjdkhfkjsghkjs");
        System.out.println(example);
        String decoded = cesarCipher.decode("daB12Nmlkkhhh mkj");
        System.out.println(decoded);

    }
}
