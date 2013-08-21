
package modelServer;


import model.*;
import persistence.*;

public  class RemoteAccountService extends RemoteService {

	
	public RemoteAccountService(String connectionName, String userName, PersistentAccountService server){
		super (connectionName, userName , server);
	}

	 

    public synchronized java.util.HashMap<?,?> changeCurrency(String transProxiString, String currency){
        try {
            PersistentTransfer trans = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            ((PersistentAccountService)this.server).changeCurrency(trans, currency);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeMoney(String transProxiString, String newAmountAsString){
        try {
            PersistentTransfer trans = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            common.Fraction newAmount = common.Fraction.parse(newAmountAsString);
            ((PersistentAccountService)this.server).changeMoney(trans, newAmount);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
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
    
    public synchronized java.util.HashMap<?,?> changeReceiverAccount(String transProxiString, String receiverAccNumberAsString){
        try {
            PersistentTransfer trans = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            long receiverAccNumber = new Long(receiverAccNumberAsString).longValue();
            ((PersistentAccountService)this.server).changeReceiverAccount(trans, receiverAccNumber);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeReceiverBank(String transProxiString, String receiverBankNumberAsString){
        try {
            PersistentTransfer trans = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            long receiverBankNumber = new Long(receiverBankNumberAsString).longValue();
            ((PersistentAccountService)this.server).changeReceiverBank(trans, receiverBankNumber);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeSubject(String transProxiString, String subject){
        try {
            PersistentTransfer trans = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            ((PersistentAccountService)this.server).changeSubject(trans, subject);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDebitGrant(String receiverProxiString, String limitProxiString){
        try {
            PersistentAccount receiver = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(receiverProxiString));
            PersistentLimitType limit = (PersistentLimitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(limitProxiString));
            ((PersistentAccountService)this.server).createDebitGrant(receiver, limit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDebit(){
        try {
            ((PersistentAccountService)this.server).createDebit();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
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
    
    public synchronized java.util.HashMap<?,?> executeTransferImplementation(String debitTransferProxiString){
        try {
            PersistentDebitTransfer debitTransfer = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferProxiString));
            ((PersistentAccountService)this.server).executeTransferImplementation(debitTransfer);
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
    


}