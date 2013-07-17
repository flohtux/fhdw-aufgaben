package model.meta;

public interface FixTransactionFeeMssgs {
    void accept(FixTransactionFeeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FixTransactionFeeDOWNMssgs extends TransactionFeeDOWNMssgs, FixTransactionFeeMssgs{}
interface FixTransactionFeeUPMssgs extends Mssgs, FixTransactionFeeMssgs{}
