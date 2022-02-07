const arr1 = [1,2,3,3,3,3,4,4];
const arr2 = [3,2,4,4,2,5,2,5,5];
const arr3 = [3,5,7,9,1];

var single = [...new Set(arr1)];
console.log(single);

var test = new Array(100);
var count = [];
for(i=0; i< arr1.length; i++){
    if(test[arr1[i]]){
        test[arr1[i]] += 1;
    }else{
        test[arr1[i]] = 1;
    }
}
console.log(test);
for(i=0; i<single.length; i++){
    count.push(test[single[i]]);
}
console.log(count);

function getCount(array) {
     return array.reduce((pv, cv)=>{ 
         pv[cv] = (pv[cv] || 0) + 1; return pv; 
    }, {});
}
const testfun = getCount(arr1);
console.log(testfun);
console.log([3]);

