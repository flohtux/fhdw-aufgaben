package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationListeProxi extends PersistentProxi implements PersistentCompensationListe{
    
    public CompensationListeProxi(long objectId) {
        super(objectId);
    }
    public CompensationListeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
            .getCompensationListe(this.getId());
    }
    
    public long getClassId() {
        return 259;
    }
    
    public CompensationListe_CompensationsProxi getCompensations() throws PersistenceException {
        return ((PersistentCompensationListe)this.getTheObject()).getCompensations();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensationListe)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensationListe)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCompensationListe getThis() throws PersistenceException {
        return ((PersistentCompensationListe)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationListe(this);
    }
    
    
    public void add(final PersistentCompensation t) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).add(t);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).register(observee);
    }
    public void remove(final PersistentCompensation t) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).remove(t);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).updateObservers(event);
    }
    public void addImplementation(final PersistentCompensation t) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).addImplementation(t);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeImplementation(final PersistentCompensation t) 
				throws PersistenceException{
        ((PersistentCompensationListe)this.getTheObject()).removeImplementation(t);
    }

    
}
