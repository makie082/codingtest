SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO,'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME;

-- ifnull(컬럼명, null값일 때 바꿀 단어)를 사용하면 한 방에 변경 가능하다!!!

-- case 문 사용하기
SELECT PT_NAME, PT_NO, GEND_CD, AGE,
    CASE
        WHEN TLNO IS NULL THEN 'NONE'
        ELSE TLNO
    END
AS TLNO
