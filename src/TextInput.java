import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Enes on 8.04.2017.
 */
public class  TextInput {



    public TextInput(){


    }


    public String textOku(String path) throws IOException {

        BufferedReader b1 = new BufferedReader(new FileReader(path));

        return b1.readLine();

    }


}
