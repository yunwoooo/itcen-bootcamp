import { useState } from "react";

export function LabComp3() {
    const [count1, setCount1] = useState(0)
    const [count2, setCount2] = useState(0)
    const [count3, setCount3] = useState(0)
    return (
        <>
            <div>
                <h3>1씩 증가 카운터</h3>
                <p>현재 값 : {count1} </p>
                <button onClick={() => setCount1(count1 + 1)}>1씩증가</button>
            </div>
            <div>
                <h3>2씩 증가 카운터</h3>
                <p>현재 값 : {count2} </p>
                <button onClick={() => setCount2(count2 + 2)}>2씩증가</button>
            </div>
            <div>
                <h3>10씩 증가 카운터</h3>
                <p>현재 값 : {count3} </p>
                <button onClick={() => setCount3(count3+ 10)}>10씩증가</button>
            </div>
        </>
    )
}