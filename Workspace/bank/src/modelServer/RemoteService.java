
package modelServer;


import model.*;
import persistence.*;

public abstract class RemoteService extends RemoteServerMaster {

	protected PersistentService server;

	public RemoteService(String connectionName, String userName, PersistentService server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    } 

    public synchronized java.util.HashMap<?,?> changePassword(String newPassword1, String newPassword2){
        try {
            String result = ((PersistentService)this.server).changePassword(newPassword1, newPassword2);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PasswordException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}