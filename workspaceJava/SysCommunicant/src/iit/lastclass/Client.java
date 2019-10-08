package iit.lastclass;

public class Client {
	public static void main(String[] args) {
		try {
			int port = 50000;
			String objectName = "HelloObject";
			String url = "rmi://localhost:" + port + "/" + objectName;
			// r�cup�re le stub de l �objet enregistr� au nom de HelloObject
			Hello obj = (Hello) java.rmi.Naming.lookup(url);
			// invocation de la m�thode
			String message = obj.sayHello();
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
