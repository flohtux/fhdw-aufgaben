
package model.visitor;
import model.UserException;
import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,AccountLimitStateExceptionVisitor<E>,CurrencyExceptionVisitor<E>,DebitNoteTransactionExceptionVisitor<E>{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public void handleMoney(PersistentMoney money) throws PersistenceException, E;
    public void handleBank(PersistentBank bank) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    
}
