package persistence;

import model.UserException;

import model.visitor.*;

public class MateriallistValueProxi extends PersistentProxi implements PersistentMateriallistValue{
    
    public MateriallistValueProxi(long objectId) {
        super(objectId);
    }
    public MateriallistValueProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
            .getMateriallistValue(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentMaterial getMaterial() throws PersistenceException {
        return ((PersistentMateriallistValue)this.getTheObject()).getMaterial();
    }
    public void setMaterial(PersistentMaterial newValue) throws PersistenceException {
        ((PersistentMateriallistValue)this.getTheObject()).setMaterial(newValue);
    }
    public long getAmount() throws PersistenceException {
        return ((PersistentMateriallistValue)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws PersistenceException {
        ((PersistentMateriallistValue)this.getTheObject()).setAmount(newValue);
    }
    public PersistentMateriallistValue getThis() throws PersistenceException {
        return ((PersistentMateriallistValue)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallistValue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallistValue(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMateriallistValue)this.getTheObject()).initializeOnInstantiation();
    }

    
}
