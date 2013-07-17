package model.meta;

public interface LimitStateMssgsVisitor extends LimitStateDOWNMssgsVisitor, LimitStateUPMssgsVisitor {}


interface LimitStateDOWNMssgsVisitor extends MinLimitStateDOWNMssgsVisitor, MaxLimitStateDOWNMssgsVisitor {

    
}


interface LimitStateUPMssgsVisitor extends AccountLimitStateUPMssgsVisitor {

    
}
