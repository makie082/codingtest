SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, "%Y-%m-%d")
FROM USED_GOODS_BOARD B JOIN USED_GOODS_REPLY R ON B.BOARD_ID = R.BOARD_ID
WHERE YEAR(B.CREATED_DATE) = 2022 AND MONTH(B.CREATED_DATE) = 10
ORDER BY R.CREATED_DATE, B.TITLE;

-- WHERE SUBSTR(B.CREATED_DATE,1,7) = '2022-10'
-- WHERE DATE_FORMAT(B.CREATED_DATE, '%Y-%m') = '2022-10'
-- 으로도 표시 가능하다!

