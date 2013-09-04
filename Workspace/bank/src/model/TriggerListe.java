
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerListe;
import persistence.Predcate;
import persistence.SubjInterface;
import persistence.TDObserver;
import persistence.TriggerListeProxi;
import persistence.TriggerListe_TriggersProxi;


/* Additional import section end */

public class TriggerListe extends PersistentObject implements PersistentTriggerListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentTriggerListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.getClass(objectId);
        return (PersistentTriggerListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentTriggerListe createTriggerListe() throws PersistenceException{
        return createTriggerListe(false);
    }
    
    public static PersistentTriggerListe createTriggerListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentTriggerListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
                .newDelayedTriggerListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
                .newTriggerListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTriggerListe createTriggerListe(boolean delayed$Persistence,PersistentTriggerListe This) throws PersistenceException {
        PersistentTriggerListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
                .newDelayedTriggerListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
                .newTriggerListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("triggers", this.getTriggers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public TriggerListe provideCopy() throws PersistenceException{
        TriggerListe result = this;
        result = new TriggerListe(this.subService, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected TriggerListe_TriggersProxi triggers;
    protected SubjInterface subService;
    protected PersistentTriggerListe This;
    
    public TriggerListe(SubjInterface subService,PersistentTriggerListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.triggers = new TriggerListe_TriggersProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 234;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 234) ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
            .newTriggerListe(this.getId());
        super.store();
        this.getTriggers().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public TriggerListe_TriggersProxi getTriggers() throws PersistenceException {
        return this.triggers;
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
            ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTriggerListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTriggerListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTriggerListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTriggerListe result = new TriggerListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTriggerListe)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTriggerListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTriggerListe(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTriggers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentTrigger t) 
				throws PersistenceException{
        model.meta.TriggerListeAddTriggerMssg event = new model.meta.TriggerListeAddTriggerMssg(t, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
        this.setThis((PersistentTriggerListe)This);
		if(this.equals(This)){
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
    public void remove(final PersistentTrigger t) 
				throws PersistenceException{
        model.meta.TriggerListeRemoveTriggerMssg event = new model.meta.TriggerListeRemoveTriggerMssg(t, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
    
    public void addImplementation(final PersistentTrigger t) 
				throws PersistenceException{
        getThis().getTriggers().add(t);
        
    }
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
    public void removeImplementation(final PersistentTrigger t) 
				throws PersistenceException{
        getThis().getTriggers().removeFirstSuccess(new Predcate<PersistentTrigger>() {
			public boolean test(PersistentTrigger argument) throws PersistenceException {
				return argument.equals(t);
			}
		});
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
