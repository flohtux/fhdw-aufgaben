package model.meta;

import persistence.PersistenceException;

public class DebitTransferSuccessfulRemoveDebitTransferTransactionMssg implements DebitTransferSuccessfulDOWNMssgs,DebitTransferSuccessfulUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransferSuccessful rcvr;
    public final persistence.PersistentDebitTransferTransaction debitTransferTransaction;
    
    public DebitTransferSuccessfulRemoveDebitTransferTransactionMssg(persistence.PersistentDebitTransferTransaction debitTransferTransaction,
                                                                     persistence.PersistentDebitTransferSuccessful rcvr){
        this.debitTransferTransaction = debitTransferTransaction;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferSuccessfulMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferSuccessfulRemoveDebitTransferTransactionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.removeImplementation(this.debitTransferTransaction);
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
