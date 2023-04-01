-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
SELECT COUNT(*)
FROM USER_INFO
WHERE YEAR(JOINED) = 2021 AND (AGE <= 29 AND AGE >= 20)