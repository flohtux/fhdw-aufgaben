package model.meta;

import persistence.PersistenceException;

public class DebitTransferTransactionChangeStateDebitTransferStateMssg implements DebitTransferTransactionDOWNMssgs,DebitTransferTransactionUPMssgs, DebitTransferNoValueDOWNMssgs{
    
    private java.util.Date exctDte = null;
    private persistence.PersistentDebitTransferDoubleState rslt;
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
    public void accept(DebitTransferNoValueMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionChangeStateDebitTransferStateMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                rslt = this.rcvr.changeStateImplementation(this.newState);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized persistence.PersistentDebitTransferDoubleState getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
        return this.rslt;
    }
    
}
