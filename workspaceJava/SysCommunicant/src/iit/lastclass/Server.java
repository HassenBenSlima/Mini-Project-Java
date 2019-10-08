package iit.lastclass;

import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {

		try {
			int port = 50000;
			String objectName = "HelloObject";
			String url = "rmi://localhost:" + port + "/" + objectName;
			LocateRegistry.createRegistry(port);
			// instancie l ’objet
			HelloImpl obj = new HelloImpl();
			// Enregistre l ’objet sous le nom "HelloObject" au rmiregistry
			java.rmi.Naming.bind(url, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
