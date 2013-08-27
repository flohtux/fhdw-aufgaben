package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceTemplateProxi extends PersistentProxi implements PersistentAccountServiceTemplate{
    
    public AccountServiceTemplateProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceTemplateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade
            .getAccountServiceTemplate(this.getId());
    }
    
    public long getClassId() {
        return 222;
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return ((PersistentAccountServiceTemplate)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentAccountServiceTemplate)this.getTheObject()).setObserver(newValue);
    }
    public PersistentDebitTransferTemplate getObservee() throws PersistenceException {
        return ((PersistentAccountServiceTemplate)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentDebitTransferTemplate newValue) throws PersistenceException {
        ((PersistentAccountServiceTemplate)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountServiceTemplate getThis() throws PersistenceException {
        return ((PersistentAccountServiceTemplate)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceTemplate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceTemplate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceTemplate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceTemplate(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceTemplate(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceTemplate(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceTemplate(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceTemplate(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountServiceTemplate)this.getTheObject()).update(event);
    }

    
}
