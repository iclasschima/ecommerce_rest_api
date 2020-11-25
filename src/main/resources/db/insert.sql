set foreign_key_checks = 0;

truncate table customer;
truncate table address;
truncate table customer_addresses;

insert into address (`id`, `city`, `country`, `state`, `street`, `zipcode`)
values (1, "Yaba", "Nigeria", "Lagos", "312 Herbert Macaulay way, Sabo", "100110"),
       (2, "Mushin", "Nigeria", "Lagos", "19 wey street, Mushin", "001001");


insert into customer (`id`, `contact`, `email`, `first_name`, `last_name`, `password`)
values (1, "09031861100", "iclasschima@gmail.com", "iClass", "Chima", "iclass123"),
       (2, "08023237911", "tobifemi@gmail.com", "Femi", "Tobi", "tobi123");


insert into customer_addresses (`customer_id`, `addresses_id`)
values (1, 1),
       (1, 2),
       (2, 2);


set foreign_key_checks = 1;