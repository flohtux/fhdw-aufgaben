package persistence;

import model.UserException;

import model.visitor.*;

public class MixedFeeICProxi extends TransactionFeeICProxi implements PersistentMixedFee{
    
    public MixedFeeICProxi(long objectId) {
        super(objectId);
    }
    public MixedFeeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
            .getMixedFee(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public PersistentFixTransactionFee getFix() throws PersistenceException {
        return ((PersistentMixedFee)this.getTheObject()).getFix();
    }
    public void setFix(PersistentFixTransactionFee newValue) throws PersistenceException {
        ((PersistentMixedFee)this.getTheObject()).setFix(newValue);
    }
    public PersistentProcentualFee getProcentual() throws PersistenceException {
        return ((PersistentMixedFee)this.getTheObject()).getProcentual();
    }
    public void setProcentual(PersistentProcentualFee newValue) throws PersistenceException {
        ((PersistentMixedFee)this.getTheObject()).setProcentual(newValue);
    }
    public long getLimit() throws PersistenceException {
        return ((PersistentMixedFee)this.getTheObject()).getLimit();
    }
    public void setLimit(long newValue) throws PersistenceException {
        ((PersistentMixedFee)this.getTheObject()).setLimit(newValue);
    }
    public PersistentMixedFee getThis() throws PersistenceException {
        return ((PersistentMixedFee)this.getTheObject()).getThis();
    }
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMixedFee)this.getTheObject()).initializeOnInstantiation();
    }

    
}
