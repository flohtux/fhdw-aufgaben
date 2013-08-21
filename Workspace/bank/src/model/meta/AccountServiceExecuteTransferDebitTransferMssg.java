package model.meta;

import persistence.PersistenceException;

public class AccountServiceExecuteTransferDebitTransferMssg implements AccountServiceDOWNMssgs,AccountServiceUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccountService rcvr;
    public final persistence.PersistentDebitTransfer debitTransfer;
    
    public AccountServiceExecuteTransferDebitTransferMssg(persistence.PersistentDebitTransfer debitTransfer,
                                                          persistence.PersistentAccountService rcvr){
        this.debitTransfer = debitTransfer;
        this.rcvr = rcvr;
    }
    public void accept(AccountServiceMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleAccountServiceExecuteTransferDebitTransferMssg(this);
    }
    public void accept(ServiceMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleAccountServiceExecuteTransferDebitTransferMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.executeTransferImplementation(this.debitTransfer);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.NoPermissionToExecuteDebitTransferException) throw (model.NoPermissionToExecuteDebitTransferException) this.excptn;
            if(this.excptn instanceof model.InvalidBankNumberException) throw (model.InvalidBankNumberException) this.excptn;
            if(this.excptn instanceof model.LimitViolatedException) throw (model.LimitViolatedException) this.excptn;
            if(this.excptn instanceof model.InvalidAccountNumberException) throw (model.InvalidAccountNumberException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
