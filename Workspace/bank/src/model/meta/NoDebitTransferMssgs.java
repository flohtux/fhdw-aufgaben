package model.meta;

public interface NoDebitTransferMssgs {
    void accept(NoDebitTransferMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoDebitTransferDOWNMssgs extends DebitTransferNoValueDOWNMssgs, NoDebitTransferMssgs{}
interface NoDebitTransferUPMssgs extends Mssgs, NoDebitTransferMssgs{}
