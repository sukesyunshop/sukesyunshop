/**
 *
 */

var start = "start";
var end = "end";
var startPath = "./images/start.png";
var gifPath = "./images/omikuji.gif";
var kekkaPath = ["./images/daikichi.png", "./images/kichi.png", "./images/kyou.png"];


function omikuji(){
	if(document.getElementById("omikuji").className == start){
		document.getElementById("omikuji").src = gifPath;
		sleep(2, function(){
			var random = Math.floor(Math.random() * 9 + 1);
			console.log(random);
			document.getElementById("omikuji").src = kekkaPath[random%3];
			document.getElementById("omikuji").className = end;
		})
	}else if(document.getElementById("omikuji").className == end){
		document.getElementById("omikuji").src = startPath;
		document.getElementById("omikuji").className = start;
	}
}

function sleep(waitSec, callbackFunc){
	var spanedSec = 0;

	var waitFunc = function(){
		spanedSec++;
		if (spanedSec >= waitSec) {
            if (callbackFunc) {
                callbackFunc();
            }
            return;
        }
        clearTimeout(id);
        id = setTimeout(waitFunc, 1000);
    };

    var id = setTimeout(waitFunc, 1000);

}