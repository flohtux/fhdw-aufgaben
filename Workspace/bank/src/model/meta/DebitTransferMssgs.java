package model.meta;

public interface DebitTransferMssgs {
    void accept(DebitTransferMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferDOWNMssgs extends DebitTransferTransactionDOWNMssgs, DebitTransferNoValueDOWNMssgs, DebitTransferMssgs{}
interface DebitTransferUPMssgs extends TransferUPMssgs, DebitUPMssgs, DebitTransferMssgs{}
