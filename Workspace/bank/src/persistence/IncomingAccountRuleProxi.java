package persistence;

import model.UserException;

import model.visitor.*;

public class IncomingAccountRuleProxi extends RuleProxi implements PersistentIncomingAccountRule{
    
    public IncomingAccountRuleProxi(long objectId) {
        super(objectId);
    }
    public IncomingAccountRuleProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
            .getIncomingAccountRule(this.getId());
    }
    
    public long getClassId() {
        return 229;
    }
    
    public long getAccountNumber() throws PersistenceException {
        return ((PersistentIncomingAccountRule)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws PersistenceException {
        ((PersistentIncomingAccountRule)this.getTheObject()).setAccountNumber(newValue);
    }
    public long getBankNumber() throws PersistenceException {
        return ((PersistentIncomingAccountRule)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws PersistenceException {
        ((PersistentIncomingAccountRule)this.getTheObject()).setBankNumber(newValue);
    }
    public PersistentIncomingAccountRule getThis() throws PersistenceException {
        return ((PersistentIncomingAccountRule)this.getTheObject()).getThis();
    }
    
    public void accept(RuleVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).deregister(observee);
    }
    public PersistentTrigger getMasterTrigger() 
				throws PersistenceException{
        return ((PersistentIncomingAccountRule)this.getTheObject()).getMasterTrigger();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).updateObservers(event);
    }
    public void changeAccountNumber(final long accNum) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).changeAccountNumber(accNum);
    }
    public void changeBankNumber(final long bankNum) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).changeBankNumber(bankNum);
    }
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
        return ((PersistentIncomingAccountRule)this.getTheObject()).check(debitTransfer);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentIncomingAccountRule)this.getTheObject()).initializeOnInstantiation();
    }

    
}
