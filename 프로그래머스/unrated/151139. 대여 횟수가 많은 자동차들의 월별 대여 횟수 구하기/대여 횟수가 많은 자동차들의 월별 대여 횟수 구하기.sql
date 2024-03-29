-- 코드를 입력하세요
# SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) as RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE CAR_ID IN (
#     SELECT car_id
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE START_DATE >= DATE('2022-08-01') AND START_DATE <= DATE('2022-10-31') 
#     GROUP BY car_id
#     HAVING COUNT(car_id) >= 5
# )
# GROUP BY MONTH, CAR_ID
# order by MONTH, CAR_ID desc



SELECT MONTH(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS

from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID in (select distinct CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by CAR_ID
    having count(HISTORY_ID) >= 5) and  START_DATE between '2022-08-01' and '2022-10-31'

group by MONTH, CAR_ID
order by MONTH, CAR_ID desc