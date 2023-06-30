import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface DatabaseService extends Remote {
    List<String> getAllData() throws RemoteException;
    boolean enregistrerUser(user user) throws RemoteException;
    List<user> consulterEtudiant()throws RemoteException;
    List<note> consulterNote()throws RemoteException;
    void editerNotes()throws RemoteException;
}
