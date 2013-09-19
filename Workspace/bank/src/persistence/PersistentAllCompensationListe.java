package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAllCompensationListe extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentAllCompensationListe getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentCompensationListe getOutgoingCompensations() 
				throws PersistenceException;
    public PersistentCompensationRequestListe getPendingCompensationRequests() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void setOutgoingCompensations(final PersistentCompensationListe outgoingCompensations) 
				throws PersistenceException;
    public void setPendingCompensationRequests(final PersistentCompensationRequestListe pendingCompensationRequests) 
				throws PersistenceException;
    public void signalChanges() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void outgoingCompensations_update(final model.meta.CompensationListeMssgs event) 
				throws PersistenceException;
    public void pendingCompensationRequests_update(final model.meta.CompensationRequestListeMssgs event) 
				throws PersistenceException;
    public void signalChangesImplementation() 
				throws PersistenceException;

}

