package model;

import model.visitor.DebitTransferStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccountDebitTransferTransactions;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentAccountListEntryProxi;
import persistence.PersistentAccountPx;
import persistence.PersistentAccountService;
import persistence.PersistentAccountServiceListEntryProxi;
import persistence.PersistentAccountServiceSuccessful;
import persistence.PersistentAccountServiceTemplate;
import persistence.PersistentAdministrator;
import persistence.PersistentAdministratorBanks;
import persistence.PersistentAdministratorBanksListEntryProxi;
import persistence.PersistentAmount;
import persistence.PersistentBank;
import persistence.PersistentCommonDate;
import persistence.PersistentDebit;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferListe;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentEventWrapper;
import persistence.PersistentExecutedState;
import persistence.PersistentLimit;
import persistence.PersistentLimitAccount;
import persistence.PersistentListEntryProxi;
import persistence.PersistentMoney;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotExecutedStateListEntryProxi;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentObject;
import persistence.PersistentSubj;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentUseTemplateCommand;

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
	public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException{
        result = common.IconInfoConstants.AccountIconNumber;
	}
	
	@Override
	public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful)
			throws PersistenceException {
		result = common.IconInfoConstants.HistorieIconNumber;
	}
	
	public void handleBank(PersistentBank bank) throws PersistenceException{
        result = common.IconInfoConstants.BankIconNumber;
	}

	public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException{
		result = common.IconInfoConstants.VorlagenIconNumber;
	}
	
	public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException{
		result = common.IconInfoConstants.LimitsIconNumber;
	}
	
	public void handleMoney(PersistentMoney money) throws PersistenceException{
		result = common.IconInfoConstants.KontostandIconNumber;
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException {
				// TODO Auto-generated method stub
				
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
	
}
