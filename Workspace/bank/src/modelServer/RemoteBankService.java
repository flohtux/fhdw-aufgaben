
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
    
    public synchronized java.util.HashMap<?,?> changeMinLimit(String accProxiString, String amountAsString){
        try {
            PersistentAccount acc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accProxiString));
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentBankService)this.server).changeMinLimit(acc, amount);
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
    
    public synchronized java.util.HashMap<?,?> changeTransactionFee(String newFee, String fixAsString, String fixCurrency, String limitAsString, String limitCurrency, String procentualAsString){
        try {
            common.Fraction fix = common.Fraction.parse(fixAsString);
            common.Fraction limit = common.Fraction.parse(limitAsString);
            common.Fraction procentual = common.Fraction.parse(procentualAsString);
            ((PersistentBankService)this.server).changeTransactionFee(newFee, fix, fixCurrency, limit, limitCurrency, procentual);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> closeAccount(String accProxiString){
        try {
            PersistentAccount acc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accProxiString));
            ((PersistentBankService)this.server).closeAccount(acc);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CloseAccountNoPossibleException e0){
            return createExceptionResult(e0, this);
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
        }catch(model.NoPermissionToExecuteDebitTransferException e0){
            return createExceptionResult(e0, this);
        }catch(model.InvalidBankNumberException e1){
            return createExceptionResult(e1, this);
        }catch(model.LimitViolatedException e2){
            return createExceptionResult(e2, this);
        }catch(model.InvalidAccountNumberException e3){
            return createExceptionResult(e3, this);
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
    
    public synchronized java.util.HashMap<?,?> findAccount(String accountNumberAsString){
        try {
            long accountNumber = new Long(accountNumberAsString).longValue();
            ((PersistentBankService)this.server).findAccount(accountNumber);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}