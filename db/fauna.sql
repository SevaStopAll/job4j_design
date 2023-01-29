SELECT * from fauna WHERE name LIKE '%fish%';
SELECT * from fauna WHERE avg_age < 21000 AND avg_age > 10000;
SELECT * from fauna WHERE discovery_date IS NULL;
SELECT * from fauna WHERE discovery_date < '01.01.1950';