package model.meta;

import persistence.PersistenceException;

public class DebitTransferTransactionExecuteMssg implements DebitTransferTransactionDOWNMssgs,DebitTransferTransactionUPMssgs{
    
    private java.util.Date exctDte = null;
    private persistence.PersistentDebitTransferTransaction rslt;
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
                rslt = this.rcvr.executeImplementation();
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized persistence.PersistentDebitTransferTransaction getResult() throws model.ExecuteException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.ExecuteException) throw (model.ExecuteException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
        return this.rslt;
    }
    
}
