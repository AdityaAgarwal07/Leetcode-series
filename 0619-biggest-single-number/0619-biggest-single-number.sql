SELECT MAX(CASE WHEN cnt = 1 THEN num END) AS num
FROM (
    SELECT num, COUNT(*) AS cnt
    FROM MyNumbers
    GROUP BY num
) t;