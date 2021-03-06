package persistence;

import model.UserException;

import model.visitor.*;

public class SubjectRuleICProxi extends RuleICProxi implements PersistentSubjectRule{
    
    public SubjectRuleICProxi(long objectId) {
        super(objectId);
    }
    public SubjectRuleICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSubjectRuleFacade
            .getSubjectRule(this.getId());
    }
    
    public long getClassId() {
        return 230;
    }
    
    public String getSubject() throws PersistenceException {
        return ((PersistentSubjectRule)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentSubjectRule)this.getTheObject()).setSubject(newValue);
    }
    public PersistentSubjectRule getThis() throws PersistenceException {
        return ((PersistentSubjectRule)this.getTheObject()).getThis();
    }
    
    public void accept(RuleVisitor visitor) throws PersistenceException {
        visitor.handleSubjectRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubjectRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubjectRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubjectRule(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleSubjectRule(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubjectRule(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubjectRule(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubjectRule(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSubjectRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubjectRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubjectRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubjectRule(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).deregister(observee);
    }
    public PersistentTrigger getMasterTrigger() 
				throws PersistenceException{
        return ((PersistentSubjectRule)this.getTheObject()).getMasterTrigger();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).updateObservers(event);
    }
    public void changeSubject(final String subject) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).changeSubject(subject);
    }
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
        return ((PersistentSubjectRule)this.getTheObject()).check(debitTransfer);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSubjectRule)this.getTheObject()).initializeOnInstantiation();
    }

    
}
