package model;

import model.visitor.DebitTransferStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountReceivedDebitGrant;
import persistence.PersistentBankFees;
import persistence.PersistentBankPx;
import persistence.PersistentCurrencyManager;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentExecutedState;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentInternalFee;
import persistence.PersistentLimitAccount;
import persistence.PersistentMixedFee;
import persistence.PersistentMoney;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentProcentualFee;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransfer;
import persistence.PersistentTriggerListe;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
		
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
		//TODO ausgehende Grants, Icon wird in der Oberfläche nicht angezeigt
	}
	
	@Override
	public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException {
		result = common.IconInfoConstants.EinzugInIconNumber;
		// TODO eingehender Grant, Icon wird in der Oberfläche nicht angezeigt
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
		transfer.getState().accept(new DebitTransferStateVisitor() {
			
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
		});
	}
	
	@Override
	public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException {
		result = common.IconInfoConstants.FolgebuchungIconNumber;
	}
}
