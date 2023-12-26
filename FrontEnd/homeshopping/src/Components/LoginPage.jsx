import { Link } from 'react-router-dom';

function LoginPage() {
    return (
        <>
            <h1>로그인</h1>
            <form>
                아이디:<input placeholder="아이디"></input>
                비밀번호:<input placeholder="비밀번호"></input>
                <button type="submit">로그인</button>
            </form>
            <Link to="signup">회원가입</Link>
        </>
    );
}

export default LoginPage;
