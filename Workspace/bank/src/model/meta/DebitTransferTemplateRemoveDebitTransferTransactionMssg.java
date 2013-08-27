package model.meta;

import persistence.PersistenceException;

public class DebitTransferTemplateRemoveDebitTransferTransactionMssg implements DebitTransferTemplateDOWNMssgs,DebitTransferTemplateUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransferTemplate rcvr;
    public final persistence.PersistentDebitTransferTransaction debitTransferTransaction;
    
    public DebitTransferTemplateRemoveDebitTransferTransactionMssg(persistence.PersistentDebitTransferTransaction debitTransferTransaction,
                                                                   persistence.PersistentDebitTransferTemplate rcvr){
        this.debitTransferTransaction = debitTransferTransaction;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferTemplateMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferTemplateRemoveDebitTransferTransactionMssg(this);
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
