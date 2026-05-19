import { useState } from "react";

export function LabComp8() {
    const [orders, setOrders]=useState([]);
    const onOrder = (menuName) => {
        setOrders([...orders, menuName]);
    };
    return(
        <div style={{ textAlign: 'center' }}>
        <hr />
            <h1>카페 메뉴판</h1>
            <MenuCard name="아메리카노" price={3000} category="커피" imgName="/images/americano.png" onOrder={onOrder}/>
            <MenuCard name="딸기 라떼" price={4500} category="음료" imgName="/images/strawberrylatte.png" onOrder={onOrder}/>
            <MenuCard name="치즈 케이크" price={5500} category="디저트" imgName="/images/cheesecake.png" onOrder={onOrder}/>
            <h2>주문 목록</h2>
            {orders.length === 0 ? (
                <p>아직 주문한 메뉴가 없습니다.</p>
            ) : (
                <ul>
                    {orders.map((order, index) => (
                        <li key={index}>{order}</li>
                    ))}
                </ul>
            )}
        </div>
    )
}
function MenuCard({...props}) {
        const cardStyle = {
        display: 'inline-block',
        border: '2px solid brown',
        borderRadius: '8px',
        padding: '16px',
        margin: '8px',
        width: '250px'
    };

    return(
        <>
            <div style={cardStyle}>
                <h2>{props.name}</h2>
                <p>분류: {props.category}</p>
                <p>가격: {props.price}원</p>
                <img src={props.imgName} style={{ width: '50px', height: '50px'}}></img>
                <hr />
                <button onClick={() => props.onOrder(props.name)}>주문하기</button>
            </div>
        </>
    )
}