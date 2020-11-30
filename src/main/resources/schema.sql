DROP TABLE IF EXISTS "CLIENTES";
CREATE TABLE "CLIENTES" (
  "ID" BIGINT(20) NOT NULL AUTO_INCREMENT,
  "NOME" VARCHAR(128) DEFAULT NULL,
  "SOBRENOME" VARCHAR(128) DEFAULT NULL,
  "TELEFONE" VARCHAR(128) DEFAULT NULL,
  PRIMARY KEY ("ID")
);