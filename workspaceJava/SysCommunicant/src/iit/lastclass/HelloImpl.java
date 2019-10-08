package iit.lastclass;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	public HelloImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello";
	}
}
