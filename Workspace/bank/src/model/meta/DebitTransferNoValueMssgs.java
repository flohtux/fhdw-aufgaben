package model.meta;

public interface DebitTransferNoValueMssgs {
    void accept(DebitTransferNoValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferNoValueDOWNMssgs extends Mssgs, DebitTransferNoValueMssgs{}
interface DebitTransferNoValueUPMssgs extends DebitTransferUPMssgs, NoDebitTransferUPMssgs, DebitTransferNoValueMssgs{}
