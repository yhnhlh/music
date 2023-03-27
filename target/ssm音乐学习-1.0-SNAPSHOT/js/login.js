// 登录注册页面切换
function tosign() {
    let login = document.querySelector('.login');
    let sign = document.querySelector('.sign');
    login.classList.add('disnone')
    sign.classList.remove('disnone')
}

function tologin() {
    let login = document.querySelector('.login');
    let sign = document.querySelector('.sign');
    sign.classList.add('disnone')
    login.classList.remove('disnone')
}