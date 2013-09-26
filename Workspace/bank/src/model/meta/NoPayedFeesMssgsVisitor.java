package model.meta;

public interface NoPayedFeesMssgsVisitor extends NoPayedFeesDOWNMssgsVisitor, NoPayedFeesUPMssgsVisitor {}


interface NoPayedFeesDOWNMssgsVisitor  {

    
}


interface NoPayedFeesUPMssgsVisitor extends DebitTransferPayedFeesUPMssgsVisitor {

    
}
