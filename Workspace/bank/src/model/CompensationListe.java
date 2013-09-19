
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
import persistence.CompensationListeProxi;
import persistence.CompensationListe_CompensationsProxi;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class CompensationListe extends PersistentObject implements PersistentCompensationListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensationListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.getClass(objectId);
        return (PersistentCompensationListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensationListe createCompensationListe() throws PersistenceException{
        return createCompensationListe(false);
    }
    
    public static PersistentCompensationListe createCompensationListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensationListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
                .newDelayedCompensationListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
                .newCompensationListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompensationListe createCompensationListe(boolean delayed$Persistence,PersistentCompensationListe This) throws PersistenceException {
        PersistentCompensationListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
                .newDelayedCompensationListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
                .newCompensationListe(-1);
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
            result.put("compensations", this.getCompensations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompensationListe provideCopy() throws PersistenceException{
        CompensationListe result = this;
        result = new CompensationListe(this.subService, 
                                       this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompensationListe_CompensationsProxi compensations;
    protected SubjInterface subService;
    protected PersistentCompensationListe This;
    
    public CompensationListe(SubjInterface subService,PersistentCompensationListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.compensations = new CompensationListe_CompensationsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 259;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 259) ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
            .newCompensationListe(this.getId());
        super.store();
        this.getCompensations().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public CompensationListe_CompensationsProxi getCompensations() throws PersistenceException {
        return this.compensations;
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
            ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensationListe result = new CompensationListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensationListe)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationListe(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCompensations().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentCompensation t) 
				throws PersistenceException{
        model.meta.CompensationListeAddCompensationMssg event = new model.meta.CompensationListeAddCompensationMssg(t, getThis());
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
        this.setThis((PersistentCompensationListe)This);
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
    public void remove(final PersistentCompensation t) 
				throws PersistenceException{
        model.meta.CompensationListeRemoveCompensationMssg event = new model.meta.CompensationListeRemoveCompensationMssg(t, getThis());
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
    
    public void addImplementation(final PersistentCompensation t) 
				throws PersistenceException{
        getThis().getCompensations().add(t);
        
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
    public void removeImplementation(final PersistentCompensation t) 
				throws PersistenceException{
    	getThis().getCompensations().filter(new Predcate<PersistentCompensation>() {
			public boolean test(PersistentCompensation argument) throws PersistenceException {
				return argument.equals(t);
			}
		});
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
