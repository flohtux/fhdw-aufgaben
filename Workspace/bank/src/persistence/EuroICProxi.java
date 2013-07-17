package persistence;

import model.UserException;

import model.visitor.*;

public class EuroICProxi extends CurrencyICProxi implements PersistentEuro{
    
    public EuroICProxi(long objectId) {
        super(objectId);
    }
    public EuroICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theEuroFacade
            .getEuro(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public PersistentEuro getThis() throws PersistenceException {
        return ((PersistentEuro)this.getTheObject()).getThis();
    }
    
    public void accept(CurrencyVisitor visitor) throws PersistenceException {
        visitor.handleEuro(this);
    }
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEuro(this);
    }
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEuro(this);
    }
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEuro(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleEuro(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEuro(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEuro(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEuro(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEuro(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEuro(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEuro(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEuro(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEuro)this.getTheObject()).initializeOnInstantiation();
    }

    
}
