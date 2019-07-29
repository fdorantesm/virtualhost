package localhost;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Apache{
  
  private Process p;
  private String ruta;

    
  public Apache(String r){
    this.ruta = r;
  }

  public void SetPath(String path) {
    this.ruta = path;
  }

  public boolean stop(){
    try{
      this.p = Runtime.getRuntime().exec("TASKKILL /F /T /IM httpd.exe");
      return true;
    }
    catch (FileNotFoundException e){
      return false;
    }catch (IOException e) {
        //
    }
    return false;
  }

  public boolean start(){
    try{
      Runtime.getRuntime().exec(this.ruta + "/apache/bin/httpd.exe");
      return true;
    }
    catch(FileNotFoundException e){
      return false;
    }catch (IOException e) {
        //
    }
    return false;
  }
}