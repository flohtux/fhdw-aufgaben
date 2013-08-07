package model.meta;

import persistence.PersistenceException;

public class DebitNoteTransferTransactionExecuteMssg implements DebitNoteTransferTransactionDOWNMssgs,DebitNoteTransferTransactionUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitNoteTransferTransaction rcvr;
    
    public DebitNoteTransferTransactionExecuteMssg(persistence.PersistentDebitNoteTransferTransaction rcvr){
        this.rcvr = rcvr;
    }
    public void accept(DebitNoteTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitNoteTransferTransactionExecuteMssg(this);
    }
    public void accept(DebitNoteTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitNoteTransferTransactionExecuteMssg(this);
    }
    public void accept(DebitNoteMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitNoteTransferTransactionExecuteMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitNoteTransferTransactionExecuteMssg(this);
    }
    public void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitNoteTransferTransactionExecuteMssg(this);
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
    public synchronized void getResult() throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.InvalidBankNumberException) throw (model.InvalidBankNumberException) this.excptn;
            if(this.excptn instanceof model.LimitViolatedException) throw (model.LimitViolatedException) this.excptn;
            if(this.excptn instanceof model.InvalidAccountNumberException) throw (model.InvalidAccountNumberException) this.excptn;
            if(this.excptn instanceof model.NoPermissionToExecuteDebitNoteTransferException) throw (model.NoPermissionToExecuteDebitNoteTransferException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
