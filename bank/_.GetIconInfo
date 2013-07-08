package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentBank;

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
}
