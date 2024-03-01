-- 코드를 입력하세요
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE * O.AMOUNT)
FROM FOOD_PRODUCT P
LEFT JOIN FOOD_ORDER O
ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE MONTH(O.PRODUCE_DATE) = 5 and YEAR(O.PRODUCE_DATE) = 2022
GROUP BY P.PRODUCT_ID
ORDER BY SUM(P.PRICE * O.AMOUNT) DESC, P.PRODUCT_ID