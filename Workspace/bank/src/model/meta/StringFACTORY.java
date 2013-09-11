package model.meta;

public class StringFACTORY{

    public static persistence.PersistentDebitTransferTransaction createObjectBySubTypeNameForDebitTransferTransaction(String name, DebitTransferTransactionSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Transaction")) return switchAssistant.handleTransaction();
        if(name.equals("Transfer")) return switchAssistant.handleTransfer();
        if(name.equals("Debit")) return switchAssistant.handleDebit();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentTransactionFee createObjectBySubTypeNameForTransactionFee(String name, TransactionFeeSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("gemischte Gebühren")) return switchAssistant.handleMixedFee();
        if(name.equals("fixe Gebühren")) return switchAssistant.handleFixTransactionFee();
        if(name.equals("prozentuale Gebühren")) return switchAssistant.handleProcentualFee();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentCurrency createObjectBySubTypeNameForCurrency(String name) throws persistence.PersistenceException {
        if(name.equals("Dollar")) return model.Dollar.getTheDollar();
        if(name.equals("Pfund")) return model.Pfund.getThePfund();
        if(name.equals("Franken")) return model.Franken.getTheFranken();
        if(name.equals("Euro")) return model.Euro.getTheEuro();
        if(name.equals("Yen")) return model.Yen.getTheYen();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentLimitType createObjectBySubTypeNameForLimitType(String name, LimitTypeSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("NoLimit")) return model.NoLimit.getTheNoLimit();
        if(name.equals("Limit")) return switchAssistant.handleLimit();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentRule createObjectBySubTypeNameForRule(String name, RuleSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("SubjectRule")) return switchAssistant.handleSubjectRule();
        if(name.equals("MoneyRule")) return switchAssistant.handleMoneyRule();
        if(name.equals("IncomingAccountRule")) return switchAssistant.handleIncomingAccountRule();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
