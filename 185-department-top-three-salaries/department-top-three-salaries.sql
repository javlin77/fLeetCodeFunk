/* Write your T-SQL query statement below */
--ms sql server
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM
    Department d
    JOIN Employee e ON d.id = e.departmentId
WHERE
    e.salary IN (
        SELECT DISTINCT TOP 3 salary
        FROM Employee e2
        WHERE e2.departmentId = d.id
        ORDER BY salary DESC
    )
ORDER BY
    Department, Salary DESC;
	