/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: [YOUR NAME HERE]
 *</p>
 */

public class DNA {


    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int StrCount = 0;
        
        return StrCount;
    }

    public int STRCountInterative(String sequence, String STR){
        int StrCount = 0;
        int biggest = 0;
        String temp_STR;
        String temp_STR_old = "";
        while (sequence.length() > STR.length()){
            temp_STR = sequence.substring(0,STR.length());
            if (temp_STR.equals(STR)){
                temp_STR_old = temp_STR;
            }
            if (temp_STR.equals(temp_STR_old)){
                biggest++;
                sequence = sequence.substring(STR.length());
            }
            else{
                if (biggest > StrCount){
                    StrCount = biggest;
                }
                biggest = 0;
                sequence = sequence.substring(1);
            }

        }
        return StrCount;
    }

    public void StrtoInt(String STR, int length){
        //Integer pasre int == 0(n)
        //
        int intSTR = 0;
        
        for (int i =0; i < length; i++){
            intSTR += (int) STR.charAt(i);
        }
    }
}
