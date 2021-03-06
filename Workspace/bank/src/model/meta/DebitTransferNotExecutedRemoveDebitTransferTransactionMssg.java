package model.meta;

import persistence.PersistenceException;

public class DebitTransferNotExecutedRemoveDebitTransferTransactionMssg implements DebitTransferNotExecutedDOWNMssgs,DebitTransferNotExecutedUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransferNotExecuted rcvr;
    public final persistence.PersistentDebitTransferTransaction debitTransferTransaction;
    
    public DebitTransferNotExecutedRemoveDebitTransferTransactionMssg(persistence.PersistentDebitTransferTransaction debitTransferTransaction,
                                                                      persistence.PersistentDebitTransferNotExecuted rcvr){
        this.debitTransferTransaction = debitTransferTransaction;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferNotExecutedMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferNotExecutedRemoveDebitTransferTransactionMssg(this);
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
