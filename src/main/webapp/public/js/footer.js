const PATHS_FOOTER = {
	INDEX: '/Nasa-JSP/',
	AUTH: [
		'/Nasa-JSP/auth/login',
		'/Nasa-JSP/auth/register',
	],
};

const ICONS_FOOTER = {
	HOME: ['fa-solid', 'fa-house'],
	USER: ['fa-solid', 'fa-user'],
}

const currentLocationFooter = window.location.pathname;

const iconFooter = document.querySelector('#icon');
const linkFooter = document.querySelector('#link');

if (currentLocationFooter === PATHS_FOOTER.INDEX) {
	addClasses(ICONS_FOOTER.USER);
	setLink(PATHS_FOOTER.AUTH[0]);
} else {
	addClasses(ICONS_FOOTER.HOME);
	setLink(PATHS_FOOTER.INDEX);
}

function addClasses (classesToAdd) {
	iconFooter.className = '';
	classesToAdd.forEach(function (classToAdd) {
		iconFooter.classList.add(classToAdd);
	});
	return;
};

function setLink(linkToSet) {
	linkFooter.href = linkToSet;
	return;
};
