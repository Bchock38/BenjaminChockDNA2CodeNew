public class RabinKarp {

    private long patHash; //Pattern hash value
    private int patLen; //pattern length
    private long p; //Large Prime
    private int radix = 256;
    private long RM; // R^(m-1) % p

    public RabinKarp(String pat){
        patLen = pat.length();
        p = 93407293830438353L;
        RM = 1;
        for (int i = 1; i <= patLen-1; i++){
            RM = (radix * RM) % p;
        }
        patHash = hash(pat, patLen);
    }

    public boolean check(int i){
        return true;
    }
    private long hash(String STR, int patLen){
        long StrHash = 0;
        for (int i = 0; i < patLen; i++){
            StrHash = (radix * StrHash + STR.charAt(i)) % p;
        }
        return StrHash;
    }

    private int search(String text){
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
