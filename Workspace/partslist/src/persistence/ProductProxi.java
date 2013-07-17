package persistence;

import model.UserException;

import model.visitor.*;

public class ProductProxi extends ComponentProxi implements PersistentProduct{
    
    public ProductProxi(long objectId) {
        super(objectId);
    }
    public ProductProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProductFacade
            .getProduct(this.getId());
    }
    
    public long getClassId() {
        return 104;
    }
    
    public Product_PartsProxi getParts() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getParts();
    }
    public PersistentProduct getThis() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getThis();
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(ComponentHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(ComponentHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    
    
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).containsComponentHierarchy(part);
    }
    public QPartSearchList getPartOf() 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).getPartOf();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).strategyComponentHierarchy(parameter, strategy);
    }
    public void addComponent(final PersistentComponent newComponent, final long amount) 
				throws model.CycleException, PersistenceException{
        ((PersistentProduct)this.getTheObject()).addComponent(newComponent, amount);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMateriallist createMateriallist() 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).createMateriallist();
    }
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
        return ((PersistentProduct)this.getTheObject()).fetchMateriallist();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyChangedMateriallist() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).notifyChangedMateriallist();
    }

    
}
