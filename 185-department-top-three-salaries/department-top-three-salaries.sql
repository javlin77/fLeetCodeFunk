# Write your MySQL query statement below
select d.name as Department, e1.name as Employee, e1.salary as Salary from Employee e1 
LEFT JOIN Department d on e1.departmentId=d.id
WHERE (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee e2
    WHERE e2.departmentId = e1.departmentId
    AND e2.salary > e1.salary
)<3; 
-- greater salary count 2 