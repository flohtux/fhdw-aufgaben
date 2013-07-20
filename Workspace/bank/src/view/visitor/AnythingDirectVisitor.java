
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
    
    public abstract void handleDebitNoteTransferTransaction(DebitNoteTransferTransactionView debitNoteTransferTransaction) throws ModelException;
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.handleDebitNoteTransferTransaction(transaction);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.handleDebitNoteTransferTransaction(debitNote);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitNoteTransferTransaction(transfer);
    }
    public abstract void handleBank(BankView bank) throws ModelException;
    
    public abstract void handleDebitNoteTransferState(DebitNoteTransferStateView debitNoteTransferState) throws ModelException;
    
    public void handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException{
        this.handleDebitNoteTransferState(notSuccessfullState);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.handleDebitNoteTransferState(executedState);
    }
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException{
        this.handleDebitNoteTransferState(notExecutetState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.handleDebitNoteTransferState(notExecutableState);
    }
    public void handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException{
        this.handleDebitNoteTransferState(successfullState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.handleDebitNoteTransferState(templateState);
    }
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
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleStornoState(StornoStateView stornoState) throws ModelException;
    
    public void handleSuccessfullStornoState(SuccessfullStornoStateView successfullStornoState) throws ModelException{
        this.handleStornoState(successfullStornoState);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.handleStornoState(requestState);
    }
    public void handleNotSuccessfullStorneState(NotSuccessfullStorneStateView notSuccessfullStorneState) throws ModelException{
        this.handleStornoState(notSuccessfullStorneState);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.handleStornoState(noRequestState);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
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
    
    public abstract void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
    public abstract void handleCurrency(CurrencyView currency) throws ModelException;
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.handleCurrency(dollar);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.handleCurrency(euro);
    }
    public abstract void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    
    
}
