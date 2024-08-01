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






