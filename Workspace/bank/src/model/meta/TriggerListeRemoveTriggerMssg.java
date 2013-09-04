package model.meta;

import persistence.PersistenceException;

public class TriggerListeRemoveTriggerMssg implements TriggerListeDOWNMssgs,TriggerListeUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentTriggerListe rcvr;
    public final persistence.PersistentTrigger t;
    
    public TriggerListeRemoveTriggerMssg(persistence.PersistentTrigger t,
                                         persistence.PersistentTriggerListe rcvr){
        this.t = t;
        this.rcvr = rcvr;
    }
    public void accept(TriggerListeMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleTriggerListeRemoveTriggerMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.removeImplementation(this.t);
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
