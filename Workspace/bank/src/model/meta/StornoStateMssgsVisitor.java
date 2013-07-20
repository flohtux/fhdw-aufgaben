package model.meta;

public interface StornoStateMssgsVisitor extends StornoStateDOWNMssgsVisitor, StornoStateUPMssgsVisitor {}


interface StornoStateDOWNMssgsVisitor extends RequestStateDOWNMssgsVisitor, NotSuccessfullStorneStateDOWNMssgsVisitor, NoRequestStateDOWNMssgsVisitor, SuccessfullStornoStateDOWNMssgsVisitor {

    
}


interface StornoStateUPMssgsVisitor  {

    
}
