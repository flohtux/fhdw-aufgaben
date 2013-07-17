package model.meta;

public interface MixedFeeMssgs {
    void accept(MixedFeeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MixedFeeDOWNMssgs extends TransactionFeeDOWNMssgs, MixedFeeMssgs{}
interface MixedFeeUPMssgs extends Mssgs, MixedFeeMssgs{}
