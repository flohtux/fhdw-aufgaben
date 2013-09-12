package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler debitTransferTransactionSUBTYPEName = new RegularExpressionHandler( "[(Transaktion)" + 
		"(Überweisung)" + 
		"(Lastschrift)]" );
    public static RegularExpressionHandler transactionFeeSUBTYPEName = new RegularExpressionHandler( "[(gemischte Gebühren)" + 
		"(fixe Gebühren)" + 
		"(prozentuale Gebühren)]" );
    public static RegularExpressionHandler currencySUBTYPEName = new RegularExpressionHandler( "[(Dollar)" + 
		"(Pfund)" + 
		"(Franken)" + 
		"(Euro)" + 
		"(Yen)]" );
    public static RegularExpressionHandler debitTransferSUBTYPEName = new RegularExpressionHandler( "[(Lastschrift)" + 
		"(Überweisung)]" );
    public static RegularExpressionHandler limitTypeSUBTYPEName = new RegularExpressionHandler( "[(NoLimit)" + 
		"(Limit)]" );
    public static RegularExpressionHandler ruleSUBTYPEName = new RegularExpressionHandler( "[(Betreffregel)" + 
		"(Geldregel)" + 
		"(Absenderregel)]" );
    

}
