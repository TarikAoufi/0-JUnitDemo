DROP TABLE IF NOT EXISTS Peronne_Numero;
DROP TABLE IF NOT EXISTS Numero;
DROP TABLE IF NOT EXISTS Personne;


CREATE TABLE Personne (
  id int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(255) DEFAULT NULL,
  prenom varchar(255) DEFAULT NULL,
  dateNaissance date DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE Numero (
  id int(11) NOT NULL AUTO_INCREMENT,
  tel varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


CREATE TABLE Personne_Numero (
  personnes_id int(11) NOT NULL,
  numeros_id int(11) NOT NULL,
  PRIMARY KEY (personnes_id,numeros_id),
  KEY FK415C43EFAD3B65F5 (numeros_id),
  KEY FK415C43EF4310FD5 (personnes_id),
  CONSTRAINT FK415C43EF4310FD5 FOREIGN KEY (personnes_id) REFERENCES Personne (id),
  CONSTRAINT FK415C43EFAD3B65F5 FOREIGN KEY (numeros_id) REFERENCES Numero (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ============================================================
--   Jeu d'essai                               
-- ============================================================
insert into Personne values(1,'Jacob','Ismael','1999-05-06'); 
insert into Personne values(2,'Reynaud','Hugo','1997-02-03'); 
insert into Personne values(3,'Blanchard','Kenza','1990-07-08');   
insert into Personne values(4,'Floch','Alain','1988-02-09');  

insert into Personne values(5,'gabin','nisrine','1999-05-06'); 
insert into Personne values(6,'renault','Hugo','1997-02-03'); 
insert into Personne values(7,'boly','manar','1990-07-08');   
insert into Personne values(8,'Floch','Alain','1988-02-09');

insert into Personne values(9,'Blanchard','Kenza','1990-07-08');   
insert into Personne values(10,'Floch','Alain','1988-02-09');
commit;

select * from Personne;



insert into Numero values(1,'0707070707','Mobile'); 
insert into Numero values(2,'0255783669','Domicile'); 
insert into Numero values(3,'0255693652','Pro'); 
insert into Numero values(4,'0604112222','Mobile');  
insert into Numero values(5,'0455693652','Pro'); 
insert into Numero values(6,'0724979230','Mobile');  
insert into Numero values(7,'0601111425','Mobile');  
insert into Numero values(8,'0506251478','Domicile');
insert into Numero values(9,'0332615488','Domicile');
insert into Numero values(10,'0902154854','Pro');
commit;


select * from Numero;


insert into Personne_Numero(personnes_id,numeros_id) values(1,8); 
insert into Personne_Numero(personnes_id,numeros_id) values(1,4); 
insert into Personne_Numero(personnes_id,numeros_id) values(1,10); 
insert into Personne_Numero(personnes_id,numeros_id) values(2,8); 
insert into Personne_Numero(personnes_id,numeros_id) values(2,5); 
insert into Personne_Numero(personnes_id,numeros_id) values(2,7);
insert into Personne_Numero(personnes_id,numeros_id) values(1,3); 
insert into Personne_Numero(personnes_id,numeros_id) values(3,9); 
insert into Personne_Numero(personnes_id,numeros_id) values(3,7); 
insert into Personne_Numero(personnes_id,numeros_id) values(3,3); 
insert into Personne_Numero(personnes_id,numeros_id) values(4,2); 
insert into Personne_Numero(personnes_id,numeros_id) values(4,9); 
insert into Personne_Numero(personnes_id,numeros_id) values(4,6); 
commit;

select * from Personne_Numero;



