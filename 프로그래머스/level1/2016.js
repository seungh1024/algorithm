function solution(a, b) {
    var answer = '';
    var day = ['THU','FRI','SAT','SUN','MON','TUE','WED'];
    var count = 0;
    if(a <= 7){
        if(a%2 == 0){
            count = 31*(a-1)+b-(a/2 -1);
        }else{
            count = 31*(a-1) + b -((a+1)/2 -1);
        }
        
    }else{
        if(a%2 == 0){
            count = 31*(a-1)+b-(a/2 -1);
        }else{
            count = 31*(a-1) + b -((a-1)/2 -1);
        }
    }
    if(a>=3){
        count = count -1;
    }
//     switch(count%7){
//         case 0: return answer += 'THU';
//         case 1: return answer += 'FRI';
//         case 2: return answer += 'SAT';
//         case 3: return answer += 'SUN';
//         case 4: return answer += 'MON';
//         case 5: return answer += 'TUE';
//         case 6: return answer += 'WED';
        
//     }
    answer = answer + day[count%7];
    return answer;
}