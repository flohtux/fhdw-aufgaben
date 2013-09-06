package model.meta;

import persistence.PersistenceException;

public class AccountCreateDebitGrantAccountLimitTypeMssg implements AccountDOWNMssgs,AccountUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccount rcvr;
    public final persistence.PersistentAccount receiver;
    public final persistence.PersistentLimitType limit;
    
    public AccountCreateDebitGrantAccountLimitTypeMssg(persistence.PersistentAccount receiver,
                                                       persistence.PersistentLimitType limit,
                                                       persistence.PersistentAccount rcvr){
        this.receiver = receiver;
        this.limit = limit;
        this.rcvr = rcvr;
    }
    public void accept(AccountMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleAccountCreateDebitGrantAccountLimitTypeMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.createDebitGrantImplementation(this.receiver, this.limit);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.GrantAlreadyGivenException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.GrantAlreadyGivenException) throw (model.GrantAlreadyGivenException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
