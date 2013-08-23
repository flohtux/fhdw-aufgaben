package model.meta;

public interface DebitTransferTemplateMssgs {
    void accept(DebitTransferTemplateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferTemplateDOWNMssgs extends Mssgs, DebitTransferTemplateMssgs{}
interface DebitTransferTemplateUPMssgs extends Mssgs, DebitTransferTemplateMssgs{}
