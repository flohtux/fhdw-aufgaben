
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
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
    
    public abstract void handleSubj(PersistentSubj subj) throws PersistenceException;
    
    public abstract void handleMoney(PersistentMoney money) throws PersistenceException;
    
    public abstract void handleBank(PersistentBank bank) throws PersistenceException;
    
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
    public abstract void handleDebitNoteTransaction(PersistentDebitNoteTransaction debitNoteTransaction) throws PersistenceException;
    
    public void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException{
        this.handleDebitNoteTransaction(trancaction);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.handleDebitNoteTransaction(debitNote);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
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
    public abstract void handleAccountLimitState(PersistentAccountLimitState accountLimitState) throws PersistenceException;
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException{
        this.handleAccountLimitState(minLimitState);
    }
    public void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException{
        this.handleAccountLimitState(noLimitState);
    }
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException{
        this.handleAccountLimitState(maxLimitState);
    }
    public abstract void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    
    public abstract void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
    public abstract void handleCurrency(PersistentCurrency currency) throws PersistenceException;
    
    public void handleDollar(PersistentDollar dollar) throws PersistenceException{
        this.handleCurrency(dollar);
    }
    public void handleEuro(PersistentEuro euro) throws PersistenceException{
        this.handleCurrency(euro);
    }
    
}
