
package model.visitor;
import model.UserException;
import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,DebitTransferTransactionExceptionVisitor<E>,DebitTransferStateExceptionVisitor<E>,StornoStateExceptionVisitor<E>,BooleanValueExceptionVisitor<E>,CurrencyExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,LimitTypeExceptionVisitor<E>,RuleExceptionVisitor<E>{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException, E;
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException, E;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException, E;
    public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException, E;
    public void handlePercent(PersistentPercent percent) throws PersistenceException, E;
    public void handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException, E;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException, E;
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException, E;
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException, E;
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException, E;
    public void handleMoney(PersistentMoney money) throws PersistenceException, E;
    public void handleBank(PersistentBank bank) throws PersistenceException, E;
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException, E;
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException, E;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException, E;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    
}
