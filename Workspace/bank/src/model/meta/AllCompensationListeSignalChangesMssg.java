package model.meta;

import persistence.PersistenceException;

public class AllCompensationListeSignalChangesMssg implements AllCompensationListeDOWNMssgs,AllCompensationListeUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAllCompensationListe rcvr;
    
    public AllCompensationListeSignalChangesMssg(persistence.PersistentAllCompensationListe rcvr){
        this.rcvr = rcvr;
    }
    public void accept(AllCompensationListeMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleAllCompensationListeSignalChangesMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.signalChangesImplementation();
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
