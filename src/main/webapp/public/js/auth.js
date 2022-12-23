// Switch auth links

const messageContainer = document.querySelector('#form-message-container');

if (messageContainer.childNodes.length > 1) {
	messageContainer.classList.add("form-messages");
}

const PATHS_AUTH = {
	LOGIN: '/Nasa-JSP/auth/login',
	REGISTER: '/Nasa-JSP/auth/register',
}

const currentLocationAuth = window.location.pathname;

const linkAuth = document.querySelector('div.switch-auth p');

if (currentLocationAuth === PATHS_AUTH.LOGIN) {
	linkAuth.innerHTML =
		`Don't have an account? <a href='${PATHS_AUTH.REGISTER}'>Register</a>`;
} else if (currentLocationAuth === PATHS_AUTH.REGISTER) {
	linkAuth.innerHTML =
		`Do you have an account? <a href='${PATHS_AUTH.LOGIN}'>Login</a>`;
}


// Focus on first input && submit by pressing enter

const authForm = document.querySelector('form');
const emailInput = authForm.email;
const passwordInput = authForm.password;

const bothInputs = [
	emailInput,
	passwordInput,
];

window.addEventListener('load', () => {
	emailInput.focus();
});

bothInputs.forEach((input) => {
	input.addEventListener('keypress', (e) => {
		const { key } = e;
		if (key === 'Enter') authForm.submit();
	});
});
