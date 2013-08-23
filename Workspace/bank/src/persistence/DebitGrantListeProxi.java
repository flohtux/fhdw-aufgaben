package persistence;

import model.UserException;

import model.visitor.*;

public class DebitGrantListeProxi extends PersistentProxi implements PersistentDebitGrantListe{
    
    public DebitGrantListeProxi(long objectId) {
        super(objectId);
    }
    public DebitGrantListeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
            .getDebitGrantListe(this.getId());
    }
    
    public long getClassId() {
        return 202;
    }
    
    public DebitGrantListe_DebitGrantsProxi getDebitGrants() throws PersistenceException {
        return ((PersistentDebitGrantListe)this.getTheObject()).getDebitGrants();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitGrantListe)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitGrantListe)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitGrantListe getThis() throws PersistenceException {
        return ((PersistentDebitGrantListe)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListe(this);
    }
    
    
    public void createDebitGrant(final PersistentAccountPx receiver, final PersistentLimitType limit) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).createDebitGrant(receiver, limit);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDebitGrantImplementation(final PersistentAccountPx receiver, final PersistentLimitType limit) 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).createDebitGrantImplementation(receiver, limit);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitGrantListe)this.getTheObject()).initializeOnInstantiation();
    }

    
}
