package persistence;

import model.UserException;

import model.visitor.*;

public class FrankenICProxi extends CurrencyICProxi implements PersistentFranken{
    
    public FrankenICProxi(long objectId) {
        super(objectId);
    }
    public FrankenICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFrankenFacade
            .getFranken(this.getId());
    }
    
    public long getClassId() {
        return 180;
    }
    
    public PersistentFranken getThis() throws PersistenceException {
        return ((PersistentFranken)this.getTheObject()).getThis();
    }
    
    public void accept(CurrencyVisitor visitor) throws PersistenceException {
        visitor.handleFranken(this);
    }
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFranken(this);
    }
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFranken(this);
    }
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFranken(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleFranken(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFranken(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFranken(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFranken(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFranken(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFranken(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFranken(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFranken(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFranken)this.getTheObject()).initializeOnInstantiation();
    }

    
}
