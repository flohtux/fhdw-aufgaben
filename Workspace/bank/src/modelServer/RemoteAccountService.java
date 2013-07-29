
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
    
    public synchronized java.util.HashMap<?,?> createTransfer(){
        try {
            ((PersistentAccountService)this.server).createTransfer();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> executeTransfer(String debitNoteTransferProxiString){
        try {
            PersistentDebitNoteTransfer debitNoteTransfer = (PersistentDebitNoteTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitNoteTransferProxiString));
            ((PersistentAccountService)this.server).executeTransfer(debitNoteTransfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.InvalidBankNumberException e0){
            return createExceptionResult(e0, this);
        }catch(model.InvalidAccountNumberException e1){
            return createExceptionResult(e1, this);
        }
    }
    


}