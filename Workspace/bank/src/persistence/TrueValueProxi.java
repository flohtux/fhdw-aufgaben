package persistence;

import model.UserException;

import model.visitor.*;

public class TrueValueProxi extends BooleanValueProxi implements PersistentTrueValue{
    
    public TrueValueProxi(long objectId) {
        super(objectId);
    }
    public TrueValueProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTrueValueFacade
            .getTrueValue(this.getId());
    }
    
    public long getClassId() {
        return 168;
    }
    
    public PersistentTrueValue getThis() throws PersistenceException {
        return ((PersistentTrueValue)this.getTheObject()).getThis();
    }
    
    public void accept(BooleanValueVisitor visitor) throws PersistenceException {
        visitor.handleTrueValue(this);
    }
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrueValue(this);
    }
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrueValue(this);
    }
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrueValue(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTrueValue(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrueValue(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrueValue(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrueValue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTrueValue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrueValue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrueValue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrueValue(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).updateObservers(event);
    }
    public PersistentBooleanValue and(final PersistentBooleanValue value) 
				throws PersistenceException{
        return ((PersistentTrueValue)this.getTheObject()).and(value);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTrueValue)this.getTheObject()).initializeOnInstantiation();
    }
    public boolean isTrue() 
				throws PersistenceException{
        return ((PersistentTrueValue)this.getTheObject()).isTrue();
    }
    public PersistentBooleanValue or(final PersistentBooleanValue value) 
				throws PersistenceException{
        return ((PersistentTrueValue)this.getTheObject()).or(value);
    }

    
}
