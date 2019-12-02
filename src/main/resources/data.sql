insert into user(email,name, password, role, id )  values( 'arnaldo@gmail.com', 'arnaldo', '123', 'ADMINISTRATOR', 1);

insert into request(id, subject, description, creation_date, status, owner_id)  values
                  ( 1, 'requisição teste','descrição teste' , sysdate, 'OPEN', 1);

insert into request_Stage(  id,   description, realization_date,   state,   request_id,
			  owner_id)  values( 1, 'teste', sysdate, 'OPEN', 1, 1); 

