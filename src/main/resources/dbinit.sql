drop table userroles;
drop table roles;
drop table users;

create table users
(
    id   serial primary key,
    name varchar(50) unique
);

create table roles
(
    id   serial primary key,
    name varchar(50) unique
);

create table userroles
(
    user_id integer,
    role_id integer,
    primary key (user_id, role_id)
);

insert into users(name)
values ('admin');
insert into users(name)
values ('user');
insert into users(name)
values ('reports');
insert into users(name)
values ('test');

insert into roles(name)
values ('user');
insert into roles(name)
values ('admin');
insert into roles(name)
values ('reports');

insert into userroles(user_id, role_id)
values (1, 1);
insert into userroles(user_id, role_id)
values (1, 2);
insert into userroles(user_id, role_id)
values (1, 3);
insert into userroles(user_id, role_id)
values (2, 1);
insert into userroles(user_id, role_id)
values (2, 3);
insert into userroles(user_id, role_id)
values (3, 3);
insert into userroles(user_id, role_id)
values (4, 3);


select *
from users u
         left join userroles ur on u.id = ur.user_id
         left join roles r on r.id = ur.role_id;

select id, concat('[', name, ']')
from users;

select *
from roles;
select *
from userroles;

delete
from userroles
where user_id = 12
  and role_id = 1;



select user0_.id as id1_2_, user0_.name as name2_2_
from users user0_
where user0_.name = 'test';





