import { useState } from 'react';
import axios from 'axios';

function SignupPage() {
    const [formData, setFormData] = useState({
        id: '',
        pw: '',
        email: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(
                // TO DO: 이후 api 수정
                'http://localhost:8080/api/users/signup',
                formData
            );
            console.log(response.data);
        } catch (error) {
            console.error('Error during signup:', error);
        }
    };

    return (
        <>
            <h1>회원가입 페이지</h1>
            <form onSubmit={handleSubmit}>
                id:
                <input
                    type="text"
                    name="id"
                    placeholder="id"
                    onChange={handleInputChange}
                />
                pw:
                <input
                    type="password"
                    name="pw"
                    placeholder="pw"
                    onChange={handleInputChange}
                />
                email:
                <input
                    type="email"
                    name="email"
                    placeholder="email"
                    onChange={handleInputChange}
                />
                <button type="submit">회원가입하기</button>
            </form>
        </>
    );
}

export default SignupPage;
