import { useState } from "react";

export function LabComp5() {
    const [liked, setLiked]=useState(false);
    const [likeCount, setLikeCount]=useState(0);

    const like = () => {
        setLikeCount(likeCount + 1)
        setLiked(true)
    };

    const unlike = () => {
        setLikeCount(likeCount - 1)
        setLiked(false)
    };

    return(
        <div style={{ textAlign: 'center' }}>
            <hr />
            <h3>좋아요 버튼을 만들어 보자</h3>
            <p> 좋아요 수: {likeCount}</p>
            {liked ? <button onClick={unlike} style={{ color : 'blue' }}>좋아요 취소</button> : <button onClick={like} style={{ color : 'red' }}>좋아요</button>}
        </div>
    )
}