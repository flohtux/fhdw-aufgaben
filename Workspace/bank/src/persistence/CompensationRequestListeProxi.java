package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationRequestListeProxi extends PersistentProxi implements PersistentCompensationRequestListe{
    
    public CompensationRequestListeProxi(long objectId) {
        super(objectId);
    }
    public CompensationRequestListeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
            .getCompensationRequestListe(this.getId());
    }
    
    public long getClassId() {
        return 260;
    }
    
    public CompensationRequestListe_CompensationrequestsProxi getCompensationrequests() throws PersistenceException {
        return ((PersistentCompensationRequestListe)this.getTheObject()).getCompensationrequests();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensationRequestListe)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensationRequestListe)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCompensationRequestListe getThis() throws PersistenceException {
        return ((PersistentCompensationRequestListe)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestListe(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).updateObservers(event);
    }
    public void add(final PersistentCompensationRequest t) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).add(t);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).initializeOnInstantiation();
    }
    public void remove(final PersistentCompensationRequest t) 
				throws PersistenceException{
        ((PersistentCompensationRequestListe)this.getTheObject()).remove(t);
    }

    
}
