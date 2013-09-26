package model.meta;

import persistence.PersistenceException;

public class AccountRemoveAccountPxDebitGrantListeMssg implements AccountDOWNMssgs,AccountUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentAccount rcvr;
    public final persistence.PersistentAccountPx acc;
    public final persistence.PersistentDebitGrantListe list;
    
    public AccountRemoveAccountPxDebitGrantListeMssg(persistence.PersistentAccountPx acc,
                                                     persistence.PersistentDebitGrantListe list,
                                                     persistence.PersistentAccount rcvr){
        this.acc = acc;
        this.list = list;
        this.rcvr = rcvr;
    }
    public void accept(AccountMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleAccountRemoveAccountPxDebitGrantListeMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.removeImplementation(this.acc, this.list);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.NoPermissionToRemoveDebitGrantException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.NoPermissionToRemoveDebitGrantException) throw (model.NoPermissionToRemoveDebitGrantException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
