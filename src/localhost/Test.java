package localhost;

public class Test {
    public static void main(String[] args) {
        Apache apache = new Apache("C:/localhost");
        if(apache.stop()){
            System.out.println("El servicio de apache ha sido detenido");
        }
//        if(apache.start()){
//            System.out.println("El servicio de apache ha sido iniciado");
//        }
        
    }
}
