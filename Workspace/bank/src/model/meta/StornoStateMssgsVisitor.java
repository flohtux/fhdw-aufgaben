package model.meta;

public interface StornoStateMssgsVisitor extends StornoStateDOWNMssgsVisitor, StornoStateUPMssgsVisitor {}


interface StornoStateDOWNMssgsVisitor extends NoRequestStateDOWNMssgsVisitor, RequestStateDOWNMssgsVisitor, NotSuccessfulStornoStateDOWNMssgsVisitor, SuccessfulStornoStateDOWNMssgsVisitor {

    
}


interface StornoStateUPMssgsVisitor  {

    
}
