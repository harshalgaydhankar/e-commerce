USE ecommtest;

TRUNCATE TABLE products;

INSERT INTO `ecommtest`.`products`
(`name`,
`code`,
`description`,
`rating`,
`reviews`,
`list_price`,
`discount`,
`actual_price`,
`quantity`,
`restricted`)
VALUES
('DVD Player',
'007',
'unknown',
5,
10,
10.5,
1,
10.4,
2,
TRUE );

