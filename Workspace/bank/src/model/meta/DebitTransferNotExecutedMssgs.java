package model.meta;

public interface DebitTransferNotExecutedMssgs {
    void accept(DebitTransferNotExecutedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferNotExecutedDOWNMssgs extends Mssgs, DebitTransferNotExecutedMssgs{}
interface DebitTransferNotExecutedUPMssgs extends Mssgs, DebitTransferNotExecutedMssgs{}
