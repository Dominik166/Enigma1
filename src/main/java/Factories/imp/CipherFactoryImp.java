
package Factories.imp;
import impl.Cipher;
import impl.CesarCipher;
import impl.Root13Cipher;
import exceptions.CipherNotFoundException;
import impl.CesarCipher;

public class CipherFactoryImp implements Factories.CipherFactory {
    public static final String CESAR = "cipher";
    public static final String ROOT13 = "root13";
    @Override
    public Cipher create(String type) {
        if(type.equals(CESAR)){
            return new CesarCipher();
        }
        if(type.equals(ROOT13)){
            return new Root13Cipher();
        }
        throw new CipherNotFoundException(type);
    }
}