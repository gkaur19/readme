package CryptoManager;


/*
* Class: CMSC203 20813
* Instructor: Ahmed Tarek
* Description: This program encrypts and decrypts messages using three classic ciphers: Vigenere, Playfair, and Caesar. 
  It scrambles text based on a key so only someone with the right key can read it.
   The program uses basic Java features and a simple interface to help you
   learn how these old encryption methods work
* Due: 10/15/2025
* Platform/compiler: Eclipse-workspace
* I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Gurleen kaur 
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
    	if (!isStringInBounds(plainText))
            return "The selected string is not in bounds, Try again.";

    	StringBuilder result = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char p = plainText.charAt(i);
            char k = key.charAt(i % key.length());

            int pIndex = ALPHABET64.indexOf(p);
            int kIndex = ALPHABET64.indexOf(k);

            if (pIndex == -1 || kIndex == -1) {
                // Character not in ALPHABET64
                result.append(p);
                continue;
            }

            int encryptedIndex = (pIndex + kIndex) % ALPHABET64.length();
            result.append(ALPHABET64.charAt(encryptedIndex));
        }
        return result.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
    	if (!isStringInBounds(encryptedText))
            return "The selected string is not in bounds, Try again.";

    	 StringBuilder result = new StringBuilder();
    	    for (int i = 0; i < encryptedText.length(); i++) {
    	        char c = encryptedText.charAt(i);
    	        char k = key.charAt(i % key.length());

    	        int cIndex = ALPHABET64.indexOf(c);
    	        int kIndex = ALPHABET64.indexOf(k);

    	        if (cIndex == -1 || kIndex == -1) {
    	            // Character not in ALPHABET64
    	            result.append(c);
    	            continue;
    	        }

    	        int decryptedIndex = (cIndex - kIndex + ALPHABET64.length()) % ALPHABET64.length();
    	        result.append(ALPHABET64.charAt(decryptedIndex));
    	    }
    	    return result.toString();
    	}


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
         //to be implemented by students
    	
    	    String allowedChars = ALPHABET64;

    	    
    	    key = key.toUpperCase();
    	    StringBuilder filteredKey = new StringBuilder();
    	    for (char c : key.toCharArray()) {
    	        if (allowedChars.indexOf(c) != -1 && filteredKey.indexOf("" + c) == -1) {
    	            filteredKey.append(c);
    	        }
    	    }

    	    // Build matrix
    	    StringBuilder matrixChars = new StringBuilder(filteredKey);
    	    for (char c : allowedChars.toCharArray()) {
    	        if (matrixChars.indexOf("" + c) == -1) matrixChars.append(c);
    	    }

    	    char[][] matrix = new char[8][8];
    	    int idx = 0;
    	    for (int i = 0; i < 8; i++)
    	        for (int j = 0; j < 8; j++)
    	            matrix[i][j] = matrixChars.charAt(idx++);

    	    // Clean plaintext which only allow chars
    	    plainText = plainText.toUpperCase();
    	    StringBuilder cleanedText = new StringBuilder();
    	    for (char c : plainText.toCharArray()) {
    	        if (allowedChars.indexOf(c) != -1) cleanedText.append(c);
    	    }

    	    // Pad if odd length
    	    if (cleanedText.length() % 2 != 0) cleanedText.append('X');

    	    StringBuilder encrypted = new StringBuilder();
    	    for (int k = 0; k < cleanedText.length(); k += 2) {
    	        char a = cleanedText.charAt(k);
    	        char b = cleanedText.charAt(k + 1);

    	        int[] posA = findPosition(matrix, a);
    	        int[] posB = findPosition(matrix, b);

    	        if (posA[0] == posB[0]) { // same row
    	            encrypted.append(matrix[posA[0]][(posA[1] + 1) % 8]);
    	            encrypted.append(matrix[posB[0]][(posB[1] + 1) % 8]);
    	        } else if (posA[1] == posB[1]) { // same column
    	            encrypted.append(matrix[(posA[0] + 1) % 8][posA[1]]);
    	            encrypted.append(matrix[(posB[0] + 1) % 8][posB[1]]);
    	        } else { // rectangle
    	            encrypted.append(matrix[posA[0]][posB[1]]);
    	            encrypted.append(matrix[posB[0]][posA[1]]);
    	        }
    	    }

    	    return encrypted.toString();
    	}


    // playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
    	String allowedChars = ALPHABET64;

        key = key.toUpperCase();
        StringBuilder filteredKey = new StringBuilder();
        for (char c : key.toCharArray())
            if (allowedChars.indexOf(c) != -1 && filteredKey.indexOf("" + c) == -1)
                filteredKey.append(c);

        StringBuilder matrixChars = new StringBuilder(filteredKey);
        for (char c : allowedChars.toCharArray())
            if (matrixChars.indexOf("" + c) == -1)
                matrixChars.append(c);

        char[][] matrix = new char[8][8];
        int idx = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                matrix[i][j] = matrixChars.charAt(idx++);

        StringBuilder decrypted = new StringBuilder();
        for (int k = 0; k < encryptedText.length(); k += 2) {
            char a = encryptedText.charAt(k);
            char b = encryptedText.charAt(k + 1);

            int[] posA = findPosition(matrix, a);
            int[] posB = findPosition(matrix, b);

            if (posA[0] == posB[0]) { // same row
                decrypted.append(matrix[posA[0]][(posA[1] + 7) % 8]);
                decrypted.append(matrix[posB[0]][(posB[1] + 7) % 8]);
            } else if (posA[1] == posB[1]) { // same column
                decrypted.append(matrix[(posA[0] + 7) % 8][posA[1]]);
                decrypted.append(matrix[(posB[0] + 7) % 8][posB[1]]);
            } else { // rectangle
                decrypted.append(matrix[posA[0]][posB[1]]);
                decrypted.append(matrix[posB[0]][posA[1]]);
            }
        }

        return decrypted.toString();
    }

    // to Find position in matrix
    private static int[] findPosition(char[][] matrix, char c) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null; 
    }



	/**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
	//to be implemented by students
    	

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            int shifted = c + key;

            if (shifted > UPPER_RANGE)
                shifted -= RANGE;// wrap around

            result.append((char) shifted);
        }

        return result.toString();
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
	//to be implemented by students
    	
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            int shifted = c - key;

            if (shifted < LOWER_RANGE) {
            	shifted += RANGE; // wrap around
            }
            result.append((char) shifted);
        }
        return result.toString();
    }   
    }
    
    


