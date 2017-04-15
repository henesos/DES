/**
 * Created by Enes on 10.04.2017.
 */
public class RoundIslemi {

    private String permutedFinal64Bits="";
    private String plainTextBinary="";
    public permutaitiontables ptable = new permutaitiontables();
    Text textHandler = new Text();

    public RoundIslemi(){

        Encrpty();
        Decryption();

    }

    /**********************************************************************************
     **************  Enkript i?lemini burada uygular?z  *******************************
     ************************************************************** ******************/

    public void Encrpty(){

        String [] leftBits= new String[17];
        String [] rightBits= new String[17];

        String bitsToBeTransformedInStringStatus ="";
        String finalLeftRightbirlesik="";
        String initialPermutaition64bits="";


        System.out.print(
                "*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+
                        "\n*******************************************************" +"ENCRPTYION"+

                        "\n");


        for (int i = 0; i <8 ; i++) {

            bitsToBeTransformedInStringStatus += textHandler.bits[0][i];

        }



        System.out.println("maintexttobin--"+bitsToBeTransformedInStringStatus);

        for (int i = 0; i <64 ; i++) {

            initialPermutaition64bits +=bitsToBeTransformedInStringStatus.charAt(ptable.initialPermutation[i]-1);

        }

        System.out.println("initial64------"+initialPermutaition64bits);

        leftBits[0] = initialPermutaition64bits.substring(0, 32);
        rightBits[0] = initialPermutaition64bits.substring(32, 64);

        for (int rounds = 0; rounds <16 ; rounds++) {

                if (rounds==0){

                    System.out.println("left"+rounds+"---------"+leftBits[rounds]);

                    System.out.println("right"+rounds+"--------"+rightBits[rounds]);

                    rightBits[rounds+1]=rightLeftXoring(function(rightBits[rounds],rounds),leftBits[rounds]);
                    leftBits[rounds+1]=rightBits[rounds];





                }else {

                    System.out.println("left"+rounds+"------------"+leftBits[rounds]);
                    System.out.println("right"+rounds+"-----------"+rightBits[rounds]);

                    rightBits[rounds+1]=rightLeftXoring(function(rightBits[rounds], rounds), leftBits[rounds]);
                    leftBits[rounds+1]=rightBits[rounds];

                    System.out.println("*************************************"+"Round-"+rounds+"************************************");

                    System.out.println("left"+(rounds+1)+"------------"+leftBits[rounds+1]);
                    System.out.println("right"+(rounds+1)+"-----------"+rightBits[rounds+1]);

                }

        }

        finalLeftRightbirlesik =leftBits[16]+rightBits[16];

        System.out.println("finalunpermuna-"+finalLeftRightbirlesik);

        for (int i = 0; i <64 ; i++) {

            permutedFinal64Bits += finalLeftRightbirlesik.charAt(ptable.finalInitialPermutation[i]-1);

        }

          System.out.println("ciphertext----"+permutedFinal64Bits+"\n\n\n\n");


    }

    /**********************************************************************************
     ********************  Dekript i?lemini burada uygular?z  *************************
     ************************************************************** ******************/

    public void Decryption(){

        String [] leftBits= new String[17];
        String [] rightBits= new String[17];
        String finalLeftRightbirlesik="";
        String initialPermutaition64bits="";


        System.out.print(
                "*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+
                        "\n*******************************************************" +"DECRPYTION"+

                "\n");

        for (int i = 0; i <64 ; i++) {

            initialPermutaition64bits +=permutedFinal64Bits.charAt(ptable.initialPermutation[i]-1);

        }

        System.out.println("initial64------"+initialPermutaition64bits);

        leftBits[16] = initialPermutaition64bits.substring(0, 32);
        rightBits[16] = initialPermutaition64bits.substring(32, 64);

        for (int rounds = 15; rounds >=0 ; rounds--) {

            if (rounds==15){

                System.out.println("right"+rounds+"---------"+rightBits[rounds+1]);

                System.out.println("left"+rounds+"--------"+leftBits[rounds+1]);

                leftBits[rounds]=rightLeftXoring(function(leftBits[rounds+1],rounds),rightBits[rounds+1]);
                rightBits[rounds]=leftBits[rounds+1];

            }else {

                System.out.println("right"+rounds+"---------"+rightBits[rounds+1]);
                System.out.println("left"+rounds+"--------"+leftBits[rounds+1]);


                leftBits[rounds]=rightLeftXoring(function(leftBits[rounds+1], rounds), rightBits[rounds+1]);
                rightBits[rounds]=leftBits[rounds+1];

                System.out.println("*************************************"+"Round-"+rounds+"************************************");

                System.out.println("right"+(rounds)+"---------"+rightBits[rounds]);
                System.out.println("left"+(rounds)+"----------"+leftBits[rounds]);

            }

        }

        finalLeftRightbirlesik =leftBits[0]+rightBits[0];

        System.out.println("finalunpermuna-"+finalLeftRightbirlesik);

        for (int i = 0; i <64 ; i++) {

            plainTextBinary += finalLeftRightbirlesik.charAt(ptable.finalInitialPermutation[i]-1);

        }

        System.out.println("ChiperText-----"+permutedFinal64Bits);
        System.out.println("plaintText-----"+plainTextBinary);

    }


    /**********************************************************************************
     *****************  Fonksiyon i?lemi t?m i? Fonksiyonlar?yla ****  ****************
     ************************************************************** ******************/

    public String function(String rightBits, int round){

        String data48Bits="";
        String xORlanmis="";
        String fonksiyonCikisBit="";

        System.out.println("32bit----------"+rightBits+"\t");

        data48Bits = Expansion(rightBits);


            System.out.println("data48bits000--" + data48Bits + "\t");
            System.out.println("subkey---------"+textHandler.subKeysFourtyEightBitsPermutated[round]);


        xORlanmis =xOR(data48Bits,round);

            System.out.println("xorlanmis------"+xORlanmis+"\t");

        fonksiyonCikisBit=SBox(xORlanmis,round);

            System.out.println("Pkutusu--------"+fonksiyonCikisBit+"\t");

        return fonksiyonCikisBit;


    }
    /**********************************************************************************
     **************  32-Bitlik Veriyi 48 Bite GEni?letme i?lemi  **********************
     ************************************************************** ******************/
    public String Expansion(String rightBits){

        String right32Bits="";

        for (int i = 0; i <48 ; i++) {

            right32Bits += rightBits.charAt(ptable.expansionPermutation[i]-1);

        }

        return right32Bits;
    }

    /**********************************************************************************
     **************  Roundun Keyi ile Roundun Sag bitini XORlama  *********************
     ************************************************************** ******************/
    public String xOR(String right48Bits,int round){

        String xORlanmisBitler="";
        String subKey;

        for (int i = 0; i < 48; i++) {

            subKey = textHandler.subKeysFourtyEightBitsPermutated[round];



            if (right48Bits.charAt(i) == '1' && subKey.charAt(i) == '1') {

                xORlanmisBitler += '0';

            } else if (right48Bits.charAt(i) == '0' && subKey.charAt(i) == '1') {

                xORlanmisBitler += '1';

            } else if (right48Bits.charAt(i) == '1' && subKey.charAt(i) == '0') {

                xORlanmisBitler += '1';

            } else if (right48Bits.charAt(i) == '0' && subKey.charAt(i) == '0') {

                xORlanmisBitler += '0';

            }

        }


        return xORlanmisBitler;
    }


    /**********************************************************************************
     *****  SBox ??lemi ile B?rlikte 48 bitlik veriden 32 Bitlik veri elde edimi  *****
     ************************************************************** ******************/
    public String SBox(String right48Bits , int round){

        String sIslemineGirmisBitler="";
        String sIslemiPPermutasyunanaugramisbitler="";
        String row="";
        String column="";
        int rowValue;
        int columnValue;


        int x=0;
        for(int i = 0; i <=42 ; i+=6) {

            row +=right48Bits.substring(i,i+6).charAt(0);
            row +=right48Bits.substring(i,i+6).charAt(5);
            column +=right48Bits.substring(i+1,i+5);

            rowValue=Integer.parseInt(row,2);
            columnValue = Integer.parseInt(column,2);

            sIslemineGirmisBitler +=String.format("%04d",Integer.parseInt(Integer.toBinaryString(ptable.sBoxes[x][rowValue][columnValue])));

            row ="";
            column="";
            x++;




        }


        System.out.println("inTheSBOX------"+sIslemineGirmisBitler);

        for (int i = 0; i <32 ; i++) {

            sIslemiPPermutasyunanaugramisbitler += sIslemineGirmisBitler.charAt(ptable.pBox[i]-1);

        }

        return sIslemiPPermutasyunanaugramisbitler;

    }



    /**********************************************************************************
     **************  Round Sonu ??lemi Sa? ve Sol Bitleri Xorlanmas?  *****************
     ************************************************************** ******************/
    public String rightLeftXoring(String rightBits, String leftBits){

        String sag32bitxorlanmis="";



        for (int i = 0; i < 32; i++) {

            if (rightBits.charAt(i) == '1' && leftBits.charAt(i) == '1') {

                sag32bitxorlanmis += '0';

            } else if (rightBits.charAt(i) == '0' && leftBits.charAt(i) == '1') {

                sag32bitxorlanmis += '1';

            } else if (rightBits.charAt(i) == '1' && leftBits.charAt(i) == '0') {

                sag32bitxorlanmis += '1';

            } else if (rightBits.charAt(i) == '0' && leftBits.charAt(i) == '0') {

                sag32bitxorlanmis += '0';

            }

        }



        return sag32bitxorlanmis;


    }



}
