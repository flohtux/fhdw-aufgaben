
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.AllCompensationListeProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAllCompensationListe;
import persistence.PersistentCompensationListe;
import persistence.PersistentCompensationRequestListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class AllCompensationListe extends PersistentObject implements PersistentAllCompensationListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAllCompensationListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.getClass(objectId);
        return (PersistentAllCompensationListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAllCompensationListe createAllCompensationListe() throws PersistenceException{
        return createAllCompensationListe(false);
    }
    
    public static PersistentAllCompensationListe createAllCompensationListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentAllCompensationListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
                .newDelayedAllCompensationListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
                .newAllCompensationListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAllCompensationListe createAllCompensationListe(boolean delayed$Persistence,PersistentAllCompensationListe This) throws PersistenceException {
        PersistentAllCompensationListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
                .newDelayedAllCompensationListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
                .newAllCompensationListe(-1);
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
            AbstractPersistentRoot outgoingCompensations = (AbstractPersistentRoot)this.getOutgoingCompensations();
            if (outgoingCompensations != null) {
                result.put("outgoingCompensations", outgoingCompensations.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    outgoingCompensations.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && outgoingCompensations.hasEssentialFields())outgoingCompensations.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot pendingCompensationRequests = (AbstractPersistentRoot)this.getPendingCompensationRequests();
            if (pendingCompensationRequests != null) {
                result.put("pendingCompensationRequests", pendingCompensationRequests.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    pendingCompensationRequests.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && pendingCompensationRequests.hasEssentialFields())pendingCompensationRequests.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AllCompensationListe provideCopy() throws PersistenceException{
        AllCompensationListe result = this;
        result = new AllCompensationListe(this.outgoingCompensations, 
                                          this.pendingCompensationRequests, 
                                          this.subService, 
                                          this.This, 
                                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentCompensationListe outgoingCompensations;
    protected PersistentCompensationRequestListe pendingCompensationRequests;
    protected SubjInterface subService;
    protected PersistentAllCompensationListe This;
    
    public AllCompensationListe(PersistentCompensationListe outgoingCompensations,PersistentCompensationRequestListe pendingCompensationRequests,SubjInterface subService,PersistentAllCompensationListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.outgoingCompensations = outgoingCompensations;
        this.pendingCompensationRequests = pendingCompensationRequests;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 261;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 261) ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
            .newAllCompensationListe(this.getId());
        super.store();
        if(this.getOutgoingCompensations() != null){
            this.getOutgoingCompensations().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.outgoingCompensationsSet(this.getId(), getOutgoingCompensations());
        }
        if(this.getPendingCompensationRequests() != null){
            this.getPendingCompensationRequests().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.pendingCompensationRequestsSet(this.getId(), getPendingCompensationRequests());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentCompensationListe getOutgoingCompensations() throws PersistenceException {
        return this.outgoingCompensations;
    }
    public void setOutgoingCompensations(PersistentCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.outgoingCompensations)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.outgoingCompensations = (PersistentCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.outgoingCompensationsSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationRequestListe getPendingCompensationRequests() throws PersistenceException {
        return this.pendingCompensationRequests;
    }
    public void setPendingCompensationRequests(PersistentCompensationRequestListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.pendingCompensationRequests)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.pendingCompensationRequests = (PersistentCompensationRequestListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.pendingCompensationRequestsSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentAllCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAllCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAllCompensationListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAllCompensationListe result = new AllCompensationListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAllCompensationListe)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListe(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getOutgoingCompensations() != null) return 1;
        if (this.getPendingCompensationRequests() != null) return 1;
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
        this.setThis((PersistentAllCompensationListe)This);
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
