
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.CompensationPendingRequestsProxi;
import persistence.CompensationPendingRequests_ObserveeProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationPendingRequests;
import persistence.PersistentCompensationRequest;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SearchListRoot;


/* Additional import section end */

public class CompensationPendingRequests extends PersistentObject implements PersistentCompensationPendingRequests{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensationPendingRequests getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.getClass(objectId);
        return (PersistentCompensationPendingRequests)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensationPendingRequests createCompensationPendingRequests() throws PersistenceException{
        return createCompensationPendingRequests(false);
    }
    
    public static PersistentCompensationPendingRequests createCompensationPendingRequests(boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensationPendingRequests result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
                .newDelayedCompensationPendingRequests();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
                .newCompensationPendingRequests(-1);
        }
        while (!(result instanceof CompensationPendingRequests)) result = (PersistentCompensationPendingRequests)result.getTheObject();
        ((CompensationPendingRequests)result).setThis(result);
        return result;
    }
    
    public CompensationPendingRequests provideCopy() throws PersistenceException{
        CompensationPendingRequests result = this;
        result = new CompensationPendingRequests(this.observer, 
                                                 this.This, 
                                                 this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentCompensation observer;
    protected CompensationPendingRequests_ObserveeProxi observee;
    protected PersistentCompensationPendingRequests This;
    
    public CompensationPendingRequests(PersistentCompensation observer,PersistentCompensationPendingRequests This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new CompensationPendingRequests_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 257;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 257) ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
            .newCompensationPendingRequests(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentCompensation getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentCompensation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.observerSet(this.getId(), newValue);
        }
    }
    public CompensationPendingRequests_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentCompensationPendingRequests newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationPendingRequests getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensationPendingRequests result = new CompensationPendingRequestsProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensationPendingRequests)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationPendingRequests(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationPendingRequests(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationPendingRequests(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationPendingRequests(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationPendingRequests(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationPendingRequests(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationPendingRequests(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationPendingRequests(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentCompensationRequest observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentCompensationRequest,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentCompensationRequest,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentCompensationRequest,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentCompensationRequest> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentCompensationRequest> findAllException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<PersistentCompensationRequest> findAll(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends UserException> PersistentCompensationRequest findFirstException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public PersistentCompensationRequest findFirst(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public java.util.Iterator<PersistentCompensationRequest> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().pendingRequests_update((model.meta.CompensationRequestMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
