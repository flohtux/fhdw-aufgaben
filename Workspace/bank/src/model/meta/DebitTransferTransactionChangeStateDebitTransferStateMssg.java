package model.meta;

import persistence.PersistenceException;

public class DebitTransferTransactionChangeStateDebitTransferStateMssg implements DebitTransferTransactionDOWNMssgs,DebitTransferTransactionUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransferTransaction rcvr;
    public final persistence.PersistentDebitTransferState newState;
    
    public DebitTransferTransactionChangeStateDebitTransferStateMssg(persistence.PersistentDebitTransferState newState,
                                                                     persistence.PersistentDebitTransferTransaction rcvr){
        this.newState = newState;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeStateImplementation(this.newState);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
