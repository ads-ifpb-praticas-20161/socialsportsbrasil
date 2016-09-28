/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dijalma Silva <dijalmacz@gmail.com>
 * Created: 27/09/2016
 */

CREATE TABLE Usuario
(
  id serial NOT NULL,
  conta character varying(255),
  data_de_nascimento date,
  email character varying(255),
  foto bytea,
  nome character varying(255),
  pontos integer NOT NULL,
  senha character varying(255),
  sobrenome character varying(255),
  username character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uk_5171l57faosmj8myawaucatdw UNIQUE (email),
  CONSTRAINT uk_863n1y3x0jalatoir4325ehal UNIQUE (username)
);

CREATE TABLE usuario_amigos
(
  usuario_id bigint NOT NULL,
  amigos_id bigint NOT NULL,
  CONSTRAINT fk78dfuay1npvomfdwyjk49iu8h FOREIGN KEY (amigos_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_n6i4952tbu9cj08f7c1hq3f0w FOREIGN KEY (amigos_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_q9cx0k2p2f6y9cylppt5420o9 FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkp8dunt6mjj9t1ncb1f15v3yv9 FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE idolo
(
  id bigint NOT NULL,
  esporte character varying(255),
  foto bytea,
  nome character varying(255),
  tipo character varying(255),
  CONSTRAINT idolo_pkey PRIMARY KEY (id),
  CONSTRAINT uk_sifv5td4ln5h0cvi5b1vt8sqo UNIQUE (nome)
);

CREATE TABLE grupo
(
  id bigint NOT NULL,
  descricao text,
  nome character varying(255),
  dono_id bigint,
  idolo_id bigint,
  CONSTRAINT grupo_pkey PRIMARY KEY (id),
  CONSTRAINT fk_3eo8kjl6xugyc9wwpoyfxah6i FOREIGN KEY (dono_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_g29ppi2cmnnaesio4b2xspjb6 FOREIGN KEY (idolo_id)
      REFERENCES idolo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkrocb9oht1v1yc8e2hj6a0odr FOREIGN KEY (dono_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkrqoc3if70ar7ajpfpkt3ln9tv FOREIGN KEY (idolo_id)
      REFERENCES idolo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_2iij2lspt3u2dj6c5max7ktt3 UNIQUE (nome)
);

CREATE TABLE usuario_grupos
(
  usuario_id bigint NOT NULL,
  grupos_id bigint NOT NULL,
  CONSTRAINT fk158r9y55ufwykh675ddt8kb43 FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk92ff1v8fkwig9tqv9bk4nvi0t FOREIGN KEY (grupos_id)
      REFERENCES grupo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_g9btqwft2kb2dm3taxsditte3 FOREIGN KEY (grupos_id)
      REFERENCES grupo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_kqtu00hyrm94v1t9q40w278gf FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);