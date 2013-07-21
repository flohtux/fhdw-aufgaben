package persistence;

import model.UserException;

import model.visitor.*;

public class PercentProxi extends PersistentProxi implements PersistentPercent{
    
    public PercentProxi(long objectId) {
        super(objectId);
    }
    public PercentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().thePercentFacade
            .getPercent(this.getId());
    }
    
    public long getClassId() {
        return 112;
    }
    
    public common.Fraction getValue() throws PersistenceException {
        return ((PersistentPercent)this.getTheObject()).getValue();
    }
    public void setValue(common.Fraction newValue) throws PersistenceException {
        ((PersistentPercent)this.getTheObject()).setValue(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentPercent)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentPercent)this.getTheObject()).setSubService(newValue);
    }
    public PersistentPercent getThis() throws PersistenceException {
        return ((PersistentPercent)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handlePercent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePercent(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePercent(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePercent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePercent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePercent(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePercent(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePercent(this);
    }
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPercent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
