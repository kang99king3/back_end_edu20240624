-- 2024-07-31
-- testsqldb
INSERT INTO table1
VALUES (NULL,'test3',SYSDATE());

INSERT INTO table2
VALUES (NULL,'test1',4);

-- sqldb 데이터베이스
SELECT * 
FROM buytbl;

SELECT *
FROM usertbl;

SELECT * 
FROM usertbl
WHERE NAME='김경호';

-- 관계연산자 사용하기
-- <, >, <=, >=, <>, !=
SELECT userID, NAME , birthyear, height
FROM usertbl
WHERE birthyear >= 1970 AND height >= 182 ;

SELECT userID, NAME , birthyear, height
FROM usertbl
WHERE birthyear >= 1970 OR height >= 182 ;

-- 연속된 데이터의 범위로 검색 
-- between A and B    A~B사이에 값에 해당되면 조회
SELECT *
FROM usertbl
where height BETWEEN 180 AND 183;

-- 일치하는 데이터를 조회
-- in(A,B,C)
SELECT *
FROM usertbl
WHERE addr IN('경남','전남','경북');
-- WHERE addr = '경남' OR addr = '전남'..

-- 문자열 검색 
-- _, %    '_종신', '_종%' , '종%'  ---> _ , % 를 앞에 쓰면 성능 저하될 여지가 있다
SELECT *
FROM usertbl
WHERE NAME LIKE '_종신';

SELECT *
FROM usertbl
WHERE NAME LIKE '김%';

-- 실습1 scott 
-- Q1) 사원 테이블(EMP)의 모든 데이터를 출력하자.
	SELECT * 
	FROM emp;
-- Q2) 사원 테이블에서 사원의 이름(ENAME), 사원의 번호(EMPNO), 월급(SAL)을 출력하자.
   SELECT ename, empno, sal 
   FROM emp ;
   
-- Q3) 사원 테이블에서 사원의 이름과 연봉을 출력하자.
   SELECT ename, sal*12 AS 'sal year'
   FROM emp;
-- Q4) 사원의 이름, 입사일(HIREDATE), 부서번호(DEPTNO)를 출력하자.
   SELECT ename, hiredate, deptno
   FROM emp;
-- Q5) 사원의 이름과, 사원을 관리하고있는 관리자(MGR)를 출력하자.
   SELECT ename, mgr
   FROM emp;
-- Q6) 부서 테이블(DEPT)의 모든 데이터를 출력하자.
    SELECT *
   FROM dept;
-- Q7) 부서 테이블의 구조를 보자
   DESC dept;
   SHOW TABLES;
   
-- Q8) 사원 테이블에서 사원의 이름, 월급, 커미션(COMM)을 출력하자.
	SELECT ename, sal, comm
	FROM emp;
-- Q9) 사원 테이블의 모든 데이터를 "OO님이 0000-00-00에 입사를 하고 OO의 월급을 받습니다." 형식인 하나의 컬럼으로 출력하자.
	SELECT CONCAT(ename,'님이',hiredate,'에 입사를 하고 ',sal,'의 월급을 받습니다.') 
	       AS '급여지급현황'
	FROM emp;

-- 2024-08-01

-- 실습2 scott
-- 2. Select ~ from~where 사용하기

-- Q1) 사원테이블에서 사원번호가 '7844' 인 
--     사원의 사원번호, 이름, 월급을 출력하자.
     SELECT empno, ename, sal
     FROM emp
     WHERE empno = 7844;
-- Q2) 사원테이블에서 'SMITH'의 사원번호, 이름, 월급을 출력하자.
	  SELECT empno, ename, sal
     FROM emp
     WHERE ename = 'SMITH';
-- Q3) 사원테이블에서 입사일이 1980년 12월 17일인 사원의 
--     모든 데이터를 출력하자.
	  DESC emp;
	  -- 날짜형식 'yyyy-MM-dd hh:mm:ss'
	  SELECT *
	  FROM emp
	  WHERE hiredate = '1980-12-17';
--	  WHERE hiredate = '1980/12/17';
-- Q4) 1980년도에서 1982년도 사이에 입사한 사원의 이름과 입사일을 출력하자.
 		SELECT ename, hiredate
	   FROM emp
--	   WHERE hiredate BETWEEN '1980-01-01' AND '1982-12-31'; 
	   WHERE hiredate >= '1980-01-01' AND hiredate <= '1982-12-31';
-- Q5) 월급이 2000 이하인 사원의 이름과 월급을 출력하자.
      SELECT ename, sal
      FROM emp
      WHERE sal <= 2000;
-- Q6) 월급이 1000에서 2000 사이인 사원의 이름과 월급을 출력하자.
		SELECT ename, sal
		FROM emp
		WHERE sal BETWEEN 1000 AND 2000;
-- Q7) 사원번호가 7369, 7499, 7521인 사원들의 이름과 월급을 출력하자.
		SELECT empno, ename, sal
		FROM emp
		WHERE empno IN (7369,7499,7521);
		
-- 교재 ( sqldb: usertbl, buytbl)
SELECT NAME , height
FROM usertbl
WHERE height > 177; 

-- 서브쿼리로 작성: 김경호의 키 구하기
SELECT NAME , height
FROM usertbl
WHERE height > (SELECT height FROM usertbl WHERE NAME='김경호');	
	
-- 서브쿼리의 결과가 2개 이상 반환할 경우
-- any, some, all 	
SELECT NAME , height
FROM usertbl
WHERE height >= ANY (SELECT height
					 FROM usertbl
					 WHERE addr = '경남');
-- WHERE height >= 170, 173; -- 관계연산자 문법상 오류
SELECT NAME , height
FROM usertbl
WHERE height >= ALL (SELECT height
					 FROM usertbl
					 WHERE addr = '경남');

-- 서브쿼리 이용해서 인라인 뷰를 정의할 수 있다.
SELECT *
FROM (SELECT NAME, height
      FROM usertbl) AS a ;
      
-- 실습3 scott      
-- 3. 서브쿼리(1) 사용하기

-- 01. 부서번호가 10번인 사원들과 
-- 같은 월급을 받는 사원의 이름과 월급을 출력하자.
	SELECT ename, sal, deptno
	FROM emp 
	WHERE sal = ANY (
					SELECT sal
					FROM emp
					WHERE deptno = 10);
					
	SELECT ename, sal, deptno
	FROM emp 
	WHERE sal in (
					SELECT sal
					FROM emp
					WHERE deptno = 10);
-- 02. 직업이 'CLERK'인 사원과 같은 부서에서 근무하는 사원의 
-- 이름과 월급, 부서번호를 출력하자.

	SELECT ename, sal, deptno
	FROM emp 
	WHERE deptno = any(SELECT deptno
							FROM emp
							WHERE job = 'CLERK');
							
-- 03. 'CHICAGO'에서 근무하는 사원들과 같은 부서에서 근무하는 
-- 사원의 이름과 월급을 출력하자.
	SELECT ename, sal
	FROM emp
	WHERE deptno =(SELECT deptno
						FROM dept
						WHERE loc = 'CHICAGO');

-- 04. 부하직원이 있는 사원의 사원번호와 이름을 출력하자. 
-- 자기 자신이 다른 사원의 관리자인 사원)
SELECT empno, ename
FROM emp
WHERE empno IN (
					SELECT mgr
					FROM emp ); 
					
-- 05. 부하직원이 없는 사원의 사원번호와 이름을 출력하자.
-- NVL(컬럼,지정값): 해당 컬럼의 값들 중에 null을 찾아서 지정한 값으로 대체  
-- null 비교할때는 is null, is not null 연산자를 사용해서 비교한다.
	SELECT empno, ename
	FROM emp
	WHERE empno NOT IN 
							(SELECT nvl(mgr,0)
							FROM emp);

	SELECT empno, ename
	FROM emp
	WHERE empno != ALL (SELECT nvl(mgr,0)
							FROM emp);
-- 06. 'KING'에게 보고하는 사원의 이름과 월급을 출력하자. 
-- (관리자가 'KING'인 사원)
	SELECT ename, sal
	FROM emp 
	WHERE mgr in
				(SELECT empno
				FROM emp
				WHERE ename = 'KING');

-- 07. 20번 부서의 사원 중 가장 많은 월급을 받는 사원보다 
-- 더 많은 월급을 받는 사원들의 이름과 월급을 출력하자.
-- 단, MAX함수를 사용하지 말자.(ANY, ALL 연산자)
	SELECT ename, sal
	FROM emp 
	WHERE sal > ALL 
					(SELECT  sal
					FROM emp
					WHERE deptno = 20);
	
-- 08. 직업이 'SALESMAN' 인 사원중 가장 큰 월급을 받는 사원보다 
-- 더 많은 월급을 받는 사원들의 이름과 월급을 출력하자.
-- 단, MAX함수를 사용하지 말자.(ANY, ALL 연산자)
	SELECT ename, sal
	FROM emp
	WHERE sal > ALL (SELECT sal
						  from emp
						  WHERE job = 'SALESMAN');


-- 정렬 : 오름차순 asc, 내림차순 desc   
-- order by 절 
SELECT NAME, mdate 
FROM usertbl 
ORDER BY mdate desc; -- 기본 오름차순 정렬 -> 생략 가능

-- 정렬할 경우 여러 컬럼으로 정의 할 수 있다.
SELECT NAME, height
FROM usertbl
ORDER BY height DESC, NAME ASC; 

-- 중복제거 : DISTINCT 
SELECT DISTINCT addr 
FROM usertbl;

-- 출력개수를 제한하는 LIMIT
SELECT emp_no, hire_date
FROM employees
ORDER BY hire_date ASC
LIMIT 5;

-- 테이블 복사하기 (서브쿼리 활용)
CREATE TABLE buytbl2 (SELECT * FROM buytbl);  
SELECT * FROM buytbl2;

-- group by 절 : 컬럼의 데이터들을 그룹화시켜주는 기능
SELECT userid, SUM(amount) AS '총 구매 개수'
FROM buytbl 
GROUP BY userid
ORDER BY userid;

SELECT userid, SUM(price*amount) AS '총 구매액'
FROM buytbl 
GROUP BY userid;

-- 집계함수 
SELECT userid, AVG(amount) AS '평균 구매 개수'
FROM buytbl
GROUP BY userid;

SELECT NAME, MAX(height), MIN(height)
FROM usertbl
GROUP BY NAME;

SELECT NAME, height
FROM usertbl
WHERE height = (SELECT MAX(height) FROM usertbl)
   OR height = (SELECT MIN(height) FROM usertbl);

SELECT COUNT(*) FROM usertbl;

SELECT COUNT(mobile1) AS '휴대폰이 있는 사용자'
FROM usertbl;

-- having절 : 집계함수를 활용한 조건식을 작성할 경우
SELECT userid AS '사용자', SUM(price*amount) AS '총구매액'
FROM buytbl
-- WHERE SUM(price*amount) > 1000
GROUP BY userid
HAVING SUM(price*amount) > 1000;-- group by 절 다음에 작성한다.

-- 08/02
-- 4. 서브쿼리(2) 사용하기

-- 01. 'SMITH'보다 월급을 많이 받는 사원들의 
-- 이름과 월급을 출력하자.

SELECT ename, sal
FROM emp 
WHERE sal >
			(SELECT sal
			FROM emp 
			WHERE ename = 'SMITH');

-- 02. 10번 부서의 사원들과 같은 월급을 받는 사원들의 
-- 이름, 월급, 부서번호를 출력하자.

SELECT ename, sal, deptno
FROM emp
WHERE sal IN 
				(SELECT sal
				FROM emp 
				WHERE deptno = 10);
-- 03. 'BLAKE'가 근무하는 부서의 위치(LOC)를 출력하자.
SELECT loc
FROM dept
WHERE deptno IN 
					(SELECT deptno
					FROM emp
					WHERE ename = 'BLAKE');
-- 04. 총 사원의 평균월급보다 더 많은 월급을 받는 
-- 사원들의 사원번호, 이름, 월급을 출력하되, 
-- 월급이 높은 사람 순으로 출력하자.
SELECT empno, ename, sal
FROM emp
WHERE sal >
			(SELECT AVG(sal)
			FROM emp)
ORDER BY sal DESC;
-- 05. 이름에 'T'를 포함하고 있는 사원들의 이름을 출력하자.
SELECT ename
FROM emp
WHERE ename LIKE '%T%';

-- 06. 20번 부서에 있는 사원들 중 
-- 가장 많은 월급을 받는 사원보다 
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하자.
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT max(sal)
				FROM emp 
				WHERE deptno = 20);
				
SELECT ename, sal, deptno
FROM emp
WHERE sal > ALL (SELECT sal
				FROM emp 
				WHERE deptno = 20);
-- 07. 'DALLAS'에서 근무하고 있는 사원과 
-- 같은 부서에서 일하는 사원의 이름, 부서번호, 직업을 출력하자.
SELECT ename, deptno, job
FROM emp
WHERE deptno IN (SELECT deptno
						FROM dept
						WHERE loc = 'DALLAS');

-- 08. 이름에 'S'가 들어가는 사원과 동일한 부서에서 근무하는 사원 중, 
-- 자신의 급여가 평균 급여보다 많은 사원들의 
-- 사원번호, 이름, 급여를 출력하자.
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN (SELECT deptno
					FROM emp
					WHERE ename LIKE '%S%')
AND sal > (SELECT AVG(sal)
			  FROM emp);
-- 09. 사원번호가 7369 인 사원과 같은 직업이고, 
-- 월급이 7876보다 많은 사원의 
-- 이름과 직업을 출력하자.
SELECT ename, job, sal
FROM emp
WHERE job IN (SELECT job
				  FROM emp
				  WHERE empno = 7369)
AND sal > (SELECT sal
			  FROM emp 
			  WHERE empno = 7876);

-- 5.연습문제  order by, 집계합수, group by절 사용하기

-- Q1) 사원테이블에서 사원 이름과 월급을 구하되, 월급을 내림차순으로 출력하자.
SELECT ename, sal
FROM emp
ORDER BY sal DESC;

-- Q2) 사원테이블에서 직업별 평균 월급을 출력하되 컬럼 ALIAS를 '평균' 으로 하고, 
--     평균 월급이 높은 순으로 정렬하자.
SELECT job, AVG(sal) AS '평균'
FROM emp
GROUP BY job
ORDER BY 평균 desc;

-- Q3) 사원테이블에서 직업별 총 월급을 구하고, 총 월급이 5000 이상인 것만 출력하자.
SELECT job, SUM(sal)
FROM emp 
GROUP BY job
HAVING SUM(sal) >= 5000;

-- Q4) 사원테이블에서 부서별 월급의 합을 구하고, 그 총합이 1000 이상인 것만 출력하자.
SELECT deptno, SUM(sal) AS '총합'
FROM emp
GROUP BY deptno
HAVING SUM(sal) >= 1000
ORDER BY 총합 DESC ;

-- 6.연습문제  create문 서브쿼리를 활용한 테이블 복사하기 

-- Q1) SIZE가 10인 문자형 컬럼 ID와 PW를 가진 TEST 테이블을 생성해보자
-- (create 기본 문법으로 테이블 생성하기: 교재등을 참고하여 만들기)
	CREATE TABLE test (
	 	id VARCHAR(10),
		pw VARCHAR(10)
	);
-- Q2) 사원 테이블(EMP)의 모든 구조와 데이터를 TEST01로 복사하여 생성해보자.
	CREATE TABLE test01 (SELECT * FROM emp );

-- Q3) 사원 테이블에서 사원의 번호와 이름을 TEST02로 복사하여 생성해보자.
	CREATE TABLE test02 (SELECT empno,ename FROM emp );

-- Q4) 사원 테이블에서 사원의 번호와 이름을 TEST03으로 복사하여 생성해보자.
-- 단, 컬럼명을 M1, M2로 변경하면서 복사하자.
	CREATE TABLE test03 (SELECT empno AS 'M1' ,ename AS 'M2' FROM emp );

-- Q5) 사원 테이블의 구조만 TEST04로 복사하여 생성해보자.
   CREATE TABLE test04 (SELECT * FROM emp WHERE 1=2);

-- Q6) 부서 테이블(DEPT) 의 구조만 TEST05로 복사하여 생성해보자.
	CREATE TABLE test05 (SELECT * FROM dept WHERE 1=2);


-- DML: insert, update, delete, select
-- insert문 

CREATE TABLE testtbl1 (id INT, username CHAR(3), age INT);
SELECT * FROM testtbl1;

-- 컬럼순서랑 맞춰야 됨, 컬럼명 생략 가능
INSERT INTO testtbl1 VALUES(1, '홍길동',25);
-- 컬럼명을 직접 설정할 수 도 있음
INSERT INTO testtbl1 (username,id) VALUES('설현',2);

CREATE TABLE testtbl2 (
	id INT AUTO_INCREMENT PRIMARY KEY   -- not null, unique
	,username CHAR(3),
	age int
);

INSERT INTO testtbl2 VALUES(NULL,'지민',25);
INSERT INTO testtbl2 VALUES(NULL,'유나',25);
INSERT INTO testtbl2 VALUES(NULL,'유경',25);

SELECT * FROM testtbl2;

SELECT LAST_INSERT_ID();

-- increment의 초기값 수정하기
ALTER TABLE testtbl2 AUTO_INCREMENT=100; 
INSERT INTO testtbl2 VALUES(NULL,'찬미',25);

SET @@auto_increment_increment=3;

INSERT INTO testtbl2 VALUES(NULL,'찬미2',25)
								  ,(NULL,'찬미2',25)
							     ,(NULL,'찬미3',25)
								  ,(NULL,'찬미4',25);

CREATE TABLE testTBL4 
(id INT, fname VARCHAR(50), lname VARCHAR(50));

INSERT INTO testtbl4
	SELECT emp_no, first_name, last_name
	FROM employees.employees; -- 다른 데이터베이스에 접근 가능

-- update문  수정하기
UPDATE testtbl4
SET lname = '없음'
WHERE fname = 'Kyoichi';

SELECT *
FROM testtbl4
WHERE fname = 'Kyoichi';

-- delete문 삭제기능
DELETE FROM testtbl4
WHERE fname = 'Aamer' LIMIT 5;

-- 변수사용
SELECT @myVar1 ;


SET @myVar1 = 3;
PREPARE myQuery
	FROM 'select name, height from usertbl order by height limit ?';
EXECUTE myQuery USING @myVar1 ;	


SET @myVar2 = 177;
PREPARE myQuery
	FROM 'select name, height from usertbl where height = ?';
EXECUTE myQuery USING @myVar2 ;

SET @myVar3 = 177;
select name, height from usertbl where height = @myVar3;

-- 순위 함수 4가지
-- 단순히 행에 번호를 부여한다.
SELECT ROW_NUMBER() over(ORDER BY height DESC) "키큰순위"
,NAME, addr, height
FROM usertbl;

-- 지역별로 구분해서 번호를 부여할 수 있다.
SELECT ROW_NUMBER() over(PARTITION BY addr ORDER BY height DESC) "키큰순위"
,NAME, addr, height
FROM usertbl;

-- dense_rank()
SELECT dense_rank() over(ORDER BY height DESC) "키큰순위"
,NAME, addr, height
FROM usertbl;
-- rank()
SELECT rank() over(ORDER BY height DESC) "키큰순위"
,NAME, addr, height
FROM usertbl;
-- NTILE()
SELECT NTILE(3) over(ORDER BY height DESC) "키큰순위"
,NAME, addr, height
FROM usertbl;

-- 9.실습 문제 
-- 9. 함수 이용하기(내장함수)

-- Q1) 사원 테이블에서 사원이름을 첫글자는 대문자로, 
-- 나머지는 소문자로 출력하자.

SELECT empno, 
      CONCAT(
	       upper(LEFT(ename,1)),
	       LOWER(RIGHT(ename,CHAR_LENGTH(ename)-1))
       ) AS 'ename'
FROM emp;

-- Q2) 사원테이블에서 사원이름을 출력하고, 
-- 이름의 두번째 글자부터 네번째 글자까지 출력하자.
SELECT ename, SUBSTRING(ename,2,3) AS '컬럼'
FROM emp;
-- Q3) 사원테이블에서 각 사원 이름의 철자 개수를 출력하자.
SELECT ename,CHAR_LENGTH(ename) '철자개수'
FROM emp;
-- Q4) 사원테이블에서 각 사원 이름의 앞 글자 하나와
--     마지막 글자 하나만 출력하되, 소문자로 출력하라.
SELECT ename, lower(LEFT(ename,1)) '컬럼1',
              lower(RIGHT(ename,1)) '컬럼2'
FROM emp ;


-- Q5) 3456.78을 소수점 첫번째 자리에서 반올림해서 출력하자.
SET @num = 3456.78;
SELECT ROUND(@num);

-- Q6) 사원테이블에서 사원이름과 
--     근무일수(고용일 ~ 현재 날짜)를 출력하자. 
SELECT ename, DATEDIFF(CURDATE(),hiredate) AS '근무일수'
FROM emp ;

-- Q7) 위 문제에서 근무일수를 '00년 00개월 00일' 형식으로 출력하자. (한달을 30일로 계산)
-- 예)
--  ENAME  |  근무일수
--  -------------------------------
--  KING     |  00년 00개월 00일

SELECT ename,
      CONCAT(
       FLOOR(DATEDIFF(CURDATE(),hiredate)/365),'년',
       floor(mod(DATEDIFF(CURDATE(),hiredate),365)/30),'월',
       mod(mod(DATEDIFF(CURDATE(),hiredate),365),30),'일'
       ) AS '근무일수'
FROM emp;





