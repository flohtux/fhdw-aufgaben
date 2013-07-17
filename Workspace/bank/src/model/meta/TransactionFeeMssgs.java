package model.meta;

public interface TransactionFeeMssgs {
    void accept(TransactionFeeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransactionFeeDOWNMssgs extends Mssgs, TransactionFeeMssgs{}
interface TransactionFeeUPMssgs extends MixedFeeUPMssgs, FixTransactionFeeUPMssgs, ProcentualFeeUPMssgs, TransactionFeeMssgs{}
