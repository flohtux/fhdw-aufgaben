
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CommonDateVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleAccountServiceSuccessfullStates(PersistentAccountServiceSuccessfullStates accountServiceSuccessfullStates) throws PersistenceException;
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleAccountServiceNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates accountServiceNotSuccessfullStates) throws PersistenceException;
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}
