/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: Benjamin Chock
 *</p>
 */

public class DNA {
    private static long p = 93407293830438353L;
    private static long RM = 1;
    private static int radix = 256;
    private static int patLen;
    private static long patHash;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int StrCount = 0;
        patLen = STR.length();

        for (int i = 1; i <= patLen-1; i++){
            RM = (radix * RM) % p;
        }
        patHash = hash(STR, patLen);
        
        return StrCount;
    }

    private static long hash(String STR, int patLen){
        long StrHash = 0;
        for (int i = 0; i < patLen; i++){
            StrHash = (radix * StrHash + STR.charAt(i)) % p;
        }
        return StrHash;
    }


    public static boolean check(int i){
        return true;
    }

    private static int search(String text){
        int textLen = text.length();
        long textHash = hash(text, patLen);
        if (patHash == textHash && check(0)){
            return 0;
        }
        for (int i = patLen; i < textLen; i++){
            textHash = (textHash + p - RM*text.charAt(i-patLen) % p) % p;
            textHash = (textHash * radix + text.charAt(i)) % p;
            if (patHash == textHash){
                if (check(i-patLen+1)){
                    return i-patLen+1;
                }
            }
        }
        return textLen;
    }

}
