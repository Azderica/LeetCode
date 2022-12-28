
/* Write your T-SQL query statement below */
SELECT city_id, day, degree
FROM (
    SELECT *, ROW_NUMBER() OVER(PARTITION BY city_id ORDER BY degree DESC, day ASC) AS level
    FROM Weather
) AS temp
WHERE level = 1;