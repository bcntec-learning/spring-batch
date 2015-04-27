drop table if exists products;

create table products
(
  id character(9) not null,
  type character(10),
  name character varying(50),
  description character varying(255),
  price float,
  update_timestamp timestamp,
  constraint products_pkey primary key (id)
);

