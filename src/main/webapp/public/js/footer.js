const PATHS_FOOTER = {
	INDEX: '/nasa/',
	LOGIN: '/nasa/auth/login',
	REGISTER: '/nasa/auth/register',
	USER: '/nasa/user',
};

const ICONS_FOOTER = {
	HOME: ['fa-solid', 'fa-house'],
	USER: ['fa-solid', 'fa-user'],
}

const currentLocationFooter = window.location.pathname;

const iconFooter = document.querySelector('#icon');
const linkToAuth = document.querySelector('#empty-session-link');
const linkToUser = document.querySelector('#full-session-link');

if (linkToAuth) {
	if (currentLocationFooter === PATHS_FOOTER.INDEX) {
		addClasses(ICONS_FOOTER.USER);
		setLink(linkToAuth, PATHS_FOOTER.LOGIN);
	} else {
		addClasses(ICONS_FOOTER.HOME);
		setLink(linkToAuth, PATHS_FOOTER.INDEX);
	}	
}

if (linkToUser) {
	if (currentLocationFooter === PATHS_FOOTER.INDEX) {
		addClasses(ICONS_FOOTER.USER);
		setLink(linkToUser, PATHS_FOOTER.USER);
	} else {
		addClasses(ICONS_FOOTER.HOME);
		setLink(linkToUser, PATHS_FOOTER.INDEX);
	}
}


function addClasses (classesToAdd) {
	iconFooter.className = '';
	classesToAdd.forEach(function (classToAdd) {
		iconFooter.classList.add(classToAdd);
	});
	return;
};

function setLink(targetLink, linkToSet) {
	targetLink.href = linkToSet;
	return;
};
