create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id),
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id),
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id),
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id),
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id)
);

create sequence SSrvc nocache;

create table Srvc(
    id number primary key,
    Cls number not null,
    SrvcSbSrvc number,
    SrvcSbSrvcCls number,
    constraint FSrvcSbSrvc foreign key (SrvcSbSrvcCls) references Cls (id),
    SrvcThis number,
    SrvcThisCls number,
    constraint FSrvcThis foreign key (SrvcThisCls) references Cls (id),
    AdmnstrtrCrrncMngr number,
    AdmnstrtrCrrncMngrCls number,
    constraint FAdmnstrtrCrrncMngr foreign key (AdmnstrtrCrrncMngrCls) references Cls (id),
    AdmnstrtrBnks number,
    AdmnstrtrBnksCls number,
    constraint FAdmnstrtrBnks foreign key (AdmnstrtrBnksCls) references Cls (id),
    BnkSrvcBnk number,
    BnkSrvcBnkCls number,
    constraint FBnkSrvcBnk foreign key (BnkSrvcBnkCls) references Cls (id),
    AccntSrvcAccnt number,
    AccntSrvcAccntCls number,
    constraint FAccntSrvcAccnt foreign key (AccntSrvcAccntCls) references Cls (id),
    AccntSrvcEvnthndl number,
    AccntSrvcEvnthndlCls number,
    constraint FAccntSrvcEvnthndl foreign key (AccntSrvcEvnthndlCls) references Cls (id),
    AccntSrvcSccssfl number,
    AccntSrvcSccssflCls number,
    constraint FAccntSrvcSccssfl foreign key (AccntSrvcSccssflCls) references Cls (id),
    AccntSrvcNtExctd number,
    AccntSrvcNtExctdCls number,
    constraint FAccntSrvcNtExctd foreign key (AccntSrvcNtExctdCls) references Cls (id),
    AccntSrvcTmplt number,
    AccntSrvcTmpltCls number,
    constraint FAccntSrvcTmplt foreign key (AccntSrvcTmpltCls) references Cls (id),
    AccntSrvcBnkFs number,
    AccntSrvcBnkFsCls number,
    constraint FAccntSrvcBnkFs foreign key (AccntSrvcBnkFsCls) references Cls (id)    
);
create index IBnkBnkSrvc on Srvc (BnkSrvcBnk, BnkSrvcBnkCls);
create index IAccntAccntSrvc on Srvc (AccntSrvcAccnt, AccntSrvcAccntCls);
create index IEvnthndlAccntSrvc on Srvc (AccntSrvcEvnthndl, AccntSrvcEvnthndlCls);


create sequence SCmpnstn nocache;

create table Cmpnstn(
    id number primary key,
    Cls number not null,
    CmpnstnRqstngAccnt number,
    CmpnstnRqstngAccntCls number,
    constraint FCmpnstnRqstngAccnt foreign key (CmpnstnRqstngAccntCls) references Cls (id),
    CmpnstnPndngRqsts number,
    CmpnstnPndngRqstsCls number,
    constraint FCmpnstnPndngRqsts foreign key (CmpnstnPndngRqstsCls) references Cls (id),
    CmpnstnStt number,
    CmpnstnSttCls number,
    constraint FCmpnstnStt foreign key (CmpnstnSttCls) references Cls (id),
    CmpnstnSbSrvc number,
    CmpnstnSbSrvcCls number,
    constraint FCmpnstnSbSrvc foreign key (CmpnstnSbSrvcCls) references Cls (id),
    CmpnstnThis number,
    CmpnstnThisCls number,
    constraint FCmpnstnThis foreign key (CmpnstnThisCls) references Cls (id)    
);
create index ISttCmpnstn on Cmpnstn (CmpnstnStt, CmpnstnSttCls);


create sequence SAccntRcvdGrnt nocache;

create table AccntRcvdGrnt(
    id number primary key,
    Cls number not null,
    AccntRcvdGrntMstr number,
    AccntRcvdGrntMstrCls number,
    constraint FAccntRcvdGrntMstr foreign key (AccntRcvdGrntMstrCls) references Cls (id),
    AccntRcvdGrntObs number,
    AccntRcvdGrntObsCls number,
    constraint FAccntRcvdGrntObs foreign key (AccntRcvdGrntObsCls) references Cls (id),
    AccntRcvdGrntThis number,
    AccntRcvdGrntThisCls number,
    constraint FAccntRcvdGrntThis foreign key (AccntRcvdGrntThisCls) references Cls (id)    
);

create sequence SDebiTrfTran nocache;

create table DebiTrfTran(
    id number primary key,
    Cls number not null,
    DebiTrfTranTmstmp Timestamp,
    DebiTrfTranSbjct varchar2(2000),
    DebiTrfTranSndr number,
    DebiTrfTranSndrCls number,
    constraint FDebiTrfTranSndr foreign key (DebiTrfTranSndrCls) references Cls (id),
    DebiTrfTranStt number,
    DebiTrfTranSttCls number,
    constraint FDebiTrfTranStt foreign key (DebiTrfTranSttCls) references Cls (id),
    DebiTrfTranSbSrvc number,
    DebiTrfTranSbSrvcCls number,
    constraint FDebiTrfTranSbSrvc foreign key (DebiTrfTranSbSrvcCls) references Cls (id),
    DebiTrfTranThis number,
    DebiTrfTranThisCls number,
    constraint FDebiTrfTranThis foreign key (DebiTrfTranThisCls) references Cls (id),
    DbtTrnsfrRecaccno number,
    DbtTrnsfrRcvrBnkNmbr number,
    DbtTrnsfrRcvr number,
    DbtTrnsfrRcvrCls number,
    constraint FDbtTrnsfrRcvr foreign key (DbtTrnsfrRcvrCls) references Cls (id),
    DbtTrnsfrMn number,
    DbtTrnsfrMnCls number,
    constraint FDbtTrnsfrMn foreign key (DbtTrnsfrMnCls) references Cls (id),
    DbtTrnsfrInvkrTrggr number,
    DbtTrnsfrInvkrTrggrCls number,
    constraint FDbtTrnsfrInvkrTrggr foreign key (DbtTrnsfrInvkrTrggrCls) references Cls (id),
    DbtTrnsfrPrvdebtra number,
    DbtTrnsfrPrvdebtraCls number,
    constraint FDbtTrnsfrPrvdebtra foreign key (DbtTrnsfrPrvdebtraCls) references Cls (id),
    TrnsctnDbtTrnsfr number,
    TrnsctnDbtTrnsfrCls number,
    constraint FTrnsctnDbtTrnsfr foreign key (TrnsctnDbtTrnsfrCls) references Cls (id)    
);
create index ISttDebiTrfTran on DebiTrfTran (DebiTrfTranStt, DebiTrfTranSttCls);


create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create sequence SChngNmCMD nocache;

create table ChngNmCMD(
    id number primary key,
    Cls number not null,
    ChngNmCMDNm varchar2(2000),
    ChngNmCMDInvoker number,
    ChngNmCMDInvokerCls number,
    constraint FChngNmCMDInvoker foreign key (ChngNmCMDInvokerCls) references Cls (id),
    ChngNmCMDCReceiver number,
    ChngNmCMDCReceiverCls number,
    constraint FChngNmCMDCReceiver foreign key (ChngNmCMDCReceiverCls) references Cls (id),
    ChngNmCMDMyCmmnDt number,
    ChngNmCMDMyCmmnDtCls number,
    constraint FChngNmCMDMyCmmnDt foreign key (ChngNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SDebiTraStat nocache;

create table DebiTraStat(
    id number primary key,
    Cls number not null,
    DebiTraStatSbSrvc number,
    DebiTraStatSbSrvcCls number,
    constraint FDebiTraStatSbSrvc foreign key (DebiTraStatSbSrvcCls) references Cls (id),
    DebiTraStatThis number,
    DebiTraStatThisCls number,
    constraint FDebiTraStatThis foreign key (DebiTraStatThisCls) references Cls (id)    
);

create sequence SDebTransLst nocache;

create table DebTransLst(
    id number primary key,
    Cls number not null,
    DebTransLstSbSrvc number,
    DebTransLstSbSrvcCls number,
    constraint FDebTransLstSbSrvc foreign key (DebTransLstSbSrvcCls) references Cls (id),
    DebTransLstThis number,
    DebTransLstThisCls number,
    constraint FDebTransLstThis foreign key (DebTransLstThisCls) references Cls (id)    
);

create sequence SCrrncMngr nocache;

create table CrrncMngr(
    id number primary key,
    Cls number not null,
    CrrncMngrSbSrvc number,
    CrrncMngrSbSrvcCls number,
    constraint FCrrncMngrSbSrvc foreign key (CrrncMngrSbSrvcCls) references Cls (id),
    CrrncMngrThis number,
    CrrncMngrThisCls number,
    constraint FCrrncMngrThis foreign key (CrrncMngrThisCls) references Cls (id)    
);

create sequence SBlnVl nocache;

create table BlnVl(
    id number primary key,
    Cls number not null,
    BlnVlSbSrvc number,
    BlnVlSbSrvcCls number,
    constraint FBlnVlSbSrvc foreign key (BlnVlSbSrvcCls) references Cls (id),
    BlnVlThis number,
    BlnVlThisCls number,
    constraint FBlnVlThis foreign key (BlnVlThisCls) references Cls (id)    
);

create sequence SPrcnt nocache;

create table Prcnt(
    id number primary key,
    Cls number not null,
    PrcntVl varchar2(2000),
    PrcntSbSrvc number,
    PrcntSbSrvcCls number,
    constraint FPrcntSbSrvc foreign key (PrcntSbSrvcCls) references Cls (id),
    PrcntThis number,
    PrcntThisCls number,
    constraint FPrcntThis foreign key (PrcntThisCls) references Cls (id)    
);

create sequence SExchngRtWrp nocache;

create table ExchngRtWrp(
    id number primary key,
    Cls number not null,
    ExchngRtWrpAmnt number,
    ExchngRtWrpAmntCls number,
    constraint FExchngRtWrpAmnt foreign key (ExchngRtWrpAmntCls) references Cls (id),
    ExchngRtWrpCrrnc number,
    ExchngRtWrpCrrncCls number,
    constraint FExchngRtWrpCrrnc foreign key (ExchngRtWrpCrrncCls) references Cls (id),
    ExchngRtWrpSbSrvc number,
    ExchngRtWrpSbSrvcCls number,
    constraint FExchngRtWrpSbSrvc foreign key (ExchngRtWrpSbSrvcCls) references Cls (id),
    ExchngRtWrpThis number,
    ExchngRtWrpThisCls number,
    constraint FExchngRtWrpThis foreign key (ExchngRtWrpThisCls) references Cls (id)    
);

create sequence SCrrnc nocache;

create table Crrnc(
    id number primary key,
    Cls number not null,
    CrrncSbSrvc number,
    CrrncSbSrvcCls number,
    constraint FCrrncSbSrvc foreign key (CrrncSbSrvcCls) references Cls (id),
    CrrncThis number,
    CrrncThisCls number,
    constraint FCrrncThis foreign key (CrrncThisCls) references Cls (id)    
);

create sequence SExctCmpnstnCMD nocache;

create table ExctCmpnstnCMD(
    id number primary key,
    Cls number not null,
    ExctCmpnstnCMDInvoker number,
    ExctCmpnstnCMDInvokerCls number,
    constraint FExctCmpnstnCMDInvoker foreign key (ExctCmpnstnCMDInvokerCls) references Cls (id),
    ExctCmpnstnCMDCReceiver number,
    ExctCmpnstnCMDCReceiverCls number,
    constraint FExctCmpnstnCMDCReceiver foreign key (ExctCmpnstnCMDCReceiverCls) references Cls (id),
    ExctCmpnstnCMDMyCmmnDt number,
    ExctCmpnstnCMDMyCmmnDtCls number,
    constraint FExctCmpnstnCMDMyCmmnDt foreign key (ExctCmpnstnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SBankOwAccPx nocache;

create table BankOwAccPx(
    id number primary key,
    Cls number not null,
    BankOwAccPxAccnt number,
    BankOwAccPxAccntCls number,
    constraint FBankOwAccPxAccnt foreign key (BankOwAccPxAccntCls) references Cls (id),
    BankOwAccPxSbSrvc number,
    BankOwAccPxSbSrvcCls number,
    constraint FBankOwAccPxSbSrvc foreign key (BankOwAccPxSbSrvcCls) references Cls (id),
    BankOwAccPxThis number,
    BankOwAccPxThisCls number,
    constraint FBankOwAccPxThis foreign key (BankOwAccPxThisCls) references Cls (id)    
);

create sequence SChngSbjctCMD nocache;

create table ChngSbjctCMD(
    id number primary key,
    Cls number not null,
    ChngSbjctCMDTrns number,
    ChngSbjctCMDTrnsCls number,
    constraint FChngSbjctCMDTrns foreign key (ChngSbjctCMDTrnsCls) references Cls (id),
    ChngSbjctCMDSbjct varchar2(2000),
    ChngSbjctCMDInvoker number,
    ChngSbjctCMDInvokerCls number,
    constraint FChngSbjctCMDInvoker foreign key (ChngSbjctCMDInvokerCls) references Cls (id),
    ChngSbjctCMDCReceiver number,
    ChngSbjctCMDCReceiverCls number,
    constraint FChngSbjctCMDCReceiver foreign key (ChngSbjctCMDCReceiverCls) references Cls (id),
    ChngSbjctCMDMyCmmnDt number,
    ChngSbjctCMDMyCmmnDtCls number,
    constraint FChngSbjctCMDMyCmmnDt foreign key (ChngSbjctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrSrvc number,
    SrvrSrvcCls number,
    constraint FSrvrSrvc foreign key (SrvrSrvcCls) references Cls (id),
    SrvrSbSrvc number,
    SrvrSbSrvcCls number,
    constraint FSrvrSbSrvc foreign key (SrvrSbSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index ISrvcSrvr on Srvr (SrvrSrvc, SrvrSrvcCls);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SDbTrNtTmpl nocache;

create table DbTrNtTmpl(
    id number primary key,
    Cls number not null,
    DbTrNtTmplSbSrvc number,
    DbTrNtTmplSbSrvcCls number,
    constraint FDbTrNtTmplSbSrvc foreign key (DbTrNtTmplSbSrvcCls) references Cls (id),
    DbTrNtTmplThis number,
    DbTrNtTmplThisCls number,
    constraint FDbTrNtTmplThis foreign key (DbTrNtTmplThisCls) references Cls (id)    
);

create sequence SCrtDbtGrntCMD nocache;

create table CrtDbtGrntCMD(
    id number primary key,
    Cls number not null,
    CrtDbtGrntCMDRcvr number,
    CrtDbtGrntCMDRcvrCls number,
    constraint FCrtDbtGrntCMDRcvr foreign key (CrtDbtGrntCMDRcvrCls) references Cls (id),
    CrtDbtGrntCMDLmt number,
    CrtDbtGrntCMDLmtCls number,
    constraint FCrtDbtGrntCMDLmt foreign key (CrtDbtGrntCMDLmtCls) references Cls (id),
    CrtDbtGrntCMDInvoker number,
    CrtDbtGrntCMDInvokerCls number,
    constraint FCrtDbtGrntCMDInvoker foreign key (CrtDbtGrntCMDInvokerCls) references Cls (id),
    CrtDbtGrntCMDCReceiver number,
    CrtDbtGrntCMDCReceiverCls number,
    constraint FCrtDbtGrntCMDCReceiver foreign key (CrtDbtGrntCMDCReceiverCls) references Cls (id),
    CrtDbtGrntCMDMyCmmnDt number,
    CrtDbtGrntCMDMyCmmnDtCls number,
    constraint FCrtDbtGrntCMDMyCmmnDt foreign key (CrtDbtGrntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STrggrLst nocache;

create table TrggrLst(
    id number primary key,
    Cls number not null,
    TrggrLstSbSrvc number,
    TrggrLstSbSrvcCls number,
    constraint FTrggrLstSbSrvc foreign key (TrggrLstSbSrvcCls) references Cls (id),
    TrggrLstThis number,
    TrggrLstThisCls number,
    constraint FTrggrLstThis foreign key (TrggrLstThisCls) references Cls (id)    
);

create sequence SExctCMD nocache;

create table ExctCMD(
    id number primary key,
    Cls number not null,
    ExctCMDInvoker number,
    ExctCMDInvokerCls number,
    constraint FExctCMDInvoker foreign key (ExctCMDInvokerCls) references Cls (id),
    ExctCMDCReceiver number,
    ExctCMDCReceiverCls number,
    constraint FExctCMDCReceiver foreign key (ExctCMDCReceiverCls) references Cls (id),
    ExctCMDCResult number,
    ExctCMDCResultCls number,
    constraint FExctCMDCResult foreign key (ExctCMDCResultCls) references Cls (id),
    ExctCMDMyCmmnDt number,
    ExctCMDMyCmmnDtCls number,
    constraint FExctCMDMyCmmnDt foreign key (ExctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAccntSrvcSccssfl nocache;

create table AccntSrvcSccssfl(
    id number primary key,
    Cls number not null,
    AccntSrvcSccssflMstr number,
    AccntSrvcSccssflMstrCls number,
    constraint FAccntSrvcSccssflMstr foreign key (AccntSrvcSccssflMstrCls) references Cls (id),
    AccntSrvcSccssflObs number,
    AccntSrvcSccssflObsCls number,
    constraint FAccntSrvcSccssflObs foreign key (AccntSrvcSccssflObsCls) references Cls (id),
    AccntSrvcSccssflThis number,
    AccntSrvcSccssflThisCls number,
    constraint FAccntSrvcSccssflThis foreign key (AccntSrvcSccssflThisCls) references Cls (id)    
);

create sequence SChngRcvAccCMD nocache;

create table ChngRcvAccCMD(
    id number primary key,
    Cls number not null,
    ChngRcvAccCMDTrns number,
    ChngRcvAccCMDTrnsCls number,
    constraint FChngRcvAccCMDTrns foreign key (ChngRcvAccCMDTrnsCls) references Cls (id),
    ChngRcvAccCMDRecAccNr number,
    ChngRcvAccCMDInvoker number,
    ChngRcvAccCMDInvokerCls number,
    constraint FChngRcvAccCMDInvoker foreign key (ChngRcvAccCMDInvokerCls) references Cls (id),
    ChngRcvAccCMDCReceiver number,
    ChngRcvAccCMDCReceiverCls number,
    constraint FChngRcvAccCMDCReceiver foreign key (ChngRcvAccCMDCReceiverCls) references Cls (id),
    ChngRcvAccCMDMyCmmnDt number,
    ChngRcvAccCMDMyCmmnDtCls number,
    constraint FChngRcvAccCMDMyCmmnDt foreign key (ChngRcvAccCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmpnstnRqst nocache;

create table CmpnstnRqst(
    id number primary key,
    Cls number not null,
    CmpnstnRqstDbtTrnsfr number,
    CmpnstnRqstDbtTrnsfrCls number,
    constraint FCmpnstnRqstDbtTrnsfr foreign key (CmpnstnRqstDbtTrnsfrCls) references Cls (id),
    CmpnstnRqstMstrCmpnstn number,
    CmpnstnRqstMstrCmpnstnCls number,
    constraint FCmpnstnRqstMstrCmpnstn foreign key (CmpnstnRqstMstrCmpnstnCls) references Cls (id),
    CmpnstnRqstStt number,
    CmpnstnRqstSttCls number,
    constraint FCmpnstnRqstStt foreign key (CmpnstnRqstSttCls) references Cls (id),
    CmpnstnRqstSbSrvc number,
    CmpnstnRqstSbSrvcCls number,
    constraint FCmpnstnRqstSbSrvc foreign key (CmpnstnRqstSbSrvcCls) references Cls (id),
    CmpnstnRqstThis number,
    CmpnstnRqstThisCls number,
    constraint FCmpnstnRqstThis foreign key (CmpnstnRqstThisCls) references Cls (id)    
);

create sequence SAccntPx nocache;

create table AccntPx(
    id number primary key,
    Cls number not null,
    AccntPxAccnt number,
    AccntPxAccntCls number,
    constraint FAccntPxAccnt foreign key (AccntPxAccntCls) references Cls (id),
    AccntPxSbSrvc number,
    AccntPxSbSrvcCls number,
    constraint FAccntPxSbSrvc foreign key (AccntPxSbSrvcCls) references Cls (id),
    AccntPxThis number,
    AccntPxThisCls number,
    constraint FAccntPxThis foreign key (AccntPxThisCls) references Cls (id)    
);

create sequence SAccntAllCmpnstn nocache;

create table AccntAllCmpnstn(
    id number primary key,
    Cls number not null,
    AccntAllCmpnstnMstr number,
    AccntAllCmpnstnMstrCls number,
    constraint FAccntAllCmpnstnMstr foreign key (AccntAllCmpnstnMstrCls) references Cls (id),
    AccntAllCmpnstnObs number,
    AccntAllCmpnstnObsCls number,
    constraint FAccntAllCmpnstnObs foreign key (AccntAllCmpnstnObsCls) references Cls (id),
    AccntAllCmpnstnThis number,
    AccntAllCmpnstnThisCls number,
    constraint FAccntAllCmpnstnThis foreign key (AccntAllCmpnstnThisCls) references Cls (id)    
);

create sequence STrnsctnF nocache;

create table TrnsctnF(
    id number primary key,
    Cls number not null,
    TrnsctnFSbSrvc number,
    TrnsctnFSbSrvcCls number,
    constraint FTrnsctnFSbSrvc foreign key (TrnsctnFSbSrvcCls) references Cls (id),
    TrnsctnFThis number,
    TrnsctnFThisCls number,
    constraint FTrnsctnFThis foreign key (TrnsctnFThisCls) references Cls (id),
    FxTrnsctnFVl number,
    FxTrnsctnFVlCls number,
    constraint FFxTrnsctnFVl foreign key (FxTrnsctnFVlCls) references Cls (id),
    PrcntlFPrcnt number,
    PrcntlFPrcntCls number,
    constraint FPrcntlFPrcnt foreign key (PrcntlFPrcntCls) references Cls (id),
    MxdFFx number,
    MxdFFxCls number,
    constraint FMxdFFx foreign key (MxdFFxCls) references Cls (id),
    MxdFPrcntl number,
    MxdFPrcntlCls number,
    constraint FMxdFPrcntl foreign key (MxdFPrcntlCls) references Cls (id),
    MxdFLmt number,
    MxdFLmtCls number,
    constraint FMxdFLmt foreign key (MxdFLmtCls) references Cls (id)    
);

create sequence SNDbtTrnsfr nocache;

create table NDbtTrnsfr(
    id number primary key,
    Cls number not null,
    NDbtTrnsfrSbSrvc number,
    NDbtTrnsfrSbSrvcCls number,
    constraint FNDbtTrnsfrSbSrvc foreign key (NDbtTrnsfrSbSrvcCls) references Cls (id),
    NDbtTrnsfrThis number,
    NDbtTrnsfrThisCls number,
    constraint FNDbtTrnsfrThis foreign key (NDbtTrnsfrThisCls) references Cls (id)    
);

create sequence SAdmnstrtrCrrncMngr nocache;

create table AdmnstrtrCrrncMngr(
    id number primary key,
    Cls number not null,
    AdmnstrtrCrrncMngrMstr number,
    AdmnstrtrCrrncMngrMstrCls number,
    constraint FAdmnstrtrCrrncMngrMstr foreign key (AdmnstrtrCrrncMngrMstrCls) references Cls (id),
    AdmnstrtrCrrncMngrObs number,
    AdmnstrtrCrrncMngrObsCls number,
    constraint FAdmnstrtrCrrncMngrObs foreign key (AdmnstrtrCrrncMngrObsCls) references Cls (id),
    AdmnstrtrCrrncMngrThis number,
    AdmnstrtrCrrncMngrThisCls number,
    constraint FAdmnstrtrCrrncMngrThis foreign key (AdmnstrtrCrrncMngrThisCls) references Cls (id)    
);

create sequence SUsTmpltCMD nocache;

create table UsTmpltCMD(
    id number primary key,
    Cls number not null,
    UsTmpltCMDDbtTrafTran number,
    UsTmpltCMDDbtTrafTranCls number,
    constraint FUsTmpltCMDDbtTrafTran foreign key (UsTmpltCMDDbtTrafTranCls) references Cls (id),
    UsTmpltCMDInvoker number,
    UsTmpltCMDInvokerCls number,
    constraint FUsTmpltCMDInvoker foreign key (UsTmpltCMDInvokerCls) references Cls (id),
    UsTmpltCMDCReceiver number,
    UsTmpltCMDCReceiverCls number,
    constraint FUsTmpltCMDCReceiver foreign key (UsTmpltCMDCReceiverCls) references Cls (id),
    UsTmpltCMDMyCmmnDt number,
    UsTmpltCMDMyCmmnDtCls number,
    constraint FUsTmpltCMDMyCmmnDt foreign key (UsTmpltCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SAccntDebTrfTrans nocache;

create table AccntDebTrfTrans(
    id number primary key,
    Cls number not null,
    AccntDebTrfTransMstr number,
    AccntDebTrfTransMstrCls number,
    constraint FAccntDebTrfTransMstr foreign key (AccntDebTrfTransMstrCls) references Cls (id),
    AccntDebTrfTransThis number,
    AccntDebTrfTransThisCls number,
    constraint FAccntDebTrfTransThis foreign key (AccntDebTrfTransThisCls) references Cls (id)    
);

create sequence SChngMnCMD nocache;

create table ChngMnCMD(
    id number primary key,
    Cls number not null,
    ChngMnCMDTrns number,
    ChngMnCMDTrnsCls number,
    constraint FChngMnCMDTrns foreign key (ChngMnCMDTrnsCls) references Cls (id),
    ChngMnCMDNwAmnt varchar2(2000),
    ChngMnCMDInvoker number,
    ChngMnCMDInvokerCls number,
    constraint FChngMnCMDInvoker foreign key (ChngMnCMDInvokerCls) references Cls (id),
    ChngMnCMDCReceiver number,
    ChngMnCMDCReceiverCls number,
    constraint FChngMnCMDCReceiver foreign key (ChngMnCMDCReceiverCls) references Cls (id),
    ChngMnCMDMyCmmnDt number,
    ChngMnCMDMyCmmnDtCls number,
    constraint FChngMnCMDMyCmmnDt foreign key (ChngMnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmpReqSt nocache;

create table CmpReqSt(
    id number primary key,
    Cls number not null,
    CmpReqStSbSrvc number,
    CmpReqStSbSrvcCls number,
    constraint FCmpReqStSbSrvc foreign key (CmpReqStSbSrvcCls) references Cls (id),
    CmpReqStThis number,
    CmpReqStThisCls number,
    constraint FCmpReqStThis foreign key (CmpReqStThisCls) references Cls (id)    
);

create sequence SMn nocache;

create table Mn(
    id number primary key,
    Cls number not null,
    MnAmnt number,
    MnAmntCls number,
    constraint FMnAmnt foreign key (MnAmntCls) references Cls (id),
    MnCrrnc number,
    MnCrrncCls number,
    constraint FMnCrrnc foreign key (MnCrrncCls) references Cls (id),
    MnSbSrvc number,
    MnSbSrvcCls number,
    constraint FMnSbSrvc foreign key (MnSbSrvcCls) references Cls (id),
    MnThis number,
    MnThisCls number,
    constraint FMnThis foreign key (MnThisCls) references Cls (id)    
);

create sequence STrggrVl nocache;

create table TrggrVl(
    id number primary key,
    Cls number not null,
    TrggrVlSbSrvc number,
    TrggrVlSbSrvcCls number,
    constraint FTrggrVlSbSrvc foreign key (TrggrVlSbSrvcCls) references Cls (id),
    TrggrVlThis number,
    TrggrVlThisCls number,
    constraint FTrggrVlThis foreign key (TrggrVlThisCls) references Cls (id),
    TrggrNm varchar2(2000),
    TrggrStt number,
    TrggrSttCls number,
    constraint FTrggrStt foreign key (TrggrSttCls) references Cls (id),
    TrggrActn number,
    TrggrActnCls number,
    constraint FTrggrActn foreign key (TrggrActnCls) references Cls (id)    
);
create index ISttTrggr on TrggrVl (TrggrStt, TrggrSttCls);


create sequence SAllCmpLstOutgngCmps nocache;

create table AllCmpLstOutgngCmps(
    id number primary key,
    Cls number not null,
    AllCmpLstOutgngCmpsMstr number,
    AllCmpLstOutgngCmpsMstrCls number,
    constraint FAllCmpLstOutgngCmpsMstr foreign key (AllCmpLstOutgngCmpsMstrCls) references Cls (id),
    AllCmpLstOutgngCmpsObs number,
    AllCmpLstOutgngCmpsObsCls number,
    constraint FAllCmpLstOutgngCmpsObs foreign key (AllCmpLstOutgngCmpsObsCls) references Cls (id),
    AllCmpLstOutgngCmpsThis number,
    AllCmpLstOutgngCmpsThisCls number,
    constraint FAllCmpLstOutgngCmpsThis foreign key (AllCmpLstOutgngCmpsThisCls) references Cls (id)    
);

create sequence SAccntSrvcNtExctd nocache;

create table AccntSrvcNtExctd(
    id number primary key,
    Cls number not null,
    AccntSrvcNtExctdMstr number,
    AccntSrvcNtExctdMstrCls number,
    constraint FAccntSrvcNtExctdMstr foreign key (AccntSrvcNtExctdMstrCls) references Cls (id),
    AccntSrvcNtExctdObs number,
    AccntSrvcNtExctdObsCls number,
    constraint FAccntSrvcNtExctdObs foreign key (AccntSrvcNtExctdObsCls) references Cls (id),
    AccntSrvcNtExctdThis number,
    AccntSrvcNtExctdThisCls number,
    constraint FAccntSrvcNtExctdThis foreign key (AccntSrvcNtExctdThisCls) references Cls (id)    
);

create sequence SDbtGrnt nocache;

create table DbtGrnt(
    id number primary key,
    Cls number not null,
    DbtGrntPrmttdAccnt number,
    DbtGrntPrmttdAccntCls number,
    constraint FDbtGrntPrmttdAccnt foreign key (DbtGrntPrmttdAccntCls) references Cls (id),
    DbtGrntLmts number,
    DbtGrntLmtsCls number,
    constraint FDbtGrntLmts foreign key (DbtGrntLmtsCls) references Cls (id),
    DbtGrntSbSrvc number,
    DbtGrntSbSrvcCls number,
    constraint FDbtGrntSbSrvc foreign key (DbtGrntSbSrvcCls) references Cls (id),
    DbtGrntThis number,
    DbtGrntThisCls number,
    constraint FDbtGrntThis foreign key (DbtGrntThisCls) references Cls (id)    
);

create sequence SBnkCrtr nocache;

create table BnkCrtr(
    id number primary key,
    Cls number not null,
    BnkCrtrLstBnkNmbr number,
    BnkCrtrSbSrvc number,
    BnkCrtrSbSrvcCls number,
    constraint FBnkCrtrSbSrvc foreign key (BnkCrtrSbSrvcCls) references Cls (id),
    BnkCrtrThis number,
    BnkCrtrThisCls number,
    constraint FBnkCrtrThis foreign key (BnkCrtrThisCls) references Cls (id)    
);

create sequence SAllCmpLst nocache;

create table AllCmpLst(
    id number primary key,
    Cls number not null,
    AllCmpLstOutgngCmps number,
    AllCmpLstOutgngCmpsCls number,
    constraint FAllCmpLstOutgngCmps foreign key (AllCmpLstOutgngCmpsCls) references Cls (id),
    AllCmpLstPndgCmp number,
    AllCmpLstPndgCmpCls number,
    constraint FAllCmpLstPndgCmp foreign key (AllCmpLstPndgCmpCls) references Cls (id),
    AllCmpLstSbSrvc number,
    AllCmpLstSbSrvcCls number,
    constraint FAllCmpLstSbSrvc foreign key (AllCmpLstSbSrvcCls) references Cls (id),
    AllCmpLstThis number,
    AllCmpLstThisCls number,
    constraint FAllCmpLstThis foreign key (AllCmpLstThisCls) references Cls (id)    
);

create sequence SAccntGrntdGrnt nocache;

create table AccntGrntdGrnt(
    id number primary key,
    Cls number not null,
    AccntGrntdGrntMstr number,
    AccntGrntdGrntMstrCls number,
    constraint FAccntGrntdGrntMstr foreign key (AccntGrntdGrntMstrCls) references Cls (id),
    AccntGrntdGrntObs number,
    AccntGrntdGrntObsCls number,
    constraint FAccntGrntdGrntObs foreign key (AccntGrntdGrntObsCls) references Cls (id),
    AccntGrntdGrntThis number,
    AccntGrntdGrntThisCls number,
    constraint FAccntGrntdGrntThis foreign key (AccntGrntdGrntThisCls) references Cls (id)    
);

create sequence SCrtAccntCMD nocache;

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    CrtAccntCMDCrrncTp varchar2(2000),
    CrtAccntCMDInvoker number,
    CrtAccntCMDInvokerCls number,
    constraint FCrtAccntCMDInvoker foreign key (CrtAccntCMDInvokerCls) references Cls (id),
    CrtAccntCMDCReceiver number,
    CrtAccntCMDCReceiverCls number,
    constraint FCrtAccntCMDCReceiver foreign key (CrtAccntCMDCReceiverCls) references Cls (id),
    CrtAccntCMDMyCmmnDt number,
    CrtAccntCMDMyCmmnDtCls number,
    constraint FCrtAccntCMDMyCmmnDt foreign key (CrtAccntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SIntrnlF nocache;

create table IntrnlF(
    id number primary key,
    Cls number not null,
    IntrnlFPrcnt number,
    IntrnlFPrcntCls number,
    constraint FIntrnlFPrcnt foreign key (IntrnlFPrcntCls) references Cls (id),
    IntrnlFSbSrvc number,
    IntrnlFSbSrvcCls number,
    constraint FIntrnlFSbSrvc foreign key (IntrnlFSbSrvcCls) references Cls (id),
    IntrnlFThis number,
    IntrnlFThisCls number,
    constraint FIntrnlFThis foreign key (IntrnlFThisCls) references Cls (id)    
);

create sequence SDebTraStaDo nocache;

create table DebTraStaDo(
    id number primary key,
    Cls number not null,
    DebTraStaDoDbtrstold number,
    DebTraStaDoDbtrstoldCls number,
    constraint FDebTraStaDoDbtrstold foreign key (DebTraStaDoDbtrstoldCls) references Cls (id),
    DebTraStaDoDbtrstNew number,
    DebTraStaDoDbtrstNewCls number,
    constraint FDebTraStaDoDbtrstNew foreign key (DebTraStaDoDbtrstNewCls) references Cls (id),
    DebTraStaDoSbSrvc number,
    DebTraStaDoSbSrvcCls number,
    constraint FDebTraStaDoSbSrvc foreign key (DebTraStaDoSbSrvcCls) references Cls (id),
    DebTraStaDoThis number,
    DebTraStaDoThisCls number,
    constraint FDebTraStaDoThis foreign key (DebTraStaDoThisCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SChngRcvrBnkCMD nocache;

create table ChngRcvrBnkCMD(
    id number primary key,
    Cls number not null,
    ChngRcvrBnkCMDTrns number,
    ChngRcvrBnkCMDTrnsCls number,
    constraint FChngRcvrBnkCMDTrns foreign key (ChngRcvrBnkCMDTrnsCls) references Cls (id),
    ChngRcvrBnkCMDRcvrBnkNmbr number,
    ChngRcvrBnkCMDInvoker number,
    ChngRcvrBnkCMDInvokerCls number,
    constraint FChngRcvrBnkCMDInvoker foreign key (ChngRcvrBnkCMDInvokerCls) references Cls (id),
    ChngRcvrBnkCMDCReceiver number,
    ChngRcvrBnkCMDCReceiverCls number,
    constraint FChngRcvrBnkCMDCReceiver foreign key (ChngRcvrBnkCMDCReceiverCls) references Cls (id),
    ChngRcvrBnkCMDMyCmmnDt number,
    ChngRcvrBnkCMDMyCmmnDtCls number,
    constraint FChngRcvrBnkCMDMyCmmnDt foreign key (ChngRcvrBnkCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAccntSrvcTmplt nocache;

create table AccntSrvcTmplt(
    id number primary key,
    Cls number not null,
    AccntSrvcTmpltMstr number,
    AccntSrvcTmpltMstrCls number,
    constraint FAccntSrvcTmpltMstr foreign key (AccntSrvcTmpltMstrCls) references Cls (id),
    AccntSrvcTmpltObs number,
    AccntSrvcTmpltObsCls number,
    constraint FAccntSrvcTmpltObs foreign key (AccntSrvcTmpltObsCls) references Cls (id),
    AccntSrvcTmpltThis number,
    AccntSrvcTmpltThisCls number,
    constraint FAccntSrvcTmpltThis foreign key (AccntSrvcTmpltThisCls) references Cls (id)    
);

create sequence SAmnt nocache;

create table Amnt(
    id number primary key,
    Cls number not null,
    AmntBlnc varchar2(2000),
    AmntSbSrvc number,
    AmntSbSrvcCls number,
    constraint FAmntSbSrvc foreign key (AmntSbSrvcCls) references Cls (id),
    AmntThis number,
    AmntThisCls number,
    constraint FAmntThis foreign key (AmntThisCls) references Cls (id)    
);

create sequence SCrtBnkCMD nocache;

create table CrtBnkCMD(
    id number primary key,
    Cls number not null,
    CrtBnkCMDNm varchar2(2000),
    CrtBnkCMDAdmnstrtr number,
    CrtBnkCMDAdmnstrtrCls number,
    constraint FCrtBnkCMDAdmnstrtr foreign key (CrtBnkCMDAdmnstrtrCls) references Cls (id),
    CrtBnkCMDInvoker number,
    CrtBnkCMDInvokerCls number,
    constraint FCrtBnkCMDInvoker foreign key (CrtBnkCMDInvokerCls) references Cls (id),
    CrtBnkCMDCReceiver number,
    CrtBnkCMDCReceiverCls number,
    constraint FCrtBnkCMDCReceiver foreign key (CrtBnkCMDCReceiverCls) references Cls (id),
    CrtBnkCMDCResult number,
    CrtBnkCMDCResultCls number,
    constraint FCrtBnkCMDCResult foreign key (CrtBnkCMDCResultCls) references Cls (id),
    CrtBnkCMDMyCmmnDt number,
    CrtBnkCMDMyCmmnDtCls number,
    constraint FCrtBnkCMDMyCmmnDt foreign key (CrtBnkCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmpnstnStt nocache;

create table CmpnstnStt(
    id number primary key,
    Cls number not null,
    CmpnstnSttSbSrvc number,
    CmpnstnSttSbSrvcCls number,
    constraint FCmpnstnSttSbSrvc foreign key (CmpnstnSttSbSrvcCls) references Cls (id),
    CmpnstnSttThis number,
    CmpnstnSttThisCls number,
    constraint FCmpnstnSttThis foreign key (CmpnstnSttThisCls) references Cls (id)    
);

create sequence SBnkPx nocache;

create table BnkPx(
    id number primary key,
    Cls number not null,
    BnkPxBnk number,
    BnkPxBnkCls number,
    constraint FBnkPxBnk foreign key (BnkPxBnkCls) references Cls (id),
    BnkPxSbSrvc number,
    BnkPxSbSrvcCls number,
    constraint FBnkPxSbSrvc foreign key (BnkPxSbSrvcCls) references Cls (id),
    BnkPxThis number,
    BnkPxThisCls number,
    constraint FBnkPxThis foreign key (BnkPxThisCls) references Cls (id)    
);

create sequence SCmpnstnPndngRqsts nocache;

create table CmpnstnPndngRqsts(
    id number primary key,
    Cls number not null,
    CmpnstnPndngRqstsMstr number,
    CmpnstnPndngRqstsMstrCls number,
    constraint FCmpnstnPndngRqstsMstr foreign key (CmpnstnPndngRqstsMstrCls) references Cls (id),
    CmpnstnPndngRqstsThis number,
    CmpnstnPndngRqstsThisCls number,
    constraint FCmpnstnPndngRqstsThis foreign key (CmpnstnPndngRqstsThisCls) references Cls (id)    
);

create sequence SAdmnstrtrBnks nocache;

create table AdmnstrtrBnks(
    id number primary key,
    Cls number not null,
    AdmnstrtrBnksMstr number,
    AdmnstrtrBnksMstrCls number,
    constraint FAdmnstrtrBnksMstr foreign key (AdmnstrtrBnksMstrCls) references Cls (id),
    AdmnstrtrBnksThis number,
    AdmnstrtrBnksThisCls number,
    constraint FAdmnstrtrBnksThis foreign key (AdmnstrtrBnksThisCls) references Cls (id)    
);

create sequence SLmtAccnt nocache;

create table LmtAccnt(
    id number primary key,
    Cls number not null,
    LmtAccntMnLmt number,
    LmtAccntMnLmtCls number,
    constraint FLmtAccntMnLmt foreign key (LmtAccntMnLmtCls) references Cls (id),
    LmtAccntMxLmt number,
    LmtAccntMxLmtCls number,
    constraint FLmtAccntMxLmt foreign key (LmtAccntMxLmtCls) references Cls (id),
    LmtAccntSbSrvc number,
    LmtAccntSbSrvcCls number,
    constraint FLmtAccntSbSrvc foreign key (LmtAccntSbSrvcCls) references Cls (id),
    LmtAccntThis number,
    LmtAccntThisCls number,
    constraint FLmtAccntThis foreign key (LmtAccntThisCls) references Cls (id)    
);

create sequence SCmpDeclndCMD nocache;

create table CmpDeclndCMD(
    id number primary key,
    Cls number not null,
    CmpDeclndCMDCmpnstn number,
    CmpDeclndCMDCmpnstnCls number,
    constraint FCmpDeclndCMDCmpnstn foreign key (CmpDeclndCMDCmpnstnCls) references Cls (id),
    CmpDeclndCMDRsn varchar2(2000),
    CmpDeclndCMDInvoker number,
    CmpDeclndCMDInvokerCls number,
    constraint FCmpDeclndCMDInvoker foreign key (CmpDeclndCMDInvokerCls) references Cls (id),
    CmpDeclndCMDCReceiver number,
    CmpDeclndCMDCReceiverCls number,
    constraint FCmpDeclndCMDCReceiver foreign key (CmpDeclndCMDCReceiverCls) references Cls (id),
    CmpDeclndCMDMyCmmnDt number,
    CmpDeclndCMDMyCmmnDtCls number,
    constraint FCmpDeclndCMDMyCmmnDt foreign key (CmpDeclndCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SDbtGrntLst nocache;

create table DbtGrntLst(
    id number primary key,
    Cls number not null,
    DbtGrntLstSbSrvc number,
    DbtGrntLstSbSrvcCls number,
    constraint FDbtGrntLstSbSrvc foreign key (DbtGrntLstSbSrvcCls) references Cls (id),
    DbtGrntLstThis number,
    DbtGrntLstThisCls number,
    constraint FDbtGrntLstThis foreign key (DbtGrntLstThisCls) references Cls (id)    
);

create sequence SAccntTrggrLst nocache;

create table AccntTrggrLst(
    id number primary key,
    Cls number not null,
    AccntTrggrLstMstr number,
    AccntTrggrLstMstrCls number,
    constraint FAccntTrggrLstMstr foreign key (AccntTrggrLstMstrCls) references Cls (id),
    AccntTrggrLstObs number,
    AccntTrggrLstObsCls number,
    constraint FAccntTrggrLstObs foreign key (AccntTrggrLstObsCls) references Cls (id),
    AccntTrggrLstThis number,
    AccntTrggrLstThisCls number,
    constraint FAccntTrggrLstThis foreign key (AccntTrggrLstThisCls) references Cls (id)    
);

create sequence SAccnt nocache;

create table Accnt(
    id number primary key,
    Cls number not null,
    AccntAccntNmbr number,
    AccntMn number,
    AccntMnCls number,
    constraint FAccntMn foreign key (AccntMnCls) references Cls (id),
    AccntLmt number,
    AccntLmtCls number,
    constraint FAccntLmt foreign key (AccntLmtCls) references Cls (id),
    AccntDebTrfTrans number,
    AccntDebTrfTransCls number,
    constraint FAccntDebTrfTrans foreign key (AccntDebTrfTransCls) references Cls (id),
    AccntGrntdGrnt number,
    AccntGrntdGrntCls number,
    constraint FAccntGrntdGrnt foreign key (AccntGrntdGrntCls) references Cls (id),
    AccntRcvdGrnt number,
    AccntRcvdGrntCls number,
    constraint FAccntRcvdGrnt foreign key (AccntRcvdGrntCls) references Cls (id),
    AccntTrggrLst number,
    AccntTrggrLstCls number,
    constraint FAccntTrggrLst foreign key (AccntTrggrLstCls) references Cls (id),
    AccntAllCmpnstn number,
    AccntAllCmpnstnCls number,
    constraint FAccntAllCmpnstn foreign key (AccntAllCmpnstnCls) references Cls (id),
    AccntSbSrvc number,
    AccntSbSrvcCls number,
    constraint FAccntSbSrvc foreign key (AccntSbSrvcCls) references Cls (id),
    AccntThis number,
    AccntThisCls number,
    constraint FAccntThis foreign key (AccntThisCls) references Cls (id)    
);
create index IAccntNmbrAccnt on Accnt (AccntAccntNmbr);
create index IMnAccnt on Accnt (AccntMn, AccntMnCls);
create index ILmtAccnt on Accnt (AccntLmt, AccntLmtCls);


create sequence SDbTrNtExec nocache;

create table DbTrNtExec(
    id number primary key,
    Cls number not null,
    DbTrNtExecSbSrvc number,
    DbTrNtExecSbSrvcCls number,
    constraint FDbTrNtExecSbSrvc foreign key (DbTrNtExecSbSrvcCls) references Cls (id),
    DbTrNtExecThis number,
    DbTrNtExecThisCls number,
    constraint FDbTrNtExecThis foreign key (DbTrNtExecThisCls) references Cls (id)    
);

create sequence SChngCrrncCMD nocache;

create table ChngCrrncCMD(
    id number primary key,
    Cls number not null,
    ChngCrrncCMDTrns number,
    ChngCrrncCMDTrnsCls number,
    constraint FChngCrrncCMDTrns foreign key (ChngCrrncCMDTrnsCls) references Cls (id),
    ChngCrrncCMDCrrnc number,
    ChngCrrncCMDCrrncCls number,
    constraint FChngCrrncCMDCrrnc foreign key (ChngCrrncCMDCrrncCls) references Cls (id),
    ChngCrrncCMDInvoker number,
    ChngCrrncCMDInvokerCls number,
    constraint FChngCrrncCMDInvoker foreign key (ChngCrrncCMDInvokerCls) references Cls (id),
    ChngCrrncCMDCReceiver number,
    ChngCrrncCMDCReceiverCls number,
    constraint FChngCrrncCMDCReceiver foreign key (ChngCrrncCMDCReceiverCls) references Cls (id),
    ChngCrrncCMDMyCmmnDt number,
    ChngCrrncCMDMyCmmnDtCls number,
    constraint FChngCrrncCMDMyCmmnDt foreign key (ChngCrrncCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SLmtTp nocache;

create table LmtTp(
    id number primary key,
    Cls number not null,
    LmtTpSbSrvc number,
    LmtTpSbSrvcCls number,
    constraint FLmtTpSbSrvc foreign key (LmtTpSbSrvcCls) references Cls (id),
    LmtTpThis number,
    LmtTpThisCls number,
    constraint FLmtTpThis foreign key (LmtTpThisCls) references Cls (id),
    LmtMn number,
    LmtMnCls number,
    constraint FLmtMn foreign key (LmtMnCls) references Cls (id)    
);

create sequence STrggrStt nocache;

create table TrggrStt(
    id number primary key,
    Cls number not null,
    TrggrSttSbSrvc number,
    TrggrSttSbSrvcCls number,
    constraint FTrggrSttSbSrvc foreign key (TrggrSttSbSrvcCls) references Cls (id),
    TrggrSttThis number,
    TrggrSttThisCls number,
    constraint FTrggrSttThis foreign key (TrggrSttThisCls) references Cls (id)    
);

create sequence SCmpnstnLst nocache;

create table CmpnstnLst(
    id number primary key,
    Cls number not null,
    CmpnstnLstSbSrvc number,
    CmpnstnLstSbSrvcCls number,
    constraint FCmpnstnLstSbSrvc foreign key (CmpnstnLstSbSrvcCls) references Cls (id),
    CmpnstnLstThis number,
    CmpnstnLstThisCls number,
    constraint FCmpnstnLstThis foreign key (CmpnstnLstThisCls) references Cls (id)    
);

create sequence SAllCmpLstPndgCmp nocache;

create table AllCmpLstPndgCmp(
    id number primary key,
    Cls number not null,
    AllCmpLstPndgCmpMstr number,
    AllCmpLstPndgCmpMstrCls number,
    constraint FAllCmpLstPndgCmpMstr foreign key (AllCmpLstPndgCmpMstrCls) references Cls (id),
    AllCmpLstPndgCmpObs number,
    AllCmpLstPndgCmpObsCls number,
    constraint FAllCmpLstPndgCmpObs foreign key (AllCmpLstPndgCmpObsCls) references Cls (id),
    AllCmpLstPndgCmpThis number,
    AllCmpLstPndgCmpThisCls number,
    constraint FAllCmpLstPndgCmpThis foreign key (AllCmpLstPndgCmpThisCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SBnk nocache;

create table Bnk(
    id number primary key,
    Cls number not null,
    BnkBnkNmbr number,
    BnkNm varchar2(2000),
    BnkLstAccNo number,
    BnkBnkFs number,
    BnkBnkFsCls number,
    constraint FBnkBnkFs foreign key (BnkBnkFsCls) references Cls (id),
    BnkOwnAccnt number,
    BnkOwnAccntCls number,
    constraint FBnkOwnAccnt foreign key (BnkOwnAccntCls) references Cls (id),
    BnkAdmnstrtr number,
    BnkAdmnstrtrCls number,
    constraint FBnkAdmnstrtr foreign key (BnkAdmnstrtrCls) references Cls (id),
    BnkSbSrvc number,
    BnkSbSrvcCls number,
    constraint FBnkSbSrvc foreign key (BnkSbSrvcCls) references Cls (id),
    BnkThis number,
    BnkThisCls number,
    constraint FBnkThis foreign key (BnkThisCls) references Cls (id)    
);
create index IBnkNmbrBnk on Bnk (BnkBnkNmbr);
create index INmBnk on Bnk (BnkNm);
create index IAdmnstrtrBnk on Bnk (BnkAdmnstrtr, BnkAdmnstrtrCls);


create sequence SDbtTrnSucc nocache;

create table DbtTrnSucc(
    id number primary key,
    Cls number not null,
    DbtTrnSuccSbSrvc number,
    DbtTrnSuccSbSrvcCls number,
    constraint FDbtTrnSuccSbSrvc foreign key (DbtTrnSuccSbSrvcCls) references Cls (id),
    DbtTrnSuccThis number,
    DbtTrnSuccThisCls number,
    constraint FDbtTrnSuccThis foreign key (DbtTrnSuccThisCls) references Cls (id)    
);

create sequence SRl nocache;

create table Rl(
    id number primary key,
    Cls number not null,
    RlSbSrvc number,
    RlSbSrvcCls number,
    constraint FRlSbSrvc foreign key (RlSbSrvcCls) references Cls (id),
    RlThis number,
    RlThisCls number,
    constraint FRlThis foreign key (RlThisCls) references Cls (id),
    IncAccRuleAccntNmbr number,
    IncAccRuleBnkNmbr number,
    SbjctRlSbjct varchar2(2000),
    MnRlCrrnc number,
    MnRlCrrncCls number,
    constraint FMnRlCrrnc foreign key (MnRlCrrncCls) references Cls (id),
    MnRlMnLmt number,
    MnRlMnLmtCls number,
    constraint FMnRlMnLmt foreign key (MnRlMnLmtCls) references Cls (id),
    MnRlMxLmt number,
    MnRlMxLmtCls number,
    constraint FMnRlMxLmt foreign key (MnRlMxLmtCls) references Cls (id)    
);

create sequence SEvntWrppr nocache;

create table EvntWrppr(
    id number primary key,
    Cls number not null,
    EvntWrpprSbSrvc number,
    EvntWrpprSbSrvcCls number,
    constraint FEvntWrpprSbSrvc foreign key (EvntWrpprSbSrvcCls) references Cls (id),
    EvntWrpprThis number,
    EvntWrpprThisCls number,
    constraint FEvntWrpprThis foreign key (EvntWrpprThisCls) references Cls (id)    
);

create sequence SBnkFs nocache;

create table BnkFs(
    id number primary key,
    Cls number not null,
    BnkFsFee number,
    BnkFsFeeCls number,
    constraint FBnkFsFee foreign key (BnkFsFeeCls) references Cls (id),
    BnkFsIntrnlF number,
    BnkFsIntrnlFCls number,
    constraint FBnkFsIntrnlF foreign key (BnkFsIntrnlFCls) references Cls (id),
    BnkFsSbSrvc number,
    BnkFsSbSrvcCls number,
    constraint FBnkFsSbSrvc foreign key (BnkFsSbSrvcCls) references Cls (id),
    BnkFsThis number,
    BnkFsThisCls number,
    constraint FBnkFsThis foreign key (BnkFsThisCls) references Cls (id)    
);

create sequence SAccntSrvcBnkFs nocache;

create table AccntSrvcBnkFs(
    id number primary key,
    Cls number not null,
    AccntSrvcBnkFsMstr number,
    AccntSrvcBnkFsMstrCls number,
    constraint FAccntSrvcBnkFsMstr foreign key (AccntSrvcBnkFsMstrCls) references Cls (id),
    AccntSrvcBnkFsObs number,
    AccntSrvcBnkFsObsCls number,
    constraint FAccntSrvcBnkFsObs foreign key (AccntSrvcBnkFsObsCls) references Cls (id),
    AccntSrvcBnkFsThis number,
    AccntSrvcBnkFsThisCls number,
    constraint FAccntSrvcBnkFsThis foreign key (AccntSrvcBnkFsThisCls) references Cls (id)    
);

create sequence SCmpRqLst nocache;

create table CmpRqLst(
    id number primary key,
    Cls number not null,
    CmpRqLstSbSrvc number,
    CmpRqLstSbSrvcCls number,
    constraint FCmpRqLstSbSrvc foreign key (CmpRqLstSbSrvcCls) references Cls (id),
    CmpRqLstThis number,
    CmpRqLstThisCls number,
    constraint FCmpRqLstThis foreign key (CmpRqLstThisCls) references Cls (id)    
);

create sequence SSubjObs nocache;

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id),
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

create sequence SDebTransLstDbtTrnsfrs nocache;

create table DebTransLstDbtTrnsfrs(
    id number primary key,
    frm number not null,
    dbtTrnsfrs number not null,
    Cls number not null,
    constraint FDebTransLstDbtTrnsfrsCls foreign key(Cls) references Cls(id),
    constraint FDebTransLstDbtTrnsfrsfrm foreign key(frm) references DebTransLst(id)
);
create index IFrmDebTransLstDbtTrnsfrs on DebTransLstDbtTrnsfrs(frm);

create sequence SCrrncMngrXchngRtGUI nocache;

create table CrrncMngrXchngRtGUI(
    id number primary key,
    frm number not null,
    xchngRtGUI number not null,
    Cls number not null,
    constraint FCrrncMngrXchngRtGUICls foreign key(Cls) references Cls(id),
    constraint FCrrncMngrXchngRtGUIfrm foreign key(frm) references CrrncMngr(id)
);
create index IFrmCrrncMngrXchngRtGUI on CrrncMngrXchngRtGUI(frm);

create sequence SCrrncMngrExchngRts nocache;

create table CrrncMngrExchngRts(
    id number primary key,
    frm number not null,
    CrrncMngrExchngRtsindxx number not null,
    CrrncMngrExchngRtsindxxCls number not null,
    constraint FCrrncMngrExchngRtsindxx foreign key (CrrncMngrExchngRtsindxxCls) references Cls (id),
    exchngRts number not null,
    Cls number not null,
    constraint FCrrncMngrExchngRtsCls foreign key(Cls) references Cls(id),
    constraint FCrrncMngrExchngRtsfrm foreign key(frm) references CrrncMngr(id)
);
create index IFrmCrrncMngrExchngRts on CrrncMngrExchngRts(frm);
create index IIndxxCrrncMngrExchngRts on CrrncMngrExchngRts(CrrncMngrExchngRtsindxx);

create sequence SCrrncMngrCrrncStck nocache;

create table CrrncMngrCrrncStck(
    id number primary key,
    frm number not null,
    crrncStck number not null,
    Cls number not null,
    constraint FCrrncMngrCrrncStckCls foreign key(Cls) references Cls(id),
    constraint FCrrncMngrCrrncStckfrm foreign key(frm) references CrrncMngr(id)
);
create index IFrmCrrncMngrCrrncStck on CrrncMngrCrrncStck(frm);

create sequence SDbTrNtTmplTmplts nocache;

create table DbTrNtTmplTmplts(
    id number primary key,
    frm number not null,
    tmplts number not null,
    Cls number not null,
    constraint FDbTrNtTmplTmpltsCls foreign key(Cls) references Cls(id),
    constraint FDbTrNtTmplTmpltsfrm foreign key(frm) references DbTrNtTmpl(id)
);
create index IFrmDbTrNtTmplTmplts on DbTrNtTmplTmplts(frm);

create sequence STrggrLstTrggrs nocache;

create table TrggrLstTrggrs(
    id number primary key,
    frm number not null,
    trggrs number not null,
    Cls number not null,
    constraint FTrggrLstTrggrsCls foreign key(Cls) references Cls(id),
    constraint FTrggrLstTrggrsfrm foreign key(frm) references TrggrLst(id)
);
create index IFrmTrggrLstTrggrs on TrggrLstTrggrs(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id),
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create sequence SAccntDebTrfTransObs nocache;

create table AccntDebTrfTransObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FAccntDebTrfTransObsCls foreign key(Cls) references Cls(id),
    constraint FAccntDebTrfTransObsfrm foreign key(frm) references AccntDebTrfTrans(id)
);
create index IFrmAccntDebTrfTransObs on AccntDebTrfTransObs(frm);

create sequence SDbtTrnsfrNxtdtttrg nocache;

create table DbtTrnsfrNxtdtttrg(
    id number primary key,
    frm number not null,
    nxtdtttrg number not null,
    Cls number not null,
    constraint FDbtTrnsfrNxtdtttrgCls foreign key(Cls) references Cls(id),
    constraint FDbtTrnsfrNxtdtttrgfrm foreign key(frm) references DebiTrfTran(id)
);
create index IFrmDbtTrnsfrNxtdtttrg on DbtTrnsfrNxtdtttrg(frm);

create sequence SCmpnstnPndngRqstsObs nocache;

create table CmpnstnPndngRqstsObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FCmpnstnPndngRqstsObsCls foreign key(Cls) references Cls(id),
    constraint FCmpnstnPndngRqstsObsfrm foreign key(frm) references CmpnstnPndngRqsts(id)
);
create index IFrmCmpnstnPndngRqstsObs on CmpnstnPndngRqstsObs(frm);

create sequence SAdmnstrtrBnksObs nocache;

create table AdmnstrtrBnksObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FAdmnstrtrBnksObsCls foreign key(Cls) references Cls(id),
    constraint FAdmnstrtrBnksObsfrm foreign key(frm) references AdmnstrtrBnks(id)
);
create index IFrmAdmnstrtrBnksObs on AdmnstrtrBnksObs(frm);

create sequence SDbtGrntLstDbtGrnts nocache;

create table DbtGrntLstDbtGrnts(
    id number primary key,
    frm number not null,
    dbtGrnts number not null,
    Cls number not null,
    constraint FDbtGrntLstDbtGrntsCls foreign key(Cls) references Cls(id),
    constraint FDbtGrntLstDbtGrntsfrm foreign key(frm) references DbtGrntLst(id)
);
create index IFrmDbtGrntLstDbtGrnts on DbtGrntLstDbtGrnts(frm);

create sequence STrggrRls nocache;

create table TrggrRls(
    id number primary key,
    frm number not null,
    rls number not null,
    Cls number not null,
    constraint FTrggrRlsCls foreign key(Cls) references Cls(id),
    constraint FTrggrRlsfrm foreign key(frm) references TrggrVl(id)
);
create index IFrmTrggrRls on TrggrRls(frm);


create index IRlsTrggrRls on TrggrRls(rls);
create sequence SDbTrNtExecNtExctds nocache;

create table DbTrNtExecNtExctds(
    id number primary key,
    frm number not null,
    ntExctds number not null,
    Cls number not null,
    constraint FDbTrNtExecNtExctdsCls foreign key(Cls) references Cls(id),
    constraint FDbTrNtExecNtExctdsfrm foreign key(frm) references DbTrNtExec(id)
);
create index IFrmDbTrNtExecNtExctds on DbTrNtExecNtExctds(frm);

create sequence SCmpnstnLstCmpnstns nocache;

create table CmpnstnLstCmpnstns(
    id number primary key,
    frm number not null,
    cmpnstns number not null,
    Cls number not null,
    constraint FCmpnstnLstCmpnstnsCls foreign key(Cls) references Cls(id),
    constraint FCmpnstnLstCmpnstnsfrm foreign key(frm) references CmpnstnLst(id)
);
create index IFrmCmpnstnLstCmpnstns on CmpnstnLstCmpnstns(frm);

create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id),
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SBnkAccnts nocache;

create table BnkAccnts(
    id number primary key,
    frm number not null,
    BnkAccntsindxx number not null,
    accnts number not null,
    Cls number not null,
    constraint FBnkAccntsCls foreign key(Cls) references Cls(id),
    constraint FBnkAccntsfrm foreign key(frm) references Bnk(id)
);
create index IFrmBnkAccnts on BnkAccnts(frm);
create index IIndxxBnkAccnts on BnkAccnts(BnkAccntsindxx);


create index IAccntsBnkAccnts on BnkAccnts(accnts);
create sequence SDbtTrnSuccSccssfls nocache;

create table DbtTrnSuccSccssfls(
    id number primary key,
    frm number not null,
    sccssfls number not null,
    Cls number not null,
    constraint FDbtTrnSuccSccssflsCls foreign key(Cls) references Cls(id),
    constraint FDbtTrnSuccSccssflsfrm foreign key(frm) references DbtTrnSucc(id)
);
create index IFrmDbtTrnSuccSccssfls on DbtTrnSuccSccssfls(frm);

create sequence SCmpRqLstRqsts nocache;

create table CmpRqLstRqsts(
    id number primary key,
    frm number not null,
    rqsts number not null,
    Cls number not null,
    constraint FCmpRqLstRqstsCls foreign key(Cls) references Cls(id),
    constraint FCmpRqLstRqstsfrm foreign key(frm) references CmpRqLst(id)
);
create index IFrmCmpRqLstRqsts on CmpRqLstRqsts(frm);

