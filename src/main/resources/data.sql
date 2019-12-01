insert into user(email,name, password, role, id )  values( 'arnaldo@gmail.com', 'arnaldo', '123', 'ADMINISTRATOR', 1);
insert into user(email,name, password, role, id )  values( 'roberto@gmail.com', 'roberto', '123', 'ADMINISTRATOR', 2);
insert into user(email,name, password, role, id )  values( 'francisco@gmail.com', 'francisco', '123', 'ADMINISTRATOR', 3);
insert into user(email,name, password, role, id )  values( 'amelia@gmail.com', 'amelia', '123', 'ADMINISTRATOR', 4);
insert into user(email,name, password, role, id )  values( 'walter@gmail.com', 'walter', '123', 'ADMINISTRATOR', 5);
insert into user(email,name, password, role, id )  values( 'gabrielle@gmail.com', 'gabrielle', '123', 'ADMINISTRATOR', 6);
insert into user(email,name, password, role, id )  values( 'monica@gmail.com', 'monica', '123', 'ADMINISTRATOR', 7);
insert into user(email,name, password, role, id )  values( 'adolfo@gmail.com', 'adolfo', '123', 'ADMINISTRATOR', 8);
insert into user(email,name, password, role, id )  values( 'lucio@gmail.com', 'lucio', '123', 'ADMINISTRATOR', 9);
insert into user(email,name, password, role, id )  values( 'renato@gmail.com', 'renato', '123', 'ADMINISTRATOR', 10);
insert into user(email,name, password, role, id )  values( 'thiago@gmail.com', 'thiago', '123', 'ADMINISTRATOR', 11);

insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 1, 'requisição teste','descrição teste' , sysdate, 'OPEN', 1);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 2, 'requisição teste','descrição teste' , sysdate, 'OPEN', 2);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 3, 'requisição teste','descrição teste' , sysdate, 'OPEN', 3);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 4, 'requisição teste','descrição teste' , sysdate, 'OPEN', 4);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 5, 'requisição teste','descrição teste' , sysdate, 'OPEN', 5);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 6, 'requisição teste','descrição teste' , sysdate, 'OPEN', 6);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 7, 'requisição teste','descrição teste' , sysdate, 'OPEN', 7);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 8, 'requisição teste','descrição teste' , sysdate, 'OPEN', 8);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 9, 'requisição teste','descrição teste' , sysdate, 'OPEN', 9);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 10, 'requisição teste','descrição teste' , sysdate, 'OPEN', 10);
insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 11, 'requisição teste','descrição teste' , sysdate, 'OPEN', 11);

insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 1, 'teste', sysdate, 'OPEN', 1, 1);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 2, 'teste', sysdate, 'OPEN', 1, 2);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 3, 'teste', sysdate, 'OPEN', 1, 3);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 4, 'teste', sysdate, 'OPEN', 1, 4);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 5, 'teste', sysdate, 'OPEN', 1, 5);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 6, 'teste', sysdate, 'OPEN', 1, 6);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 7, 'teste', sysdate, 'OPEN', 1, 7);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 8, 'teste', sysdate, 'OPEN', 1, 8);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 9, 'teste', sysdate, 'OPEN', 1, 9);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 10, 'teste', sysdate, 'OPEN', 1, 10);
insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 11, 'teste', sysdate, 'OPEN', 1, 11);

