package model;

import model.visitor.DebitTransferStateVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentBank;
import persistence.PersistentExecutedState;
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
	public void handleBank(PersistentBank bank) throws PersistenceException{
        result = common.IconInfoConstants.BankIconNumber;
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
