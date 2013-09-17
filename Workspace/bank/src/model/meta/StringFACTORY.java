package model.meta;

public class StringFACTORY{

    public static persistence.PersistentDebitTransferTransaction createObjectBySubTypeNameForDebitTransferTransaction(String name, DebitTransferTransactionSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Transaktion")) return switchAssistant.handleTransaction();
        if(name.equals("Überweisung")) return switchAssistant.handleTransfer();
        if(name.equals("Lastschrift")) return switchAssistant.handleDebit();
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
    public static persistence.PersistentDebitTransfer createObjectBySubTypeNameForDebitTransfer(String name, DebitTransferSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Lastschrift")) return switchAssistant.handleDebit();
        if(name.equals("Überweisung")) return switchAssistant.handleTransfer();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentLimitType createObjectBySubTypeNameForLimitType(String name, LimitTypeSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Unbegrenzt")) return model.NoLimit.getTheNoLimit();
        if(name.equals("Begrenzt")) return switchAssistant.handleLimit();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentRule createObjectBySubTypeNameForRule(String name, RuleSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("Betreffregel")) return switchAssistant.handleSubjectRule();
        if(name.equals("Geldregel")) return switchAssistant.handleMoneyRule();
        if(name.equals("Absenderregel")) return switchAssistant.handleIncomingAccountRule();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
