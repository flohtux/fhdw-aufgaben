package persistence;

import model.UserException;

import model.visitor.*;

public class AdministratorProxi extends ServiceProxi implements PersistentAdministrator{
    
    public AdministratorProxi(long objectId) {
        super(objectId);
    }
    public AdministratorProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
            .getAdministrator(this.getId());
    }
    
    public long getClassId() {
        return -117;
    }
    
    public PersistentAdministrator getThis() throws PersistenceException {
        return ((PersistentAdministrator)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).deregister(observee);
    }
    public PersistentServer getAccess() 
				throws PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).getAccess();
    }
    public PersistentAdministratorBanks getBanks() 
				throws PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).getBanks();
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).register(observee);
    }
    public void signalChanged(boolean signal) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).updateObservers(event);
    }
    public void banks_update(model.meta.BankMssgs event) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).banks_update(event);
    }
    public void changeName(PersistentBank bank, String name) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).changeName(bank, name);
    }
    public String changePassword(String newPassword1, String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void connected(String user) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createBank(String name) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).createBank(name);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initializeOnInstantiation();
    }
    public void translateMoney(PersistentMoney money, PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).translateMoney(money, currency);
    }

    
}
