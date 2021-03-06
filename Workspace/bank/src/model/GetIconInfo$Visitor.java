package model;

import model.visitor.CompensationRequestStateVisitor;
import model.visitor.CompensationStateVisitor;
import model.visitor.DebitTransferStateVisitor;
import model.visitor.TriggerStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAcceptedState;
import persistence.PersistentAccount;
import persistence.PersistentAccountAllCompensation;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountReceivedDebitGrant;
import persistence.PersistentAllCompensationListe;
import persistence.PersistentBankFees;
import persistence.PersistentBankOwnAccountPx;
import persistence.PersistentBankPx;
import persistence.PersistentCompensatedState;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationDeclinedCommand;
import persistence.PersistentCompensationListe;
import persistence.PersistentCompensationPendingRequests;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCompensationRequestListe;
import persistence.PersistentCompensationRequestedState;
import persistence.PersistentCurrencyManager;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentDebitGrantListePx;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentDeclinedCompensationState;
import persistence.PersistentDeclinedState;
import persistence.PersistentDisabledState;
import persistence.PersistentEnabledState;
import persistence.PersistentExecutedState;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentInternalFee;
import persistence.PersistentLimit;
import persistence.PersistentLimitAccount;
import persistence.PersistentMixedFee;
import persistence.PersistentMoney;
import persistence.PersistentNoLimit;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentProcentualFee;
import persistence.PersistentSuccessfulCompensationState;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerListe;
import persistence.PersistentWaitingCompensationState;
import persistence.PersistentWaitingState;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	public void handleTrigger(PersistentTrigger trigger) throws PersistenceException {
		trigger.getState().accept(new TriggerStateVisitor() {
			
			@Override
			public void handleEnabledState(PersistentEnabledState enabledState)	throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
			}
			
			@Override
			public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException {
				result = common.IconInfoConstants.NegativeIconNumber;
			}
		});
	}
		
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}
	//TODO PREREQUISITES: Icon: how to assign icon information
	
	@Override
	public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException {
		result = common.IconInfoConstants.EinzugInIconNumber;
	}
	
	@Override
	public void handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException {
		result = common.IconInfoConstants.EinzugOutIconNumber;
	}
	
	@Override
	public void handleAccount(PersistentAccount account) throws PersistenceException {
		result = common.IconInfoConstants.BankAccountIconNumber;
	}
	
	public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException{
        result = common.IconInfoConstants.AccountIconNumber;
	}
	
	@Override
	public void handleBankFees(PersistentBankFees bankFees)	throws PersistenceException {
		result = common.IconInfoConstants.GebührenIconNumber;
	}
	
	public void handleBankPx(PersistentBankPx bank) throws PersistenceException{
        result = common.IconInfoConstants.BankIconNumber;
	}

	@Override
	public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException {
		result = common.IconInfoConstants.KontostandIconNumber;
	}

	@Override
	public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted)	throws PersistenceException {
		result = common.IconInfoConstants.NochNichtErledigteAuftraegeIconNumber;
	}
	
	@Override
	public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful)
			throws PersistenceException {
		result = common.IconInfoConstants.HistorieIconNumber;
	}
	
	public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException{
		result = common.IconInfoConstants.VorlagenIconNumber;
	}
	
	@Override
	public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException {
		result = common.IconInfoConstants.FixeKostenIconNumber;
	}
	
	@Override
	public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException {
		result = common.IconInfoConstants.RabattIconNumber;
	}
	
	public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException{
		result = common.IconInfoConstants.LimitsIconNumber;
	}
	
	@Override
	public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException {
		result = common.IconInfoConstants.MixKostenIconNumber;
	}
	
	public void handleMoney(PersistentMoney money) throws PersistenceException{
		result = common.IconInfoConstants.KontostandIconNumber;
	}
	
	@Override
	public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException {
		result = common.IconInfoConstants.ProzentualeKostenIconNumber;
	}
	
	@Override
	public void handleTransfer(PersistentTransfer transfer) throws PersistenceException {
		this.handleDebitTransferTransaction(transfer);
	}
	
	@Override
	public void handleDebit(PersistentDebit debit) throws PersistenceException {
		this.handleDebitTransferTransaction(debit);
	}
	
	@Override
	public void handleTransaction(PersistentTransaction transaction)
			throws PersistenceException {
		this.handleDebitTransferTransaction(transaction);
	}
	
	@Override
	public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException {
		result = common.IconInfoConstants.FolgebuchungIconNumber;
	}
	
	private void handleDebitTransferTransaction(PersistentDebitTransferTransaction debitTransferTransaction) throws PersistenceException {
		debitTransferTransaction.getState().accept(new DebitTransferStateVisitor() {
			
			@Override
			public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException {
				result = common.IconInfoConstants.VorlagenIconNumber;
			}
			
			@Override
			public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
			}
			
			@Override
			public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException {
				// TODO Auto-generated method stub
				result = common.IconInfoConstants.WarningIconNumber;
			}
			
			@Override
			public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException {
				result = common.IconInfoConstants.NeutralIconNumber;
				// TODO "Noch nicht ausgeführt", Icon wird nicht angezeigt.
			}
			
			@Override
			public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleCompensatedState(PersistentCompensatedState compensatedState) throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
				
			}

			@Override
			public void handleCompensationRequestedState(
					PersistentCompensationRequestedState compensationRequestedState)
					throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
			}
		});
	}
	@Override
	public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException {
		result = common.IconInfoConstants.NoLimitIconNumber;
	}
	
	@Override
	public void handleLimit(PersistentLimit limit) throws PersistenceException {
		result = common.IconInfoConstants.LimitIconNumber;
	}
	@Override
	public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException {
		result = common.IconInfoConstants.KompensationOutIconNumber;
	}
	
	@Override
	public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe)
			throws PersistenceException {
		result = common.IconInfoConstants.KompensationInIconNumber;
	}
	
	@Override
	public void handleAllCompensationListe(
			PersistentAllCompensationListe allCompensationListe)
			throws PersistenceException {
		result = common.IconInfoConstants.KompensationIconNumber;
	}
	
	@Override
	public void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx)	throws PersistenceException {
		result = common.IconInfoConstants.BankIconNumber;
	}
	
	@Override
	public void handleCompensation(PersistentCompensation compensation) throws PersistenceException {
		compensation.getState().accept(new CompensationStateVisitor() {
			
			@Override
			public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException {
				result = common.IconInfoConstants.NeutralIconNumber;
			}
			@Override
			public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
			}
			@Override
			public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException {
				result = common.IconInfoConstants.NegativeIconNumber;
			}
		});
	}
	@Override
	public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException {
		compensationRequest.getState().accept(new CompensationRequestStateVisitor() {
			
			public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException {
				result = common.IconInfoConstants.NeutralIconNumber;
			}
			
			public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException {
				result = common.IconInfoConstants.NegativeIconNumber;
			}
			
			public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException {
				result = common.IconInfoConstants.PositiveIconNumber;
			}
		});
	}
}
