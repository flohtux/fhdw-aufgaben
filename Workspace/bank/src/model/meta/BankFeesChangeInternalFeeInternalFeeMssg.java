package model.meta;

import persistence.PersistenceException;

public class BankFeesChangeInternalFeeInternalFeeMssg implements BankFeesDOWNMssgs,BankFeesUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentBankFees rcvr;
    public final persistence.PersistentInternalFee newInternalFee;
    
    public BankFeesChangeInternalFeeInternalFeeMssg(persistence.PersistentInternalFee newInternalFee,
                                                    persistence.PersistentBankFees rcvr){
        this.newInternalFee = newInternalFee;
        this.rcvr = rcvr;
    }
    public void accept(BankFeesMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleBankFeesChangeInternalFeeInternalFeeMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeInternalFeeImplementation(this.newInternalFee);
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
