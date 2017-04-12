import java.io.IOException;

/**
 * Created by Enes on 9.04.2017.
 */
public class Text {

    private String path = "merhaba.txt";
    private String pathKey="key.txt";
    public static TextInput textInput;
    public String [][] bits = new String [8][8];
    public String [] subKeysFourtyEightBitsPermutated = new String[16];
    public permutaitiontables p;


    public Text (){
        textToBinary();
        getSubKeys();
    }

    public void getSubKeys(){

        textInput=new TextInput();
        String key = null;
        String fiftySixBitPermutedKey ="";
        String [] subKeyLeft28Bits = new String[17];
        String [] subKeyRight28Bits = new String[17];
        String [] subKeysFiftySixBits = new String[16];


        p=new permutaitiontables();
        try {
            key = textInput.textOku(pathKey);
        } catch (IOException e) {
            e.printStackTrace();
        }

        char [] keyCharacters = new char[8];

        String mainKeyBitStatus = "";

        for (int i = 0; i <8 ; i++) {

            keyCharacters [i] = key.charAt(i);
            mainKeyBitStatus += String.format("%08d",Integer.parseInt(Integer.toBinaryString(keyCharacters[i])));

        }

        for (int i = 0; i <56 ; i++) {

            fiftySixBitPermutedKey += mainKeyBitStatus.charAt(p.toFiftySixBitsKey[i]-1);

        }

        subKeyLeft28Bits[0]=fiftySixBitPermutedKey.substring(0,28);
        subKeyRight28Bits[0]=fiftySixBitPermutedKey.substring(28,56);




        for (int i=0; i<16 ; i++){


            subKeyLeft28Bits[i+1]=cyclicLeftShift(subKeyLeft28Bits[i],p.shiftingOperation[i]-1);
            subKeyRight28Bits[i+1]=cyclicLeftShift(subKeyRight28Bits[i],p.shiftingOperation[i]-1);

            subKeysFiftySixBits[i]=subKeyLeft28Bits[i+1]+subKeyRight28Bits[i+1];



        }


        for (int j= 0;j<16;j++) {

            subKeysFourtyEightBitsPermutated[j]="";

            for (int i=0;i<48;i++) {

                subKeysFourtyEightBitsPermutated[j] += subKeysFiftySixBits[j].charAt(p.toFourtyEightBitsKey[i]-1);

            }

        }

        for (int i = 0; i < 16; i++) {

            System.out.println(i+".subKey \t"+subKeysFourtyEightBitsPermutated[i]);

        }



    }

    public void textToBinary(){

        textInput = new TextInput();
        String plainText = null;
        try {
            plainText = textInput.textOku(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        char [][] karakterler = new char [plainText.length()/8][8];

        String [] splittedStrings = new String[plainText.length()/8];



        String eightBitConversion;

        int x=0;
        int y=8;

        for (int i = 0; i < plainText.length()/8 ; i++) {

            splittedStrings[i]=plainText.substring(x,y);

            x+=8;
            y+=8;

        }

        int s = 0;
            for (int i = 0; i < plainText.length() / 8; i++) {



            for (int j = 0; j < 8; j++) {

                karakterler[i][j] = splittedStrings[i].charAt(j);

                eightBitConversion = String.format("%08d", Integer.parseInt(Integer.toBinaryString(karakterler[i][j])));



                bits[i][j]=eightBitConversion;

            }

        }

    }


    public static String cyclicLeftShift(String s, int k){
        k = k%s.length();
        return s.substring(k) + s.substring(0, k);
    }



}
