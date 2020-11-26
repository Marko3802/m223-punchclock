const URL = 'http://localhost:8081';

document.addEventListener('DOMContentLoaded', function(){
    const createSignUpForm = document.querySelector('#signupForm');
    createSignUpForm.addEventListener('submit', (e) => signUp(e));
});

const signUp = (e) =>{
    e.preventDefault();
    const formData = new FormData(e.target);
    const signUp = {};
    signUp['username'] = formData.get('username');
    signUp['password'] = formData.get('password');

    fetch(`${URL}/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(signUp)
    }).then((result) => {
            if(result.status === 200){
                window.location.replace(`${URL}/index.html`);;
            }

    });
}