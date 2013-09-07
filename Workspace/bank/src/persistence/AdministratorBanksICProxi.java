package persistence;

import model.UserException;

import model.visitor.*;

public class AdministratorBanksICProxi extends PersistentInCacheProxiOptimistic implements PersistentAdministratorBanks{
    
    public AdministratorBanksICProxi(long objectId) {
        super(objectId);
    }
    public AdministratorBanksICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
            .getAdministratorBanks(this.getId());
    }
    
    public long getClassId() {
        return 125;
    }
    
    public PersistentAdministrator getObserver() throws PersistenceException {
        return ((PersistentAdministratorBanks)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAdministrator newValue) throws PersistenceException {
        ((PersistentAdministratorBanks)this.getTheObject()).setObserver(newValue);
    }
    public AdministratorBanks_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAdministratorBanks)this.getTheObject()).getObservee();
    }
    public PersistentAdministratorBanks getThis() throws PersistenceException {
        return ((PersistentAdministratorBanks)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministratorBanks(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministratorBanks(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministratorBanks(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministratorBanks(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdministratorBanks(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministratorBanks(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministratorBanks(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministratorBanks(this);
    }
    
    
    public void add(final PersistentBankPx observee) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentBankPx,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentBankPx,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentBankPx,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentBankPx> procdure) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentBankPx> findAllException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentBankPx> findAll(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).findAll(predcate);
    }
    public <E extends UserException> PersistentBankPx findFirstException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentBankPx findFirst(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentBankPx> iterator() 
				throws PersistenceException{
        return ((PersistentAdministratorBanks)this.getTheObject()).iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAdministratorBanks)this.getTheObject()).update(event);
    }

    
}
