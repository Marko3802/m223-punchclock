const URL = 'http://localhost:8081';
let companies = [];

const createCompany = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const company = {};
    company['name'] = formData.get('companyName');
    company['headquarter'] = formData.get('headquarter');

 fetch(`${URL}/companies`, {
         method: 'POST',
         headers: {
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(company)
     }).then((result) => {
         result.json().then((company) => {
             companies.push(company);
             renderCompanies();
         });
     });
};

const updateCompany = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const company = {};
    company['name'] = formData.get('companyNameU');
    company['headquarter'] = formData.get('headquarterU');
    company['id'] = formData.get('companyIdU');

 fetch(`${URL}/companies`, {
         method: 'PUT',
         headers: {
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(company)
     }).then((result) => {
         result.json().then((company) => {
             companies.push(company);
             renderCompanies();
         });
     });
};

const indexCompanies = () => {
    fetch(`${URL}/companies`, {
        method: 'GET',
        headers: {
            'Authorization' : localStorage.getItem("JWT")
        },
    }).then((result) => {
        result.json().then((result) => {
            companies = result;
            renderCompanies();
        });
    });
    renderCompanies();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderCompanies = () => {
    const display = document.querySelector('#companyDisplay');
    display.innerHTML = '';
    companies.forEach((company) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(company.id));
        row.appendChild(createCell(company.headquarter));
        row.appendChild(createCell(company.name));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createCompanyForm = document.querySelector('#createCompanyForm');
    createCompanyForm.addEventListener('submit', createCompany);
    indexCompanies();
});