
package modelServer;


import model.*;
import persistence.*;

public  class RemoteAdministrator extends RemoteService {

	
	public RemoteAdministrator(String connectionName, String userName, PersistentAdministrator server){
		super (connectionName, userName , server);
	}

	 

    public synchronized java.util.HashMap<?,?> changeCurrencyRateGUI(String currency, String rateAsString){
        try {
            common.Fraction rate = common.Fraction.parse(rateAsString);
            ((PersistentAdministrator)this.server).changeCurrencyRateGUI(currency, rate);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeName(String bankProxiString, String name){
        try {
            PersistentBank bank = (PersistentBank)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(bankProxiString));
            ((PersistentAdministrator)this.server).changeName(bank, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changePassword(String newPassword1, String newPassword2){
        try {
            String result = ((PersistentAdministrator)this.server).changePassword(newPassword1, newPassword2);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PasswordException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createBank(String name){
        try {
            ((PersistentAdministrator)this.server).createBank(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> searchBankByBankNumber(String bankNumAsString){
        try {
            long bankNum = new Long(bankNumAsString).longValue();
            PersistentBank result = ((PersistentAdministrator)this.server).searchBankByBankNumber(bankNum);
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.InvalidBankNumberException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}