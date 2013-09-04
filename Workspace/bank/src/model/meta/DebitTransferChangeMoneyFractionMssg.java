package model.meta;

import persistence.PersistenceException;

public class DebitTransferChangeMoneyFractionMssg implements DebitTransferDOWNMssgs,DebitTransferUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransfer rcvr;
    public final common.Fraction newAmount;
    
    public DebitTransferChangeMoneyFractionMssg(common.Fraction newAmount,
                                                persistence.PersistentDebitTransfer rcvr){
        this.newAmount = newAmount;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeMoneyFractionMssg(this);
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeMoneyFractionMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeMoneyFractionMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeMoneyFractionMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeMoneyImplementation(this.newAmount);
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
