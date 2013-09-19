
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
import persistence.CompensationRequestListeProxi;
import persistence.CompensationRequestListe_CompensationrequestsProxi;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCompensationRequestListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class CompensationRequestListe extends PersistentObject implements PersistentCompensationRequestListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensationRequestListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.getClass(objectId);
        return (PersistentCompensationRequestListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensationRequestListe createCompensationRequestListe() throws PersistenceException{
        return createCompensationRequestListe(false);
    }
    
    public static PersistentCompensationRequestListe createCompensationRequestListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensationRequestListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
                .newDelayedCompensationRequestListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
                .newCompensationRequestListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompensationRequestListe createCompensationRequestListe(boolean delayed$Persistence,PersistentCompensationRequestListe This) throws PersistenceException {
        PersistentCompensationRequestListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
                .newDelayedCompensationRequestListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
                .newCompensationRequestListe(-1);
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
            result.put("compensationrequests", this.getCompensationrequests().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompensationRequestListe provideCopy() throws PersistenceException{
        CompensationRequestListe result = this;
        result = new CompensationRequestListe(this.subService, 
                                              this.This, 
                                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompensationRequestListe_CompensationrequestsProxi compensationrequests;
    protected SubjInterface subService;
    protected PersistentCompensationRequestListe This;
    
    public CompensationRequestListe(SubjInterface subService,PersistentCompensationRequestListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.compensationrequests = new CompensationRequestListe_CompensationrequestsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 260;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 260) ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
            .newCompensationRequestListe(this.getId());
        super.store();
        this.getCompensationrequests().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public CompensationRequestListe_CompensationrequestsProxi getCompensationrequests() throws PersistenceException {
        return this.compensationrequests;
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
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCompensationRequestListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensationRequestListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationRequestListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensationRequestListe result = new CompensationRequestListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensationRequestListe)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestListe(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCompensationrequests().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentCompensationRequest t) 
				throws PersistenceException{
        model.meta.CompensationRequestListeAddCompensationRequestMssg event = new model.meta.CompensationRequestListeAddCompensationRequestMssg(t, getThis());
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
        this.setThis((PersistentCompensationRequestListe)This);
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
    
    public void addImplementation(final PersistentCompensationRequest t) 
				throws PersistenceException{
        getThis().getCompensationrequests().add(t);
        
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
    public void remove(final PersistentCompensationRequest t) 
				throws PersistenceException{
        //TODO: implement method: removegetThis().getCompensationrequests().add(t);
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
