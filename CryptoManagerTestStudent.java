package CryptoManager;


import junit.framework.TestCase;

/**
 * Student JUnit tests for CryptoManager methods.
 * 
 * @author gurleen kaur
 * @version 10/13/2025
 */
public class CryptoManagerTestStudent extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    // Test for isStringInBounds using different strings
    public void testIsStringInBoundsStudent() {
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD!"));
        assertFalse(CryptoManager.isStringInBounds("hello world!")); // lowercase not allowed
        assertTrue(CryptoManager.isStringInBounds("HELLO$WORLD#")); // special chars if out of bounds
    }

    // Test for Vigenere encryption/decryption
    public void testVigenereEncryptDecryptStudent() {
        String plain = "HELLO2025!";
        String key = "KEY123!";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }

    // Test for Playfair encryption/decryption
    public void testPlayfairEncryptDecryptStudent() {
        String plain = "WORLD2025!";
        String key = "PLAY123!";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }

    // Test for Caesar encryption/decryption
    public void testCaesarEncryptDecryptStudent() {
        String plain = "TEST 2025!";
        int key = 5;
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
}
