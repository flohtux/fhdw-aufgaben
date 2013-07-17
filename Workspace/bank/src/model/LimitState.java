
package model;

import persistence.*;


/* Additional import section end */

public abstract class LimitState extends model.AccountLimitState implements PersistentLimitState{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot balance = (AbstractPersistentRoot)this.getBalance();
            if (balance != null) {
                result.put("balance", balance.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    balance.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && balance.hasEssentialFields())balance.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract LimitState provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAmount balance;
    
    public LimitState(SubjInterface subService,PersistentAccountLimitState This,PersistentAmount balance,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAccountLimitState)This,id);
        this.balance = balance;        
    }
    
    static public long getTypeId() {
        return 149;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getBalance() != null){
            this.getBalance().store();
            ConnectionHandler.getTheConnectionHandler().theLimitStateFacade.balanceSet(this.getId(), getBalance());
        }
        
    }
    
    public PersistentAmount getBalance() throws PersistenceException {
        return this.balance;
    }
    public void setBalance(PersistentAmount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.balance)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.balance = (PersistentAmount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitStateFacade.balanceSet(this.getId(), newValue);
        }
    }
    public abstract PersistentLimitState getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLimitState)This);
		if(this.equals(This)){
			this.setBalance((PersistentAmount)final$$Fields.get("balance"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
