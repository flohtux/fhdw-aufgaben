package persistence;

import model.UserException;

import model.visitor.*;

public class DebitNoteProxi extends DebitNoteTransferProxi implements PersistentDebitNote{
    
    public DebitNoteProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitNoteFacade
            .getDebitNote(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public PersistentDebitNote getThis() throws PersistenceException {
        return ((PersistentDebitNote)this.getTheObject()).getThis();
    }
    
    public void accept(DebitNoteTransferVisitor visitor) throws PersistenceException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNote(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitNote(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNote(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNote(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNote(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void execute() 
				throws model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).execute();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNote)this.getTheObject()).initializeOnInstantiation();
    }

    
}
