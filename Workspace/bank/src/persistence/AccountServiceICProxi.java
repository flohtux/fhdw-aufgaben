package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceICProxi extends ServiceICProxi implements PersistentAccountService{
    
    public AccountServiceICProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
            .getAccountService(this.getId());
    }
    
    public long getClassId() {
        return -130;
    }
    
    public PersistentAccount getAccount() throws PersistenceException {
        return ((PersistentAccountService)this.getTheObject()).getAccount();
    }
    public void setAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountService)this.getTheObject()).setAccount(newValue);
    }
    public PersistentEventWrapper getEventhandle() throws PersistenceException {
        return ((PersistentAccountService)this.getTheObject()).getEventhandle();
    }
    public void setEventhandle(PersistentEventWrapper newValue) throws PersistenceException {
        ((PersistentAccountService)this.getTheObject()).setEventhandle(newValue);
    }
    public PersistentAccountService getThis() throws PersistenceException {
        return ((PersistentAccountService)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    
    
    public PersistentCompensationRequestListe a_Path_In_AnswerAcceptWithTrigger() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).a_Path_In_AnswerAcceptWithTrigger();
    }
    public PersistentCompensationRequestListe a_Path_In_AnswerAccept() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).a_Path_In_AnswerAccept();
    }
    public PersistentCompensationRequestListe a_Path_In_AnswerDecline() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).a_Path_In_AnswerDecline();
    }
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransactionTemplate() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).debitTransfer_Path_In_AddToTransactionTemplate();
    }
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransaction() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).debitTransfer_Path_In_AddToTransaction();
    }
    public DebitTransferSearchList debitTransfer_Path_In_RemoveFromTransaction(final PersistentTransaction transaction) 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).debitTransfer_Path_In_RemoveFromTransaction(transaction);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).deregister(observee);
    }
    public DebitTransferTransactionSearchList dtr_Path_In_RequestCompensation() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).dtr_Path_In_RequestCompensation();
    }
    public PersistentServer getAccess() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getAccess();
    }
    public PersistentBankFees getBankFees() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getBankFees();
    }
    public PersistentDebitTransferNotExecuted getNotExecuted() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getNotExecuted();
    }
    public PersistentDebitTransferSuccessful getSuccessful() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getSuccessful();
    }
    public PersistentDebitTransferTemplate getTemplate() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getTemplate();
    }
    public PersistentDebitGrantListe grant_Path_In_Remove() 
				throws model.UserException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).grant_Path_In_Remove();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).register(observee);
    }
    public void setBankFees(final PersistentBankFees bankFees) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).setBankFees(bankFees);
    }
    public void setNotExecuted(final PersistentDebitTransferNotExecuted notExecuted) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).setNotExecuted(notExecuted);
    }
    public void setSuccessful(final PersistentDebitTransferSuccessful successful) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).setSuccessful(successful);
    }
    public void setTemplate(final PersistentDebitTransferTemplate template) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).setTemplate(template);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).updateObservers(event);
    }
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).useTemplate(debitTransferTransaction, invoker);
    }
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).addToTransactionTemplate(transaction, debitTransfer);
    }
    public void addToTransactionTrigger(final PersistentTransaction transaction, final String type) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).addToTransactionTrigger(transaction, type);
    }
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).addToTransaction(transaction, debitTransfer);
    }
    public void answerAcceptWithTrigger(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).answerAcceptWithTrigger(a);
    }
    public void answerAccept(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).answerAccept(a);
    }
    public void answerDecline(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).answerDecline(a);
    }
    public void bankFees_update(final model.meta.BankFeesMssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).bankFees_update(event);
    }
    public void changeCurrency(final PersistentDebitTransfer trans, final String currency) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeCurrency(trans, currency);
    }
    public void changeIncomingAccountRuleAccountNumber(final PersistentIncomingAccountRule rule, final long newAccNum) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeIncomingAccountRuleAccountNumber(rule, newAccNum);
    }
    public void changeIncomingAccountRuleBankNumber(final PersistentIncomingAccountRule rule, final long newBankNum) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeIncomingAccountRuleBankNumber(rule, newBankNum);
    }
    public void changeMoneyRuleMax(final PersistentMoneyRule rule, final common.Fraction maxValue) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeMoneyRuleMax(rule, maxValue);
    }
    public void changeMoneyRuleMin(final PersistentMoneyRule rule, final common.Fraction minValue) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeMoneyRuleMin(rule, minValue);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeMoney(trans, newAmount);
    }
    public String changePassword(final String newPassword1, final String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccNumber) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeReceiverAccount(trans, receiverAccNumber);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber);
    }
    public void changeSubjectRuleSubject(final PersistentSubjectRule rule, final String newSubject) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeSubjectRuleSubject(rule, newSubject);
    }
    public void changeSubject(final PersistentDebitTransfer trans, final String subject) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeSubject(trans, subject);
    }
    public PersistentBooleanValue checkMoneyRuleMax(final PersistentMoneyRule rule, final common.Fraction maxValue) 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).checkMoneyRuleMax(rule, maxValue);
    }
    public PersistentBooleanValue checkMoneyRuleMin(final PersistentMoneyRule rule, final common.Fraction minValue) 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).checkMoneyRuleMin(rule, minValue);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDebitGrant(final long receiverAccNumber, final long receiverBankNumber, final String limitType, final common.Fraction amount, final String cur) 
				throws model.GrantAlreadyGivenException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createDebitGrant(receiverAccNumber, receiverBankNumber, limitType, amount, cur);
    }
    public void createDebit() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createDebit();
    }
    public void createNewRule(final PersistentTrigger t, final String type) 
				throws model.DoubleRuleDefinitionException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createNewRule(t, type);
    }
    public void createTemplate(final String type) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createTemplate(type);
    }
    public void createTransaction() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createTransaction();
    }
    public void createTransfer() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createTransfer();
    }
    public void createTrigger(final String name, final String type) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createTrigger(name, type);
    }
    public void disable(final PersistentTrigger t) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).disable(t);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).disconnected();
    }
    public void enable(final PersistentTrigger t) 
				throws model.NoRuleDefinitionException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).enable(t);
    }
    public void executeTransfer(final PersistentDebitTransferTransaction debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.ExecuteException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).executeTransfer(debitTransfer);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initializeOnInstantiation();
    }
    public void notExecuted_update(final model.meta.DebitTransferNotExecutedMssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).notExecuted_update(event);
    }
    public void removeFromTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).removeFromTransaction(transaction, debitTransfer);
    }
    public void remove(final PersistentDebitGrant grant) 
				throws model.NoPermissionToRemoveDebitGrantException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).remove(grant);
    }
    public void requestCompensation(final PersistentDebitTransferTransaction dtr) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).requestCompensation(dtr);
    }
    public void successful_update(final model.meta.DebitTransferSuccessfulMssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).successful_update(event);
    }
    public void template_update(final model.meta.DebitTransferTemplateMssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).template_update(event);
    }
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).useTemplate(debitTransferTransaction);
    }

    
}
