package mediaplaeyr;

import java.io.IOException;
import java.util.ArrayList;


public class ArraySound extends ArrayList<String> {

     int mods = 0;
     ArrayList<String> adder = new ArrayList<>();

    ArraySound() throws IOException {
        TxtSoundArray.addStyle(adder);
        if(mods==0) {
            for (int j = 0; j < adder.size(); j++) {
                System.out.println(adder.get(j));

                super.add(adder.get(j));
                if (j == adder.size() - 1) {

                }
            }
                    super.add("excision-pegboard-nerds_bring-the-madness.wav");
                    super.add("cat.wav");

        }
    }
}



