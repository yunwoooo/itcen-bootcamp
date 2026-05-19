export function LabComp1() {
    const name ='둘리'
    const age=10
    const role='아기공룡 둘리의 주인공'
    const friends = [
        { id: 1, name:'또치' },
        { id: 2, name:'도우너' }
    ]
    return (
        <ul style={{ textAlign: 'left'}}>
            <li>이름 : {name}</li>
            <li>나이 : {age}</li>
            <li>역할 : {role}</li>
            <li>
                친구들 : {friends.map((friend) => friend.name).join(', ')}
            </li>
        </ul>
    )
}