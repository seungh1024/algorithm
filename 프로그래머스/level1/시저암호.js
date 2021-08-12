var bigstart = 'A '; //65, 공백 32
var bigend = 'Z';//90

var smallstart = 'a';//97
var smallend = 'z';//122



const test1 = "AB";
const test2= "z";
const test3 = "a B z"
const n = 1;
var answer = '';


for(i=0; i<test1.length; i++){
    //charCodeAt ->원하는 위치의 문자를 아스키로 변환
    if(test1.charCodeAt(i) <=90){
        if(test1.charCodeAt(i) == 32){
            answer = answer+' ';
        }
        else{
            const asc = test1.charCodeAt(i) + n;
            console.log(asc);
            if(asc >90){
                asc = asc - 25;
            }
            //test1[i] = String.fromCharCode(asc);
            answer = answer +String.fromCharCode(asc);
            console.log(answer);
        };
        
    }else{
        const asc = test1.charCodeAt(i) + n;
        if(asc >122){
            asc = asc - 25;
        }
        answer = answer +String.fromCharCode(asc);
        console.log(answer);
    }
}
console.log(test1);
