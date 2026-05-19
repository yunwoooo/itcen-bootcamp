import { useState } from "react";

export function LabComp6() {
    const [todo, setTodo] = useState('')
    const [items, setItems] = useState([])
    const addTodo = () => {
        if (todo.trim() === '') return;
        setItems([...items, todo])
        setTodo('');
    };
    return(
        <div style={{ textAlign: 'center' }}>
            <hr />
            <h1>Todo List</h1>
            <input type='text' value={todo} onChange={(e) => setTodo(e.target.value)} placeholder="할 일을 입력하세요"></input>
            <button style={{ margin: 4 }} onClick={addTodo}>추가</button>
            <ul>
                {items.map((item, index) => (
                <li key={index}>{item}</li>
                ))}
            </ul>
        </div>
    )
}