function solution(dartResult) {
    var answer = 0;
    var num = [];
    var eff = [];
    var sum = [];
    for(var i = 0; i< dartResult.length; i++){
        var dr = dartResult[i];
        if(dr == 0 ||dr == 1||dr ==2||dr ==3||dr ==4||dr ==5||dr ==6||dr ==7||dr ==8||dr ==9){
            if(dartResult[i] == 0 && dartResult[i-1]/2){
                num.pop();
                num.push(10);
            }else{
                num.push(dartResult[i]);
            }
            
        }else{
            eff.push(dartResult[i]);
        }
    }
    console.log(num);
    console.log(eff);
    var j = 0;
    for(var i = 0; i< eff.length; i++){
        if(eff[i] == 'S'){
            sum.push(num[j]);
            j++;
        }else if(eff[i] == 'D'){
            sum.push(num[j]*num[j]);
            j++;
        }else if(eff[i] == 'T'){
            sum.push(num[j]*num[j]*num[j]);
            j++;
        }else if(eff[i] == '*'){
            if(sum.length -2>=0){
                var p = sum.pop()*2;
                var q = sum.pop()*2;
                sum.push(q);
                sum.push(p);
            }else{
                sum.push(sum.pop()*2);
            }
        }else{
            sum.push(sum.pop()*(-1));
        }
    }
    console.log(sum);
    for(var i = 0; i< sum.length; i++){
        answer += sum[i]/1;
    }
    return answer;
}