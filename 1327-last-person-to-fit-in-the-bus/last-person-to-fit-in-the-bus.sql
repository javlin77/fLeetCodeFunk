# Write your MySQL query statement below
SELECT q1.person_name
FROM Queue q1
JOIN Queue q2
ON q2.turn <= q1.turn
GROUP BY q1.turn, q1.person_name, q1.person_id
HAVING SUM(q2.weight) <= 1000
ORDER BY q1.turn DESC
LIMIT 1;