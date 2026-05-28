SELECT name
FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT sales_id
    FROM Orders o
    JOIN Company c
    USING(com_id)
    WHERE c.name = 'RED'
);