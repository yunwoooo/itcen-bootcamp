import { useState } from "react";

export function LabComp4() {
    const [name, setName] = useState('')
    return(
        <div style={{ textAlign: 'center' }}>
            <hr />
            <h3>이름 입력</h3>
            <input type='text' value={name} onChange={(e) => setName(e.target.value)} placeholder="이름을 입력하세요"></input>
            <p>안녕하세요,  {name}님</p>
            <p>글자 수: {name.length}</p>
        </div>
    )
}