let add=(a,b)=>{
    if(typeof a != 'number' | typeof b != 'number'){
        throw new Error('invalid input');
    }
    return a+b;
}

let subtract=(a,b)=>{
    if(typeof a != 'number' | typeof b != 'number'){
        throw new Error('invalid input');
    }
    return a-b;
}

module.exports={
    add,
    subtract
};