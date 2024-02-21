SELECT III.ITEM_ID, III.ITEM_NAME, III.RARITY
FROM ITEM_INFO AS III
WHERE III.ITEM_ID IN (
    SELECT IT.ITEM_ID
    FROM ITEM_INFO AS II
    JOIN ITEM_TREE AS IT
    ON II.ITEM_ID = IT.PARENT_ITEM_ID
    WHERE II.RARITY LIKE 'RARE'
)
ORDER BY III.ITEM_ID DESC;
