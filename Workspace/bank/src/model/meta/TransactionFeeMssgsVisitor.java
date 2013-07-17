package model.meta;

public interface TransactionFeeMssgsVisitor extends TransactionFeeDOWNMssgsVisitor, TransactionFeeUPMssgsVisitor {}


interface TransactionFeeDOWNMssgsVisitor extends MixedFeeDOWNMssgsVisitor, FixTransactionFeeDOWNMssgsVisitor, ProcentualFeeDOWNMssgsVisitor {

    
}


interface TransactionFeeUPMssgsVisitor  {

    
}
