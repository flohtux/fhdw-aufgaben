package model.meta;

public interface ProcentualFeeMssgs {
    void accept(ProcentualFeeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProcentualFeeDOWNMssgs extends TransactionFeeDOWNMssgs, ProcentualFeeMssgs{}
interface ProcentualFeeUPMssgs extends Mssgs, ProcentualFeeMssgs{}
