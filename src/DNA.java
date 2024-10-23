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
    private static final long p = 93407293830438353L;
    private static long RM = 1;
    private static final int radix = 256;
    private static int patLen;
    private static long patHash;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        RM = 1;
        int StrCount = 0;
        int curStrCount = 0;
        patLen = STR.length();
        //compute R^(patlen-1) %p for removeing leading digit
        for (int i = 1; i <= patLen-1; i++){
            RM = (radix * RM) % p;
        }
        patHash = hash(STR,0 ,patLen);
        int start = 0;
        int startSTR = 0;
        int locationChange;
        //check for very first match
        locationChange = search(sequence, start);
        startSTR = locationChange;
        start = locationChange;
        curStrCount++;
        while (start+patLen < sequence.length()){
            locationChange = search(sequence, start);
            //if matches are neighbors increase count
            if (locationChange == startSTR + patLen){
                if (curStrCount > StrCount){
                    StrCount = curStrCount;
                }
                curStrCount++;
                startSTR = locationChange;
                start = locationChange;
            }
            //if match is first match/not neighbor reset count add 1
            else if (locationChange != -1){
                curStrCount = 0;
                curStrCount++;
                startSTR = locationChange;
                start = locationChange;
            }
            //no match return Str Count
            else{
                return StrCount;
            }

        }
        return StrCount;
    }

    //compute hash for STR
    private static long hash(String STR, int start ,int patLen){
        long StrHash = 0;
        for (int i = start; i < start+patLen; i++){
            StrHash = (radix * StrHash + STR.charAt(i)) % p;
        }

        return StrHash;
    }

    //Check (doesn't actually do anything)
    public static boolean check(int i){
        return true;
    }

    private static int search(String text, int start){
        int textLen = text.length();
        long textHash = hash(text, start, patLen);
        //if match return index of match
        if (patHash == textHash && check(0)){
            return start+patLen;
        }
        //search for match in text
        for (int i = start+patLen; i < textLen; i++){
           //remove leading digit and check for match
            textHash = (textHash + p - RM*text.charAt(i-patLen) % p) % p;
            textHash = (textHash * radix + text.charAt(i)) % p;
            if (patHash == textHash){
                if (check(i-patLen+1)){
                    //return index of match
                    return i-patLen+1;
                }
            }
        }
        //if no match return -1
        return -1;
    }

}
