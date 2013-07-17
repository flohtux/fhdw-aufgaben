package model.meta;

public interface NoLimitStateMssgsVisitor extends NoLimitStateDOWNMssgsVisitor, NoLimitStateUPMssgsVisitor {}


interface NoLimitStateDOWNMssgsVisitor  {

    
}


interface NoLimitStateUPMssgsVisitor extends AccountLimitStateUPMssgsVisitor {

    
}
