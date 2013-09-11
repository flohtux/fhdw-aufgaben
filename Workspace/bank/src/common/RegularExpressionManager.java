package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler debitTransferTransactionSUBTYPEName = new RegularExpressionHandler( "[(Transaction)" + 
		"(Transfer)" + 
		"(Debit)]" );
    public static RegularExpressionHandler transactionFeeSUBTYPEName = new RegularExpressionHandler( "[(gemischte Gebühren)" + 
		"(fixe Gebühren)" + 
		"(prozentuale Gebühren)]" );
    public static RegularExpressionHandler currencySUBTYPEName = new RegularExpressionHandler( "[(Dollar)" + 
		"(Pfund)" + 
		"(Franken)" + 
		"(Euro)" + 
		"(Yen)]" );
    public static RegularExpressionHandler limitTypeSUBTYPEName = new RegularExpressionHandler( "[(NoLimit)" + 
		"(Limit)]" );
    public static RegularExpressionHandler ruleSUBTYPEName = new RegularExpressionHandler( "[(SubjectRule)" + 
		"(MoneyRule)" + 
		"(IncomingAccountRule)]" );
    

}
