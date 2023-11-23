create table organizador(
 	organizador_id bigint not null auto_increment,
	nome varchar(100) not null,
    email varchar(100) not null unique,
    fone varchar(20) not null,
    ativo tinyint,
    primary key(organizador_id)
);

create table area(
 	area_id bigint not null auto_increment,
	descricao varchar(100) not null,
    primary key(area_id)
);


create table autor(
 	autor_id bigint not null auto_increment,
	nome varchar(100) not null,
    email varchar(100) not null unique,
    instituicao varchar(100) not null,
    fone varchar(20) not null,
    ativo tinyint,
    primary key(autor_id)
);

create table artigo(
	 artigo_id bigint not null auto_increment,
	 titulo varchar(100) not null, 
	 resumo text not null, 
	 keyWord1 varchar(100) not null,
	 keyWord2 varchar(100) not null,
	 keyWord3 varchar(100) not null,
	 dataSubmissao date, 
	 area_id bigint not null,
	 primary key(artigo_id),
	 constraint fk_area_id foreign key (area_id) references area(area_id)
);

create table autor_artigo(
	autor_id bigint not null,
	artigo_id bigint not null,
	primary key(autor_id, artigo_id),
	constraint fk_autor_id foreign key(autor_id) references autor(autor_id),
	constraint fk_artigo_id foreign key(artigo_id) references artigo(artigo_id)
);

