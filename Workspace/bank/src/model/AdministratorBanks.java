
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AdministratorBanksProxi;
import persistence.AdministratorBanks_ObserveeProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAdministrator;
import persistence.PersistentAdministratorBanks;
import persistence.PersistentBankPx;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SearchListRoot;


/* Additional import section end */

public class AdministratorBanks extends PersistentObject implements PersistentAdministratorBanks{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAdministratorBanks getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.getClass(objectId);
        return (PersistentAdministratorBanks)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAdministratorBanks createAdministratorBanks() throws PersistenceException{
        return createAdministratorBanks(false);
    }
    
    public static PersistentAdministratorBanks createAdministratorBanks(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdministratorBanks result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
                .newDelayedAdministratorBanks();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
                .newAdministratorBanks(-1);
        }
        while (!(result instanceof AdministratorBanks)) result = (PersistentAdministratorBanks)result.getTheObject();
        ((AdministratorBanks)result).setThis(result);
        return result;
    }
    
    public AdministratorBanks provideCopy() throws PersistenceException{
        AdministratorBanks result = this;
        result = new AdministratorBanks(this.observer, 
                                        this.This, 
                                        this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAdministrator observer;
    protected AdministratorBanks_ObserveeProxi observee;
    protected PersistentAdministratorBanks This;
    
    public AdministratorBanks(PersistentAdministrator observer,PersistentAdministratorBanks This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AdministratorBanks_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 125) ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
            .newAdministratorBanks(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAdministrator getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentAdministrator newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAdministrator)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.observerSet(this.getId(), newValue);
        }
    }
    public AdministratorBanks_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAdministratorBanks newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAdministratorBanks)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAdministratorBanks getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdministratorBanks result = new AdministratorBanksProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAdministratorBanks)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentBankPx observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentBankPx,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentBankPx,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentBankPx,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentBankPx> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentBankPx> findAllException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<PersistentBankPx> findAll(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends UserException> PersistentBankPx findFirstException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public PersistentBankPx findFirst(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public java.util.Iterator<PersistentBankPx> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().banks_update((model.meta.BankPxMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
