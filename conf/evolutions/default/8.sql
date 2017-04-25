# --- !Ups
alter table usuario add column papel enum('CLIENTE', 'ADMIN');
update usuario set papel = 'CLIENTE';
update usuario set papel = 'ADMIN' where admin = true;
alter table usuario drop column admin;
# --- !Downs
alter table usuario add column admin bit(1);
update usuario set admin = false;
update usuario set admin = true where papel = 'ADMIN';
alter table usuario drop column papel;