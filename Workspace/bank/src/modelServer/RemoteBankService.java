
package modelServer;


import model.*;
import persistence.*;

public  class RemoteBankService extends RemoteService {

	
	public RemoteBankService(String connectionName, String userName, PersistentBankService server){
		super (connectionName, userName , server);
	}

	 

    public synchronized java.util.HashMap<?,?> changeMaxLimit(String accProxiString, String amountAsString){
        try {
            PersistentAccount acc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accProxiString));
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentBankService)this.server).changeMaxLimit(acc, amount);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changePassword(String newPassword1, String newPassword2){
        try {
            String result = ((PersistentBankService)this.server).changePassword(newPassword1, newPassword2);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PasswordException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> closeAccount(String accProxiString){
        try {
            PersistentAccount acc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accProxiString));
            ((PersistentBankService)this.server).closeAccount(acc);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> closeAccount(String accProxiString, String transAccProxiString){
        try {
            PersistentAccount acc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accProxiString));
            PersistentAccount transAcc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transAccProxiString));
            ((PersistentBankService)this.server).closeAccount(acc, transAcc);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createAccount(String currencyType){
        try {
            ((PersistentBankService)this.server).createAccount(currencyType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}