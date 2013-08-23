package model.meta;

public interface DebitMssgsVisitor extends DebitDOWNMssgsVisitor, DebitUPMssgsVisitor {}


interface DebitDOWNMssgsVisitor  {

    
}


interface DebitUPMssgsVisitor extends DebitTransferUPMssgsVisitor {

    
}
