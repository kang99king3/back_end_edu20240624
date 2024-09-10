/**
 * 쿠키 기능 구현 
 */

//setCookie() 구현 :   setCookie(a,b,c)
	function setCookie(name,value,expires,domain,path,secure){
		var cookies="";
		
		//인코딩처리 3가지
		//escape() : ASCII코드로 변환, 나머지 유니코드 변환 --> 이제 안씀
		//encodeURI(): 주소전체를 인코딩할때 사용
		//             일반 문자는 인코딩처리, 주소와 관련 특수문자는 제외
		//            http://www.hankyung.com/user?id=aa&name=bb
		//encodeURIComponent():모든 문자/특수문자등등을 인코딩 처리함
		//                     파라미터를 처리할때 사용
		// "name=value"
		cookies+=name+"="+encodeURIComponent(value);//인코딩처리해서 저장
		
		var date = new Date();
		date.setDate(date.getDate()+expires);// 2024.08.30 --> 30+5 
		cookies+=";expires="+date.toUTCString();//유효기간설정:세계표준시로 설정
// 		cookies+=";max-age="+(1000*1*60*60*24);// ms단위로 설정
		
		if(domain){
			cookies+=";domain="+domain;
		}
		if(path){
			cookies+=";path="+path;
		}
		if(secure){
			cookies+=";secure="+secure;
		}
		document.cookie=cookies;// 쿠키 저장하기
// 		document.cookie="id=hk;name=hankyung";
// 		document.forms
// 		document.body...
	}
	
	//cookie="user":"hk" 유효기간설정  
	//---->  user라는 이름의 값을 확인해서 상태유지활용
	//원하는 cookie값 가져오는 기능
	//"user=hk;name=kkk"
	function getCookie(cookieName){
		
		return "cookieName에 해당하는 값 리턴";
	}
	
	//cookie 삭제하는 기능: expires 유효기간을 재설정
	function removeCookie(name){
		var date=new Date();
		date.setDate(date.getDate()-1);// 현재날짜의 1일전으로 셋팅->유효기간이 지남
		document.cookie=name+"=;expires="+date.toUTCString();
// 		document.cookie=name+"=;max-age=0";
	}