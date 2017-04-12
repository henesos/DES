/**
 * Created by Enes on 10.04.2017.
 */
public class deneme {

    public String wordKey;
    public String [] subKeys;
    public String bitsToBeTransformedInStringStatus ="";
    public String leftBits;
    public String rightBits;


    public void getStringBits(Text getBits){

         getBits=new Text();

        for (int i = 0; i <8 ; i++) {

            bitsToBeTransformedInStringStatus+=getBits.bits[0][i];

        }

        leftBits=bitsToBeTransformedInStringStatus.substring(0,32);
        rightBits=bitsToBeTransformedInStringStatus.substring(32,64);





    }

    public String function(){



        return ";";
    }





}
