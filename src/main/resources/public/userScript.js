const URL = 'http://localhost:8081';
let users = [];

const createCompany = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] = formData.get('username');
    user['password'] = formData.get('password');

 fetch(`${URL}/users`, {
         method: 'POST',
         headers: {
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(user)
     }).then((result) => {
         result.json().then((user) => {
             users.push(user);
             renderUsers();
         });
     });
};

const indexUsers = () => {
    fetch(`${URL}/users`, {
        method: 'GET',
        headers: {
            'Authorization' : localStorage.getItem("JWT")
        },
    }).then((result) => {
        result.json().then((result) => {
            users = result;
            renderUsers();
        });
    });
    renderUsers();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderUsers = () => {
    const display = document.querySelector('#userDisplay');
    display.innerHTML = '';
    companies.forEach((user) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(user.id));
        row.appendChild(createCell(user.username));
        row.appendChild(createCell(user.password));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createCompanyForm = document.querySelector('#createUserForm');
    createCompanyForm.addEventListener('submit', createCompany);
    indexCompanies();
});