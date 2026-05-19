import { useState } from "react";

export function LabComp7() {
    const cardStyle = {
        display: 'flex',
        flexWrap: 'wrap'}
    return(
        <>
            <h1>캐릭터 카드</h1>
            <div>
                <CharacterCard name="둘리" age={10} role="아기공룡" friends={["또치", "도우너", "마이콜"]} />
                <CharacterCard name="도우너" age={11} role="깐따삐야 별 외계인" friends={["둘리", "또치"]} />
                <CharacterCard name="또치" age={12} role="아프리카에서 온 타조" friends={["또치", "둘리", "희동이"]} />
            </div>
        </>
    )
}
function CharacterCard({...props}) {
    const cardStyle = {
        display: 'inline-block',
        border: '2px solid purple',
        borderRadius: '8px',
        padding: '16px',
        margin: '8px',
        width: '250px'
    };

    return(
        <div style={cardStyle}>
            <h2>{props.name}</h2>
            <p>나이: {props.age}</p>
            <p>역할: {props.role}</p>
            <p>친구들: {props.friends.join(', ')}</p>
        </div>
    )
}