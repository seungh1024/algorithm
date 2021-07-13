function solution(n) {
    var answer = '';
    var subak = '수박';
    for(var i = 0; i<(n/2); i++){
        answer += subak;
    };
    if(n%2 != 0){
        answer = answer.substr(0,n);
    }
    return answer;
}