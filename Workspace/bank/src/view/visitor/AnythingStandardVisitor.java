
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.standardHandling(falseValue);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.standardHandling(noRequestState);
    }
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException{
        this.standardHandling(debitTransferListe);
    }
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException{
        this.standardHandling(currencyManager);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException{
        this.standardHandling(internalFee);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.standardHandling(trueValue);
    }
    public void handlePercent(PercentView percent) throws ModelException{
        this.standardHandling(percent);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.standardHandling(successfulState);
    }
    public void handleAmount(AmountView amount) throws ModelException{
        this.standardHandling(amount);
    }
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.standardHandling(noLimit);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
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
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException{
        this.standardHandling(debitTransferTemplate);
    }
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.standardHandling(franken);
    }
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException{
        this.standardHandling(limitAccount);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.standardHandling(limit);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException{
        this.standardHandling(debitGrantListe);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.standardHandling(requestState);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.standardHandling(accountService);
    }
    public void handleAccountPx(AccountPxView accountPx) throws ModelException{
        this.standardHandling(accountPx);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.standardHandling(notExecutedState);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.standardHandling(yen);
    }
    public void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException{
        this.standardHandling(debitTransferNotExecuted);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleMoney(MoneyView money) throws ModelException{
        this.standardHandling(money);
    }
    public void handleBank(BankView bank) throws ModelException{
        this.standardHandling(bank);
    }
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException{
        this.standardHandling(debitTransferSuccessful);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.standardHandling(pfund);
    }
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException{
        this.standardHandling(successfulStornoState);
    }
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException{
        this.standardHandling(debitGrant);
    }
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException{
        this.standardHandling(bankCreator);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
