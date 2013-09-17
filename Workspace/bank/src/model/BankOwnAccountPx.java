
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BankOwnAccountPx extends PersistentObject implements PersistentBankOwnAccountPx{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentBankOwnAccountPx getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.getClass(objectId);
        return (PersistentBankOwnAccountPx)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentBankOwnAccountPx createBankOwnAccountPx(PersistentAccount account) throws PersistenceException{
        return createBankOwnAccountPx(account,false);
    }
    
    public static PersistentBankOwnAccountPx createBankOwnAccountPx(PersistentAccount account,boolean delayed$Persistence) throws PersistenceException {
        PersistentBankOwnAccountPx result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
                .newDelayedBankOwnAccountPx();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
                .newBankOwnAccountPx(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentBankOwnAccountPx createBankOwnAccountPx(PersistentAccount account,boolean delayed$Persistence,PersistentBankOwnAccountPx This) throws PersistenceException {
        PersistentBankOwnAccountPx result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
                .newDelayedBankOwnAccountPx();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
                .newBankOwnAccountPx(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public BankOwnAccountPx provideCopy() throws PersistenceException{
        BankOwnAccountPx result = this;
        result = new BankOwnAccountPx(this.account, 
                                      this.subService, 
                                      this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount account;
    protected SubjInterface subService;
    protected PersistentBankOwnAccountPx This;
    
    public BankOwnAccountPx(PersistentAccount account,SubjInterface subService,PersistentBankOwnAccountPx This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.account = account;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 262;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 262) ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
            .newBankOwnAccountPx(this.getId());
        super.store();
        if(this.getAccount() != null){
            this.getAccount().store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.accountSet(this.getId(), getAccount());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAccount getAccount() throws PersistenceException {
        return this.account;
    }
    public void setAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.account)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.account = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.accountSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentBankOwnAccountPx newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBankOwnAccountPx)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentBankOwnAccountPx getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBankOwnAccountPx result = new BankOwnAccountPxProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentBankOwnAccountPx)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankOwnAccountPx(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankOwnAccountPx(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankOwnAccountPx(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankOwnAccountPx(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankOwnAccountPx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankOwnAccountPx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankOwnAccountPx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankOwnAccountPx(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBankOwnAccountPx)This);
		if(this.equals(This)){
			this.setAccount((PersistentAccount)final$$Fields.get("account"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
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
