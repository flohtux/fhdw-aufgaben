package persistence;

import model.UserException;

public abstract class DebitTransferTransactionProxi extends PersistentProxi implements PersistentDebitTransferTransaction{
    
    public DebitTransferTransactionProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferTransactionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setTimestamp(newValue);
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setSubject(newValue);
    }
    public PersistentAccount getSender() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getSender();
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setSender(newValue);
    }
    public PersistentDebitTransferState getState() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getState();
    }
    public void setState(PersistentDebitTransferState newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setState(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentDebitTransferTransaction)this.getTheObject()).changeState(newState);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction execute() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentDebitTransferTransaction)this.getTheObject()).execute();
    }
    public void execute(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).execute(invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).updateObservers(event);
    }
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentDebitTransferTransaction)this.getTheObject()).changeStateImplementation(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
        return ((PersistentDebitTransferTransaction)this.getTheObject()).copy();
    }
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentDebitTransferTransaction)this.getTheObject()).executeImplementation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
