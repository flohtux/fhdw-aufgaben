
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.standardHandling(accountService);
    }
    public void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException{
        this.standardHandling(noLimitState);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.standardHandling(debitNote);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException{
        this.standardHandling(minLimitState);
    }
    public void handleTrancaction(TrancactionView trancaction) throws ModelException{
        this.standardHandling(trancaction);
    }
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException{
        this.standardHandling(maxLimitState);
    }
    public void handleAmount(AmountView amount) throws ModelException{
        this.standardHandling(amount);
    }
    public void handleMoney(MoneyView money) throws ModelException{
        this.standardHandling(money);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
    }
    public void handleBank(BankView bank) throws ModelException{
        this.standardHandling(bank);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.standardHandling(bankService);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.standardHandling(procentualFee);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException{
        this.standardHandling(bankCreator);
    }
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
