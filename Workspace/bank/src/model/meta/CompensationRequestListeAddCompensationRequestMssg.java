package model.meta;

import persistence.PersistenceException;

public class CompensationRequestListeAddCompensationRequestMssg implements CompensationRequestListeDOWNMssgs,CompensationRequestListeUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentCompensationRequestListe rcvr;
    public final persistence.PersistentCompensationRequest t;
    
    public CompensationRequestListeAddCompensationRequestMssg(persistence.PersistentCompensationRequest t,
                                                              persistence.PersistentCompensationRequestListe rcvr){
        this.t = t;
        this.rcvr = rcvr;
    }
    public void accept(CompensationRequestListeMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleCompensationRequestListeAddCompensationRequestMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.addImplementation(this.t);
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
