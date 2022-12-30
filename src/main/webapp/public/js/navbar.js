const currentLocationNavbar = window.location.pathname;
const userInSessionNavbar = document.querySelector('a.session-span');

if (currentLocationNavbar === '/nasa/user') {
	userInSessionNavbar.style.pointerEvents = 'none';
}
