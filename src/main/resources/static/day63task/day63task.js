    function 등록함수(){
    // 1. HTML로부터 INPUT 마크업 DOM 객체 가져오기
    const contInput = document.querySelector('.contInput');
    // 2. 가져온 DOM객체의 VALUE 속성 가져온다.
    const 할일내용 = contInput.value;
    // 3. 할일 객체 구성한다.
    const 할일 = {
        tcontent : 할일내용 , tstatus : false
    };

    const option = {
        method : 'POST' , 
        headers : {"Content-Type" : "application/JSON"} ,
        body : JSON.stringify(할일)
    }

    fetch("/sign.do" , option)
        .then(r => r.json())
        .then(d => {console.log(d);
            if(d == true) {    
                alert('[할일 등록 되었습니다.]');
                contInput.value = ``;
                출력함수();
                return;
            } else {alert("등록 실패.")}
        }) 
} // f end

// [4 R] 출력함수 정의 ,
// 사용처 : JS가 실행될때 JS에서 최초1번실행 , 등록/수정/삭제 성공 했을때 , 매개변수 : X , 반환값 : X
출력함수()
function 출력함수(){
    const option = {
        method : 'GET' , 
        headers : {"Content-Type" : "application/JSON"} ,
    }
    fetch("/list.do" , option)
        .then(r => r.json())
        .then(d => {console.log(d);
            // 1. HTML로부터 DIV 마크업 DOM 객체 가져오기
    const todoBottom = document.querySelector('.todoBottom');
    // 2. 출력할 HTML문자열 구성하기
    let HTML = '';
        // (1) 할일목록(배열)내 모든 요소를 하나씩 HTML문자열 만들기
        for( let index = 0 ; index <= d.length - 1 ; index++ ){
            // - index는 0부터 배열내 마지막인덱스까지 1씩 증가 반복
            const 할일 = d[index]; //- index번째의 객체 꺼내기
            HTML += `<div class="contBox ${ 할일.tstatus ? 'success' : '' }">
                        <div class="cont"> ${ 할일.tcontent } </div>
                        <div class="contBtns">
                            <button onclick="수정함수( ${ 할일.tno } )" class="updateBtn"> 수정 </button>
                            <button onclick="삭제함수( ${ 할일.tno } )" class="deleteBtn"> 삭제 </button>
                        </div>
                    </div>`
        } // for end
    // 3. 가져온 마크업 객체에 출력할 HTML문자열 대입하기
    todoBottom.innerHTML = HTML;
        }) // then ed
        .catch(e => {console.log(e);})
} // f end

// [5 U] 수정함수 정의 , 상태변경
// 사용처 : [수정]버튼 onclick 클릭했을때 , 매개변수 : 수정할할일코드 , 반환값 : X
function 수정함수( tno ){  console.log( `${tno} 수정함수`)
    const option = {
        method : 'PUT' , 
        headers : {"Content-Type" : "application/JSON"} ,
        body : JSON.stringify(tno)
    }
    // (1) 배열내 수정할 할일코드 객체 찾기.
        fetch(`/update.do?tno=${tno}` , {method : 'PUT' , headers : {"Content-Type" : "application/JSON"}})
            .then(r => r.json())
            .then(d => {console.log(d);
                if (d == true) {
                    alert("수정 성공.")
                    출력함수(); //<------------ 수정 처리후 출력함수를 재호출 함으로써 ( 출력상태 새로고침 )
                    return;
                } else {alert("수정 실패.")}
            })
            .catch(e => {console.log(e);})
} // f end


// [6 D] 삭제함수 정의 ,
// 사용처 : [삭제]버튼 onclick 클릭했을때 , 매개변수 : 삭제할할일코드 , 반환값 : X
function 삭제함수( tno ){  console.log( `${tno} 삭제함수`)
    fetch(`/delete.do?tno=${tno}` , {method : `delete`})
        .then(r => r.json())
        .then(d => {console.log(d);
            if(d == true)  {
                alert("삭제 성공.")
                출력함수( );
                return;
            } else { alert("삭제 실패.") } 
        }) // then ed
        .catch(e => {console.log(e);})
} // f end



