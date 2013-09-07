package persistence;

import model.UserException;

import model.visitor.*;

public class MoneyRuleICProxi extends RuleICProxi implements PersistentMoneyRule{
    
    public MoneyRuleICProxi(long objectId) {
        super(objectId);
    }
    public MoneyRuleICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
            .getMoneyRule(this.getId());
    }
    
    public long getClassId() {
        return 232;
    }
    
    public PersistentCurrency getCurrency() throws PersistenceException {
        return ((PersistentMoneyRule)this.getTheObject()).getCurrency();
    }
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException {
        ((PersistentMoneyRule)this.getTheObject()).setCurrency(newValue);
    }
    public PersistentAmount getMinLimit() throws PersistenceException {
        return ((PersistentMoneyRule)this.getTheObject()).getMinLimit();
    }
    public void setMinLimit(PersistentAmount newValue) throws PersistenceException {
        ((PersistentMoneyRule)this.getTheObject()).setMinLimit(newValue);
    }
    public PersistentAmount getMaxLimit() throws PersistenceException {
        return ((PersistentMoneyRule)this.getTheObject()).getMaxLimit();
    }
    public void setMaxLimit(PersistentAmount newValue) throws PersistenceException {
        ((PersistentMoneyRule)this.getTheObject()).setMaxLimit(newValue);
    }
    public PersistentMoneyRule getThis() throws PersistenceException {
        return ((PersistentMoneyRule)this.getTheObject()).getThis();
    }
    
    public void accept(RuleVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).updateObservers(event);
    }
    public void changeMax(final common.Fraction maxValue) 
				throws model.MaximumIsLowerThenMinimumException, PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).changeMax(maxValue);
    }
    public void changeMin(final common.Fraction minValue) 
				throws model.MinimumIsHigherThenMaximumException, PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).changeMin(minValue);
    }
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
        return ((PersistentMoneyRule)this.getTheObject()).check(debitTransfer);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMoneyRule)this.getTheObject()).initializeOnInstantiation();
    }

    
}
