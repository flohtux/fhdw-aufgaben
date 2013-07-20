
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.standardHandling(requestState);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.standardHandling(accountService);
    }
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.standardHandling(falseValue);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException{
        this.standardHandling(notSuccessfullStorneState);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.standardHandling(noRequestState);
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
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException{
        this.standardHandling(internalFee);
    }
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException{
        this.standardHandling(notExecutetState);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException{
        this.standardHandling(notSuccessfullState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.standardHandling(trueValue);
    }
    public void handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException{
        this.standardHandling(successfullState);
    }
    public void handlePercent(PercentView percent) throws ModelException{
        this.standardHandling(percent);
    }
    public void handleAmount(AmountView amount) throws ModelException{
        this.standardHandling(amount);
    }
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.standardHandling(noLimit);
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
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException{
        this.standardHandling(successfullStornoState);
    }
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException{
        this.standardHandling(bankCreator);
    }
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException{
        this.standardHandling(limitAccount);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.standardHandling(limit);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
