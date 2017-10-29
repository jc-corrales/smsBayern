--------------------------------------------------------
--  Constraints for Table TIPOPRODUCTO
--------------------------------------------------------

  ALTER TABLE "ISIS2304B041720"."TIPOPRODUCTO" ADD CONSTRAINT "PK_VIDEO" PRIMARY KEY ("ID_PROD", "ID_TIPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B041720"."TIPOPRODUCTO" MODIFY ("ID_TIPO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."TIPOPRODUCTO" MODIFY ("ID_PROD" NOT NULL ENABLE);
