package persistence;

import model.UserException;

import model.visitor.*;

public class MateriallistICProxi extends PersistentInCacheProxiOptimistic implements PersistentMateriallist{
    
    public MateriallistICProxi(long objectId) {
        super(objectId);
    }
    public MateriallistICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
            .getMateriallist(this.getId());
    }
    
    public long getClassId() {
        return 111;
    }
    
    public Materiallist_ValuesProxi getValues() throws PersistenceException {
        return ((PersistentMateriallist)this.getTheObject()).getValues();
    }
    public PersistentMateriallist getThis() throws PersistenceException {
        return ((PersistentMateriallist)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallist(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallist(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMateriallist addAll(final PersistentMateriallist list) 
				throws PersistenceException{
        return ((PersistentMateriallist)this.getTheObject()).addAll(list);
    }
    public PersistentMateriallist add(final PersistentMaterial material, final long amount) 
				throws PersistenceException{
        return ((PersistentMateriallist)this.getTheObject()).add(material, amount);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMateriallist)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMateriallist multiply(final long factor) 
				throws PersistenceException{
        return ((PersistentMateriallist)this.getTheObject()).multiply(factor);
    }

    
}
