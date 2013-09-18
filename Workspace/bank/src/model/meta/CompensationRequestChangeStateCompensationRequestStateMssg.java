package model.meta;

import persistence.PersistenceException;

public class CompensationRequestChangeStateCompensationRequestStateMssg implements CompensationRequestDOWNMssgs,CompensationRequestUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentCompensationRequest rcvr;
    public final persistence.PersistentCompensationRequestState a;
    
    public CompensationRequestChangeStateCompensationRequestStateMssg(persistence.PersistentCompensationRequestState a,
                                                                      persistence.PersistentCompensationRequest rcvr){
        this.a = a;
        this.rcvr = rcvr;
    }
    public void accept(CompensationRequestMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleCompensationRequestChangeStateCompensationRequestStateMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeStateImplementation(this.a);
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
