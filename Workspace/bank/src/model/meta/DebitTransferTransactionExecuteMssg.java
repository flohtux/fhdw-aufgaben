package model.meta;

import persistence.PersistenceException;

public class DebitTransferTransactionExecuteMssg implements DebitTransferTransactionDOWNMssgs,DebitTransferTransactionUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransferTransaction rcvr;
    
    public DebitTransferTransactionExecuteMssg(persistence.PersistentDebitTransferTransaction rcvr){
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteMssg(this);
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteMssg(this);
    }
    public void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.executeImplementation();
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.NoPermissionToExecuteDebitTransferException, model.DebitException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.NoPermissionToExecuteDebitTransferException) throw (model.NoPermissionToExecuteDebitTransferException) this.excptn;
            if(this.excptn instanceof model.DebitException) throw (model.DebitException) this.excptn;
            if(this.excptn instanceof model.InvalidBankNumberException) throw (model.InvalidBankNumberException) this.excptn;
            if(this.excptn instanceof model.InvalidAccountNumberException) throw (model.InvalidAccountNumberException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
