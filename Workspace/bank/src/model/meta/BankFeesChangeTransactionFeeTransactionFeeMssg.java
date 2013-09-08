package model.meta;

import persistence.PersistenceException;

public class BankFeesChangeTransactionFeeTransactionFeeMssg implements BankFeesDOWNMssgs,BankFeesUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentBankFees rcvr;
    public final persistence.PersistentTransactionFee newTransactionFee;
    
    public BankFeesChangeTransactionFeeTransactionFeeMssg(persistence.PersistentTransactionFee newTransactionFee,
                                                          persistence.PersistentBankFees rcvr){
        this.newTransactionFee = newTransactionFee;
        this.rcvr = rcvr;
    }
    public void accept(BankFeesMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleBankFeesChangeTransactionFeeTransactionFeeMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeTransactionFeeImplementation(this.newTransactionFee);
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
