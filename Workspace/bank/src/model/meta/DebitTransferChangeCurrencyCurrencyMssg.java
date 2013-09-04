package model.meta;

import persistence.PersistenceException;

public class DebitTransferChangeCurrencyCurrencyMssg implements DebitTransferDOWNMssgs,DebitTransferUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitTransfer rcvr;
    public final persistence.PersistentCurrency currency;
    
    public DebitTransferChangeCurrencyCurrencyMssg(persistence.PersistentCurrency currency,
                                                   persistence.PersistentDebitTransfer rcvr){
        this.currency = currency;
        this.rcvr = rcvr;
    }
    public void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeCurrencyCurrencyMssg(this);
    }
    public void accept(DebitTransferTransactionMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeCurrencyCurrencyMssg(this);
    }
    public void accept(TransferMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeCurrencyCurrencyMssg(this);
    }
    public void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitTransferChangeCurrencyCurrencyMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeCurrencyImplementation(this.currency);
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
