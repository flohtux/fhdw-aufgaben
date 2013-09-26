
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitGrantListePx extends PersistentObject implements PersistentDebitGrantListePx{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitGrantListePx getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.getClass(objectId);
        return (PersistentDebitGrantListePx)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitGrantListePx createDebitGrantListePx(PersistentDebitGrantListe d1) throws PersistenceException{
        return createDebitGrantListePx(d1,false);
    }
    
    public static PersistentDebitGrantListePx createDebitGrantListePx(PersistentDebitGrantListe d1,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitGrantListePx result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
                .newDelayedDebitGrantListePx();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
                .newDebitGrantListePx(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("d1", d1);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitGrantListePx createDebitGrantListePx(PersistentDebitGrantListe d1,boolean delayed$Persistence,PersistentDebitGrantListePx This) throws PersistenceException {
        PersistentDebitGrantListePx result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
                .newDelayedDebitGrantListePx();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
                .newDebitGrantListePx(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("d1", d1);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot d1 = (AbstractPersistentRoot)this.getD1();
            if (d1 != null) {
                result.put("d1", d1.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    d1.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && d1.hasEssentialFields())d1.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitGrantListePx provideCopy() throws PersistenceException{
        DebitGrantListePx result = this;
        result = new DebitGrantListePx(this.d1, 
                                       this.subService, 
                                       this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDebitGrantListe d1;
    protected SubjInterface subService;
    protected PersistentDebitGrantListePx This;
    
    public DebitGrantListePx(PersistentDebitGrantListe d1,SubjInterface subService,PersistentDebitGrantListePx This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.d1 = d1;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 286;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 286) ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
            .newDebitGrantListePx(this.getId());
        super.store();
        if(this.getD1() != null){
            this.getD1().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.d1Set(this.getId(), getD1());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentDebitGrantListe getD1() throws PersistenceException {
        return this.d1;
    }
    public void setD1(PersistentDebitGrantListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.d1)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.d1 = (PersistentDebitGrantListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.d1Set(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitGrantListePx newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitGrantListePx)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitGrantListePx getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitGrantListePx result = new DebitGrantListePxProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitGrantListePx)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListePx(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListePx(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getD1() != null && this.getD1().getTheObject().getLeafInfo() != 0) return 1;
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
        this.setThis((PersistentDebitGrantListePx)This);
		if(this.equals(This)){
			this.setD1((PersistentDebitGrantListe)final$$Fields.get("d1"));
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
