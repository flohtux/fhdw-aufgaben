
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.standardHandling(falseValue);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException{
        this.standardHandling(noRequestState);
    }
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException{
        this.standardHandling(currencyManager);
    }
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException{
        this.standardHandling(internalFee);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.standardHandling(executedState);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.standardHandling(trueValue);
    }
    public void handlePercent(PersistentPercent percent) throws PersistenceException{
        this.standardHandling(percent);
    }
    public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException{
        this.standardHandling(successfulState);
    }
    public void handleAmount(PersistentAmount amount) throws PersistenceException{
        this.standardHandling(amount);
    }
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException{
        this.standardHandling(noLimit);
    }
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.standardHandling(administrator);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.standardHandling(createBankCommand);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.standardHandling(bankService);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.standardHandling(procentualFee);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException{
        this.standardHandling(administratorBanks);
    }
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.standardHandling(dollar);
    }
    public void handleFranken(PersistentFranken franken) throws PersistenceException{
        this.standardHandling(franken);
    }
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException{
        this.standardHandling(limitAccount);
    }
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleLimit(PersistentLimit limit) throws PersistenceException{
        this.standardHandling(limit);
    }
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.standardHandling(mixedFee);
    }
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException{
        this.standardHandling(requestState);
    }
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.standardHandling(accountService);
    }
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException{
        this.standardHandling(administratorCurrencyManager);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.standardHandling(euro);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.standardHandling(templateState);
    }
    public void handleYen(PersistentYen yen) throws PersistenceException{
        this.standardHandling(yen);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException{
        this.standardHandling(notExecutetState);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.standardHandling(notExecutableState);
    }
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException{
        this.standardHandling(accountDebitTransferTransactions);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleMoney(PersistentMoney money) throws PersistenceException{
        this.standardHandling(money);
    }
    public void handleBank(PersistentBank bank) throws PersistenceException{
        this.standardHandling(bank);
    }
    public void handlePfund(PersistentPfund pfund) throws PersistenceException{
        this.standardHandling(pfund);
    }
    public void handleNotSuccessfulStornoState(PersistentNotSuccessfulStornoState notSuccessfulStornoState) throws PersistenceException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(PersistentSuccessfulStornoState successfulStornoState) throws PersistenceException{
        this.standardHandling(successfulStornoState);
    }
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException{
        this.standardHandling(bankCreator);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
