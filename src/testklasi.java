/**
 * Created by Enes on 13.04.2017.
 */
public class testklasi {
    static permutaitiontables t = new permutaitiontables();


    public static void main(String []args){

        String s ="00000000111111110000100110100100";

        String ss="";
        for (int i = 0; i <32 ; i++) {

            ss+=s.charAt(t.expansionPermutation[i]-1);

        }

        System.out.print(ss);



    }

}
