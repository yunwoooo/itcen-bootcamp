export function LabComp2() {
    const today=new Date()
    const day=today.getDate()
    return (
    <div style={{ textAlign: 'center' }}>
      <hr />
      <h2>오늘은 {day}일이므로 {day%2==1 ? '홀수' : '짝수'}날입니다.</h2>
    </div>)
}