
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.handleService(administrator);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.handleService(accountService);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.handleService(bankService);
    }
    public abstract void handleAmount(AmountView amount) throws ModelException;
    
    public abstract void handleMoney(MoneyView money) throws ModelException;
    
    public abstract void handleBank(BankView bank) throws ModelException;
    
    public abstract void handleAccount(AccountView account) throws ModelException;
    
    public abstract void handleTransactionFee(TransactionFeeView transactionFee) throws ModelException;
    
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.handleTransactionFee(fixTransactionFee);
    }
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.handleTransactionFee(mixedFee);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.handleTransactionFee(procentualFee);
    }
    public abstract void handleDebitNoteTransaction(DebitNoteTransactionView debitNoteTransaction) throws ModelException;
    
    public void handleTrancaction(TrancactionView trancaction) throws ModelException{
        this.handleDebitNoteTransaction(trancaction);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.handleDebitNoteTransaction(debitNote);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleAccountLimitState(AccountLimitStateView accountLimitState) throws ModelException;
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException{
        this.handleAccountLimitState(minLimitState);
    }
    public void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException{
        this.handleAccountLimitState(noLimitState);
    }
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException{
        this.handleAccountLimitState(maxLimitState);
    }
    public abstract void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
    public abstract void handleCurrency(CurrencyView currency) throws ModelException;
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.handleCurrency(dollar);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.handleCurrency(euro);
    }
    
}
