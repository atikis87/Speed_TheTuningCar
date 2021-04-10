/*
*SQL DATABASE
*/
CREATE DATABASE tuningcarmanagement;
USE tuningcarmanagement;

/*
 * TABLES
 */

/* 
 * CAR TABLE
 */
CREATE  TABLE tuningcar(registrationNumber VARCHAR(50) PRIMARY KEY, brand VARCHAR(50), model VARCHAR(50), price DOUBLE);

/*
 * CLIENT TABLE
 */

CREATE TABLE client(CIN VARCHAR(50) PRIMARY KEY, firstName VARCHAR(50),lastName VARCHAR(50));

/*
 * RENT TABLE
 */
CREATE TABLE rentingcar(rentID INT PRIMARY KEY AUTO_INCREMENT, registrationNumber VARCHAR(50), CIN VARCHAR(50), isReturned BIT, rentalDate DATE, returnDate DATE);

/*
 * CLIENTS
 */

INSERT INTO client VALUES ('A001', 'Attila','Kiss');
INSERT INTO client VALUES ('A002', 'Brian', 'O,Conner');
INSERT INTO client VALUES ('A003', 'Mia','Toretto');
INSERT INTO client VALUES ('A004', 'Letti','Ortiz');
INSERT INTO client VALUES ('A005', 'Roman','Pearce');
INSERT INTO client VALUES ('A006', 'Luke','Hobbs ');
INSERT INTO client VALUES ('A007', 'Giselle','Jashar ');
INSERT INTO client VALUES ('A008', 'Scarlett','Johansson');
INSERT INTO client VALUES ('A009', 'Jashon', 'Statham');
INSERT INTO client VALUES ('A010', 'Robert', 'Downey Jr');
INSERT INTO client VALUES ('A011', 'Dominik', 'Toretto');
INSERT INTO client VALUES ('A012', 'Jim', 'Carry');
INSERT INTO client VALUES ('A013', 'Tom', 'Cruise');


/* 
 * CAR DETAILS
 */
insert into tuningcar values ('Z85P385', 'Audi', 'TT', 63890);
insert into tuningcar values ('Z95P385', 'Nissan', 'Skyline GT-R', 108900);
insert into tuningcar values ('A85P345', 'Chevrolet', 'Corvette', 31599);
insert into tuningcar values ('YK12974', 'Infiniti', 'G35', 62777);
insert into tuningcar values ('SL12697', 'Chevrolet', 'Corvette', 74999);
insert into tuningcar values ('KDG1578', 'Mazda', 'Miata', 89595);
insert into tuningcar values ('MFS6723', 'Subaru', 'Impreza WRX', 10590);
insert into tuningcar values ('NFM4879', 'Dodge', 'Viper', 38825);
insert into tuningcar values ('BDX2367', 'Lexus', ' IS300', 5995);
insert into tuningcar values ('NXJ3215', 'Ford', 'Mustang', 47440);
insert into tuningcar values ('KST4512', 'Volkswagen', 'GTi', 3495);
insert into tuningcar values ('MQN1459', 'Pontiac', 'Fiero GT', 46355);
insert into tuningcar values ('LST5479', 'Honda', 'Odyssey', 34895);
insert into tuningcar values ('MPZ1235', 'Mercury', 'Marauder', 119999);
insert into tuningcar values ('PEY9876', 'Hyundai', 'Azera', 27950);
insert into tuningcar values ('NDG4587', 'Honda', 'S2000', 44995);
insert into tuningcar values ('MSG4578', 'Dodge', 'Neon SRT-4', 30545);
insert into tuningcar values ('MAH1358', 'Mitsubishi', 'Eclipse', 91675);
insert into tuningcar values ('QMT1458', 'Acura', 'Integra', 37497);
insert into tuningcar values ('MST2548', 'Kia', 'Seed', 25988);
insert into tuningcar values ('NVHF458', 'Ferrari', ' FXX', 89350);
insert into tuningcar values ('DRST753', 'Bugatti', 'Veyron', 61321);
insert into tuningcar values ('MK15DH9', 'Mitsubishi', 'Lancer Evolution IX', 42500);
insert into tuningcar values ('MG98P2P', 'Mazda', 'RX-8', 27988);
insert into tuningcar values ('QSZD654', 'Nissan', 'Z-car', 86900);
insert into tuningcar values ('OIRZ325', 'Mercury', 'Mariner', 30995);
insert into tuningcar values ('PLKD987', 'Mazda', 'Miata', 32930);
insert into tuningcar values ('ML658PS', 'Mitsubishi', '3000GT', 31995);
insert into tuningcar values ('KFS6A21', 'Nissan', 'Silvia', 36777);
insert into tuningcar values ('NBWC987', 'Chevrolet', 'Camaro', 17500);
insert into tuningcar values ('MPAT147', 'Plymouth', 'Voyager', 9995);
insert into tuningcar values ('POIU986', 'Pontiac', 'Firebird', 39999);
insert into tuningcar values ('MDGR458', 'Porche', '911 GT3', 399999);
insert into tuningcar values ('15HG6AR', 'Honda', ' accord type r', 35999);
insert into tuningcar values ('PKR67H6', 'Suzuki', 'Swift', 27499);
insert into tuningcar values ('SGAN88S', 'McLaren', 'Senna', 21530);
insert into tuningcar values ('1233SFW', 'Subaru', 'WRX/STI', 34999);
insert into tuningcar values ('X15P98A', 'Acura', 'RSX', 470004);
insert into tuningcar values ('LQ515DK', 'Suzuki', 'XL-7', 25880);
insert into tuningcar values ('MD58VC8', 'Toyota', 'AE86', 99999);
insert into tuningcar values ('KDTO875', 'Volkswagen', 'R32', 51274);
insert into tuningcar values ('MZPH558', 'Nissan', 'Sentra SE-R', 45845);