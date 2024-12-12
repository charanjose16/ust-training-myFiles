// const {add} = require("./calculator")

const { add ,subtract} = require("./calculator");

test('Valid Add Test',()=>{
    expect(add(1,2)).toBe(3);
})

test('When string passed to add',()=>{
    expect(()=> add('1','2').toThrow('Invalid input'))
})

test('valid subtract ',()=>{
    expect(subtract(5,3)).toBe(2)
})

test('When string passed to subtract',()=>{
    expect(()=> subtract('1','2').toThrow('Invalid input'))
})