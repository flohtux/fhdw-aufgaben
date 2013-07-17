package persistence;

import model.UserException;

import model.visitor.*;

public class TrancactionProxi extends DebitNoteTransactionProxi implements PersistentTrancaction{
    
    public TrancactionProxi(long objectId) {
        super(objectId);
    }
    public TrancactionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTrancactionFacade
            .getTrancaction(this.getId());
    }
    
    public long getClassId() {
        return 152;
    }
    
    public PersistentTrancaction getThis() throws PersistenceException {
        return ((PersistentTrancaction)this.getTheObject()).getThis();
    }
    
    public void accept(DebitNoteTransactionVisitor visitor) throws PersistenceException {
        visitor.handleTrancaction(this);
    }
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrancaction(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrancaction(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrancaction(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTrancaction(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrancaction(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrancaction(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrancaction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTrancaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrancaction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrancaction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrancaction(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTrancaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
