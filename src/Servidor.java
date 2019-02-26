import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread{
	private static Vector clientes;
	private Socket conexao;
	private String meuNome;
	
    public static void main(String[] args)  {
        
        try {
        	clientes = new Vector();
        	
            ServerSocket s = new ServerSocket(9999);
            while(true){
            	System.out.println("Esperando conectar...");
            	Socket conexao = s.accept();
            	System.out.println("Conectou");
            	Thread t = new Servidor(conexao);
            	t.start();
            }
            
		}catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
    }
    
    public Servidor(Socket s) {
    	conexao = s;
    }
}