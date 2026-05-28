# Write your MySQL query statement below
select u.name,SUM(t.amount) as balance from Transactions t LEFT JOIN Users u
using (account)
GROUP BY u.name
HAVING balance > 10000;