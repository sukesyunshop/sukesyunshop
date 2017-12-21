/**
 *
 */

var start = "start";
var end = "end";
var startPath = "./images/start.png";
var gifPath = "./images/omikuji.gif";
var kekkaPath = ["./images/daikichi.png", "./images/kichi.png", "./images/kyou.png"];


function omikuji(){
	console.log('1');
	if(document.getElementById("omikuji").className == start){
		console.log('start');
		document.getElementById("omikuji").src = gifPath;
		sleep(2, function(){
			var random = Math.floor(Math.random() * 3 + 1);
			document.getElementById("omikuji").src = kekkaPath[random];
			document.getElementById("omikuji").className = end;
		})
	}else if(document.getElementById("omikuji").className == end){
		console.log('end');
		document.getElementById("omikuji").src = startPath;
		document.getElementById("omikuji").className = start;
	}
}

function sleep(waitSec, callbackFunc){
	console.log('sleep');
	var spanedSec = 0;

	var waitFunc = function(){
		spanedSec++;
		if (spanedSec >= waitSec) {
			console.log('plus');
            if (callbackFunc) {
            	console.log('func');
                callbackFunc();
            }
            return;
        }
        clearTimeout(id);
        id = setTimeout(waitFunc, 1000);
    };

    var id = setTimeout(waitFunc, 1000);

}