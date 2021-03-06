package persistence;

import model.UserException;

import model.visitor.*;

public class FixTransactionFeeICProxi extends TransactionFeeICProxi implements PersistentFixTransactionFee{
    
    public FixTransactionFeeICProxi(long objectId) {
        super(objectId);
    }
    public FixTransactionFeeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
            .getFixTransactionFee(this.getId());
    }
    
    public long getClassId() {
        return 108;
    }
    
    public PersistentMoney getValue() throws PersistenceException {
        return ((PersistentFixTransactionFee)this.getTheObject()).getValue();
    }
    public void setValue(PersistentMoney newValue) throws PersistenceException {
        ((PersistentFixTransactionFee)this.getTheObject()).setValue(newValue);
    }
    public PersistentFixTransactionFee getThis() throws PersistenceException {
        return ((PersistentFixTransactionFee)this.getTheObject()).getThis();
    }
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFixTransactionFee)this.getTheObject()).initializeOnInstantiation();
    }

    
}
