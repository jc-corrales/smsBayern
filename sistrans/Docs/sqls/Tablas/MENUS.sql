--------------------------------------------------------
--  DDL for Table MENUS
--------------------------------------------------------

  CREATE TABLE "ISIS2304B041720"."MENUS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(40 BYTE), 
	"ID_ENTRADA" NUMBER, 
	"ID_PLATOFUERTE" NUMBER, 
	"ID_POSTRE" NUMBER, 
	"ID_BEBIDA" NUMBER, 
	"ID_RESTAURANTE" NUMBER, 
	"ID_ACOMPANIAMIENTO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;