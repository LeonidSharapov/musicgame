package mediaplaeyr;

import java.io.*;
import java.util.ArrayList;

public class SoundList {

  private  FileOutputStream trr;
 private  int dubl = 0;
  private    String c ="";
    private   String d ="";

  public SoundList() throws IOException {


  }

   String addmusic(String  brr){
      c=brr;
      d=brr;
      return "";

    }
     ArrayList returnMet(ArrayList arrayList) throws IOException {


      if(!c.isEmpty()) {
        for(int i=0; i<arrayList.size();i++) {
          if(arrayList.get(i).equals(c)){
            dubl+=1;
          }
        }
        if(dubl==0) {
          arrayList.add(c);

            try {
              trr = new FileOutputStream(TxtSoundArray.file,true);
              tt(trr);
            } catch (FileNotFoundException e) {

            }

        }
          dubl=0;
          c="";
      }
      return arrayList;
    }
     void tt(FileOutputStream fos) throws IOException {
      d=d+"\r\n";
      fos.write(d.getBytes());
      fos.flush();
      fos.close();
    }
}
