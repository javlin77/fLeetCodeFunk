SELECT
    IF(
        MOD(id, 2) = 1
        AND id = (SELECT COUNT(*) FROM Seat),

        id,

        IF(MOD(id, 2) = 1, id + 1, id - 1)
    ) AS id,

    student

FROM Seat
ORDER BY id;