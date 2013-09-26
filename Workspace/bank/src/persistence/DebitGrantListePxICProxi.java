package persistence;

import model.UserException;

import model.visitor.*;

public class DebitGrantListePxICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitGrantListePx{
    
    public DebitGrantListePxICProxi(long objectId) {
        super(objectId);
    }
    public DebitGrantListePxICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitGrantListePxFacade
            .getDebitGrantListePx(this.getId());
    }
    
    public long getClassId() {
        return 286;
    }
    
    public PersistentDebitGrantListe getD1() throws PersistenceException {
        return ((PersistentDebitGrantListePx)this.getTheObject()).getD1();
    }
    public void setD1(PersistentDebitGrantListe newValue) throws PersistenceException {
        ((PersistentDebitGrantListePx)this.getTheObject()).setD1(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitGrantListePx)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitGrantListePx)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitGrantListePx getThis() throws PersistenceException {
        return ((PersistentDebitGrantListePx)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListePx(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListePx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListePx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListePx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListePx(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitGrantListePx)this.getTheObject()).initializeOnInstantiation();
    }

    
}
