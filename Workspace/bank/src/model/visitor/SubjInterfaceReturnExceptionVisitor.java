
package model.visitor;
import model.UserException;
import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,DebitTransferTransactionReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,DebitTransferStateReturnExceptionVisitor<R, E> ,StornoStateReturnExceptionVisitor<R, E> ,BooleanValueReturnExceptionVisitor<R, E> ,LimitTypeReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> {
    
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException, E;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException, E;
    public R handlePercent(PersistentPercent percent) throws PersistenceException, E;
    public R handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public R handleMoney(PersistentMoney money) throws PersistenceException, E;
    public R handleBank(PersistentBank bank) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException, E;
    
}
