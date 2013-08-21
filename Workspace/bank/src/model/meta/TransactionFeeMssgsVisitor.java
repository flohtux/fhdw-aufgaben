package model.meta;

public interface TransactionFeeMssgsVisitor extends TransactionFeeDOWNMssgsVisitor, TransactionFeeUPMssgsVisitor {}


interface TransactionFeeDOWNMssgsVisitor extends FixTransactionFeeDOWNMssgsVisitor, ProcentualFeeDOWNMssgsVisitor, MixedFeeDOWNMssgsVisitor {

    
}


interface TransactionFeeUPMssgsVisitor  {

    
}
