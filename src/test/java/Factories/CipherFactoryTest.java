package Factories;

import Factories.imp.CipherFactoryImp;
import exceptions.CipherNotFoundException;
import impl.CesarCipher;
import impl.Cipher;
import impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CipherFactoryTest {
    private static final String MESSAGE = " Type of cipher has not been recognized";
    CipherFactoryImp factory = new CipherFactoryImp();

    @Test
    protected void ifCesarCipherInstanceRetarnedWithCesarTypeTest(){
        Cipher cipher = factory.create(CipherFactoryImp.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher);
    }

    @Test
    protected void ifRoot13CipherInstanceRetarnedWithRoot13CipherTest(){
        Cipher cipher = factory.create(CipherFactoryImp.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }
    @Test
    protected void shouldThrowExceptionWithGivenUnknownType(){
        String unknown = "unknown";
        Assertions.assertThrows( CipherNotFoundException.class,()-> factory.create(unknown),
             MESSAGE + unknown);  // lambda jest executable

    }




}
