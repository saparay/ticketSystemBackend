insert into Ticket(ID, DATE_OF_CLOSE, DATE_OF_RISE, DESCRIPTION, STATUS, PRIORITY, USERNAME, TICKET_NAME)
values (1001, CURRENT_DATE(), CURRENT_DATE()+2, 'Some Description of Ticket 1', 'CLOSE', 'High', 'saparay', 'Ticket 1');
insert into Ticket(ID, DATE_OF_CLOSE, DATE_OF_RISE, DESCRIPTION, STATUS, PRIORITY, USERNAME, TICKET_NAME)
values (1002, CURRENT_DATE(), CURRENT_DATE(), 'Some Description of Ticket 2', 'OPEN', 'Low', 'saparay', 'Ticket 2');
insert into Ticket(ID, DATE_OF_CLOSE, DATE_OF_RISE, DESCRIPTION, STATUS, PRIORITY, USERNAME, TICKET_NAME)
values (1003, CURRENT_DATE(), CURRENT_DATE(), 'Some Description of Ticket 3', 'OPEN', 'High', 'mani', 'Ticket 3');
insert into Ticket(ID, DATE_OF_CLOSE, DATE_OF_RISE, DESCRIPTION, STATUS, PRIORITY, USERNAME, TICKET_NAME)
values (1004, CURRENT_DATE(), CURRENT_DATE(), 'Some Description of Ticket 4', 'OPEN', 'Medium', 'mani', 'Ticket 4');



insert into USERS(id, full_name, username,email, password, roles )values (3001, 'Mani Chandra', 'saparay','saparay@email.com', '$2a$10$bhmPhbQj4Lg4yY0xJucgbuRYrRMsdosBnO42.JMWA16NDYtiP78d.', 'ROLE_ADMIN');
insert into USERS(id, full_name, username,email, password, roles )values (3002, 'Ajay Chandra', 'ajay','ajay@email.com', '$2a$10$bhmPhbQj4Lg4yY0xJucgbuRYrRMsdosBnO42.JMWA16NDYtiP78d.', 'ROLE_LEAD');
insert into USERS(id, full_name, username,email, password, roles )values (3003, 'Chandra', 'mani','mani@email.com', '$2a$10$0kiqtC/UaVjoxOHdVpOQDekYNYXTxs0OHeL4T1XxlsM8S7RZ5Obzm', 'ROLE_MEMBER');


insert into WORK_NOTES (ID, WORK_NOTE, WORK_TIME, TICKET_ID ) values (2001, 'some work note 1', CURRENT_TIME(), 1001);
insert into WORK_NOTES (ID, WORK_NOTE, WORK_TIME, TICKET_ID ) values (2002, 'some work note 1', CURRENT_TIME(), 1002);
insert into WORK_NOTES (ID, WORK_NOTE, WORK_TIME, TICKET_ID ) values (2003, 'some work note 1', CURRENT_TIME(), 1003);
insert into WORK_NOTES (ID, WORK_NOTE, WORK_TIME, TICKET_ID ) values (2004, 'some work note 1', CURRENT_TIME(), 1004);


