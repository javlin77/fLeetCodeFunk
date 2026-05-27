# Write your MySQL query statement below

SELECT
    ROUND(
        COUNT(DISTINCT a1.player_id) /
        (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2) AS fraction
FROM Activity a1
JOIN (
    SELECT
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) a2
ON a1.player_id = a2.player_id
AND DATE_SUB(a1.event_date, INTERVAL 1 DAY) = a2.first_login;