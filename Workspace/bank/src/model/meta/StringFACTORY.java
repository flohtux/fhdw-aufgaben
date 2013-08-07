package model.meta;

public class StringFACTORY{

    public static persistence.PersistentCurrency createObjectBySubTypeNameForCurrency(String name) throws persistence.PersistenceException {
        if(name.equals("Dollar")) return model.Dollar.getTheDollar();
        if(name.equals("Euro")) return model.Euro.getTheEuro();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    public static persistence.PersistentTransactionFee createObjectBySubTypeNameForTransactionFee(String name, TransactionFeeSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals("FixTransactionFee")) return switchAssistant.handleFixTransactionFee();
        if(name.equals("MixedFee")) return switchAssistant.handleMixedFee();
        if(name.equals("ProcentualFee")) return switchAssistant.handleProcentualFee();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
}
