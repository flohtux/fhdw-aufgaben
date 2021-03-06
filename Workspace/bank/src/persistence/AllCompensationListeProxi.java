package persistence;

import model.UserException;

import model.visitor.*;

public class AllCompensationListeProxi extends PersistentProxi implements PersistentAllCompensationListe{
    
    public AllCompensationListeProxi(long objectId) {
        super(objectId);
    }
    public AllCompensationListeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAllCompensationListeFacade
            .getAllCompensationListe(this.getId());
    }
    
    public long getClassId() {
        return 261;
    }
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAllCompensationListe)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAllCompensationListe)this.getTheObject()).setSubService(newValue);
    }
    public PersistentAllCompensationListe getThis() throws PersistenceException {
        return ((PersistentAllCompensationListe)this.getTheObject()).getThis();
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
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensationListe getOutgoingCompensations() 
				throws PersistenceException{
        return ((PersistentAllCompensationListe)this.getTheObject()).getOutgoingCompensations();
    }
    public PersistentCompensationRequestListe getPendingCompensationRequests() 
				throws PersistenceException{
        return ((PersistentAllCompensationListe)this.getTheObject()).getPendingCompensationRequests();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).register(observee);
    }
    public void setOutgoingCompensations(final PersistentCompensationListe outgoingCompensations) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).setOutgoingCompensations(outgoingCompensations);
    }
    public void setPendingCompensationRequests(final PersistentCompensationRequestListe pendingCompensationRequests) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).setPendingCompensationRequests(pendingCompensationRequests);
    }
    public void signalChanges() 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).signalChanges();
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).initializeOnInstantiation();
    }
    public void outgoingCompensations_update(final model.meta.CompensationListeMssgs event) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).outgoingCompensations_update(event);
    }
    public void pendingCompensationRequests_update(final model.meta.CompensationRequestListeMssgs event) 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).pendingCompensationRequests_update(event);
    }
    public void signalChangesImplementation() 
				throws PersistenceException{
        ((PersistentAllCompensationListe)this.getTheObject()).signalChangesImplementation();
    }

    
}
