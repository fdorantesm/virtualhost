package localhost;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

class CVirtualHost{
  private String ip;
  private String ruta;
  private String servidor;
  private String dominio;
  private String t;
  private boolean exists;
  private char unidad = System.getenv("WINDIR").charAt(0);

  public CVirtualHost(String ip, String ruta, String servidor, String dominio){
    this.ip = ip;
    this.ruta = ruta;
    this.servidor = servidor;
    this.dominio = dominio;
  }

  public void SetServidor(String server){
    this.servidor = server;
  }

  public void SetIP(String ip_address) {
    this.ip = ip_address;
  }

  public void SetRuta(String path) {
    this.ruta = path;
  }

  public void SetDominio(String domain) {
    this.dominio = domain;
  }

  public boolean HTTPData(){
    try{
        FileWriter httpd_conf = new FileWriter(this.ruta + "/apache/conf/httpd.conf", true);
        PrintWriter pluma = new PrintWriter(httpd_conf);
        pluma.println("#"+this.servidor+this.dominio+"#");
        pluma.println("<VirtualHost " + this.ip + ">");
        pluma.println("DocumentRoot " + this.ruta + "/htdocs/" + this.servidor + this.dominio);
        pluma.println("ServerName " + this.servidor);
        pluma.println("</VirtualHost>\n");

        httpd_conf.close();
        return true;
    }
    catch (Exception e){
        //
    }

    return false;
  }

  public boolean Hosts(){
    try{
        FileWriter hosts = new FileWriter(unidad + ":/Windows/System32/drivers/etc/hosts", true);
        PrintWriter pluma = new PrintWriter(hosts);

        pluma.println(this.ip + " " + this.servidor + this.dominio);
        hosts.close();
        return true;
    } catch (Exception e) {
        //
    }
    return false;
  }

  public boolean LMhosts(){
    
    try{
        FileWriter lmhosts = new FileWriter(unidad + ":/Windows/System32/drivers/etc/lmhosts", true);
        PrintWriter pluma = new PrintWriter(lmhosts);

        pluma.println(this.ip + " " + this.servidor + this.dominio + " #PRE");

        lmhosts.close();
        return true;
    }
    catch (Exception e) {
        //
    }
    return false;
  }

  public boolean Domain(){
    FileWriter itworks = null;
    PrintWriter pluma = null;
    String html = null;
    File domain = null;
    try
    {
      domain = new File(this.ruta + "/htdocs/" + this.servidor + this.dominio);
      domain.mkdir();

      itworks = new FileWriter(this.ruta + "/htdocs/" + this.servidor + this.dominio + "/index.html");
      pluma = new PrintWriter(itworks);
      html = "<!DOCTYPE html>\n"
              + "<html lang=\"es\">\n\t"
              + "<head>\n\t\t"
              + "<title>It works :)</title>\n\t"
              + "</head>\n\t"
              + "<body>\n\t\t"
              + "<h1 style=\"text-align:center;\">It works :)</h1>\n\t\t"
              + "<h3 style=\"text-align:center;\">" + this.servidor + this.dominio + "</h2>\n\t\t"
              + "<h5 style=\"text-align:center;\">por <a href=\"http://wiroos.com.mx\" style=\"color:orange;text-decoration:none;font-weight:bold;\" target=\"_blank\">Fernando Dorantes Monsiváis</h3>\n\t"
              + "</body>\n"
              + "</html>";

      pluma.println(html);

      itworks.close();

      return true;
    }
    catch (Exception e) {
    }
    return false;
  }

  public boolean isIPAvailable(String ip){
        String conf = OpenConf();

        if (OpenConf().contains("<VirtualHost " + ip + ">")) {
          return false;
        }

        return true;
  }

  public boolean isDomainAvailable(String servidor, String dominio){
        String conf = OpenConf();

        if (OpenConf().contains("#"+servidor + dominio+"#")) {
          return false;
        }

    return true;
  }

  public boolean existsHTTPD(String ruta){
    try{
        File httpd = new File(ruta + "/apache/conf/httpd.conf");
        this.exists = (httpd.exists());
        return this.exists;
    } catch (Exception e) {
        //
    }
    return false;
  }

  public boolean existsHTDOCS(String ruta){
    try{
        File htdocs = new File(ruta + "/htdocs");
        this.exists = (htdocs.exists());
        return this.exists;
    }catch (Exception e) {
        //
    }
    return false;
  }

  public String OpenConf(){
    Scanner in = null;
    try {
        in = new Scanner(new FileReader(this.ruta + "/apache/conf/httpd.conf"));
        while (in.hasNextLine()) {
          this.t += in.nextLine();
        }

        return this.t;
    }
    catch (FileNotFoundException e){
        return null;
    }
    finally {
        if(in != null)in.close();
    }
  }

  public void GoToNewDomain(String servidor, String dominio){
    try{
        Desktop.getDesktop().browse(new URI("http://" + servidor + dominio));
    }
    catch (Exception e){
        //
    }
  }

  public void Contact(){
    try {
        Desktop.getDesktop().browse(new URI("http://wiroos.com.mx"));
    }
    catch (Exception e){
    
    }
  }
}
