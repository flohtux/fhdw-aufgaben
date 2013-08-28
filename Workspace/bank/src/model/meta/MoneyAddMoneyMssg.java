package model.meta;

import persistence.PersistenceException;

public class MoneyAddMoneyMssg implements MoneyDOWNMssgs,MoneyUPMssgs{
    
    private java.util.Date exctDte = null;
    private persistence.PersistentMoney rslt;
    private Exception excptn;
    public final persistence.PersistentMoney rcvr;
    public final persistence.PersistentMoney money;
    
    public MoneyAddMoneyMssg(persistence.PersistentMoney money,
                             persistence.PersistentMoney rcvr){
        this.money = money;
        this.rcvr = rcvr;
    }
    public void accept(MoneyMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleMoneyAddMoneyMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                rslt = this.rcvr.addImplementation(this.money);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized persistence.PersistentMoney getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
        return this.rslt;
    }
    
}
