SELECT
    IF(
        id = (SELECT MAX(id) FROM seat) AND MOD(id, 2) = 1,
        
        id,
        
        IF(MOD(id, 2) = 1, id + 1, id - 1)
    ) AS id,
    
    student

FROM seat
ORDER BY id;