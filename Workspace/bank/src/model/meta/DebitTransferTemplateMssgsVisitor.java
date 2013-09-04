package model.meta;

public interface DebitTransferTemplateMssgsVisitor extends DebitTransferTemplateDOWNMssgsVisitor, DebitTransferTemplateUPMssgsVisitor {}


interface DebitTransferTemplateDOWNMssgsVisitor  {

    public void handleDebitTransferTemplateAddDebitTransferTransactionMssg(DebitTransferTemplateAddDebitTransferTransactionMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferTemplateRemoveDebitTransferTransactionMssg(DebitTransferTemplateRemoveDebitTransferTransactionMssg event) throws persistence.PersistenceException;
    
}


interface DebitTransferTemplateUPMssgsVisitor  {

    public void handleDebitTransferTemplateAddDebitTransferTransactionMssg(DebitTransferTemplateAddDebitTransferTransactionMssg event) throws persistence.PersistenceException;
    public void handleDebitTransferTemplateRemoveDebitTransferTransactionMssg(DebitTransferTemplateRemoveDebitTransferTransactionMssg event) throws persistence.PersistenceException;
    
}
