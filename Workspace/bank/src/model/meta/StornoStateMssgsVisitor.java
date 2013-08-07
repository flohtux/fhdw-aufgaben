package model.meta;

public interface StornoStateMssgsVisitor extends StornoStateDOWNMssgsVisitor, StornoStateUPMssgsVisitor {}


interface StornoStateDOWNMssgsVisitor extends RequestStateDOWNMssgsVisitor, NoRequestStateDOWNMssgsVisitor, NotSuccessfulStornoStateDOWNMssgsVisitor, SuccessfulStornoStateDOWNMssgsVisitor {

    
}


interface StornoStateUPMssgsVisitor  {

    
}
