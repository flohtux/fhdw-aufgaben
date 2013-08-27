
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.handleService(accountService);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.handleService(administrator);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.handleService(bankService);
    }
    public abstract void handleDebitTransferTransaction(DebitTransferTransactionView debitTransferTransaction) throws ModelException;
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.handleDebitTransferTransaction(transaction);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitTransferTransaction(transfer);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleDebitTransferTransaction(debit);
    }
    public abstract void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    
    public abstract void handleAccountPx(AccountPxView accountPx) throws ModelException;
    
    public abstract void handleTransactionFee(TransactionFeeView transactionFee) throws ModelException;
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.handleTransactionFee(mixedFee);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.handleTransactionFee(fixTransactionFee);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.handleTransactionFee(procentualFee);
    }
    public abstract void handleAccount(AccountView account) throws ModelException;
    
    public abstract void handleDebitTransferState(DebitTransferStateView debitTransferState) throws ModelException;
    
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.handleDebitTransferState(executedState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.handleDebitTransferState(notExecutableState);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.handleDebitTransferState(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.handleDebitTransferState(successfulState);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.handleDebitTransferState(notExecutedState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.handleDebitTransferState(templateState);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleStornoState(StornoStateView stornoState) throws ModelException;
    
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException{
        this.handleStornoState(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException{
        this.handleStornoState(successfulStornoState);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.handleStornoState(requestState);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.handleStornoState(noRequestState);
    }
    public abstract void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    
    public abstract void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    
    public abstract void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    
    public abstract void handleInternalFee(InternalFeeView internalFee) throws ModelException;
    
    public abstract void handleLimitType(LimitTypeView limitType) throws ModelException;
    
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.handleLimitType(noLimit);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.handleLimitType(limit);
    }
    public abstract void handleBooleanValue(BooleanValueView booleanValue) throws ModelException;
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.handleBooleanValue(falseValue);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.handleBooleanValue(trueValue);
    }
    public abstract void handlePercent(PercentView percent) throws ModelException;
    
    public abstract void handleCurrency(CurrencyView currency) throws ModelException;
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.handleCurrency(dollar);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.handleCurrency(pfund);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.handleCurrency(franken);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.handleCurrency(euro);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.handleCurrency(yen);
    }
    public abstract void handleAmount(AmountView amount) throws ModelException;
    
    public abstract void handleMoney(MoneyView money) throws ModelException;
    
    public abstract void handleBank(BankView bank) throws ModelException;
    
    public abstract void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    
    public abstract void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    
    public abstract void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
    public abstract void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    
    
}
