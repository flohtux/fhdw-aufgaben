package persistence;

import model.UserException;

import model.visitor.*;

public class DebitTransferPayedFeesProxi extends PersistentProxi implements PersistentDebitTransferPayedFees{
    
    public DebitTransferPayedFeesProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferPayedFeesProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
            .getDebitTransferPayedFees(this.getId());
    }
    
    public long getClassId() {
        return 288;
    }
    
    public PersistentMoney getPayedFees() throws PersistenceException {
        return ((PersistentDebitTransferPayedFees)this.getTheObject()).getPayedFees();
    }
    public void setPayedFees(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitTransferPayedFees)this.getTheObject()).setPayedFees(newValue);
    }
    public PersistentAccount getPayingAccount() throws PersistenceException {
        return ((PersistentDebitTransferPayedFees)this.getTheObject()).getPayingAccount();
    }
    public void setPayingAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitTransferPayedFees)this.getTheObject()).setPayingAccount(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferPayedFees)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferPayedFees)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitTransferPayedFees getThis() throws PersistenceException {
        return ((PersistentDebitTransferPayedFees)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferPayedFees)this.getTheObject()).initializeOnInstantiation();
    }

    
}
