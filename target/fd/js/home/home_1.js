/**

 * @description js原生设置cookie

 * @param {String} name 给你要设置的cookie起个名字（key）

 * @param {String} value cookie的具体内容(value)

 * @param {String} expiredays 设置cookie的过期时间，单位：天

 */

function setCookie(name, value, expiredays) {

    var exdate=new Date();

    exdate.setDate(exdate.getDate() + expiredays);

    document.cookie = name + '=' + escape(value)+ ((expiredays == null) ? '' : ';expires=' +exdate.toGMTString());

}
/**

 * @description js原生获取cookie方法1

 * @param {String} name 你要获取的cookie名

 */

function getCookie(name) {

    if (document.cookie.length > 0) {

        var start = document.cookie.indexOf(name + '=');

        if (start !== -1) {

            start = start + name.length + 1;

            var end = document.cookie.indexOf(';', start);

            if (end === -1) {

                end = document.cookie.length;

                return unescape(document.cookie.substring(start, end));

            }
        }

    }

    return '';
}
/**

 * @description js原生获取cookie方法2

 * @param {String} name 你要获取的cookie名

 */

function getCookie(name) {

    var cookieArr = document.cookie.split(';') || [];

    if(!cookieArr.length){

        return '';

    }

    for(var i = 0; i < cookieArr.length; i ++){

        var key = $.trim(cookieArr[i]).split('=')[0];

        var value = $.trim(cookieArr[i]).split('=')[1];

        if(key === name){

            return value;

        }

    }

}
function checkCookie() {

    username = getCookie('username');

    if (username !== null && username !== '') {

        alert('Welcome again ' + username + '!');

    } else {

        username = prompt('Please enter your name:', '');

        if (username !== null && username !== '') {

            setCookie('username',username,365);

        }

    }

}