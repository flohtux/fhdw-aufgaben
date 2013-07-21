package persistence;

import model.UserException;

import model.visitor.*;

public class DollarProxi extends CurrencyProxi implements PersistentDollar{
    
    public DollarProxi(long objectId) {
        super(objectId);
    }
    public DollarProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDollarFacade
            .getDollar(this.getId());
    }
    
    public long getClassId() {
        return 126;
    }
    
    public PersistentDollar getThis() throws PersistenceException {
        return ((PersistentDollar)this.getTheObject()).getThis();
    }
    
    public void accept(CurrencyVisitor visitor) throws PersistenceException {
        visitor.handleDollar(this);
    }
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDollar(this);
    }
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDollar(this);
    }
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDollar(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDollar(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDollar(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDollar(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDollar(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDollar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDollar(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDollar(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDollar(this);
    }
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDollar)this.getTheObject()).initializeOnInstantiation();
    }

    
}
