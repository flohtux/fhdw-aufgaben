package model.meta;

import persistence.PersistenceException;

public class DebitTransferTransactionExecuteAccountMssg implements DebitTransferTransactionDOWNMssgs,DebitTransferTransactionUPMssgs, DebitTransferNoValueDOWNMssgs{
    
    private java.util.Date exctDte = null;
    private persistence.PersistentDebitTransferTransaction rslt;
    private Exception excptn;
    public final persistence.PersistentDebitTransferTransaction rcvr;
    public final persistence.PersistentAccount hasToPayFees;
    
    public DebitTransferTransactionExecuteAccountMssg(persistence.PersistentAccount hasToPayFees,
                                                      persistence.PersistentDebitTransferTransaction rcvr){
        this.hasToPayFees = hasToPayFees;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public void accept(DebitTransferNoValueMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTransactionExecuteAccountMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                rslt = this.rcvr.executeImplementation(this.hasToPayFees);
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
