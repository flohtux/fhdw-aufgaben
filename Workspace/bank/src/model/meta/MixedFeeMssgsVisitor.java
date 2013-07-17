package model.meta;

public interface MixedFeeMssgsVisitor extends MixedFeeDOWNMssgsVisitor, MixedFeeUPMssgsVisitor {}


interface MixedFeeDOWNMssgsVisitor  {

    
}


interface MixedFeeUPMssgsVisitor extends TransactionFeeUPMssgsVisitor {

    
}
