package model.meta;

import persistence.PersistenceException;

public class DebitGrantListeRemoveAccountPxMssg implements DebitGrantListeDOWNMssgs,DebitGrantListeUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentDebitGrantListe rcvr;
    public final persistence.PersistentAccountPx acc;
    
    public DebitGrantListeRemoveAccountPxMssg(persistence.PersistentAccountPx acc,
                                              persistence.PersistentDebitGrantListe rcvr){
        this.acc = acc;
        this.rcvr = rcvr;
    }
    public void accept(DebitGrantListeMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleDebitGrantListeRemoveAccountPxMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.removeImplementation(this.acc);
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
