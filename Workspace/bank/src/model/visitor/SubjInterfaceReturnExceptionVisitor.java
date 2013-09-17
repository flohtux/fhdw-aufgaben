
package model.visitor;
import model.UserException;
import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,DebitTransferTransactionReturnExceptionVisitor<R, E> ,DebitTransferStateReturnExceptionVisitor<R, E> ,StornoStateReturnExceptionVisitor<R, E> ,BooleanValueReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,LimitTypeReturnExceptionVisitor<R, E> ,TriggerStateReturnExceptionVisitor<R, E> ,TriggerValueReturnExceptionVisitor<R, E> ,RuleReturnExceptionVisitor<R, E> {
    
    public R handleCompensation(PersistentCompensation compensation) throws PersistenceException, E;
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException, E;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException, E;
    public R handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException, E;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException, E;
    public R handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException, E;
    public R handlePercent(PersistentPercent percent) throws PersistenceException, E;
    public R handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public R handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException, E;
    public R handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException, E;
    public R handleBankPx(PersistentBankPx bankPx) throws PersistenceException, E;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException, E;
    public R handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException, E;
    public R handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException, E;
    public R handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException, E;
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException, E;
    public R handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException, E;
    public R handleMoney(PersistentMoney money) throws PersistenceException, E;
    public R handleBank(PersistentBank bank) throws PersistenceException, E;
    public R handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException, E;
    public R handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException, E;
    public R handleBankFees(PersistentBankFees bankFees) throws PersistenceException, E;
    public R handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException, E;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    public R handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException, E;
    
}
