package model;

import model.visitor.DebitTransferStateVisitor;
import model.visitor.TriggerStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountReceivedDebitGrant;
import persistence.PersistentBankFees;
import persistence.PersistentBankPx;
import persistence.PersistentCompensationListe;
import persistence.PersistentCompensationPendingRequests;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCurrencyManager;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentDebitTransferTransaction;
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
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerListe;

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
	public void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException {
		result = common.IconInfoConstants.EinzugOutIconNumber;
		//TODO ausgehende Grants, Icon wird in der Oberfl�che nicht angezeigt
	}
	
	@Override
	public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException {
		result = common.IconInfoConstants.EinzugInIconNumber;
		// TODO eingehender Grant, Icon wird in der Oberfl�che nicht angezeigt
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
		result = common.IconInfoConstants.Geb�hrenIconNumber;
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
				//result = 
				// TODO Torben				
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
				// TODO "Noch nicht ausgef�hrt", Icon wird nicht angezeigt.
			}
			
			@Override
			public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException {
				// TODO Auto-generated method stub
				
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
		// TODO Auto-generated method stub  "von mir ausgel�ste Kompensation"
		super.handleCompensationListe(compensationListe);
	}
	
	@Override
	public void handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException {
		// TODO Auto-generated method stub   "eingehenden Anfragen"
		super.handleCompensationPendingRequests(compensationPendingRequests);
	}
	
	@Override
	public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException {
		// TODO Auto-generated method stub  "Kompensationsanfrage"
		super.handleCompensationRequest(compensationRequest);
	}
	
	
}
