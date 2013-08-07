
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleAccountDebitNoteTransferTransactions(PersistentAccountDebitNoteTransferTransactions accountDebitNoteTransferTransactions) throws PersistenceException;
    
    public abstract void handleService(PersistentService service) throws PersistenceException;
    
    public void handleAdministrator(PersistentAdministrator administrator) throws PersistenceException{
        this.handleService(administrator);
    }
    public void handleAccountService(PersistentAccountService accountService) throws PersistenceException{
        this.handleService(accountService);
    }
    public void handleBankService(PersistentBankService bankService) throws PersistenceException{
        this.handleService(bankService);
    }
    public abstract void handleAmount(PersistentAmount amount) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleMoney(PersistentMoney money) throws PersistenceException;
    
    public abstract void handleDebitNoteTransferTransaction(PersistentDebitNoteTransferTransaction debitNoteTransferTransaction) throws PersistenceException;
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.handleDebitNoteTransferTransaction(transaction);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.handleDebitNoteTransferTransaction(debitNote);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.handleDebitNoteTransferTransaction(transfer);
    }
    public abstract void handleSubj(PersistentSubj subj) throws PersistenceException;
    
    public abstract void handleBank(PersistentBank bank) throws PersistenceException;
    
    public abstract void handleDebitNoteTransferState(PersistentDebitNoteTransferState debitNoteTransferState) throws PersistenceException;
    
    public void handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException{
        this.handleDebitNoteTransferState(notSuccessfullState);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.handleDebitNoteTransferState(executedState);
    }
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException{
        this.handleDebitNoteTransferState(notExecutetState);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.handleDebitNoteTransferState(notExecutableState);
    }
    public void handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException{
        this.handleDebitNoteTransferState(successfullState);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.handleDebitNoteTransferState(templateState);
    }
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    
    public abstract void handleTransactionFee(PersistentTransactionFee transactionFee) throws PersistenceException;
    
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException{
        this.handleTransactionFee(fixTransactionFee);
    }
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException{
        this.handleTransactionFee(mixedFee);
    }
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException{
        this.handleTransactionFee(procentualFee);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleStornoState(PersistentStornoState stornoState) throws PersistenceException;
    
    public void handleSuccessfullStornoState(PersistentSuccessfullStornoState successfullStornoState) throws PersistenceException{
        this.handleStornoState(successfullStornoState);
    }
    public void handleRequestState(PersistentRequestState requestState) throws PersistenceException{
        this.handleStornoState(requestState);
    }
    public void handleNotSuccessfullStorneState(PersistentNotSuccessfullStorneState notSuccessfullStorneState) throws PersistenceException{
        this.handleStornoState(notSuccessfullStorneState);
    }
    public void handleNoRequestState(PersistentNoRequestState noRequestState) throws PersistenceException{
        this.handleStornoState(noRequestState);
    }
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    
    public abstract void handleLimitType(PersistentLimitType limitType) throws PersistenceException;
    
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException{
        this.handleLimitType(noLimit);
    }
    public void handleLimit(PersistentLimit limit) throws PersistenceException{
        this.handleLimitType(limit);
    }
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleBooleanValue(PersistentBooleanValue booleanValue) throws PersistenceException;
    
    public void handleFalseValue(PersistentFalseValue falseValue) throws PersistenceException{
        this.handleBooleanValue(falseValue);
    }
    public void handleTrueValue(PersistentTrueValue trueValue) throws PersistenceException{
        this.handleBooleanValue(trueValue);
    }
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.handleCommonDate(createAccountCommand);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.handleCommonDate(createBankCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.handleCommonDate(changeNameCommand);
    }
    public abstract void handlePercent(PersistentPercent percent) throws PersistenceException;
    
    public abstract void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    
    public abstract void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
    public abstract void handleCurrency(PersistentCurrency currency) throws PersistenceException;
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.handleCurrency(dollar);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.handleCurrency(euro);
    }
    public abstract void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    
    
}
