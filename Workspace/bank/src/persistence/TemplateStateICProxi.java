package persistence;

import model.UserException;

import model.visitor.*;

public class TemplateStateICProxi extends DebitTransferStateICProxi implements PersistentTemplateState{
    
    public TemplateStateICProxi(long objectId) {
        super(objectId);
    }
    public TemplateStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTemplateStateFacade
            .getTemplateState(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public PersistentTemplateState getThis() throws PersistenceException {
        return ((PersistentTemplateState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentTemplateState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).updateObservers(event);
    }
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentTemplateState)this.getTheObject()).isExecutable();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentTemplateState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
