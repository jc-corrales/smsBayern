--------------------------------------------------------
--  Constraints for Table PEDIDOS
--------------------------------------------------------

  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("FECHA" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" ADD CONSTRAINT "PK_PEDIDO" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("ID_RESTAURANTE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("SERVIDO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" ADD CONSTRAINT "BOOL_DESPACHADO" CHECK (SERVIDO = 1 OR SERVIDO = 0) ENABLE;
  ALTER TABLE "ISIS2304B041720"."PEDIDOS" MODIFY ("ID_ORDEN" NOT NULL ENABLE);
