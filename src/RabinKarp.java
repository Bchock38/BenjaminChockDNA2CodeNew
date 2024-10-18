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
}
