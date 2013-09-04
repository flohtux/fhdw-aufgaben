package model;

import model.visitor.DebitTransferStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccountPx;
import persistence.PersistentBank;
import persistence.PersistentDebitTransferSuccessful;
import persistence.PersistentDebitTransferTemplate;
import persistence.PersistentExecutedState;
import persistence.PersistentLimitAccount;
import persistence.PersistentMoney;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransfer;

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
