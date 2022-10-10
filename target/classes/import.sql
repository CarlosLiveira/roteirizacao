INSERT INTO tb_categoria(codigo, descricao) VALUES(1, 'Refrigeração');
INSERT INTO tb_categoria(codigo, descricao) VALUES(2, 'Queimadores');
INSERT INTO tb_categoria(codigo, descricao) VALUES(3, 'Lavadoras');
INSERT INTO tb_categoria(codigo, descricao) VALUES(4, 'Portáteis');

INSERT INTO tb_tipo_transporte(codigo, descricao) VALUES(1, 'Leve');
INSERT INTO tb_tipo_transporte(codigo, descricao) VALUES(2, 'Pesado');

INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(1, 'ASP STICK 700W BRITANIA DUST OFF PTO 110V', 4, 1);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(2, 'LIQ 5VEL/PUL KITCHENAID KUA15AE PTO 220V', 4, 1);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(3, 'COIFA 70CM TOPAZIO TP7771IX INOX 110V SUGGAR', 2, 2);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(4, 'FOGAO 2B MESA A GAS FG3202VP PR BIVOLT SUGGAR', 2, 2);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(5, 'REF FF 02563FBA189 DFX50 430LT IN 110V ELECTROLUX', 1, 2);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(6, 'ADEGA BZC12AEBNA 12 GARRAFAS PRETO 220V BRASTEMP', 1, 2);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(7, 'L/S 10,2K SAMSUNG WD10J6410AXFAZ 220V INX', 3, 2);
INSERT INTO tb_sku(codigo, descricao, codigo_categoria, codigo_tipo_transporte) VALUES(8, 'LAVA E SECA 9KG WD90J6410 IN 127V SAMSUNG', 3, 2);

INSERT INTO tb_filial(cnpj, descricao) VALUES('1', 'Jundiai');
INSERT INTO tb_filial(cnpj, descricao) VALUES('2', 'Camaçari');
INSERT INTO tb_filial(cnpj, descricao) VALUES('3', 'Betim');
INSERT INTO tb_filial(cnpj, descricao) VALUES('4', 'São Bernardo do Campo');
INSERT INTO tb_filial(cnpj, descricao) VALUES('5', 'Ribeirao Preto');
INSERT INTO tb_filial(cnpj, descricao) VALUES('6', 'Duque de Caxias');

INSERT INTO tb_regiao(codigo, descricao, status) VALUES(1, 'Centro São Paulo', 'ATIVO');
INSERT INTO tb_regiao(codigo, descricao, status) VALUES(2, 'Zona Norte São Paulo', 'INATIVO');
INSERT INTO tb_regiao(codigo, descricao, status) VALUES(3, 'Zona Leste São Paulo', 'ATIVO');
INSERT INTO tb_regiao(codigo, descricao, status) VALUES(4, 'Zona Leste São Paulo', 'ATIVO');

INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (1, 1, 01000, 01599);
INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (1, 2, 01600, 01999);
INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (2, 3 ,02000, 02999);
INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (3, 4, 03000, 03999);
INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (4, 5, 08000, 08499);
INSERT INTO tb_regiao_faixas_cep(regiao, codigo, cep_Inicial, cep_Final) VALUES (3, 6, 01000, 01599);

INSERT INTO tb_regiao_categoria(codigo_regiao, codigo_categoria) VALUES(1, 1);
INSERT INTO tb_regiao_categoria(codigo_regiao, codigo_categoria) VALUES(2, 2);
INSERT INTO tb_regiao_categoria(codigo_regiao, codigo_categoria) VALUES(2, 1);

INSERT INTO tb_regiao_sku(regiao, sku) VALUES(1, 1);
INSERT INTO tb_regiao_sku(regiao, sku) VALUES(1, 3);
INSERT INTO tb_regiao_sku(regiao, sku) VALUES(2, 5);
INSERT INTO tb_regiao_sku(regiao, sku) VALUES(3, 2);
INSERT INTO tb_regiao_sku(regiao, sku) VALUES(4, 4);
INSERT INTO tb_regiao_sku(regiao, sku) VALUES(4, 6);

