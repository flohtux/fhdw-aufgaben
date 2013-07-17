
package modelServer;


import model.*;
import persistence.*;

public  class RemoteAccountService extends RemoteService {

	
	public RemoteAccountService(String connectionName, String userName, PersistentAccountService server){
		super (connectionName, userName , server);
	}

	 

    public synchronized java.util.HashMap<?,?> changePassword(String newPassword1, String newPassword2){
        try {
            String result = ((PersistentAccountService)this.server).changePassword(newPassword1, newPassword2);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PasswordException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTransfer(String transactionProxiString){
        try {
            PersistentTrancaction transaction = (PersistentTrancaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            ((PersistentAccountService)this.server).createTransfer(transaction);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}