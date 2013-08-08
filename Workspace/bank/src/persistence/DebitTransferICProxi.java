package persistence;

import model.UserException;

public abstract class DebitTransferICProxi extends DebitTransferTransactionICProxi implements PersistentDebitTransfer{
    
    public DebitTransferICProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public long getReceiverAccountNumber() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public PersistentAccount getSender() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getSender();
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setSender(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setMoney(newValue);
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setSubject(newValue);
    }
    public PersistentDebitTransferState getState() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getState();
    }
    public void setState(PersistentDebitTransferState newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setState(newValue);
    }
    public PersistentStornoState getStornoState() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getStornoState();
    }
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setStornoState(newValue);
    }
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).deregister(observee);
    }
    public void execute() 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).execute();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void executeImplementation() 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).executeImplementation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
