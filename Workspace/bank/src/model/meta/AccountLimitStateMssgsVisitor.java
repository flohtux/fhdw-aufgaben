package model.meta;

public interface AccountLimitStateMssgsVisitor extends AccountLimitStateDOWNMssgsVisitor, AccountLimitStateUPMssgsVisitor {}


interface AccountLimitStateDOWNMssgsVisitor extends NoLimitStateDOWNMssgsVisitor, LimitStateDOWNMssgsVisitor {

    
}


interface AccountLimitStateUPMssgsVisitor  {

    
}
