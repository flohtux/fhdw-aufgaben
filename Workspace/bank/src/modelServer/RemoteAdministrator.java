
package modelServer;


import model.*;
import persistence.*;

public  class RemoteAdministrator extends RemoteService {

	
	public RemoteAdministrator(String connectionName, String userName, PersistentAdministrator server){
		super (connectionName, userName , server);
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
    
    public synchronized java.util.HashMap<?,?> translateMoney(String moneyProxiString, String currencyProxiString){
        try {
            PersistentMoney money = (PersistentMoney)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moneyProxiString));
            PersistentCurrency currency = (PersistentCurrency)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(currencyProxiString));
            ((PersistentAdministrator)this.server).translateMoney(money, currency);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}