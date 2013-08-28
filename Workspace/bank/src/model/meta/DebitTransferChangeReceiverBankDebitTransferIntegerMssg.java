package model.meta;

import persistence.PersistenceException;

public class DebitTransferChangeReceiverBankDebitTransferIntegerMssg implements DebitTransferDOWNMssgs,DebitTransferUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransfer rcvr;
    public final persistence.PersistentDebitTransfer trans;
    public final long receiverBankNumber;
    
    public DebitTransferChangeReceiverBankDebitTransferIntegerMssg(persistence.PersistentDebitTransfer trans,
                                                                   long receiverBankNumber,
                                                                   persistence.PersistentDebitTransfer rcvr){
        this.trans = trans;
        this.receiverBankNumber = receiverBankNumber;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(this);
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeReceiverBankDebitTransferIntegerMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeReceiverBankImplementation(this.trans, this.receiverBankNumber);
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
