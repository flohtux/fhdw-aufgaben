package model.meta;

public interface DebitTransferSuccessfulMssgs {
    void accept(DebitTransferSuccessfulMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferSuccessfulDOWNMssgs extends Mssgs, DebitTransferSuccessfulMssgs{}
interface DebitTransferSuccessfulUPMssgs extends Mssgs, DebitTransferSuccessfulMssgs{}
