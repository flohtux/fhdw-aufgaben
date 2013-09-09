package persistence;

import model.UserException;

import model.visitor.*;

public class BankFeesICProxi extends PersistentInCacheProxiOptimistic implements PersistentBankFees{
    
    public BankFeesICProxi(long objectId) {
        super(objectId);
    }
    public BankFeesICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
            .getBankFees(this.getId());
    }
    
    public long getClassId() {
        return 244;
    }
    
    public PersistentTransactionFee getFee() throws PersistenceException {
        return ((PersistentBankFees)this.getTheObject()).getFee();
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        ((PersistentBankFees)this.getTheObject()).setFee(newValue);
    }
    public PersistentInternalFee getInternalFee() throws PersistenceException {
        return ((PersistentBankFees)this.getTheObject()).getInternalFee();
    }
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException {
        ((PersistentBankFees)this.getTheObject()).setInternalFee(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBankFees)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBankFees)this.getTheObject()).setSubService(newValue);
    }
    public PersistentBankFees getThis() throws PersistenceException {
        return ((PersistentBankFees)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankFees(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankFees(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankFees(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankFees(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankFees(this);
    }
    
    
    public void changeInternalFee(final PersistentInternalFee newInternalFee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).changeInternalFee(newInternalFee);
    }
    public void changeTransactionFee(final PersistentTransactionFee newTransactionFee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).changeTransactionFee(newTransactionFee);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).updateObservers(event);
    }
    public void changeInternalFeeImplementation(final PersistentInternalFee newInternalFee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).changeInternalFeeImplementation(newInternalFee);
    }
    public void changeTransactionFeeImplementation(final PersistentTransactionFee newTransactionFee) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).changeTransactionFeeImplementation(newTransactionFee);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBankFees)this.getTheObject()).initializeOnInstantiation();
    }

    
}
