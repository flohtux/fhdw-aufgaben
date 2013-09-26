package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensationRequest extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentDebitTransfer getDebitTransfer() throws PersistenceException ;
    public void setDebitTransfer(PersistentDebitTransfer newValue) throws PersistenceException ;
    public PersistentAccount getHasToAnswer() throws PersistenceException ;
    public void setHasToAnswer(PersistentAccount newValue) throws PersistenceException ;
    public PersistentCompensation getMasterCompensation() throws PersistenceException ;
    public void setMasterCompensation(PersistentCompensation newValue) throws PersistenceException ;
    public PersistentCompensationRequestState getState() throws PersistenceException ;
    public void setState(PersistentCompensationRequestState newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentCompensationRequest getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void changeState(final PersistentCompensationRequestState a) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void changeStateImplementation(final PersistentCompensationRequestState a) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

