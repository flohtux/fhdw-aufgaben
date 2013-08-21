
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitGrant extends PersistentObject implements PersistentDebitGrant{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitGrant getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.getClass(objectId);
        return (PersistentDebitGrant)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitGrant createDebitGrant(PersistentAccount permittedAccount,PersistentLimitType limits) throws PersistenceException{
        return createDebitGrant(permittedAccount,limits,false);
    }
    
    public static PersistentDebitGrant createDebitGrant(PersistentAccount permittedAccount,PersistentLimitType limits,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitGrant result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
                .newDelayedDebitGrant();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
                .newDebitGrant(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("permittedAccount", permittedAccount);
        final$$Fields.put("limits", limits);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitGrant createDebitGrant(PersistentAccount permittedAccount,PersistentLimitType limits,boolean delayed$Persistence,PersistentDebitGrant This) throws PersistenceException {
        PersistentDebitGrant result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
                .newDelayedDebitGrant();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
                .newDebitGrant(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("permittedAccount", permittedAccount);
        final$$Fields.put("limits", limits);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot permittedAccount = (AbstractPersistentRoot)this.getPermittedAccount();
            if (permittedAccount != null) {
                result.put("permittedAccount", permittedAccount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    permittedAccount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && permittedAccount.hasEssentialFields())permittedAccount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot limits = (AbstractPersistentRoot)this.getLimits();
            if (limits != null) {
                result.put("limits", limits.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    limits.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && limits.hasEssentialFields())limits.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitGrant provideCopy() throws PersistenceException{
        DebitGrant result = this;
        result = new DebitGrant(this.permittedAccount, 
                                this.limits, 
                                this.subService, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount permittedAccount;
    protected PersistentLimitType limits;
    protected SubjInterface subService;
    protected PersistentDebitGrant This;
    
    public DebitGrant(PersistentAccount permittedAccount,PersistentLimitType limits,SubjInterface subService,PersistentDebitGrant This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.permittedAccount = permittedAccount;
        this.limits = limits;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 191) ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
            .newDebitGrant(this.getId());
        super.store();
        if(this.getPermittedAccount() != null){
            this.getPermittedAccount().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.permittedAccountSet(this.getId(), getPermittedAccount());
        }
        if(this.getLimits() != null){
            this.getLimits().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.limitsSet(this.getId(), getLimits());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAccount getPermittedAccount() throws PersistenceException {
        return this.permittedAccount;
    }
    public void setPermittedAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.permittedAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.permittedAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.permittedAccountSet(this.getId(), newValue);
        }
    }
    public PersistentLimitType getLimits() throws PersistenceException {
        return this.limits;
    }
    public void setLimits(PersistentLimitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.limits)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.limits = (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.limitsSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitGrant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitGrant)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitGrant getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitGrant result = new DebitGrantProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitGrant)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrant(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrant(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getPermittedAccount() != null) return 1;
        if (this.getLimits() != null) return 1;
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
        this.setThis((PersistentDebitGrant)This);
		if(this.equals(This)){
			this.setPermittedAccount((PersistentAccount)final$$Fields.get("permittedAccount"));
			this.setLimits((PersistentLimitType)final$$Fields.get("limits"));
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
